package com.jayvijay.scottie.data.ai.provider

class FakeDeviceResources(
  var availableMemory: Long? = null,
  var availableStorage: Long? = null,
) : DeviceResources {
  var probes = 0
    private set

  override suspend fun availableMemoryBytes(): Long? = availableMemory.also { probes++ }

  override suspend fun availableStorageBytes(): Long? = availableStorage
}
