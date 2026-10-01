// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleTesting02

import ai.koog.agents.core.tools.ToolRegistry
import ai.koog.agents.testing.tools.getMockExecutor
val toolRegistry = ToolRegistry {}

// Create a mock LLM executor
val mockLLMApi = getMockExecutor {
  // Mock a simple text response
  mockLLMAnswer("Hello!") onRequestContains "Hello"

  // Mock a default response
  mockLLMAnswer("I don't know how to answer that.").asDefaultResponse
}
