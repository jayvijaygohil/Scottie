// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleStreamingApi01

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.prompt.streaming.StreamFrame
val strategy = strategy<String, String>("strategy_name") {
    val node by node<Unit, Unit> {

llm.writeSession {
    appendPrompt { user("Tell me a joke, then call a tool with JSON args.") }

    val stream = requestLLMStreaming() // Flow<StreamFrame>

    stream.collect { frame ->
        when (frame) {
            is StreamFrame.TextDelta -> print(frame.text)
            is StreamFrame.ReasoningDelta -> print("[Reasoning] text=${frame.text} summary=${frame.summary}")
            is StreamFrame.ToolCallComplete -> {
                println("\n🔧 Tool call: ${frame.name} args=${frame.content}")
                // Optionally parse lazily:
                // val json = frame.contentJson
            }
            is StreamFrame.End -> println("\n[END] reason=${frame.finishReason}")
            else -> {} // Handle other frame types (TextComplete, ToolCallDelta, etc.)
        }
    }
}
   }
}
