package com.jayvijay.scottie.data.ai.provider

import ai.runanywhere.proto.v1.ErrorCode
import ai.runanywhere.proto.v1.InferenceFramework
import ai.runanywhere.proto.v1.ModelFileDescriptor
import ai.runanywhere.proto.v1.ModelFileRole
import ai.runanywhere.proto.v1.ModelInfo
import ai.runanywhere.proto.v1.ModelSource
import ai.runanywhere.proto.v1.RegisterModelFromUrlRequest
import android.app.ActivityManager
import android.content.Context
import android.util.Log
import com.jayvijay.scottie.domain.entities.DownloadFailure
import com.jayvijay.scottie.domain.entities.DownloadPhase
import com.jayvijay.scottie.domain.entities.DownloadProgress
import com.runanywhere.sdk.core.onnx.ONNX
import com.runanywhere.sdk.llm.llamacpp.LlamaCPP
import com.runanywhere.sdk.npu.qhexrt.QHexRT
import com.runanywhere.sdk.public.RunAnywhere
import com.runanywhere.sdk.public.api.DownloadEvent
import com.runanywhere.sdk.public.api.ModelRegistration
import com.runanywhere.sdk.public.api.models
import com.runanywhere.sdk.public.extensions.Models.isDownloadedOnDisk
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.cancellation.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

@Singleton
class RunAnywhereModelRuntime
@Inject
constructor(@ApplicationContext private val context: Context) : ModelRuntime {

  override suspend fun prepare(catalog: List<CatalogModel>): Set<String> =
    withContext(Dispatchers.IO) {
      // CPU backends before initialize (else load fails); QHexRT needs the SDK-held context.
      registerBackend("llama.cpp") { LlamaCPP.register() }
      registerBackend("onnx") { ONNX.register() }
      RunAnywhere.initialize(context = context)
      registerBackend("qhexrt") { QHexRT.register() }
      catalog.mapNotNullTo(mutableSetOf()) { row ->
        try {
          register(row)?.id
        } catch (e: CancellationException) {
          throw e
        } catch (@Suppress("TooGenericExceptionCaught") e: Exception) {
          Log.w(TAG, "register ${row.id} failed", e)
          null
        }
      }
    }

  override suspend fun downloadedIds(): Set<String> =
    withContext(Dispatchers.IO) {
      RunAnywhere.models.list().filter { it.isDownloadedOnDisk }.mapTo(mutableSetOf()) { it.id }
    }

  override suspend fun totalMemoryBytes(): Long? =
    context
      .getSystemService(ActivityManager::class.java)
      ?.let { manager -> ActivityManager.MemoryInfo().also(manager::getMemoryInfo).totalMem }
      ?.takeIf { it > 0 }

  override fun download(modelId: String): Flow<RuntimeDownloadEvent> = flow {
    var last = DownloadProgress(bytesDone = 0, bytesTotal = 0, fraction = null)
    RunAnywhere.models.download(modelId).collect { event ->
      val mapped =
        when (event) {
          is DownloadEvent.Started -> null
          is DownloadEvent.Progress -> {
            last =
              DownloadProgress(
                bytesDone = event.bytesDone,
                bytesTotal = event.bytesTotal.coerceAtLeast(0),
                fraction = event.fraction?.coerceIn(0f, 1f),
              )
            RuntimeDownloadEvent.Progress(last)
          }
          is DownloadEvent.Verifying ->
            RuntimeDownloadEvent.Progress(last.copy(fraction = 1f, phase = DownloadPhase.VERIFYING))
          is DownloadEvent.Extracting ->
            RuntimeDownloadEvent.Progress(
              last.copy(fraction = 1f, phase = DownloadPhase.EXTRACTING)
            )
          is DownloadEvent.Completed -> RuntimeDownloadEvent.Completed
          is DownloadEvent.Cancelled -> RuntimeDownloadEvent.Cancelled
          is DownloadEvent.Failed ->
            if (event.error.code == ErrorCode.ERROR_CODE_CANCELLED) {
              RuntimeDownloadEvent.Cancelled
            } else {
              Log.w(TAG, "download $modelId failed", event.error)
              RuntimeDownloadEvent.Failed(event.error.code.toFailure())
            }
        }
      if (mapped != null) emit(mapped)
    }
  }
    .flowOn(Dispatchers.IO)

  override suspend fun delete(modelId: String) =
    withContext(Dispatchers.IO) { RunAnywhere.models.delete(modelId) }

  private suspend fun registerBackend(name: String, register: suspend () -> Unit) {
    try {
      register()
    } catch (e: CancellationException) {
      throw e
    } catch (@Suppress("TooGenericExceptionCaught") e: Exception) {
      Log.w(TAG, "$name backend registration failed", e)
    }
  }

  /** Null when the device cannot run [row] or it needs a Hugging Face token. */
  private suspend fun register(row: CatalogModel): ModelInfo? =
    when (row) {
      is SingleFileModel ->
        if (row.framework == InferenceFramework.INFERENCE_FRAMEWORK_QHEXRT) {
          if (QHexRT.modelRequiresHfAuth(row.id)) null
          else QHexRT.registerModelForDevice(row.toQHexRTRequest())
        } else {
          RunAnywhere.models.register(
            ModelRegistration.url(
              id = row.id,
              name = row.name,
              url = row.url,
              framework = row.framework,
              category = row.category,
              memoryBytes = row.memoryBytes,
              downloadBytes = row.downloadBytes,
              supportsThinking = row.supportsThinking,
              supportsLora = row.supportsLora,
            )
          )
        }
      is ArchiveModel ->
        RunAnywhere.models.register(
          ModelRegistration.archive(
            id = row.id,
            name = row.name,
            url = row.url,
            framework = row.framework,
            structure = row.structure,
            archiveType = row.archiveType,
            category = row.category,
            memoryBytes = row.memoryBytes,
          )
        )
      is MultiFileModel ->
        RunAnywhere.models.register(
          ModelRegistration.multiFile(
            id = row.id,
            name = row.name,
            framework = row.framework,
            files = row.files.mapIndexed(::descriptor),
            category = row.category,
            memoryBytes = row.memoryBytes,
            downloadBytes = row.downloadBytes,
          )
        )
    }

  private fun SingleFileModel.toQHexRTRequest() =
    RegisterModelFromUrlRequest(
      id = id,
      name = name,
      url = url,
      framework = framework,
      category = category,
      source = ModelSource.MODEL_SOURCE_REMOTE,
      memory_required_bytes = memoryBytes,
      download_size_bytes = memoryBytes,
      context_length = contextLength,
      supports_thinking = supportsThinking,
      supports_lora = supportsLora,
      description = HNPU_DESCRIPTION,
    )

  private fun descriptor(index: Int, file: ModelFile) =
    ModelFileDescriptor(
      url = file.url,
      filename = file.filename,
      is_optional = false,
      size_bytes = file.sizeBytes,
      checksum_sha256 = file.checksumSha256,
      role =
        if (index == 0) ModelFileRole.MODEL_FILE_ROLE_PRIMARY_MODEL
        else ModelFileRole.MODEL_FILE_ROLE_COMPANION,
    )

  private companion object {
    const val TAG = "ModelRuntime"
    const val HNPU_DESCRIPTION = "Qualcomm Hexagon NPU model bundle."
  }
}

internal fun ErrorCode.toFailure(): DownloadFailure =
  when (this) {
    ErrorCode.ERROR_CODE_NETWORK_UNAVAILABLE,
    ErrorCode.ERROR_CODE_NETWORK_ERROR,
    ErrorCode.ERROR_CODE_TIMEOUT,
    ErrorCode.ERROR_CODE_DOWNLOAD_FAILED -> DownloadFailure.NETWORK
    ErrorCode.ERROR_CODE_INSUFFICIENT_STORAGE,
    ErrorCode.ERROR_CODE_STORAGE_FULL,
    ErrorCode.ERROR_CODE_STORAGE_ERROR,
    ErrorCode.ERROR_CODE_FILE_WRITE_FAILED -> DownloadFailure.STORAGE
    ErrorCode.ERROR_CODE_CHECKSUM_MISMATCH,
    ErrorCode.ERROR_CODE_EXTRACTION_FAILED,
    ErrorCode.ERROR_CODE_UNSUPPORTED_ARCHIVE,
    ErrorCode.ERROR_CODE_PARTIAL_DOWNLOAD -> DownloadFailure.CORRUPTED
    else -> DownloadFailure.UNKNOWN
  }
