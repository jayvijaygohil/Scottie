package com.jayvijay.scottie.feature.interacbanking.data.ai.provider

import android.annotation.SuppressLint
import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder
import com.jayvijay.scottie.feature.interacbanking.domain.repository.AudioRecorder
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Singleton
class AndroidAudioRecorder @Inject constructor() : AudioRecorder {
  private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
  private val lock = Any()
  private var session: Session? = null

  @SuppressLint("MissingPermission")
  override suspend fun start() =
    withContext(Dispatchers.IO) {
      cancel()
      val minSize =
        AudioRecord.getMinBufferSize(
          SAMPLE_RATE,
          AudioFormat.CHANNEL_IN_MONO,
          AudioFormat.ENCODING_PCM_16BIT,
        )
      val bufferSize = maxOf(minSize, MIN_BUFFER_BYTES)
      val record =
        AudioRecord(
          MediaRecorder.AudioSource.MIC,
          SAMPLE_RATE,
          AudioFormat.CHANNEL_IN_MONO,
          AudioFormat.ENCODING_PCM_16BIT,
          bufferSize,
        )
      if (record.state != AudioRecord.STATE_INITIALIZED) {
        record.release()
        error("AudioRecord failed to initialize")
      }
      val output = ByteArrayOutputStream()
      try {
        record.startRecording()
      } catch (@Suppress("TooGenericExceptionCaught") e: Throwable) {
        record.release()
        throw e
      }
      val job = scope.launch {
        val chunk = ByteArray(bufferSize)
        while (isActive) {
          val read = record.read(chunk, 0, chunk.size)
          if (read > 0) {
            synchronized(output) { output.write(chunk, 0, read) }
          } else {
            break
          }
        }
      }
      synchronized(lock) { session = Session(record, job, output) }
    }

  override suspend fun stop(): ByteArray =
    withContext(Dispatchers.IO) {
      val current =
        synchronized(lock) { session.also { session = null } }
          ?: return@withContext encodeWav(ByteArray(0))
      try {
        runCatching { current.record.stop() }
        current.job.cancelAndJoin()
      } finally {
        runCatching { current.record.release() }
      }
      val pcm = synchronized(current.output) { current.output.toByteArray() }
      encodeWav(pcm)
    }

  override fun cancel() {
    val current = synchronized(lock) { session.also { session = null } } ?: return
    current.job.cancel()
    try {
      runCatching { current.record.stop() }
    } finally {
      runCatching { current.record.release() }
    }
  }

  private class Session(
    val record: AudioRecord,
    val job: Job,
    val output: ByteArrayOutputStream,
  )

  internal companion object {
    const val SAMPLE_RATE = 16_000
    private const val CHANNELS = 1
    private const val BITS_PER_SAMPLE = 16
    private const val BYTES_PER_SAMPLE = 2
    private const val BYTE_RATE = SAMPLE_RATE * CHANNELS * BYTES_PER_SAMPLE
    private const val BLOCK_ALIGN = CHANNELS * BYTES_PER_SAMPLE
    private const val WAV_HEADER_BYTES = 44
    private const val RIFF_CHUNK_HEADER_BYTES = 36
    private const val FMT_CHUNK_SIZE = 16
    private const val PCM_FORMAT = 1
    private const val MIN_BUFFER_BYTES = 4_096

    fun encodeWav(pcm: ByteArray): ByteArray =
      ByteBuffer.allocate(WAV_HEADER_BYTES + pcm.size)
        .order(ByteOrder.LITTLE_ENDIAN)
        .apply {
          put("RIFF".toByteArray(Charsets.US_ASCII))
          putInt(RIFF_CHUNK_HEADER_BYTES + pcm.size)
          put("WAVE".toByteArray(Charsets.US_ASCII))
          put("fmt ".toByteArray(Charsets.US_ASCII))
          putInt(FMT_CHUNK_SIZE)
          putShort(PCM_FORMAT.toShort())
          putShort(CHANNELS.toShort())
          putInt(SAMPLE_RATE)
          putInt(BYTE_RATE)
          putShort(BLOCK_ALIGN.toShort())
          putShort(BITS_PER_SAMPLE.toShort())
          put("data".toByteArray(Charsets.US_ASCII))
          putInt(pcm.size)
          put(pcm)
        }
        .array()
  }
}
