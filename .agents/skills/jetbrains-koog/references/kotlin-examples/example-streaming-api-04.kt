// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleStreamingApi04

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.agent.GraphAIAgent
import ai.koog.agents.features.eventHandler.feature.handleEvents
import ai.koog.prompt.streaming.StreamFrame
import ai.koog.prompt.structure.markdown.MarkdownStructureDefinition
fun GraphAIAgent.FeatureContext.installStreamingApi() {

handleEvents {
    onToolCallStarting { context ->
        println("\n🔧 Using ${context.toolName} with ${context.toolArgs}... ")
    }

    onLLMStreamingFrameReceived { context ->
        when (val frame = context.streamFrame) {
            is StreamFrame.TextDelta -> print(frame.text)
            is StreamFrame.ReasoningDelta -> print("[Reasoning] text=${frame.text} summary=${frame.summary}")
            else -> {} // Handle other frame types if needed
        }
    }

    onLLMStreamingFailed { context ->
        println("❌ Error: ${context.error}")
    }

    onLLMStreamingCompleted {
        println("🏁 Done")
    }
}
}
