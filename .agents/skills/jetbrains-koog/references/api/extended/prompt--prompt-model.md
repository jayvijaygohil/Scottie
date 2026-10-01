# prompt / prompt-model

Additional Kotlin contracts from the supplied Dokka build. Read [API coverage](../../api-index.md) before use.

## ai.koog.prompt.annotations.InternalPromptAPI

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.annotations/-internal-prompt-a-p-i/index.html`

### :prompt:prompt-model/commonMain

```kotlin
annotation class InternalPromptAPI
```

Indicates that the annotated API is internal to prompt-related implementations and not intended for public use.

Classes, functions, or members marked with this annotation are part of the internal functionality of the Koog core infrastructure and are not guaranteed to maintain backwards compatibility. They are subject to change, removal, or modification without notice.

This annotation is primarily used to signal to developers that the API is not designed for general application development and should only be used with caution in specialized scenarios, such as extending or modifying internal behavior.

## ai.koog.prompt.dsl.ModerationCategory.Defamation

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category/-defamation/index.html`

### :prompt:prompt-model/commonMain

```kotlin
object Defamation : ModerationCategory
```

Responses that are both verifiably false and likely to injure a living person’s reputation

## ai.koog.prompt.dsl.ModerationCategory.ElectionsMisinformation

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category/-elections-misinformation/index.html`

### :prompt:prompt-model/commonMain

```kotlin
object ElectionsMisinformation : ModerationCategory
```

Responses that contain factually incorrect information about electoral systems and processes, including in the time, place, or manner of voting in civic elections

## ai.koog.prompt.dsl.ModerationCategory.Harassment

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category/-harassment/index.html`

### :prompt:prompt-model/commonMain

```kotlin
object Harassment : ModerationCategory
```

Represents the "Harassment" moderation category.

This category is used to flag content that involves intimidation, bullying, or other behaviors directed towards individuals or groups with the intent to harass or demean.

Content flagged under this category may exhibit harmful or abusive language, intended to provoke or distress others.

## ai.koog.prompt.dsl.ModerationCategory.HarassmentThreatening

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category/-harassment-threatening/index.html`

### :prompt:prompt-model/commonMain

```kotlin
object HarassmentThreatening : ModerationCategory
```

Represents the category of moderation specifically focused on identifying content that involves harassment with a threatening nature.

This includes harmful interactions or communications that are intended to intimidate, coerce, or threaten individuals or groups.

## ai.koog.prompt.dsl.ModerationCategory.Hate

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category/-hate/index.html`

### :prompt:prompt-model/commonMain

```kotlin
object Hate : ModerationCategory
```

Represents content categorized as hate speech or related material.

The HATE category is used to denote content that contains elements perceived as offensive, discriminatory, or expressing hatred towards individuals or groups based on attributes such as race, religion, gender, or other characteristics. This designation is typically used in content moderation and classification systems to identify and flag harmful material.

## ai.koog.prompt.dsl.ModerationCategory.HateThreatening

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category/-hate-threatening/index.html`

### :prompt:prompt-model/commonMain

```kotlin
object HateThreatening : ModerationCategory
```

Represents the HATE_THREATENING moderation category.

This category identifies content that exhibits hateful behavior combined with direct or indirect threats. The HATE_THREATENING category is a specific subset of hate-related moderation, focusing on harmful content that not only spreads hate but also includes threatening language, behavior, or implications.

## ai.koog.prompt.dsl.ModerationCategory.Illicit

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category/-illicit/index.html`

### :prompt:prompt-model/commonMain

```kotlin
object Illicit : ModerationCategory
```

Represents the moderation category for content that may involve illegal or illicit activities. This category is used to identify content that violates legal frameworks or ethical guidelines.

## ai.koog.prompt.dsl.ModerationCategory.IllicitViolent

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category/-illicit-violent/index.html`

### :prompt:prompt-model/commonMain

```kotlin
object IllicitViolent : ModerationCategory
```

Represents content classified as both illicit and violent in nature.

This category is used for moderation purposes where content involves a combination of illegal or illicit activities with elements of violence. The classification may include materials that promote or depict violent actions involving unlawful or prohibited activities.

## ai.koog.prompt.dsl.ModerationCategory.IntellectualProperty

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category/-intellectual-property/index.html`

### :prompt:prompt-model/commonMain

```kotlin
object IntellectualProperty : ModerationCategory
```

Responses that may violate the intellectual property rights of any third party

## ai.koog.prompt.dsl.ModerationCategory.Misconduct

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category/-misconduct/index.html`

### :prompt:prompt-model/commonMain

```kotlin
object Misconduct : ModerationCategory
```

Represents a predefined moderation category for cases associated with misconduct.

Note: Used in AWS Bedrock filters

## ai.koog.prompt.dsl.ModerationCategory.ModerationCategory

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category/-moderation-category.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(name: String)
```

## ai.koog.prompt.dsl.ModerationCategory.Privacy

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category/-privacy/index.html`

### :prompt:prompt-model/commonMain

```kotlin
object Privacy : ModerationCategory
```

Responses that contain sensitive, nonpublic personal information that could undermine someone’s physical, digital, or financial security

## ai.koog.prompt.dsl.ModerationCategory.PromptAttack

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category/-prompt-attack/index.html`

### :prompt:prompt-model/commonMain

```kotlin
object PromptAttack : ModerationCategory
```

Represents a specific moderation category for identifying and handling potential prompt attacks.

Note: Used in AWS Bedrock filters

## ai.koog.prompt.dsl.ModerationCategory.SelfHarm

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category/-self-harm/index.html`

### :prompt:prompt-model/commonMain

```kotlin
object SelfHarm : ModerationCategory
```

Represents the "SELF_HARM" moderation category. This category is used to identify content that pertains to self-harm or related behavior.

## ai.koog.prompt.dsl.ModerationCategory.SelfHarmInstructions

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category/-self-harm-instructions/index.html`

### :prompt:prompt-model/commonMain

```kotlin
object SelfHarmInstructions : ModerationCategory
```

Represents the moderation category for instructions or content that encourages or promotes self-harm.

This category is used to flag content that provides guidance, techniques, or encouragement for engaging in self-harm behaviors. It helps in detecting and preventing the spread of harmful instructional content.

## ai.koog.prompt.dsl.ModerationCategory.SelfHarmIntent

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category/-self-harm-intent/index.html`

### :prompt:prompt-model/commonMain

```kotlin
object SelfHarmIntent : ModerationCategory
```

Represents content that explicitly indicates an intent of self-harm.

This category is used in moderation to evaluate material that contains expressions or indications of an individual's intent to harm themselves.

## ai.koog.prompt.dsl.ModerationCategory.Sexual

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category/-sexual/index.html`

### :prompt:prompt-model/commonMain

```kotlin
object Sexual : ModerationCategory
```

Represents content categorized as sexual in nature.

This category is used to flag or identify content that is sexually explicit or contains sexual references. It is often utilized in content moderation systems to ensure compliance with guidelines and to prevent inappropriate or harmful material from being disseminated.

## ai.koog.prompt.dsl.ModerationCategory.SexualMinors

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category/-sexual-minors/index.html`

### :prompt:prompt-model/commonMain

```kotlin
object SexualMinors : ModerationCategory
```

Represents content related to sexual material involving minors.

This category is used for moderation purposes to flag and handle inappropriate or harmful content concerning the exploitation, abuse, or endangerment of minors in a sexual context.

## ai.koog.prompt.dsl.ModerationCategory.SpecializedAdvice

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category/-specialized-advice/index.html`

### :prompt:prompt-model/commonMain

```kotlin
object SpecializedAdvice : ModerationCategory
```

Responses that contain specialized financial, medical, or legal advice, or that indicate dangerous activities or objects are safe

## ai.koog.prompt.dsl.ModerationCategory.Violence

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category/-violence/index.html`

### :prompt:prompt-model/commonMain

```kotlin
object Violence : ModerationCategory
```

Represents the category of content classified as violent behavior or actions.

This moderation category is used to identify content that promotes, incites, or depicts violence and physical harm towards individuals or groups.

## ai.koog.prompt.dsl.ModerationCategory.ViolenceGraphic

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category/-violence-graphic/index.html`

### :prompt:prompt-model/commonMain

```kotlin
object ViolenceGraphic : ModerationCategory
```

Represents the VIOLENCE_GRAPHIC moderation category.

This category pertains to content that includes graphic depictions of violence, which may be harmful, distressing, or triggering to viewers.

It is used to classify and moderate content that explicitly involves detailed graphic or extreme visual elements of violent acts or scenes.

## ai.koog.prompt.dsl.ModerationCategory.equals

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category/equals.html`

### :prompt:prompt-model/commonMain

```kotlin
open operator override fun equals(other: Any?): Boolean
```

Compares this object with another for equality. Two instances of ModerationCategory are equal if their name is equal.

true if the specified object is a ModerationCategory and has the same name; false otherwise.

- other — The object to compare with this instance.
## ai.koog.prompt.dsl.ModerationCategory.hashCode

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category/hash-code.html`

### :prompt:prompt-model/commonMain

```kotlin
open override fun hashCode(): Int
```

## ai.koog.prompt.dsl.ModerationCategory

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable open class ModerationCategory(val name: String)
```

Represents categories for content moderation used to classify potentially harmful or inappropriate content. These categories help identify specific types of violations that content may fall under.

- Harassment
- HarassmentThreatening
- Hate
- HateThreatening
- Illicit
- IllicitViolent
- SelfHarm
- SelfHarmIntent
- SelfHarmInstructions
- Sexual
- SexualMinors
- Violence
- ViolenceGraphic
- Defamation
- SpecializedAdvice
- Privacy
- IntellectualProperty
- ElectionsMisinformation
- Misconduct
- PromptAttack
## ai.koog.prompt.dsl.ModerationCategory.name

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category/name.html`

### :prompt:prompt-model/commonMain

```kotlin
val name: String
```

## ai.koog.prompt.dsl.ModerationCategoryResult.ModerationCategoryResult

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category-result/-moderation-category-result.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(detected: Boolean, confidenceScore: Double? = null, appliedInputTypes: List<ModerationResult.InputType> = emptyList())
```

## ai.koog.prompt.dsl.ModerationCategoryResult.appliedInputTypes

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category-result/applied-input-types.html`

### :prompt:prompt-model/commonMain

```kotlin
val appliedInputTypes: List<ModerationResult.InputType>
```

## ai.koog.prompt.dsl.ModerationCategoryResult.confidenceScore

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category-result/confidence-score.html`

### :prompt:prompt-model/commonMain

```kotlin
val confidenceScore: Double?
```

## ai.koog.prompt.dsl.ModerationCategoryResult.detected

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category-result/detected.html`

### :prompt:prompt-model/commonMain

```kotlin
val detected: Boolean
```

## ai.koog.prompt.dsl.ModerationCategoryResult

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-category-result/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class ModerationCategoryResult(val detected: Boolean, val confidenceScore: Double? = null, val appliedInputTypes: List<ModerationResult.InputType> = emptyList())
```

Represents the detailed result of moderating a specific category of content.

## ai.koog.prompt.dsl.ModerationResult.InputType.IMAGE

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-result/-input-type/-i-m-a-g-e/index.html`

### :prompt:prompt-model/commonMain

```kotlin
IMAGE
```

Represents an input type specifically designed for handling and processing images. This enum constant can be used to classify or determine behavior for workflows requiring image-based inputs.

## ai.koog.prompt.dsl.ModerationResult.InputType.TEXT

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-result/-input-type/-t-e-x-t/index.html`

### :prompt:prompt-model/commonMain

```kotlin
TEXT
```

This enum value is typically used to classify inputs as textual data within the supported input types.

## ai.koog.prompt.dsl.ModerationResult.InputType.entries

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-result/-input-type/entries.html`

### :prompt:prompt-model/commonMain

```kotlin
val entries: EnumEntries<ModerationResult.InputType>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.prompt.dsl.ModerationResult.InputType

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-result/-input-type/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable enum InputType : Enum<ModerationResult.InputType>
```

Represents the type of input provided for content moderation.

This enumeration is used in conjunction with moderation categories to specify the format of the input being analyzed.

## ai.koog.prompt.dsl.ModerationResult.InputType.valueOf

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-result/-input-type/value-of.html`

### :prompt:prompt-model/commonMain

```kotlin
fun valueOf(value: String): ModerationResult.InputType
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.prompt.dsl.ModerationResult.InputType.values

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-result/-input-type/values.html`

### :prompt:prompt-model/commonMain

```kotlin
fun values(): Array<ModerationResult.InputType>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.prompt.dsl.ModerationResult.ModerationResult

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-result/-moderation-result.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(isHarmful: Boolean, categories: Map<ModerationCategory, ModerationCategoryResult>)
```

## ai.koog.prompt.dsl.ModerationResult.categories

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-result/categories.html`

### :prompt:prompt-model/commonMain

```kotlin
val categories: Map<ModerationCategory, ModerationCategoryResult>
```

## ai.koog.prompt.dsl.ModerationResult

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-result/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class ModerationResult(val isHarmful: Boolean, val categories: Map<ModerationCategory, ModerationCategoryResult>)
```

Represents the result of a content moderation request.

## ai.koog.prompt.dsl.ModerationResult.isHarmful

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-result/is-harmful.html`

### :prompt:prompt-model/commonMain

```kotlin
val isHarmful: Boolean
```

## ai.koog.prompt.dsl.ModerationResult.violatedCategories

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-result/violated-categories.html`

### :prompt:prompt-model/commonMain

```kotlin
val violatedCategories: List<ModerationCategory>
```

A list of moderation categories that have been flagged as detected in the moderation result.

Used to identify the specific types of violations found in the moderated content.

## ai.koog.prompt.dsl.ModerationResult.violatesAll

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-result/violates-all.html`

### :prompt:prompt-model/commonMain

```kotlin
fun violatesAll(vararg checkedCategories: ModerationCategory): Boolean
```

Checks if all the provided moderation categories are violated in this moderation result.

This method evaluates whether all specified categories have been flagged as "detected" within the current moderation result's category map.

true if all provided categories are flagged as detected; false otherwise.

- checkedCategories — A variable number of ModerationCategory objects representing the categories to check for violations.
## ai.koog.prompt.dsl.ModerationResult.violatesCategory

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-result/violates-category.html`

### :prompt:prompt-model/commonMain

```kotlin
fun violatesCategory(category: ModerationCategory): Boolean
```

Checks if the specified moderation category is flagged as detected in the moderation result.

true if the specified category is flagged as detected; false otherwise.

- category — The moderation category to verify within the current moderation result.
## ai.koog.prompt.dsl.ModerationResult.violatesOneOf

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-moderation-result/violates-one-of.html`

### :prompt:prompt-model/commonMain

```kotlin
fun violatesOneOf(vararg checkedCategories: ModerationCategory): Boolean
```

Evaluates whether the content violates any of the specified moderation categories.

true if any of the specified categories are flagged as detected, false otherwise.

- checkedCategories — A variable number of ModerationCategory objects to check if the content is flagged in any of these categories.
## ai.koog.prompt.message.AssistantMessageBuilder.AssistantMessageBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-assistant-message-builder/-assistant-message-builder.html`

### :prompt:prompt-model/jvmMain

```kotlin
constructor()
```

## ai.koog.prompt.message.AssistantMessageBuilder.addPart

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-assistant-message-builder/add-part.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun addPart(part: MessagePart.ResponsePart): AssistantMessageBuilder
```

## ai.koog.prompt.message.AssistantMessageBuilder.addReasoning

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-assistant-message-builder/add-reasoning.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun addReasoning(toolResult: MessagePart.Reasoning): AssistantMessageBuilder
```

## ai.koog.prompt.message.AssistantMessageBuilder.addText

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-assistant-message-builder/add-text.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun addText(content: String, cache: CacheControl? = null): AssistantMessageBuilder
```

## ai.koog.prompt.message.AssistantMessageBuilder.addToolCall

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-assistant-message-builder/add-tool-call.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun addToolCall(toolCall: MessagePart.Tool.Call): AssistantMessageBuilder
```

## ai.koog.prompt.message.AssistantMessageBuilder.build

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-assistant-message-builder/build.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun build(): Message.Assistant
```

Builds a new Message.Assistant instance.

- IllegalStateException — if no content parts have been added.
## ai.koog.prompt.message.AssistantMessageBuilder.finishReason

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-assistant-message-builder/finish-reason.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun finishReason(finishReason: String): AssistantMessageBuilder
```

Sets the finish reason.

## ai.koog.prompt.message.AssistantMessageBuilder.id

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-assistant-message-builder/id.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun id(id: String?): AssistantMessageBuilder
```

## ai.koog.prompt.message.AssistantMessageBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-assistant-message-builder/index.html`

### :prompt:prompt-model/jvmMain

```kotlin
class AssistantMessageBuilder
```

## ai.koog.prompt.message.AssistantMessageBuilder.metaInfo

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-assistant-message-builder/meta-info.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun metaInfo(metaInfo: ResponseMetaInfo): AssistantMessageBuilder
```

## ai.koog.prompt.message.AttachmentContent.Binary.Base64.toString

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-content/-binary/-base64/to-string.html`

### :prompt:prompt-model/commonMain

```kotlin
open override fun toString(): String
```

## ai.koog.prompt.message.AttachmentContent.Binary.Bytes.equals

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-content/-binary/-bytes/equals.html`

### :prompt:prompt-model/commonMain

```kotlin
open operator override fun equals(other: Any?): Boolean
```

## ai.koog.prompt.message.AttachmentContent.Binary.Bytes.hashCode

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-content/-binary/-bytes/hash-code.html`

### :prompt:prompt-model/commonMain

```kotlin
open override fun hashCode(): Int
```

## ai.koog.prompt.message.AttachmentContent.Binary.Bytes.toString

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-content/-binary/-bytes/to-string.html`

### :prompt:prompt-model/commonMain

```kotlin
open override fun toString(): String
```

## ai.koog.prompt.message.AttachmentContent.PlainText.toString

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-content/-plain-text/to-string.html`

### :prompt:prompt-model/commonMain

```kotlin
open override fun toString(): String
```

## ai.koog.prompt.message.MessageBuilder.assistant

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-builder/assistant.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun assistant(): AssistantMessageBuilder
```

Creates a new AssistantMessageBuilder for building Message.Assistant instances.

## ai.koog.prompt.message.MessageBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-builder/index.html`

### :prompt:prompt-model/jvmMain

```kotlin
object MessageBuilder
```

## ai.koog.prompt.message.MessageBuilder.system

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-builder/system.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun system(): SystemMessageBuilder
```

Creates a new SystemMessageBuilder for building Message.System instances.

## ai.koog.prompt.message.MessageBuilder.user

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-builder/user.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun user(): UserMessageBuilder
```

Creates a new UserMessageBuilder for building Message.User instances.

## ai.koog.prompt.message.ReasoningBuilder.ReasoningBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-reasoning-builder/-reasoning-builder.html`

### :prompt:prompt-model/jvmMain

```kotlin
constructor()
```

## ai.koog.prompt.message.ReasoningBuilder.build

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-reasoning-builder/build.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun build(): MessagePart.Reasoning
```

Builds a new MessagePart.Reasoning instance.

- IllegalStateException — if no content parts have been added.
## ai.koog.prompt.message.ReasoningBuilder.cacheControl

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-reasoning-builder/cache-control.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun cacheControl(cacheControl: CacheControl?): ReasoningBuilder
```

Sets the cache-control directive for the provider's prompt-caching feature.

## ai.koog.prompt.message.ReasoningBuilder.content

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-reasoning-builder/content.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun content(content: List<String>): ReasoningBuilder
```

Sets a single text content for the message, replacing any previously added parts.

## ai.koog.prompt.message.ReasoningBuilder.encrypted

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-reasoning-builder/encrypted.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun encrypted(encrypted: String?): ReasoningBuilder
```

Sets the encrypted content.

## ai.koog.prompt.message.ReasoningBuilder.id

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-reasoning-builder/id.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun id(id: String?): ReasoningBuilder
```

Sets the reasoning ID.

## ai.koog.prompt.message.ReasoningBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-reasoning-builder/index.html`

### :prompt:prompt-model/jvmMain

```kotlin
class ReasoningBuilder
```

## ai.koog.prompt.message.ReasoningBuilder.summary

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-reasoning-builder/summary.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun summary(summary: List<String>): ReasoningBuilder
```

Sets the summary as a single text string.

## ai.koog.prompt.message.RequestMetaInfoBuilder.RequestMetaInfoBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-request-meta-info-builder/-request-meta-info-builder.html`

### :prompt:prompt-model/jvmMain

```kotlin
constructor()
```

## ai.koog.prompt.message.RequestMetaInfoBuilder.build

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-request-meta-info-builder/build.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun build(): RequestMetaInfo
```

Builds a new RequestMetaInfo instance. If no timestamp is set, the current system time is used.

## ai.koog.prompt.message.RequestMetaInfoBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-request-meta-info-builder/index.html`

### :prompt:prompt-model/jvmMain

```kotlin
class RequestMetaInfoBuilder
```

## ai.koog.prompt.message.RequestMetaInfoBuilder.metadata

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-request-meta-info-builder/metadata.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun metadata(metadata: JsonObject?): RequestMetaInfoBuilder
```

Sets the metadata.

## ai.koog.prompt.message.RequestMetaInfoBuilder.timestamp

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-request-meta-info-builder/timestamp.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun timestamp(timestamp: Instant): RequestMetaInfoBuilder
```

### :prompt:prompt-model/jvmMain

```kotlin
fun timestamp(timestamp: Instant): RequestMetaInfoBuilder
```

Sets the timestamp using kotlin.time.Instant.

## ai.koog.prompt.message.ResponseMetaInfoBuilder.ResponseMetaInfoBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-response-meta-info-builder/-response-meta-info-builder.html`

### :prompt:prompt-model/jvmMain

```kotlin
constructor()
```

## ai.koog.prompt.message.ResponseMetaInfoBuilder.build

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-response-meta-info-builder/build.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun build(): ResponseMetaInfo
```

Builds a new ResponseMetaInfo instance. If no timestamp is set, the current system time is used.

## ai.koog.prompt.message.ResponseMetaInfoBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-response-meta-info-builder/index.html`

### :prompt:prompt-model/jvmMain

```kotlin
class ResponseMetaInfoBuilder
```

## ai.koog.prompt.message.ResponseMetaInfoBuilder.inputTokensCount

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-response-meta-info-builder/input-tokens-count.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun inputTokensCount(count: Int): ResponseMetaInfoBuilder
```

Sets the input token count.

## ai.koog.prompt.message.ResponseMetaInfoBuilder.metadata

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-response-meta-info-builder/metadata.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun metadata(metadata: JsonObject?): ResponseMetaInfoBuilder
```

Sets the metadata.

## ai.koog.prompt.message.ResponseMetaInfoBuilder.outputTokensCount

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-response-meta-info-builder/output-tokens-count.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun outputTokensCount(count: Int): ResponseMetaInfoBuilder
```

Sets the output token count.

## ai.koog.prompt.message.ResponseMetaInfoBuilder.timestamp

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-response-meta-info-builder/timestamp.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun timestamp(timestamp: Instant): ResponseMetaInfoBuilder
```

### :prompt:prompt-model/jvmMain

```kotlin
fun timestamp(timestamp: Instant): ResponseMetaInfoBuilder
```

Sets the timestamp using kotlin.time.Instant.

## ai.koog.prompt.message.ResponseMetaInfoBuilder.totalTokensCount

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-response-meta-info-builder/total-tokens-count.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun totalTokensCount(count: Int): ResponseMetaInfoBuilder
```

Sets the total token count.

## ai.koog.prompt.message.SystemMessageBuilder.SystemMessageBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-system-message-builder/-system-message-builder.html`

### :prompt:prompt-model/jvmMain

```kotlin
constructor()
```

## ai.koog.prompt.message.SystemMessageBuilder.addPart

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-system-message-builder/add-part.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun addPart(part: MessagePart.Text): SystemMessageBuilder
```

Adds a text content part to the message.

## ai.koog.prompt.message.SystemMessageBuilder.addText

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-system-message-builder/add-text.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun addText(content: String, cache: CacheControl? = null): SystemMessageBuilder
```

Adds the text content of the message, replacing any previously added parts.

## ai.koog.prompt.message.SystemMessageBuilder.build

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-system-message-builder/build.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun build(): Message.System
```

Builds a new Message.System instance.

- IllegalStateException — if no content parts have been added.
## ai.koog.prompt.message.SystemMessageBuilder.id

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-system-message-builder/id.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun id(id: String?): SystemMessageBuilder
```

## ai.koog.prompt.message.SystemMessageBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-system-message-builder/index.html`

### :prompt:prompt-model/jvmMain

```kotlin
class SystemMessageBuilder
```

## ai.koog.prompt.message.SystemMessageBuilder.metaInfo

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-system-message-builder/meta-info.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun metaInfo(metaInfo: RequestMetaInfo): SystemMessageBuilder
```

## ai.koog.prompt.message.ToolCallBuilder.ToolCallBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-tool-call-builder/-tool-call-builder.html`

### :prompt:prompt-model/jvmMain

```kotlin
constructor()
```

## ai.koog.prompt.message.ToolCallBuilder.args

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-tool-call-builder/args.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun args(args: JsonObject): ToolCallBuilder
```

Sets the tool call arguments.

## ai.koog.prompt.message.ToolCallBuilder.build

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-tool-call-builder/build.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun build(): MessagePart.Tool.Call
```

Builds a new MessagePart.Tool.Call instance.

- IllegalStateException — if tool name or content parts are missing.
## ai.koog.prompt.message.ToolCallBuilder.cacheControl

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-tool-call-builder/cache-control.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun cacheControl(cacheControl: CacheControl?): ToolCallBuilder
```

Sets the cache-control directive for the provider's prompt-caching feature.

## ai.koog.prompt.message.ToolCallBuilder.id

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-tool-call-builder/id.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun id(id: String?): ToolCallBuilder
```

Sets the tool call ID.

## ai.koog.prompt.message.ToolCallBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-tool-call-builder/index.html`

### :prompt:prompt-model/jvmMain

```kotlin
class ToolCallBuilder
```

## ai.koog.prompt.message.ToolCallBuilder.tool

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-tool-call-builder/tool.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun tool(tool: String): ToolCallBuilder
```

Sets the tool name.

## ai.koog.prompt.message.ToolResultBuilder.ToolResultBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-tool-result-builder/-tool-result-builder.html`

### :prompt:prompt-model/jvmMain

```kotlin
constructor()
```

## ai.koog.prompt.message.ToolResultBuilder.build

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-tool-result-builder/build.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun build(): MessagePart.Tool.Result
```

Builds a new MessagePart.Tool.Result instance.

- IllegalStateException — if tool name or content parts are missing.
## ai.koog.prompt.message.ToolResultBuilder.cacheControl

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-tool-result-builder/cache-control.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun cacheControl(cacheControl: CacheControl?): ToolResultBuilder
```

Sets the cache-control directive for the provider's prompt-caching feature.

## ai.koog.prompt.message.ToolResultBuilder.id

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-tool-result-builder/id.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun id(id: String?): ToolResultBuilder
```

Sets the tool result ID.

## ai.koog.prompt.message.ToolResultBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-tool-result-builder/index.html`

### :prompt:prompt-model/jvmMain

```kotlin
class ToolResultBuilder
```

## ai.koog.prompt.message.ToolResultBuilder.isError

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-tool-result-builder/is-error.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun isError(isError: Boolean): ToolResultBuilder
```

## ai.koog.prompt.message.ToolResultBuilder.output

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-tool-result-builder/output.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun output(output: String): ToolResultBuilder
```

Adds a text content part to the message.

## ai.koog.prompt.message.ToolResultBuilder.tool

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-tool-result-builder/tool.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun tool(tool: String): ToolResultBuilder
```

Sets the tool name.

## ai.koog.prompt.message.UserMessageBuilder.UserMessageBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-user-message-builder/-user-message-builder.html`

### :prompt:prompt-model/jvmMain

```kotlin
constructor()
```

## ai.koog.prompt.message.UserMessageBuilder.addAttachment

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-user-message-builder/add-attachment.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun addAttachment(attachment: AttachmentSource, cache: CacheControl? = null): UserMessageBuilder
```

## ai.koog.prompt.message.UserMessageBuilder.addPart

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-user-message-builder/add-part.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun addPart(part: MessagePart.RequestPart): UserMessageBuilder
```

## ai.koog.prompt.message.UserMessageBuilder.addText

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-user-message-builder/add-text.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun addText(content: String, cache: CacheControl? = null): UserMessageBuilder
```

## ai.koog.prompt.message.UserMessageBuilder.addToolResult

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-user-message-builder/add-tool-result.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun addToolResult(toolResult: MessagePart.Tool.Result): UserMessageBuilder
```

## ai.koog.prompt.message.UserMessageBuilder.build

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-user-message-builder/build.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun build(): Message.User
```

Builds a new Message.User instance.

- IllegalStateException — if no content parts have been added.
## ai.koog.prompt.message.UserMessageBuilder.id

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-user-message-builder/id.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun id(id: String?): UserMessageBuilder
```

## ai.koog.prompt.message.UserMessageBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-user-message-builder/index.html`

### :prompt:prompt-model/jvmMain

```kotlin
class UserMessageBuilder
```

## ai.koog.prompt.message.UserMessageBuilder.metaInfo

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-user-message-builder/meta-info.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun metaInfo(metaInfo: RequestMetaInfo): UserMessageBuilder
```

## ai.koog.prompt.message.builder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/builder.html`

### :prompt:prompt-model/jvmMain

```kotlin
fun RequestMetaInfo.Companion.builder(): RequestMetaInfoBuilder
```

Creates a new RequestMetaInfoBuilder.

### :prompt:prompt-model/jvmMain

```kotlin
fun ResponseMetaInfo.Companion.builder(): ResponseMetaInfoBuilder
```

Creates a new ResponseMetaInfoBuilder.

## ai.koog.prompt.message.require

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/require.html`

### :prompt:prompt-model/commonMain

```kotlin
inline fun <T : CacheControl> CacheControl.require(): T
```

Requires this CacheControl to be of the specified type T, or throws an IllegalStateException.

## ai.koog.prompt.params.LLMParams.component1

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/component1.html`

### :prompt:prompt-model/commonMain

```kotlin
operator fun component1(): Double?
```

Retrieves the value of the temperature as a nullable Double. This function is typically used in destructuring declarations.

the temperature value, which may be null

## ai.koog.prompt.params.LLMParams.component10

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/component10.html`

### :prompt:prompt-model/commonMain

```kotlin
operator fun component10(): Map<String, JsonElement>?
```

## ai.koog.prompt.params.LLMParams.component2

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/component2.html`

### :prompt:prompt-model/commonMain

```kotlin
operator fun component2(): Int?
```

Provides the second component of the object, corresponding to maxTokens.

The value of maxTokens, or null if not set.

## ai.koog.prompt.params.LLMParams.component3

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/component3.html`

### :prompt:prompt-model/commonMain

```kotlin
operator fun component3(): Int?
```

Retrieves the third component of the data structure, representing the number of choices.

The number of choices as an Int if available, or null otherwise.

## ai.koog.prompt.params.LLMParams.component4

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/component4.html`

### :prompt:prompt-model/commonMain

```kotlin
operator fun component4(): String?
```

Retrieves the fourth component of the data structure.

the fourth component of the data as a nullable String, or null if not available.

## ai.koog.prompt.params.LLMParams.component5

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/component5.html`

### :prompt:prompt-model/commonMain

```kotlin
operator fun component5(): LLMParams.Schema?
```

Provides the fifth component of the data structure, represented by the schema property.

The schema of type Schema?, or null if it is not set.

## ai.koog.prompt.params.LLMParams.component6

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/component6.html`

### :prompt:prompt-model/commonMain

```kotlin
operator fun component6(): LLMParams.ToolChoice?
```

Retrieves the sixth component of a destructured object, which represents a tool choice.

The tool choice associated with this component, or null if not set.

## ai.koog.prompt.params.LLMParams.component7

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/component7.html`

### :prompt:prompt-model/commonMain

```kotlin
operator fun component7(): String?
```

Retrieves the seventh component of the data class, typically used for destructuring declarations.

The seventh component as a nullable String, or null if not available.

## ai.koog.prompt.params.LLMParams.copy

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/copy.html`

### :prompt:prompt-model/commonMain

```kotlin
open fun copy(temperature: Double? = this.temperature, maxTokens: Int? = this.maxTokens, numberOfChoices: Int? = this.numberOfChoices, speculation: String? = this.speculation, schema: LLMParams.Schema? = this.schema, toolChoice: LLMParams.ToolChoice? = this.toolChoice, user: String? = this.user, additionalProperties: Map<String, JsonElement>? = this.additionalProperties): LLMParams
```

Creates a copy of this instance with the ability to modify any of its properties.

## ai.koog.prompt.params.LLMParams.equals

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/equals.html`

### :prompt:prompt-model/commonMain

```kotlin
open operator override fun equals(other: Any?): Boolean
```

## ai.koog.prompt.params.LLMParams.hashCode

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/hash-code.html`

### :prompt:prompt-model/commonMain

```kotlin
open override fun hashCode(): Int
```

## ai.koog.prompt.params.LLMParams.toString

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/to-string.html`

### :prompt:prompt-model/commonMain

```kotlin
open override fun toString(): String
```

## ai.koog.prompt.params.additionalPropertiesOf

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/additional-properties-of.html`

### :prompt:prompt-model/commonMain

```kotlin
fun additionalPropertiesOf(vararg pairs: Pair<String, Any>): Map<String, JsonElement>
```

Converts a variable number of pairs into a map where the values are transformed into JsonElement instances.

A map with the provided keys associated with their corresponding JsonElement representations as values.

- pairs — A variable number of key-value pairs, where the keys are strings and the values are any type.
## ai.koog.prompt.text.BuilderBase.BuilderBase

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.text/-builder-base/-builder-base.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor()
```

## ai.koog.prompt.text.BuilderBase.build

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.text/-builder-base/build.html`

### :prompt:prompt-model/commonMain

```kotlin
abstract fun build(): TContent
```

## ai.koog.prompt.text.BuilderBase

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.text/-builder-base/index.html`

### :prompt:prompt-model/commonMain

```kotlin
abstract class BuilderBase<TContent>
```

- TextContentBuilderBase
## ai.koog.prompt.text.TextContentBuilder.TextContentBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.text/-text-content-builder/-text-content-builder.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor()
```

## ai.koog.prompt.text.TextContentBuilder.build

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.text/-text-content-builder/build.html`

### :prompt:prompt-model/commonMain

```kotlin
open override fun build(): String
```

Constructs and returns the accumulated textual content stored in the builder.

A string representation of the textual content built using the current builder.

## ai.koog.prompt.text.TextContentBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.text/-text-content-builder/index.html`

### :prompt:prompt-model/commonMain

```kotlin
open class TextContentBuilder : TextContentBuilderBase<String>
```

A content builder class for building and manipulating purely textual content.

- TextContentBuilderBase
## ai.koog.prompt.text.TextContentBuilderBase.Caret.Caret

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.text/-text-content-builder-base/-caret/-caret.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(line: Int, offset: Int)
```

## ai.koog.prompt.text.TextContentBuilderBase.Caret

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.text/-text-content-builder-base/-caret/index.html`

### :prompt:prompt-model/commonMain

```kotlin
data class Caret(val line: Int, val offset: Int)
```

Represents the position of a caret within a text document.

## ai.koog.prompt.text.TextContentBuilderBase.Caret.line

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.text/-text-content-builder-base/-caret/line.html`

### :prompt:prompt-model/commonMain

```kotlin
val line: Int
```

## ai.koog.prompt.text.TextContentBuilderBase.Caret.offset

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.text/-text-content-builder-base/-caret/offset.html`

### :prompt:prompt-model/commonMain

```kotlin
val offset: Int
```

## ai.koog.prompt.text.TextContentBuilderBase.TextContentBuilderBase

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.text/-text-content-builder-base/-text-content-builder-base.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor()
```

## ai.koog.prompt.text.TextContentBuilderBase.br

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.text/-text-content-builder-base/br.html`

### :prompt:prompt-model/commonMain

```kotlin
fun br()
```

Adds two consecutive newline characters to the text content.

This function is typically used to create a double line break, ensuring greater spacing between sections of the textual content.

## ai.koog.prompt.text.TextContentBuilderBase.caret

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.text/-text-content-builder-base/caret.html`

### :prompt:prompt-model/commonMain

```kotlin
val caret: TextContentBuilderBase.Caret
```

Represents the current caret position in the text being built.

The caret's position is determined by the number of lines and the character offset in the last line of the internal text content managed by the builder.

## ai.koog.prompt.text.TextContentBuilderBase

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.text/-text-content-builder-base/index.html`

### :prompt:prompt-model/commonMain

```kotlin
abstract class TextContentBuilderBase<TContent> : BuilderBase<TContent>
```

A base utility class for building and manipulating content based on the text. This class can be extended to support more types of text-based content, e.g. text with attachments or some metadata.

Provides methods for constructing formatted strings with features such as inserting text, adding new lines, and applying padding. The builder pattern supports a fluent and convenient approach to managing text content.

- ContentPartsBuilderBase
- ResponseMessagePartsBuilder
- TextContentBuilder
## ai.koog.prompt.text.TextContentBuilderBase.newline

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.text/-text-content-builder-base/newline.html`

### :prompt:prompt-model/commonMain

```kotlin
fun newline()
```

Appends a newline character to the underlying text builder.

This method is primarily used to ensure proper formatting and separation of text content in the TextContentBuilder class.

## ai.koog.prompt.text.TextContentBuilderBase.not

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.text/-text-content-builder-base/not.html`

### :prompt:prompt-model/commonMain

```kotlin
open operator fun String.not()
```

Defines a custom operator function for the String class. This unary not operator (!) is invoked on a String instance and performs a custom action defined by the text function.

The implementation of this function uses the this keyword to reference the current String the operator is called on and passes it to the text function.

This is typically used to enhance the behavior or further abstract operations on String objects in a concise and intuitive manner.

## ai.koog.prompt.text.TextContentBuilderBase.padding

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.text/-text-content-builder-base/padding.html`

### :prompt:prompt-model/commonMain

```kotlin
fun padding(padding: String, body: TextContentBuilder.() -> Unit)
```

Adds padding to each line of the content produced by the provided builder block.

- padding — The string to prepend to each line of the content.
- body — A lambda function applied to a TextContentBuilder instance, where the content is constructed.
## ai.koog.prompt.text.TextContentBuilderBase.textWithNewLine

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.text/-text-content-builder-base/text-with-new-line.html`

### :prompt:prompt-model/commonMain

```kotlin
fun textWithNewLine(text: String)
```

Adds the given text to the content. If the caret is not at the beginning of the line, a newline is added before appending the text.

- text — The text to be added to the content.
## ai.koog.prompt.text.TextContentBuilderBase.text

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.text/-text-content-builder-base/text.html`

### :prompt:prompt-model/commonMain

```kotlin
open fun text(text: String)
```

Appends the given text to the current content.

- text — The string to be appended to the content.
## ai.koog.prompt.text.TextContentBuilderBase.unaryPlus

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.text/-text-content-builder-base/unary-plus.html`

### :prompt:prompt-model/commonMain

```kotlin
open operator fun String.unaryPlus()
```

Adds the given string as a new line of text to the content being built by the TextContentBuilder.

This operator function ensures that the text is appended on a new line if the caret is not already at the beginning of a new line. If the caret is positioned at the start of a line, the string is directly appended.

The method is designed to simplify building multiline text content and integrates seamlessly with the TextContentBuilder, supporting fluent and declarative content construction.

## ai.koog.prompt.text.numbered

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.text/numbered.html`

### :prompt:prompt-model/commonMain

```kotlin
fun TextContentBuilderBase<*>.numbered(startLineNumber: Int = 1, body: TextContentBuilderBase<*>.() -> Unit): TextContentBuilderBase<*>
```

Extension function for TextContentBuilder that adds line numbering to the content.

The TextContentBuilder instance with numbered lines

- startLineNumber — The starting line number (default is 1)
- body — The content builder function
## ai.koog.prompt.text.text

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.text/text.html`

### :prompt:prompt-model/commonMain

```kotlin
fun text(block: TextContentBuilder.() -> Unit): String
```

Builds a textual content using a provided builder block and returns it as a string.

A string representation of the built content after applying the builder block.

- block — A lambda function applied to a TextContentBuilder instance, where the textual content is constructed.
### :prompt:prompt-model/commonMain

```kotlin
inline fun TextContentBuilderBase<*>.text(init: TextContentBuilder.() -> Unit)
```

Extension function to add text content to a TextContentBuilder.

Useful for embedding text content within other text content.

Example:

- init — The text content builder