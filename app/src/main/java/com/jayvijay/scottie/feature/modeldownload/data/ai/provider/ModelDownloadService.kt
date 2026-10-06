package com.jayvijay.scottie.feature.modeldownload.data.ai.provider

import android.Manifest
import android.annotation.SuppressLint
import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ServiceInfo
import android.os.Build
import android.os.IBinder
import android.os.PowerManager
import android.os.SystemClock
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.ServiceCompat
import androidx.core.content.ContextCompat
import com.jayvijay.scottie.MainActivity
import com.jayvijay.scottie.R
import com.jayvijay.scottie.feature.modeldownload.domain.entities.DownloadPhase
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelCatalog
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelDownloadStatus
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelEntry
import com.jayvijay.scottie.feature.modeldownload.domain.repository.ModelDownloadRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

/**
 * Keeps the process alive while the repository downloads and mirrors that download in a
 * notification. The transfer itself is owned by [ModelDownloadRepository].
 */
@AndroidEntryPoint
class ModelDownloadService : Service() {
  @Inject lateinit var repository: ModelDownloadRepository

  private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
  private var observer: Job? = null
  private var wakeLock: PowerManager.WakeLock? = null
  private var trackedId: String? = null
  private var lastProgressPost = 0L

  override fun onBind(intent: Intent?): IBinder? = null

  override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
    if (intent?.action == ACTION_CANCEL) {
      trackedId?.let(repository::pause)
      if (observer == null) stopSelf()
      return START_NOT_STICKY
    }
    NotificationManagerCompat.from(this)
      .createNotificationChannel(
        NotificationChannelCompat.Builder(CHANNEL_ID, NotificationManagerCompat.IMPORTANCE_LOW)
          .setName(getString(R.string.model_download_channel))
          .build()
      )
    ServiceCompat.startForeground(
      this,
      PROGRESS_ID,
      baseNotification(getString(R.string.model_download_notification_starting))
        .setOngoing(true)
        .setProgress(0, 0, true)
        .build(),
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC
      } else {
        0
      },
    )
    if (wakeLock == null) {
      wakeLock =
        getSystemService(PowerManager::class.java)
          .newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "Scottie:ModelDownload")
          .apply { acquire(WAKE_LOCK_TIMEOUT_MS) }
    }
    if (observer == null) {
      observer = scope.launch { repository.catalog.collect(::render) }
    }
    return START_NOT_STICKY
  }

  // Android 15+ caps dataSync runtime; pause keeps the bytes for a later resume.
  override fun onTimeout(startId: Int, fgsType: Int) {
    trackedId?.let(repository::pause)
    stop()
  }

  override fun onDestroy() {
    scope.cancel()
    wakeLock?.takeIf { it.isHeld }?.release()
    super.onDestroy()
  }

  private fun render(catalog: ModelCatalog) {
    val entries = (catalog as? ModelCatalog.Ready)?.entries ?: return
    val downloading = entries.firstOrNull { it.status is ModelDownloadStatus.Downloading }
    if (downloading != null) {
      trackedId = downloading.model.id
      val now = SystemClock.elapsedRealtime()
      if (now - lastProgressPost >= PROGRESS_INTERVAL_MS) {
        lastProgressPost = now
        notify(PROGRESS_ID, progressNotification(downloading))
      }
      return
    }
    entries
      .find { it.model.id == trackedId }
      ?.let(::outcomeNotification)
      ?.let {
        notify(OUTCOME_ID, it)
      }
    stop()
  }

  private fun stop() {
    ServiceCompat.stopForeground(this, ServiceCompat.STOP_FOREGROUND_REMOVE)
    stopSelf()
  }

  private fun progressNotification(entry: ModelEntry): Notification {
    val progress = (entry.status as ModelDownloadStatus.Downloading).progress
    val text =
      when (progress.phase) {
        DownloadPhase.VERIFYING -> getString(R.string.model_download_status_checking)
        DownloadPhase.EXTRACTING -> getString(R.string.model_download_status_unpacking)
        DownloadPhase.TRANSFERRING -> null
      }
    val cancel =
      PendingIntent.getService(
        this,
        0,
        Intent(this, ModelDownloadService::class.java).setAction(ACTION_CANCEL),
        PendingIntent.FLAG_IMMUTABLE,
      )
    val fraction = progress.fraction
    return baseNotification(entry.model.name)
      .setContentText(text)
      .setOngoing(true)
      .setProgress(PERCENT, ((fraction ?: 0f) * PERCENT).toInt(), fraction == null)
      .addAction(0, getString(R.string.model_download_notification_cancel), cancel)
      .build()
  }

  private fun outcomeNotification(entry: ModelEntry): Notification? {
    val name = entry.model.name
    val (title, icon) =
      when (entry.status) {
        ModelDownloadStatus.Downloaded ->
          getString(R.string.model_download_notification_ready, name) to
            android.R.drawable.stat_sys_download_done
        is ModelDownloadStatus.Paused ->
          getString(R.string.model_download_notification_paused, name) to
            android.R.drawable.stat_sys_download_done
        is ModelDownloadStatus.Failed ->
          getString(R.string.model_download_notification_failed, name) to
            android.R.drawable.stat_notify_error
        else -> return null
      }
    return baseNotification(title).setSmallIcon(icon).setAutoCancel(true).build()
  }

  private fun baseNotification(title: String): NotificationCompat.Builder =
    NotificationCompat.Builder(this, CHANNEL_ID)
      .setSmallIcon(android.R.drawable.stat_sys_download)
      .setContentTitle(title)
      .setOnlyAlertOnce(true)
      .setSilent(true)
      .setContentIntent(
        PendingIntent.getActivity(
          this,
          0,
          Intent(this, MainActivity::class.java)
            .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP),
          PendingIntent.FLAG_IMMUTABLE,
        )
      )

  @SuppressLint("MissingPermission") // Checked below; denied permission only hides notifications.
  private fun notify(id: Int, notification: Notification) {
    val manager = NotificationManagerCompat.from(this)
    val permitted =
      Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU ||
        ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) ==
          PackageManager.PERMISSION_GRANTED
    if (permitted && manager.areNotificationsEnabled()) manager.notify(id, notification)
  }

  private companion object {
    const val ACTION_CANCEL = "com.jayvijay.scottie.action.CANCEL_MODEL_DOWNLOAD"
    const val CHANNEL_ID = "model_downloads"
    const val PROGRESS_ID = 1
    const val OUTCOME_ID = 2
    const val PERCENT = 100
    const val PROGRESS_INTERVAL_MS = 1_000L
    const val WAKE_LOCK_TIMEOUT_MS = 2 * 60 * 60 * 1_000L
  }
}
