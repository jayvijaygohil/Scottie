package com.jayvijay.scottie.data.ai.provider

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/** Keeps the process alive while a download runs. */
interface DownloadForegroundHost {
  /** Starts the foreground download service; false if the system refused. */
  fun start(): Boolean
}

class ServiceDownloadForegroundHost
@Inject
constructor(@ApplicationContext private val context: Context) : DownloadForegroundHost {
  override fun start(): Boolean =
    try {
      ContextCompat.startForegroundService(
        context,
        Intent(context, ModelDownloadService::class.java),
      )
      true
    } catch (@Suppress("TooGenericExceptionCaught") e: RuntimeException) {
      // ForegroundServiceStartNotAllowedException (API 31+) or SecurityException.
      Log.w("ModelDownload", "foreground service refused", e)
      false
    }
}
