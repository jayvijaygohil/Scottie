// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleHandlingFailures04

import ai.koog.prompt.executor.clients.retry.RetryConfig
import ai.koog.prompt.executor.clients.retry.RetryablePattern

val config = RetryConfig(
    retryablePatterns = listOf(
        RetryablePattern.Status(429),   // Specific status code
        RetryablePattern.Keyword("quota"),  // Keyword in error message
        RetryablePattern.Regex(Regex("ERR_\\d+")),  // Custom regex pattern
        RetryablePattern.Custom { error ->  // Custom logic
            error.contains("temporary") && error.length > 20
        }
    )
)
