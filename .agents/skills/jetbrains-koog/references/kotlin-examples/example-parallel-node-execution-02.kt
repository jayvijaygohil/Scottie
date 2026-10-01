// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleParallelNodeExecution02

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.dsl.builder.parallel

typealias Input = String
typealias Output = Int

val strategy = strategy<String, String>("strategy_name") {
   val nodeCalcTokens by node<Input, Output>() { 1 }
   val nodeCalcSymbols by node<Input, Output>() { 2 }
   val nodeCalcWords by node<Input, Output>() { 3 }

val calc by parallel<String, Int>(
   nodeCalcTokens, nodeCalcSymbols, nodeCalcWords,
) {
   selectByMax { it }
}
}
