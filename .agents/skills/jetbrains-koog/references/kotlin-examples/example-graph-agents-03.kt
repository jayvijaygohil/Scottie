// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleGraphAgents03

import ai.koog.prompt.message.Message
import ai.koog.prompt.message.MessagePart
/**

onCondition { it is Message.Assistant } transformed { (it as Message.Assistant).parts.filterIsInstance<MessagePart.Text>().joinToString("\n") { part -> part.text } }
**/
