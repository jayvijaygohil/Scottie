package com.jayvijay.scottie.data.ai.provider

import android.app.ActivityManager
import android.content.Context
import android.os.StatFs
import android.util.Log
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/** Device probes for the compatibility check; null when unknown. */
interface DeviceResources {
  suspend fun availableMemoryBytes(): Long?

  suspend fun availableStorageBytes(): Long?
}

@Singleton
class AndroidDeviceResources @Inject constructor(@ApplicationContext private val context: Context) :
  DeviceResources {

  /** Mirrors RunAnywhere's `PhysicalMemoryProbe.availablePhysicalMemoryBytes`. */
  override suspend fun availableMemoryBytes(): Long? =
    withContext(Dispatchers.IO) {
      context
        .getSystemService(ActivityManager::class.java)
        ?.let { ActivityManager.MemoryInfo().also(it::getMemoryInfo).availMem }
        ?.takeIf { it > 0 } ?: memAvailableKb()?.times(KIB)?.takeIf { it > 0 }
    }

  override suspend fun availableStorageBytes(): Long? =
    withContext(Dispatchers.IO) {
      try {
        StatFs(context.filesDir.path).availableBytes
      } catch (e: IllegalArgumentException) {
        Log.w(TAG, "statfs failed", e)
        null
      }
    }

  private fun memAvailableKb(): Long? =
    try {
      File("/proc/meminfo").useLines { lines ->
        lines
          .firstOrNull { it.startsWith("MemAvailable:") }
          ?.removePrefix("MemAvailable:")
          ?.trim()
          ?.substringBefore(' ')
          ?.toLongOrNull()
      }
    } catch (e: IOException) {
      Log.w(TAG, "meminfo unreadable", e)
      null
    }

  private companion object {
    const val TAG = "DeviceResources"
    const val KIB = 1_024L
  }
}
