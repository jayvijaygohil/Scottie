// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleTesting18

import ai.koog.agents.testing.tools.getMockExecutor
val promptExecutor = 

getMockExecutor {
    mockLLMAnswer("Response A") onRequestContains "topic A"
    mockLLMAnswer("Response B") onRequestContains "topic B"
    mockLLMAnswer("Exact response") onRequestEquals "exact question"
    mockLLMAnswer("Conditional response") onCondition { it.contains("keyword") && it.length > 10 }
}
