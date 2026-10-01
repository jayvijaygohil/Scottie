// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleNodesAndComponent11

/**

inline fun <reified T> AIAgentNodeDelegate<Input, Output>.transform(
    noinline transformation: suspend (Output) -> T
): AIAgentNodeDelegate<Input, T>
**/
