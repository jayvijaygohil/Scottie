package com.jayvijay.scottie.di

import ai.koog.http.client.KoogHttpClientException
import ai.koog.prompt.executor.clients.LLMClientException
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.InferenceFailure
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.InferenceFailure.MODEL_UNAVAILABLE
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.InferenceFailure.OFFLINE
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.InferenceFailure.UNAUTHORIZED
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.InferenceFailure.UNKNOWN
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import org.junit.Assert.assertEquals
import org.junit.Test

class InferenceFailureClassifierTest {
  private fun client(cause: Throwable) = LLMClientException("c", cause = cause)

  private fun http(status: Int) = client(KoogHttpClientException(statusCode = status))

  @Test
  fun httpStatusesMapToActionableFailures() {
    mapOf(401 to UNAUTHORIZED, 403 to UNAUTHORIZED, 404 to MODEL_UNAVAILABLE)
      .plus(400 to MODEL_UNAVAILABLE)
      .plus(500 to UNKNOWN)
      .forEach { (status, failure) ->
        assertEquals("$status", failure, classifyInference(http(status)))
      }
  }

  @Test
  fun transportErrorsAreOffline() {
    assertEquals(OFFLINE, classifyInference(client(UnknownHostException())))
    assertEquals(OFFLINE, classifyInference(SocketTimeoutException()))
  }

  @Test
  fun anythingElseIsUnknown() {
    assertEquals(InferenceFailure.UNKNOWN, classifyInference(IllegalStateException()))
  }
}
