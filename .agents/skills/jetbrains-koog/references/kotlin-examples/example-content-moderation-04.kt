// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleContentModeration04

import ai.koog.prompt.dsl.ModerationCategory
import ai.koog.prompt.dsl.ModerationCategoryResult
import kotlinx.serialization.Serializable

@Serializable
public data class ModerationResult(
    val isHarmful: Boolean,
    val categories: Map<ModerationCategory, ModerationCategoryResult>
) {
    /**
     * A list of moderation categories that have been flagged as detected in the moderation result.
     *
     * Used to identify the specific types of violations found in the moderated content.
     */
    public val violatedCategories: List<ModerationCategory> = categories.filter { it.value.detected }.keys.toList()

    /**
     * Represents the type of input provided for content moderation.
     *
     * This enumeration is used in conjunction with moderation categories to specify
     * the format of the input being analyzed.
     */
    @Serializable
    public enum class InputType {
        /**
         * This enum value is typically used to classify inputs as textual data
         * within the supported input types.
         */
        TEXT,

        /**
         * Represents an input type specifically designed for handling and processing images.
         * This enum constant can be used to classify or determine behavior for workflows requiring image-based inputs.
         */
        IMAGE,
    }
}
