// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleDataTransferBetweenNodes02

import ai.koog.agents.core.agent.entity.createStorageKey
class UserData(
    val name: String,
    val age: Int
)

val userDataKey = createStorageKey<UserData>("user-data")
