// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleHandlingFailures05

import ai.koog.prompt.executor.clients.retry.RetryConfig
import ai.koog.prompt.executor.clients.retry.RetryablePattern

val config = RetryConfig(
    retryablePatterns = RetryConfig.DEFAULT_PATTERNS + listOf(
        RetryablePattern.Keyword("custom_error")
    )
)
