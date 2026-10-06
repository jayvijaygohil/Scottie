package com.jayvijay.scottie.feature.modeldownload.data.ai.provider

import ai.runanywhere.proto.v1.InferenceFramework
import ai.runanywhere.proto.v1.ModelCategory
import com.jayvijay.scottie.feature.modeldownload.domain.entities.DownloadFailure
import java.io.ByteArrayInputStream
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder

class LiteRtModelRuntimeTest {
  @get:Rule val folder = TemporaryFolder()

  private val body = ByteArray(600 * 1_024) { it.toByte() }
  private var server = Server()
  private val ranges = mutableListOf<String?>()

  private val dir by lazy { folder.newFolder("litert") }
  private val runtime by lazy { LiteRtModelRuntime(dir) { url -> FakeConnection(url, server) } }
  private val part
    get() = File(dir, "$ID.part")

  private val target
    get() = File(dir, ID)

  private suspend fun prepared(size: Long = body.size.toLong()) = runtime.also {
    it.prepare(listOf(LiteRtModel(ID, "M", "https://x/$ID", size, size, false)))
  }

  @Test
  fun freshDownloadProgressesThenCompletes() = runTest {
    val events = prepared().download(ID).toList()
    assertTrue(events.dropLast(1).all { it is RuntimeDownloadEvent.Progress })
    assertEquals(RuntimeDownloadEvent.Completed, events.last())
    assertArrayEquals(body, target.readBytes())
    assertFalse(part.exists())
    assertEquals(listOf<String?>(null), ranges)
    assertEquals(setOf(ID), runtime.downloadedIds())
  }

  @Test
  fun resumesWithRangeAndPartialContent() = runTest {
    prepared()
    part.writeBytes(body.copyOf(1_000))
    val events = runtime.download(ID).toList()
    assertEquals(listOf<String?>("bytes=1000-"), ranges)
    val first = events.first() as RuntimeDownloadEvent.Progress
    assertTrue(first.progress.bytesDone > 1_000)
    assertEquals(RuntimeDownloadEvent.Completed, events.last())
    assertArrayEquals(body, target.readBytes())
  }

  @Test
  fun restartsWhenServerIgnoresRange() = runTest {
    server = Server(honorRange = false)
    prepared()
    part.writeBytes(ByteArray(1_000) { 7 })
    assertEquals(RuntimeDownloadEvent.Completed, runtime.download(ID).last())
    assertArrayEquals(body, target.readBytes())
  }

  @Test
  fun sizeMismatchIsCorruptedAndDropsPart() = runTest {
    val result = prepared(size = body.size + 1L).download(ID).last()
    assertEquals(RuntimeDownloadEvent.Failed(DownloadFailure.CORRUPTED), result)
    assertFalse(part.exists())
    assertFalse(target.exists())
  }

  @Test
  fun outOfSpaceIsStorage() = runTest {
    server = Server(failure = IOException("write failed: ENOSPC (No space left on device)"))
    val result = prepared().download(ID).last()
    assertEquals(RuntimeDownloadEvent.Failed(DownloadFailure.STORAGE), result)
  }

  @Test
  fun otherIoFailureIsNetwork() = runTest {
    server = Server(failure = IOException("reset"))
    val result = prepared().download(ID).last()
    assertEquals(RuntimeDownloadEvent.Failed(DownloadFailure.NETWORK), result)
  }

  @Test
  fun httpErrorIsNetwork() = runTest {
    server = Server(code = HttpURLConnection.HTTP_NOT_FOUND)
    val result = prepared().download(ID).last()
    assertEquals(RuntimeDownloadEvent.Failed(DownloadFailure.NETWORK), result)
  }

  @Test
  fun cancellingKeepsPart() = runTest {
    server = Server(stallAfterFirstRead = true)
    prepared().download(ID).take(1).toList()
    assertTrue(part.length() > 0)
    assertFalse(target.exists())
    assertEquals(emptySet<String>(), runtime.downloadedIds())
  }

  @Test
  fun deleteRemovesBothFiles() = runTest {
    prepared()
    part.writeBytes(byteArrayOf(1))
    target.writeBytes(byteArrayOf(1))
    runtime.delete(ID)
    assertFalse(part.exists())
    assertFalse(target.exists())
  }

  @Test
  fun prepareAcceptsOnlyLiteRtRows() = runTest {
    val stt = MultiFileModel("stt", "S", SHERPA, STT, 1, files = emptyList())
    val lite = LiteRtModel(ID, "M", "u", 1, 1, false)
    assertEquals(setOf(ID), runtime.prepare(listOf(lite, stt)))
  }

  private data class Server(
    val honorRange: Boolean = true,
    val code: Int = HttpURLConnection.HTTP_OK,
    val failure: IOException? = null,
    /** Gives the collector time to cancel before the transfer can finish. */
    val stallAfterFirstRead: Boolean = false,
  )

  private inner class FakeConnection(url: URL, private val server: Server) :
    HttpURLConnection(url) {
    private var range: String? = null

    override fun setRequestProperty(key: String, value: String) {
      if (key == "Range") range = value
    }

    override fun getResponseCode(): Int {
      ranges += range
      return when {
        server.code != HTTP_OK -> server.code
        range != null && server.honorRange -> HTTP_PARTIAL
        else -> HTTP_OK
      }
    }

    override fun getInputStream(): InputStream {
      val start = range?.takeIf { server.honorRange }?.removePrefix("bytes=")?.removeSuffix("-")
      val bytes = ByteArrayInputStream(body, start?.toInt() ?: 0, body.size - (start?.toInt() ?: 0))
      return object : InputStream() {
        private var reads = 0

        override fun read(): Int = bytes.read()

        override fun read(b: ByteArray, off: Int, len: Int): Int {
          server.failure?.let { throw it }
          if (server.stallAfterFirstRead && reads++ > 0) Thread.sleep(STALL_MS)
          return bytes.read(b, off, len)
        }
      }
    }

    override fun connect() = Unit

    override fun disconnect() = Unit

    override fun usingProxy() = false
  }

  private companion object {
    const val ID = "m.litertlm"
    const val STALL_MS = 500L
    val SHERPA = InferenceFramework.INFERENCE_FRAMEWORK_SHERPA
    val STT = ModelCategory.MODEL_CATEGORY_SPEECH_RECOGNITION
  }
}
