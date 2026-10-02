package com.jayvijay.scottie.di

import com.jayvijay.scottie.data.ai.provider.AndroidDeviceResources
import com.jayvijay.scottie.data.ai.provider.CatalogModel
import com.jayvijay.scottie.data.ai.provider.DeviceResources
import com.jayvijay.scottie.data.ai.provider.DownloadForegroundHost
import com.jayvijay.scottie.data.ai.provider.LiteRtModelRuntime
import com.jayvijay.scottie.data.ai.provider.ModelRuntime
import com.jayvijay.scottie.data.ai.provider.RoutingModelRuntime
import com.jayvijay.scottie.data.ai.provider.RunAnywhereModelRuntime
import com.jayvijay.scottie.data.ai.provider.ServiceDownloadForegroundHost
import com.jayvijay.scottie.data.ai.provider.StaticModelCatalog
import com.jayvijay.scottie.data.ai.provider.socModel
import com.jayvijay.scottie.data.repository.ModelDownloadRepositoryImpl
import com.jayvijay.scottie.domain.repository.ModelDownloadRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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

  @Provides fun provideModelCatalog(): List<CatalogModel> = StaticModelCatalog.forDevice(socModel())

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
}
