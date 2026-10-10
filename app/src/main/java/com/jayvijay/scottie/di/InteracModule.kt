package com.jayvijay.scottie.di

import ai.koog.agents.core.tools.ToolRegistry
import ai.koog.prompt.executor.model.PromptExecutor
import com.jayvijay.scottie.core.ai.OnDeviceTextModels
import com.jayvijay.scottie.feature.interacbanking.data.ai.tools.MockInteracBankingTools
import com.jayvijay.scottie.feature.interacbanking.domain.agent.tools.InteracBankingTools
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.IntentExtractor
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.InteracAssistantAgent
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.ModelResolver
import com.jayvijay.scottie.feature.interacbanking.domain.entities.TextModelOption
import com.jayvijay.scottie.feature.interacbanking.domain.repository.TextModelSource
import com.jayvijay.scottie.feature.interacbanking.presentation.ModelSettingsDestination
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.A2uiBridgeFactory
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.ProcessorA2uiBridge
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.interacCatalog
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelCatalog
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelDownloadStatus
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelType
import com.jayvijay.scottie.feature.modeldownload.domain.repository.ModelDownloadRepository
import com.jayvijay.scottie.feature.modeldownload.presentation.ModelDownloadScreen
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Module
@InstallIn(SingletonComponent::class)
object InteracModule {
  /** Same singleton instance as the service, so the model and the presenter see one ledger. */
  // ponytail: set to ToolRegistry.EMPTY if on-device tool calls are flaky
  @Provides
  @Singleton
  fun toolRegistry(mock: MockInteracBankingTools): ToolRegistry = ToolRegistry { tools(mock) }

  @Provides fun modelResolver(): ModelResolver = ModelResolver(OnDeviceTextModels::llModel)

  @Provides
  @Singleton
  fun intentExtractor(
    executor: PromptExecutor,
    registry: ToolRegistry,
    resolver: ModelResolver,
  ): IntentExtractor = InteracAssistantAgent(executor, registry, resolver)

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
      override val models: Flow<List<TextModelOption>> =
        repository.catalog.map { catalog ->
          (catalog as? ModelCatalog.Ready)
            ?.entries
            ?.filter {
              it.model.type == ModelType.TEXT && it.status == ModelDownloadStatus.Downloaded
            }
            ?.map { TextModelOption(it.model.id, it.model.name) }
            .orEmpty()
        }
      override val active: Flow<String?> = repository.activeTextModel

      override fun select(id: String) = repository.selectTextModel(id)
    }

  @Provides
  fun modelSettingsDestination(): ModelSettingsDestination = ModelSettingsDestination {
    ModelDownloadScreen
  }
}

@Module
@InstallIn(SingletonComponent::class)
interface InteracBindingsModule {
  @Binds fun interacBankingTools(impl: MockInteracBankingTools): InteracBankingTools
}
