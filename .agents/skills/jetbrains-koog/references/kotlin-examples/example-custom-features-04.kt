// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCustomFeatures04

import ai.koog.agents.core.feature.config.FeatureConfig
import ai.koog.agents.core.feature.handler.AgentLifecycleEventContext

class MyFeatureConfig : FeatureConfig() {
    override fun setEventFilter(filter: (AgentLifecycleEventContext) -> Boolean) {
        // Deactivate event filtering for the feature
        throw UnsupportedOperationException("Event filtering is not allowed.")
    }
}
