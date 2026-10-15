package com.jayvijay.scottie.di

import android.content.Context
import com.jayvijay.scottie.feature.modeldownload.data.ai.provider.AndroidDeviceResources
import com.jayvijay.scottie.feature.modeldownload.data.ai.provider.CatalogModel
import com.jayvijay.scottie.feature.modeldownload.data.ai.provider.DeviceResources
import com.jayvijay.scottie.feature.modeldownload.data.ai.provider.DownloadForegroundHost
import com.jayvijay.scottie.feature.modeldownload.data.ai.provider.LiteRtModelRuntime
import com.jayvijay.scottie.feature.modeldownload.data.ai.provider.ModelRuntime
import com.jayvijay.scottie.feature.modeldownload.data.ai.provider.RoutingModelRuntime
import com.jayvijay.scottie.feature.modeldownload.data.ai.provider.RunAnywhereModelRuntime
import com.jayvijay.scottie.feature.modeldownload.data.ai.provider.ServiceDownloadForegroundHost
import com.jayvijay.scottie.feature.modeldownload.data.ai.provider.StaticModelCatalog
import com.jayvijay.scottie.feature.modeldownload.data.repository.ModelDownloadRepositoryImpl
import com.jayvijay.scottie.feature.modeldownload.data.repository.OpenRouterConfigRepositoryImpl
import com.jayvijay.scottie.feature.modeldownload.domain.repository.ModelDownloadRepository
import com.jayvijay.scottie.feature.modeldownload.domain.repository.OpenRouterConfigRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.io.File
import javax.inject.Named
import javax.inject.Qualifier
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.serialization.json.Json

/** Process-lifetime scope for work that outlives screens, such as model downloads. */
@Qualifier @Retention(AnnotationRetention.BINARY) annotation class ApplicationScope

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
  @Provides
  @Singleton
  fun provideJson(): Json = Json {
    ignoreUnknownKeys = true
  }

  @Provides
  @Singleton
  @ApplicationScope
  fun provideApplicationScope(): CoroutineScope =
    CoroutineScope(SupervisorJob() + Dispatchers.Default)

  @Provides fun provideModelCatalog(): List<CatalogModel> = StaticModelCatalog.models

  @Provides
  @Named("activeTextModelFile")
  fun activeTextModelFile(@ApplicationContext context: Context): File =
    File(context.filesDir, "active_text_model")

  @Provides
  @Named("activeAudioModelFile")
  fun activeAudioModelFile(@ApplicationContext context: Context): File =
    File(context.filesDir, "active_audio_model")

  /** Excluded from backup in `res/xml`; keep the name in sync. */
  @Provides
  @Named("openRouterConfigFile")
  fun openRouterConfigFile(@ApplicationContext context: Context): File =
    File(context.filesDir, "openrouter_config.json")

  @Provides
  @Singleton
  fun provideModelRuntime(
    liteRt: LiteRtModelRuntime,
    runAnywhere: RunAnywhereModelRuntime,
  ): ModelRuntime = RoutingModelRuntime(liteRt, runAnywhere)
}

@Module
@InstallIn(SingletonComponent::class)
interface DataBindingsModule {
  @Binds fun deviceResources(impl: AndroidDeviceResources): DeviceResources

  @Binds fun downloadForegroundHost(impl: ServiceDownloadForegroundHost): DownloadForegroundHost

  @Binds fun modelDownloadRepository(impl: ModelDownloadRepositoryImpl): ModelDownloadRepository

  @Binds
  fun openRouterConfigRepository(impl: OpenRouterConfigRepositoryImpl): OpenRouterConfigRepository
}
