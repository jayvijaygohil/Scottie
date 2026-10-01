// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCreatingPrompts05

import ai.koog.prompt.dsl.prompt

val prompt = prompt("article_review") {
    system("Evaluate the article.")

    // Example 1
    user("The article is clear and easy to understand.")
    assistant("positive")

    // Example 2
    user("The article is hard to read but it's clear and useful.")
    assistant("neutral")

    // Example 3
    user("The article is confusing and misleading.")
    assistant("negative")

    // New input to classify
    user("The article is interesting and helpful.")
}
