// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleLlmParameters03

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.prompt.params.LLMParams
val strategy = strategy<Unit, Unit>("strategy-name") {
val node by node<Unit, Unit> {

llm.writeSession {
    changeLLMParams(
        LLMParams(
            temperature = 0.7,
            maxTokens = 500
        )
    )
}
   }
}
