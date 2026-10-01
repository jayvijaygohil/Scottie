// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleEventHandlers01

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.features.eventHandler.feature.handleEvents
import ai.koog.prompt.executor.llms.all.simpleOllamaAIExecutor
import ai.koog.prompt.executor.ollama.client.OllamaModels
val agent = AIAgent(
    promptExecutor = simpleOllamaAIExecutor(),
    llmModel = OllamaModels.Meta.LLAMA_3_2,
) {

handleEvents {
    // Handle tool calls
    onToolCallStarting { eventContext ->
        println("Tool called: ${eventContext.toolName} with args ${eventContext.toolArgs}")
    }
    // Handle event triggered when the agent completes its execution
    onAgentCompleted { eventContext ->
        println("Agent finished with result: ${eventContext.result}")
    }

    // Other event handlers
}
} 
