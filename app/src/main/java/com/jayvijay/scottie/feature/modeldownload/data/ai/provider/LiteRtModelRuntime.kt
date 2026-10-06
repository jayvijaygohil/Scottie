package com.jayvijay.scottie.feature.modeldownload.data.ai.provider

import android.content.Context
import android.util.Log
import com.jayvijay.scottie.core.ai.OnDeviceTextModels
import com.jayvijay.scottie.feature.modeldownload.domain.entities.DownloadFailure
import com.jayvijay.scottie.feature.modeldownload.domain.entities.DownloadProgress
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

/**
 * Downloads LiteRT files to `<dir>/<id>`, where Koog loads them, via `<id>.part`. Paused or failed
 * transfers keep the partial file and resume with a Range request.
 */
// ponytail: no SHA-256 over multi-GB files; add it if a corrupt file is reported.
@Singleton
class LiteRtModelRuntime
internal constructor(
  private val dir: File,
  private val open: (URL) -> HttpURLConnection = { it.openConnection() as HttpURLConnection },
) : ModelRuntime {

  @Inject
  constructor(@ApplicationContext context: Context) : this(OnDeviceTextModels.dir(context))

  private val rows = ConcurrentHashMap<String, LiteRtModel>()

  override suspend fun prepare(catalog: List<CatalogModel>): Set<String> =
    withContext(Dispatchers.IO) {
      dir.mkdirs()
      catalog.filterIsInstance<LiteRtModel>().mapTo(mutableSetOf()) { row ->
        rows[row.id] = row
        row.id
      }
    }

  override suspend fun downloadedIds(): Set<String> =
    withContext(Dispatchers.IO) { rows.keys.filterTo(mutableSetOf()) { File(dir, it).exists() } }

  override fun download(modelId: String): Flow<RuntimeDownloadEvent> = flow {
    val row = rows.getValue(modelId)
    val part = File(dir, "$modelId.part")
    val connection = open(URL(row.url))
    try {
      var done = part.length()
      if (done > 0) connection.setRequestProperty("Range", "bytes=$done-")
      when (connection.responseCode) {
        HttpURLConnection.HTTP_OK -> done = 0 // Range ignored: start over.
        HttpURLConnection.HTTP_PARTIAL -> Unit
        else -> {
          Log.w(TAG, "download $modelId: HTTP ${connection.responseCode}")
          emit(RuntimeDownloadEvent.Failed(DownloadFailure.NETWORK))
          return@flow
        }
      }
      FileOutputStream(part, done > 0).use { out ->
        connection.inputStream.use { input ->
          val buffer = ByteArray(CHUNK_BYTES)
          while (true) {
            val read = input.read(buffer)
            if (read < 0) break
            out.write(buffer, 0, read)
            done += read
            emit(RuntimeDownloadEvent.Progress(progress(done, row.downloadBytes)))
          }
        }
      }
    } finally {
      connection.disconnect()
    }
    emit(finish(part, File(dir, modelId), row.downloadBytes))
  }
    .catch { e ->
      if (e !is IOException) throw e
      Log.w(TAG, "download $modelId failed", e)
      val storage = e.message?.contains("ENOSPC") == true
      emit(
        RuntimeDownloadEvent.Failed(
          if (storage) DownloadFailure.STORAGE else DownloadFailure.NETWORK
        )
      )
    }
    .flowOn(Dispatchers.IO)

  override suspend fun delete(modelId: String) =
    withContext(Dispatchers.IO) {
      listOf(File(dir, modelId), File(dir, "$modelId.part")).forEach { file ->
        if (file.exists() && !file.delete()) throw IOException("cannot delete $file")
      }
    }

  private fun finish(part: File, target: File, size: Long): RuntimeDownloadEvent =
    when {
      part.length() != size -> {
        part.delete()
        RuntimeDownloadEvent.Failed(DownloadFailure.CORRUPTED)
      }
      part.renameTo(target) -> RuntimeDownloadEvent.Completed
      else -> RuntimeDownloadEvent.Failed(DownloadFailure.STORAGE)
    }

  private fun progress(done: Long, total: Long) =
    DownloadProgress(done, total, (done.toFloat() / total).coerceIn(0f, 1f))

  private companion object {
    const val TAG = "LiteRtRuntime"
    const val CHUNK_BYTES = 256 * 1_024
  }
}
