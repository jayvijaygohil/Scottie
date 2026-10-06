package com.jayvijay.scottie.feature.modeldownload.presentation

import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelCatalog
import com.jayvijay.scottie.feature.modeldownload.domain.repository.DownloadStart
import com.jayvijay.scottie.feature.modeldownload.domain.repository.ModelDownloadRepository
import kotlinx.coroutines.flow.MutableStateFlow

class FakeModelDownloadRepository : ModelDownloadRepository {
  override val catalog = MutableStateFlow<ModelCatalog>(ModelCatalog.Loading)
  var deleteResult: Result<Unit> = Result.success(Unit)
  var downloadResult: DownloadStart = DownloadStart.Started

  val downloads = mutableListOf<String>()
  val pauses = mutableListOf<String>()
  val deletes = mutableListOf<String>()

  override suspend fun download(modelId: String): DownloadStart {
    downloads += modelId
    return downloadResult
  }

  override fun pause(modelId: String) {
    pauses += modelId
  }

  override suspend fun delete(modelId: String): Result<Unit> {
    deletes += modelId
    return deleteResult
  }
}
