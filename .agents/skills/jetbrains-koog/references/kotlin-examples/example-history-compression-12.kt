// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleHistoryCompression12

import ai.koog.agents.core.agent.session.AIAgentLLMWriteSession
import ai.koog.agents.core.dsl.extension.HistoryCompressionStrategy
import ai.koog.prompt.message.Message
import ai.koog.prompt.message.MessagePart

class MyCustomCompressionStrategy : HistoryCompressionStrategy() {
    override suspend fun compress(
        llmSession: AIAgentLLMWriteSession,
        memoryMessages: List<Message>
    ) {
        // 1. Process the current history in llmSession.prompt.messages
        // 2. Create new compressed messages
        // 3. Update the prompt with the compressed messages

        // Save original messages to preserve them
        val originalMessages = llmSession.prompt.messages
        
        // Example implementation:
        val importantMessages = llmSession.prompt.messages
            .filterIsInstance<Message.Assistant>()
            .filter { message ->
                // Your custom filtering logic
                message.parts.filterIsInstance<MessagePart.Text>().any { it.text.contains("important") }
            }
        
        // Note: you can also make LLM requests using the `llmSession` and ask the LLM to do some job for you using, for example, `llmSession.requestLLMWithoutTools()`
        // Or you can change the current model: `llmSession.model = AnthropicModels.Opus_4_6` and ask some other LLM model -- but don't forget to change it back after

        // Compose the prompt with the filtered messages
        val compressedMessages = composeMessageHistory(
            originalMessages,
            importantMessages,
            memoryMessages
        )
    }
}
