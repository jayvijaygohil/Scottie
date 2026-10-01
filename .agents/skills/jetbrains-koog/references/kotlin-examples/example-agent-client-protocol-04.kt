// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleAgentClientProtocol04

import ai.koog.agents.features.acp.toKoogMessage
import ai.koog.prompt.Prompt
import com.agentclientprotocol.model.ContentBlock
import ai.koog.utils.time.KoogClock

val clock: KoogClock = KoogClock.System

private fun Prompt.appendPrompt(content: List<ContentBlock>): Prompt {
    return withMessages { messages ->
        messages + listOf(content.toKoogMessage(clock))
    }
}
