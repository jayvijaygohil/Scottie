// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleDataTransferBetweenNodes04

import ai.koog.agents.core.agent.entity.createStorageKey
import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
class UserData(
    val name: String,
    val age: Int
)
fun main() {
    val userDataKey = createStorageKey<UserData>("user-data")
    val str = strategy<String, Unit>("my-strategy") {

val nodeRetrieveData by node<String, Unit> { message ->
    storage.get(userDataKey)?.let { userFromStorage ->
        println("Hello dear $userFromStorage, here's a message for you: $message")
    }
}
    }
}
