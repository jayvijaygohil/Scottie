package com.jayvijay.scottie.di

import ai.koog.prompt.executor.clients.litert.LiteRTClientConfig
import ai.koog.prompt.executor.clients.litert.LiteRTLLMClient
import ai.koog.prompt.executor.clients.litert.LiteRTLLMProvider
import ai.koog.prompt.executor.clients.litert.LiteRTLLModels
import ai.koog.prompt.executor.llms.MultiLLMPromptExecutor
import ai.koog.prompt.executor.model.PromptExecutor
import android.content.Context
import com.jayvijay.scottie.core.ai.OnDeviceTextModels
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.io.File
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AiModule {
  /**
   * Singleton keeps the LiteRT engine warm across screens. Its `close()` uses `runBlocking`, so
   * never call it on the main thread.
   */
  @Provides
  @Singleton
  fun promptExecutor(@ApplicationContext context: Context): PromptExecutor =
    MultiLLMPromptExecutor(
      mapOf(
        LiteRTLLMProvider to
          LiteRTLLMClient(
            LiteRTClientConfig(
              defaultModel = LiteRTLLModels.Gemma4E2B,
              modelsPath = OnDeviceTextModels.dir(context).path,
              backend = OnDeviceTextModels.BACKEND,
            )
          )
      )
    )

  @Provides
  @Named("liteRtModelsDir")
  fun modelsDir(@ApplicationContext context: Context): File = OnDeviceTextModels.dir(context)
}
