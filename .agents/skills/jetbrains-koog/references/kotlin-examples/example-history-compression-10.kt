// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleHistoryCompression10

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.dsl.builder.subgraph
import ai.koog.agents.core.dsl.extension.nodeLLMCompressHistory
import ai.koog.agents.core.dsl.extension.FactRetrievalHistoryCompressionStrategy
import ai.koog.agents.core.dsl.extension.Concept
import ai.koog.agents.core.dsl.extension.FactType
typealias ProcessedInput = String
val strategy = strategy<String, String>("strategy_name") {
val node by node<Unit, Unit> {

val compressHistory by nodeLLMCompressHistory<ProcessedInput>(
    strategy = FactRetrievalHistoryCompressionStrategy(
        Concept(
            keyword = "user_preferences",
            // Description to the LLM -- what specifically to search for
            description = "User's preferences for the recommendation system, including the preferred conversation style, theme in the application, etc.",
            // LLM would search for multiple relevant facts related to this concept:
            factType = FactType.MULTIPLE
        ),
        Concept(
            keyword = "product_details",
            // Description to the LLM -- what specifically to search for
            description = "Brief details about products in the catalog the user has been checking",
            // LLM would search for multiple relevant facts related to this concept:
            factType = FactType.MULTIPLE
        ),
        Concept(
            keyword = "issue_solved",
            // Description to the LLM -- what specifically to search for
            description = "Was the initial user's issue resolved?",
            // LLM would search for a single answer to the question:
            factType = FactType.SINGLE
        )
    )
)
    }
}
