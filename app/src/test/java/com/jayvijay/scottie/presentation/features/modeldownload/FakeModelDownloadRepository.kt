package com.jayvijay.scottie.presentation.features.modeldownload

import com.jayvijay.scottie.domain.entities.ModelCatalog
import com.jayvijay.scottie.domain.repository.ModelDownloadRepository
import kotlinx.coroutines.flow.MutableStateFlow

class FakeModelDownloadRepository : ModelDownloadRepository {
  override val catalog = MutableStateFlow<ModelCatalog>(ModelCatalog.Loading)
  var deleteResult: Result<Unit> = Result.success(Unit)

  val downloads = mutableListOf<String>()
  val pauses = mutableListOf<String>()
  val deletes = mutableListOf<String>()

  override fun download(modelId: String) {
    downloads += modelId
  }

  override fun pause(modelId: String) {
    pauses += modelId
  }

  override suspend fun delete(modelId: String): Result<Unit> {
    deletes += modelId
    return deleteResult
  }
}
