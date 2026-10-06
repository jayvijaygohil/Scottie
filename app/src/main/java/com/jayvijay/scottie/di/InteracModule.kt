package com.jayvijay.scottie.di

import ai.koog.agents.core.tools.ToolRegistry
import ai.koog.prompt.executor.model.PromptExecutor
import com.jayvijay.scottie.core.ai.OnDeviceTextModels
import com.jayvijay.scottie.feature.interacbanking.data.ai.tools.MockInteracBankingTools
import com.jayvijay.scottie.feature.interacbanking.domain.agent.tools.InteracBankingTools
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.IntentExtractor
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.InteracAssistantAgent
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.ModelResolver
import com.jayvijay.scottie.feature.interacbanking.presentation.InteracAssistantScreen
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.A2uiBridgeFactory
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.ProcessorA2uiBridge
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.interacCatalog
import com.jayvijay.scottie.feature.modeldownload.presentation.TextModelDestination
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

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

  /** The only place both features' presentation types meet. */
  @Provides
  fun textModelDestination(): TextModelDestination =
    TextModelDestination { InteracAssistantScreen(it) }
}

@Module
@InstallIn(SingletonComponent::class)
interface InteracBindingsModule {
  @Binds fun interacBankingTools(impl: MockInteracBankingTools): InteracBankingTools
}
