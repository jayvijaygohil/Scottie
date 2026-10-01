# Skill discovery and prompt generation

Kotlin contracts extracted from the supplied Dokka build. Read [coverage and compatibility](../api-index.md) first. Read individual symbols as needed; source labels and incomplete declarations are preserved.

## ai.koog.skills.discovery.SkillCollisionPrecedence.FIRST_FOUND

Module: `skills`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `skills/ai.koog.skills.discovery/-skill-collision-precedence/-f-i-r-s-t_-f-o-u-n-d/index.html`

### :skills/commonMain

```kotlin
FIRST_FOUND
```

## ai.koog.skills.discovery.SkillCollisionPrecedence.LAST_FOUND

Module: `skills`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `skills/ai.koog.skills.discovery/-skill-collision-precedence/-l-a-s-t_-f-o-u-n-d/index.html`

### :skills/commonMain

```kotlin
LAST_FOUND
```

## ai.koog.skills.discovery.SkillCollisionPrecedence

Module: `skills`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `skills/ai.koog.skills.discovery/-skill-collision-precedence/index.html`

### :skills/commonMain

```kotlin
enum SkillCollisionPrecedence : Enum<SkillCollisionPrecedence>
```

Defines which discovered skill wins when multiple skills share the same name.

## ai.koog.skills.discovery.discoverSkills

Module: `skills`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `skills/ai.koog.skills.discovery/discover-skills.html`

### :skills/commonMain

```kotlin
suspend fun <Path> discoverSkills(fs: FileSystemProvider.ReadOnly<Path>, directoriesToSearch: List<String>, maxDepth: Int = 4, maxDirectories: Int = 2000, precedenceRule: SkillCollisionPrecedence = SkillCollisionPrecedence.LAST_FOUND, skillFileName: String = DEFAULT_SKILL_FILE_NAME, skippedDirectoryNames: Set<String> = DEFAULT_SKIPPED_DIRECTORY_NAMES, skillNamePattern: Regex = DEFAULT_SKILL_NAME_PATTERN, warningLogger: (String) -> Unit = ::defaultWarningLogger): List<Skill>
```

Discovers and parses skills from directoriesToSearch using breadth-first traversal.

For each visited directory, this function looks for a file named skillFileName. If found, the file is parsed as a skill definition and validated. Skills with missing required frontmatter fields (name, description) or malformed frontmatter are ignored.

Name collisions are resolved by precedenceRule:

SkillCollisionPrecedence.FIRST_FOUND keeps the first discovered skill.

SkillCollisionPrecedence.LAST_FOUND replaces with the most recently discovered skill.

Discovery is bounded by maxDepth and maxDirectories, and directories listed in skippedDirectoryNames are not traversed.

Warnings (ignored roots/directories, malformed skill files, collisions, and format mismatches) are reported through warningLogger.

discovered skills after applying validation and collision precedence.

- fs — file system provider used to interact with files.
- directoriesToSearch — absolute root directories to scan for skills.
- maxDepth — maximum traversal depth relative to each root directory. Must be >= 0.
- maxDirectories — maximum number of directories to visit across all roots. Must be > 0.
- precedenceRule — rule for resolving duplicate skill names.
- skillFileName — skill descriptor file name to search for in each directory.
- skippedDirectoryNames — directory names that should be ignored during traversal.
- skillNamePattern — regular expression used to validate discovered skill names.
- warningLogger — callback used to emit non-fatal discovery warnings.
- IllegalArgumentException — if maxDepth is negative or maxDirectories is not positive.

Referenced packages: `ai.koog.rag.base.files`, `ai.koog.skills.model`.

## ai.koog.skills.model.Skill.Skill

Module: `skills`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `skills/ai.koog.skills.model/-skill/-skill.html`

### :skills/commonMain

```kotlin
constructor(name: String, description: String, location: String, license: String? = null, compatibility: String? = null, metadata: Map<String, String>? = null, allowedTools: String? = null)
```

## ai.koog.skills.model.Skill.allowedTools

Module: `skills`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `skills/ai.koog.skills.model/-skill/allowed-tools.html`

### :skills/commonMain

```kotlin
@SerialName(value = "allowed-tools") val allowedTools: String?
```

## ai.koog.skills.model.Skill.compatibility

Module: `skills`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `skills/ai.koog.skills.model/-skill/compatibility.html`

### :skills/commonMain

```kotlin
val compatibility: String?
```

## ai.koog.skills.model.Skill.description

Module: `skills`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `skills/ai.koog.skills.model/-skill/description.html`

### :skills/commonMain

```kotlin
val description: String
```

## ai.koog.skills.model.Skill

Module: `skills`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `skills/ai.koog.skills.model/-skill/index.html`

### :skills/commonMain

```kotlin
@Serializable data class Skill(val name: String, val description: String, val location: String, val license: String? = null, val compatibility: String? = null, val metadata: Map<String, String>? = null, val allowedTools: String? = null)
```

Represents an available agent skill.

## ai.koog.skills.model.Skill.license

Module: `skills`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `skills/ai.koog.skills.model/-skill/license.html`

### :skills/commonMain

```kotlin
val license: String?
```

## ai.koog.skills.model.Skill.location

Module: `skills`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `skills/ai.koog.skills.model/-skill/location.html`

### :skills/commonMain

```kotlin
val location: String
```

## ai.koog.skills.model.Skill.metadata

Module: `skills`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `skills/ai.koog.skills.model/-skill/metadata.html`

### :skills/commonMain

```kotlin
val metadata: Map<String, String>?
```

## ai.koog.skills.model.Skill.name

Module: `skills`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `skills/ai.koog.skills.model/-skill/name.html`

### :skills/commonMain

```kotlin
val name: String
```

## ai.koog.skills.prompt.SkillsPromptFormat.JSON

Module: `skills`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `skills/ai.koog.skills.prompt/-skills-prompt-format/-j-s-o-n/index.html`

### :skills/commonMain

```kotlin
JSON
```

JSON representation with the available_skills root property.

## ai.koog.skills.prompt.SkillsPromptFormat.XML

Module: `skills`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `skills/ai.koog.skills.prompt/-skills-prompt-format/-x-m-l/index.html`

### :skills/commonMain

```kotlin
XML
```

XML representation with the available_skills root element.

## ai.koog.skills.prompt.SkillsPromptFormat.YML

Module: `skills`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `skills/ai.koog.skills.prompt/-skills-prompt-format/-y-m-l/index.html`

### :skills/commonMain

```kotlin
YML
```

YAML representation with the available_skills root key.

## ai.koog.skills.prompt.SkillsPromptFormat

Module: `skills`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `skills/ai.koog.skills.prompt/-skills-prompt-format/index.html`

### :skills/commonMain

```kotlin
enum SkillsPromptFormat : Enum<SkillsPromptFormat>
```

Supported output formats for a generated skills prompt.

## ai.koog.skills.prompt.generateSkillsPrompt

Module: `skills`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `skills/ai.koog.skills.prompt/generate-skills-prompt.html`

### :skills/commonMain

```kotlin
fun generateSkillsPrompt(skills: List<Skill>, format: SkillsPromptFormat, includeLocation: Boolean = true, includeLicense: Boolean = false, includeCompatibility: Boolean = false, includeMetadata: Boolean = false, includeAllowedTools: Boolean = false): String
```

Generates a textual prompt that describes available skills in the requested format.

The output always includes each skill's name and description. Additional properties can be included via dedicated include* flags.

Generated prompt string in the selected format.

- skills — Skills to include in the prompt.
- format — Output format for the generated prompt.
- includeLocation — Whether to include the location property.
- includeLicense — Whether to include the license property when present.
- includeCompatibility — Whether to include the compatibility property when present.
- includeMetadata — Whether to include the metadata property when present and non-empty.
- includeAllowedTools — Whether to include the allowed-tools property when present.

Referenced packages: `ai.koog.skills.model`.
