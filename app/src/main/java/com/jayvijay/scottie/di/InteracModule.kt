package com.jayvijay.scottie.di

import ai.koog.agents.core.tools.ToolRegistry
import ai.koog.http.client.KoogHttpClientException
import ai.koog.prompt.executor.model.PromptExecutor
import com.jayvijay.scottie.core.ai.OnDeviceSttModels
import com.jayvijay.scottie.core.ai.OnDeviceTextModels
import com.jayvijay.scottie.core.ai.OpenRouterTextModels
import com.jayvijay.scottie.feature.interacbanking.data.ai.provider.AndroidAudioRecorder
import com.jayvijay.scottie.feature.interacbanking.data.ai.tools.MockInteracBankingTools
import com.jayvijay.scottie.feature.interacbanking.domain.agent.tools.InteracBankingTools
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.FailureClassifier
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.InferenceException
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.InferenceFailure
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.IntentExtractor
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.InteracAssistantAgent
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.ModelResolver
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.ResolvedModel
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.SpeechTranscriber
import com.jayvijay.scottie.feature.interacbanking.domain.repository.AudioRecorder
import com.jayvijay.scottie.feature.interacbanking.domain.repository.TextModelSource
import com.jayvijay.scottie.feature.interacbanking.presentation.ModelSettingsDestination
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.A2uiBridgeFactory
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.ProcessorA2uiBridge
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.interacCatalog
import com.jayvijay.scottie.feature.modeldownload.domain.entities.OpenRouterConfig
import com.jayvijay.scottie.feature.modeldownload.domain.repository.ModelDownloadRepository
import com.jayvijay.scottie.feature.modeldownload.domain.repository.OpenRouterConfigRepository
import com.jayvijay.scottie.feature.modeldownload.presentation.ModelDownloadScreen
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.io.IOException
import javax.inject.Singleton
import kotlin.coroutines.cancellation.CancellationException
import kotlinx.coroutines.flow.Flow

@Module
@InstallIn(SingletonComponent::class)
object InteracModule {
  /** Same singleton instance as the service, so the model and the presenter see one ledger. */
  // ponytail: set to ToolRegistry.EMPTY if on-device tool calls are flaky
  @Provides
  @Singleton
  fun toolRegistry(mock: MockInteracBankingTools): ToolRegistry = ToolRegistry { tools(mock) }

  @Provides
  @Singleton
  fun modelResolver(
    onDevice: PromptExecutor,
    openRouter: OpenRouterConfigRepository,
  ): ModelResolver = RoutingModelResolver(onDevice, openRouter)

  @Provides fun failureClassifier(): FailureClassifier = FailureClassifier(::classifyInference)

  @Provides
  @Singleton
  fun intentExtractor(
    registry: ToolRegistry,
    resolver: ModelResolver,
    classifier: FailureClassifier,
  ): IntentExtractor = InteracAssistantAgent(registry, resolver, classifier)

  @Provides
  @Singleton
  fun speechTranscriber(
    resolver: ModelResolver,
    classifier: FailureClassifier,
  ): SpeechTranscriber = SpeechTranscriber { wavBytes, modelId ->
    try {
      if (!modelId.startsWith(OpenRouterConfig.ID_PREFIX)) {
        OnDeviceSttModels.transcribe(modelId, wavBytes)
      } else {
        val remoteId = modelId.removePrefix(OpenRouterConfig.ID_PREFIX)
        OpenRouterTextModels.transcribeAudio(resolver.resolve(modelId).executor, remoteId, wavBytes)
      }
    } catch (e: CancellationException) {
      throw e
    } catch (@Suppress("TooGenericExceptionCaught") e: Exception) {
      throw InferenceException(classifier.classify(e), e)
    }
  }

  @Provides
  @Singleton
  fun bridgeFactory(): A2uiBridgeFactory {
    val catalog = interacCatalog()
    return A2uiBridgeFactory { ProcessorA2uiBridge(catalog) }
  }

  /** The only place both features meet: the chat reads model state through its own contract. */
  @Provides
  fun textModelSource(repository: ModelDownloadRepository): TextModelSource =
    object : TextModelSource {
      override val active: Flow<String?> = repository.activeTextModel
      override val activeAudio: Flow<String?> = repository.activeAudioModel
    }

  @Provides
  fun modelSettingsDestination(): ModelSettingsDestination = ModelSettingsDestination {
    ModelDownloadScreen
  }
}

/** On-device ids go to LiteRT; prefixed ids to OpenRouter with the saved key. */
private class RoutingModelResolver(
  private val onDevice: PromptExecutor,
  private val openRouter: OpenRouterConfigRepository,
) : ModelResolver {
  private var remote: Triple<String, String, PromptExecutor>? = null

  override fun resolve(modelId: String): ResolvedModel {
    if (!modelId.startsWith(OpenRouterConfig.ID_PREFIX)) {
      return ResolvedModel(onDevice, OnDeviceTextModels.llModel(modelId))
    }
    val config = checkNotNull(openRouter.config.value) { "OpenRouter not configured" }
    val model = OpenRouterTextModels.llModel(modelId.removePrefix(OpenRouterConfig.ID_PREFIX))
    return ResolvedModel(remoteExecutor(config.baseUrl, config.apiKey), model)
  }

  /** Rebuilt only when the connection changes; the replaced client is closed. */
  @Synchronized
  private fun remoteExecutor(baseUrl: String, apiKey: String): PromptExecutor {
    remote?.let { (url, key, executor) ->
      if (url == baseUrl && key == apiKey) return executor
      executor.close()
    }
    return OpenRouterTextModels.executor(baseUrl, apiKey).also {
      remote = Triple(baseUrl, apiKey, it)
    }
  }
}

/** Walks the cause chain: Koog wraps HTTP and transport errors in its client exceptions. */
internal fun classifyInference(error: Throwable): InferenceFailure =
  generateSequence(error) { it.cause }
    .firstNotNullOfOrNull { cause ->
      when {
        cause is KoogHttpClientException ->
          when (cause.statusCode) {
            HTTP_UNAUTHORIZED,
            HTTP_FORBIDDEN -> InferenceFailure.UNAUTHORIZED
            // ponytail: 400 treated as bad model id; OpenRouter also uses 400 for malformed
            // requests
            HTTP_BAD_REQUEST,
            HTTP_NOT_FOUND -> InferenceFailure.MODEL_UNAVAILABLE
            else -> null
          }
        cause is IOException -> InferenceFailure.OFFLINE
        else -> null
      }
    } ?: InferenceFailure.UNKNOWN

private const val HTTP_BAD_REQUEST = 400
private const val HTTP_UNAUTHORIZED = 401
private const val HTTP_FORBIDDEN = 403
private const val HTTP_NOT_FOUND = 404

@Module
@InstallIn(SingletonComponent::class)
interface InteracBindingsModule {
  @Binds fun interacBankingTools(impl: MockInteracBankingTools): InteracBankingTools

  @Binds fun audioRecorder(impl: AndroidAudioRecorder): AudioRecorder
}
