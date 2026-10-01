# Built-in interaction, file, search, and shell tools

Kotlin contracts extracted from the supplied Dokka build. Read [coverage and compatibility](../api-index.md) first. Read individual symbols as needed; source labels and incomplete declarations are preserved.

## ai.koog.agents.ext.tool.AskUser.Args.Args

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool/-ask-user/-args/-args.html`

### :agents:agents-ext/commonMain

```kotlin
constructor(message: String)
```

## ai.koog.agents.ext.tool.AskUser.Args

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool/-ask-user/-args/index.html`

### :agents:agents-ext/commonMain

```kotlin
@Serializable data class Args(val message: String)
```

Represents the arguments for the AskUser tool

## ai.koog.agents.ext.tool.AskUser.Args.message

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool/-ask-user/-args/message.html`

### :agents:agents-ext/commonMain

```kotlin
val message: String
```

## ai.koog.agents.ext.tool.AskUser.execute

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool/-ask-user/execute.html`

### :agents:agents-ext/commonMain

```kotlin
open suspend override fun execute(args: AskUser.Args): String
```

## ai.koog.agents.ext.tool.AskUser

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool/-ask-user/index.html`

### :agents:agents-ext/commonMain

```kotlin
object AskUser : SimpleTool<AskUser.Args>
```

Object representation of a tool that provides an interface for agent-user interaction. It allows the agent to ask the user for input (via stdout/stdin).


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.ext.tool.ExitTool.Args.Args

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool/-exit-tool/-args/-args.html`

### :agents:agents-ext/commonMain

```kotlin
constructor(message: String)
```

## ai.koog.agents.ext.tool.ExitTool.Args

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool/-exit-tool/-args/index.html`

### :agents:agents-ext/commonMain

```kotlin
@Serializable data class Args(val message: String)
```

Represents the arguments for the ExitTool tool

## ai.koog.agents.ext.tool.ExitTool.Args.message

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool/-exit-tool/-args/message.html`

### :agents:agents-ext/commonMain

```kotlin
val message: String
```

## ai.koog.agents.ext.tool.ExitTool.execute

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool/-exit-tool/execute.html`

### :agents:agents-ext/commonMain

```kotlin
open suspend override fun execute(args: ExitTool.Args): String
```

## ai.koog.agents.ext.tool.ExitTool

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool/-exit-tool/index.html`

### :agents:agents-ext/commonMain

```kotlin
object ExitTool : SimpleTool<ExitTool.Args>
```

An object representing the exit tool, primarily intended for ending conversations upon user request or based on agent decision. This tool finalizes interactions with a provided message.

The tool utilizes a structured set of arguments, which includes the final message of the agent to provide closure to the conversation. It returns the result as a standardized string, signaling the execution has been completed.

The descriptor defines the tool's metadata including its name, description, and required parameters.


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.ext.tool.SayToUser.Args.Args

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool/-say-to-user/-args/-args.html`

### :agents:agents-ext/commonMain

```kotlin
constructor(message: String)
```

## ai.koog.agents.ext.tool.SayToUser.Args

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool/-say-to-user/-args/index.html`

### :agents:agents-ext/commonMain

```kotlin
@Serializable data class Args(val message: String)
```

Represents the arguments for the SayToUser tool

## ai.koog.agents.ext.tool.SayToUser.Args.message

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool/-say-to-user/-args/message.html`

### :agents:agents-ext/commonMain

```kotlin
val message: String
```

## ai.koog.agents.ext.tool.SayToUser.execute

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool/-say-to-user/execute.html`

### :agents:agents-ext/commonMain

```kotlin
open suspend override fun execute(args: SayToUser.Args): String
```

## ai.koog.agents.ext.tool.SayToUser

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool/-say-to-user/index.html`

### :agents:agents-ext/commonMain

```kotlin
object SayToUser : SimpleTool<SayToUser.Args>
```

The SayToUser allows agent to say something to the output (via println).


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.ext.tool.file.EditFileTool.Args.Args

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-edit-file-tool/-args/-args.html`

### :agents:agents-ext/commonMain

```kotlin
constructor(path: String, original: String, replacement: String)
```

## ai.koog.agents.ext.tool.file.EditFileTool.Args

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-edit-file-tool/-args/index.html`

### :agents:agents-ext/commonMain

```kotlin
@Serializable data class Args(val path: String, val original: String, val replacement: String)
```

Arguments required to perform a single edit operation on a file.

## ai.koog.agents.ext.tool.file.EditFileTool.Args.original

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-edit-file-tool/-args/original.html`

### :agents:agents-ext/commonMain

```kotlin
val original: String
```

## ai.koog.agents.ext.tool.file.EditFileTool.Args.path

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-edit-file-tool/-args/path.html`

### :agents:agents-ext/commonMain

```kotlin
val path: String
```

## ai.koog.agents.ext.tool.file.EditFileTool.Args.replacement

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-edit-file-tool/-args/replacement.html`

### :agents:agents-ext/commonMain

```kotlin
val replacement: String
```

## ai.koog.agents.ext.tool.file.EditFileTool.Companion.descriptor

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-edit-file-tool/-companion/descriptor.html`

### :agents:agents-ext/commonMain

```kotlin
val descriptor: ToolDescriptor
```

Descriptor for the edit file tool.


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.ext.tool.file.EditFileTool.Companion

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-edit-file-tool/-companion/index.html`

### :agents:agents-ext/commonMain

```kotlin
object Companion
```

Descriptor for the edit file tool.

## ai.koog.agents.ext.tool.file.EditFileTool.Companion.toolDescription

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-edit-file-tool/-companion/tool-description.html`

### :agents:agents-ext/commonMain

```kotlin
val toolDescription: String
```

Provides a description for the functionality of a tool that modifies files by applying text replacements.

This description outlines key features, requirements, limitations, and use cases of the tool.

## ai.koog.agents.ext.tool.file.EditFileTool.Companion.toolName

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-edit-file-tool/-companion/tool-name.html`

### :agents:agents-ext/commonMain

```kotlin
val toolName: String
```

Represents the name of the tool used for file editing functionality.

This constant holds the unique identifier for the tool, which is used in configurations, registration, or referencing the tool within the system.

## ai.koog.agents.ext.tool.file.EditFileTool.EditFileTool

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-edit-file-tool/-edit-file-tool.html`

### :agents:agents-ext/commonMain

```kotlin
constructor(fs: FileSystemProvider.ReadWrite<Path>)
```


Referenced packages: `ai.koog.rag.base.files`.

## ai.koog.agents.ext.tool.file.EditFileTool.Result.Result

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-edit-file-tool/-result/-result.html`

### :agents:agents-ext/commonMain

```kotlin
constructor(patchApplyResult: PatchApplyResult)
```


Referenced packages: `ai.koog.agents.ext.tool.file.patch`.

## ai.koog.agents.ext.tool.file.EditFileTool.Result

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-edit-file-tool/-result/index.html`

### :agents:agents-ext/commonMain

```kotlin
@Serializable data class Result(val patchApplyResult: PatchApplyResult)
```

Result of applying the edit patch to the target file.


Referenced packages: `ai.koog.agents.ext.tool.file.patch`.

## ai.koog.agents.ext.tool.file.EditFileTool.Result.patchApplyResult

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-edit-file-tool/-result/patch-apply-result.html`

### :agents:agents-ext/commonMain

```kotlin
val patchApplyResult: PatchApplyResult
```


Referenced packages: `ai.koog.agents.ext.tool.file.patch`.

## ai.koog.agents.ext.tool.file.EditFileTool.encodeResultToString

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-edit-file-tool/encode-result-to-string.html`

### :agents:agents-ext/commonMain

```kotlin
open override fun encodeResultToString(result: EditFileTool.Result, serializer: JSONSerializer): String
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.ext.tool.file.EditFileTool.execute

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-edit-file-tool/execute.html`

### :agents:agents-ext/commonMain

```kotlin
open suspend override fun execute(args: EditFileTool.Args): EditFileTool.Result
```

## ai.koog.agents.ext.tool.file.EditFileTool

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-edit-file-tool/index.html`

### :agents:agents-ext/commonMain

```kotlin
class EditFileTool<Path>(fs: FileSystemProvider.ReadWrite<Path>) : Tool<EditFileTool.Args, EditFileTool.Result>
```

Tool to enable the agent to edit files.

Takes a file path and two strings: original and replacement. And searches for the original string in the file and replaces it with the replacement.

Also handles case and white space mismatches in the original string.


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.rag.base.files`.

## ai.koog.agents.ext.tool.file.ListDirectoryTool.Args.Args

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-list-directory-tool/-args/-args.html`

### :agents:agents-ext/commonMain

```kotlin
constructor(absolutePath: String, depth: Int = 1, filter: String? = null)
```

## ai.koog.agents.ext.tool.file.ListDirectoryTool.Args.absolutePath

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-list-directory-tool/-args/absolute-path.html`

### :agents:agents-ext/commonMain

```kotlin
val absolutePath: String
```

## ai.koog.agents.ext.tool.file.ListDirectoryTool.Args.depth

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-list-directory-tool/-args/depth.html`

### :agents:agents-ext/commonMain

```kotlin
val depth: Int
```

## ai.koog.agents.ext.tool.file.ListDirectoryTool.Args.filter

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-list-directory-tool/-args/filter.html`

### :agents:agents-ext/commonMain

```kotlin
val filter: String?
```

## ai.koog.agents.ext.tool.file.ListDirectoryTool.Args

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-list-directory-tool/-args/index.html`

### :agents:agents-ext/commonMain

```kotlin
@Serializable data class Args(val absolutePath: String, val depth: Int = 1, val filter: String? = null)
```

Specifies which directory to list and how to traverse its contents.

## ai.koog.agents.ext.tool.file.ListDirectoryTool.ListDirectoryTool

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-list-directory-tool/-list-directory-tool.html`

### :agents:agents-ext/commonMain

```kotlin
constructor(fs: FileSystemProvider.ReadOnly<Path>)
```

- Path — the filesystem path type used by the provider

Referenced packages: `ai.koog.rag.base.files`.

## ai.koog.agents.ext.tool.file.ListDirectoryTool.Result.Result

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-list-directory-tool/-result/-result.html`

### :agents:agents-ext/commonMain

```kotlin
constructor(root: FileSystemEntry.Folder)
```


Referenced packages: `ai.koog.rag.base.files.model`.

## ai.koog.agents.ext.tool.file.ListDirectoryTool.Result

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-list-directory-tool/-result/index.html`

### :agents:agents-ext/commonMain

```kotlin
@Serializable data class Result(val root: FileSystemEntry.Folder)
```

Contains the successfully listed directory with its hierarchical structure and metadata.

The result encapsulates a FileSystemEntry.Folder which includes:

Directory metadata (name, path, hidden status)

Child entries organized hierarchically with their metadata


Referenced packages: `ai.koog.rag.base.files.model`.

## ai.koog.agents.ext.tool.file.ListDirectoryTool.Result.root

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-list-directory-tool/-result/root.html`

### :agents:agents-ext/commonMain

```kotlin
val root: FileSystemEntry.Folder
```


Referenced packages: `ai.koog.rag.base.files.model`.

## ai.koog.agents.ext.tool.file.ListDirectoryTool.encodeResultToString

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-list-directory-tool/encode-result-to-string.html`

### :agents:agents-ext/commonMain

```kotlin
open override fun encodeResultToString(result: ListDirectoryTool.Result, serializer: JSONSerializer): String
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.ext.tool.file.ListDirectoryTool.execute

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-list-directory-tool/execute.html`

### :agents:agents-ext/commonMain

```kotlin
open suspend override fun execute(args: ListDirectoryTool.Args): ListDirectoryTool.Result
```

Lists directory contents from the filesystem with optional depth and pattern filtering.

Performs validation before listing:

Validates the depth parameter is positive

Verifies the path exists in the filesystem

Confirms the path points to a directory

Result containing the directory tree with its contents and metadata

- args — arguments specifying the directory path, depth, and optional filter
- ToolException.ValidationFailure — if the path doesn't exist, isn't a directory, depth is invalid, or filter matches nothing
## ai.koog.agents.ext.tool.file.ListDirectoryTool

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-list-directory-tool/index.html`

### :agents:agents-ext/commonMain

```kotlin
class ListDirectoryTool<Path>(fs: FileSystemProvider.ReadOnly<Path>) : Tool<ListDirectoryTool.Args, ListDirectoryTool.Result>
```

Provides functionality to list directory contents with configurable depth and glob filtering parameters, returning a structured directory tree with file and folder metadata.

- Path — the filesystem path type used by the provider

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.rag.base.files`.

## ai.koog.agents.ext.tool.file.ReadFileTool.Args.Args

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-read-file-tool/-args/-args.html`

### :agents:agents-ext/commonMain

```kotlin
constructor(path: String, startLine: Int = 0, endLine: Int = -1)
```

## ai.koog.agents.ext.tool.file.ReadFileTool.Args.endLine

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-read-file-tool/-args/end-line.html`

### :agents:agents-ext/commonMain

```kotlin
val endLine: Int
```

## ai.koog.agents.ext.tool.file.ReadFileTool.Args

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-read-file-tool/-args/index.html`

### :agents:agents-ext/commonMain

```kotlin
@Serializable data class Args(val path: String, val startLine: Int = 0, val endLine: Int = -1)
```

Specifies which file to read and what portion of its content to extract.

## ai.koog.agents.ext.tool.file.ReadFileTool.Args.path

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-read-file-tool/-args/path.html`

### :agents:agents-ext/commonMain

```kotlin
val path: String
```

## ai.koog.agents.ext.tool.file.ReadFileTool.Args.startLine

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-read-file-tool/-args/start-line.html`

### :agents:agents-ext/commonMain

```kotlin
val startLine: Int
```

## ai.koog.agents.ext.tool.file.ReadFileTool.ReadFileTool

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-read-file-tool/-read-file-tool.html`

### :agents:agents-ext/commonMain

```kotlin
constructor(fs: FileSystemProvider.ReadOnly<Path>)
```

- Path — the filesystem path type used by the provider

Referenced packages: `ai.koog.rag.base.files`.

## ai.koog.agents.ext.tool.file.ReadFileTool.Result.Result

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-read-file-tool/-result/-result.html`

### :agents:agents-ext/commonMain

```kotlin
constructor(file: FileSystemEntry.File, warningMessage: String? = null)
```


Referenced packages: `ai.koog.rag.base.files.model`.

## ai.koog.agents.ext.tool.file.ReadFileTool.Result.file

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-read-file-tool/-result/file.html`

### :agents:agents-ext/commonMain

```kotlin
val file: FileSystemEntry.File
```


Referenced packages: `ai.koog.rag.base.files.model`.

## ai.koog.agents.ext.tool.file.ReadFileTool.Result

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-read-file-tool/-result/index.html`

### :agents:agents-ext/commonMain

```kotlin
@Serializable data class Result(val file: FileSystemEntry.File, val warningMessage: String? = null)
```

Contains the successfully read file with its metadata and extracted content.

The result encapsulates a FileSystemEntry.File which includes:

File metadata (path, name, extension, size, content type, hidden status)

Content as either full-text or line-range excerpt


Referenced packages: `ai.koog.rag.base.files.model`.

## ai.koog.agents.ext.tool.file.ReadFileTool.Result.warningMessage

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-read-file-tool/-result/warning-message.html`

### :agents:agents-ext/commonMain

```kotlin
val warningMessage: String?
```

## ai.koog.agents.ext.tool.file.ReadFileTool.encodeResultToString

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-read-file-tool/encode-result-to-string.html`

### :agents:agents-ext/commonMain

```kotlin
open override fun encodeResultToString(result: ReadFileTool.Result, serializer: JSONSerializer): String
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.ext.tool.file.ReadFileTool.execute

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-read-file-tool/execute.html`

### :agents:agents-ext/commonMain

```kotlin
open suspend override fun execute(args: ReadFileTool.Args): ReadFileTool.Result
```

Reads file content from the filesystem with optional line range filtering.

Performs validation before reading:

Verifies the path exists in the filesystem

Confirms the path points to a file

Confirms the file is a text file

If the requested endLine exceeds the file's line count, it will be clamped to the available lines and a warning will be included in the result.

Result containing the file with its content, metadata, and optional warning

- args — arguments specifying the file path and optional line range
- ToolException.ValidationFailure — if the file doesn't exist, is a directory, or is not a text file, or if line range parameters are invalid
## ai.koog.agents.ext.tool.file.ReadFileTool

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-read-file-tool/index.html`

### :agents:agents-ext/commonMain

```kotlin
class ReadFileTool<Path>(fs: FileSystemProvider.ReadOnly<Path>) : Tool<ReadFileTool.Args, ReadFileTool.Result>
```

Provides functionality to read file contents with configurable start and end line parameters, returning structured file metadata and content.

- Path — the filesystem path type used by the provider

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.rag.base.files`.

## ai.koog.agents.ext.tool.file.WriteFileTool.Args.Args

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-write-file-tool/-args/-args.html`

### :agents:agents-ext/commonMain

```kotlin
constructor(path: String, content: String)
```

## ai.koog.agents.ext.tool.file.WriteFileTool.Args.content

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-write-file-tool/-args/content.html`

### :agents:agents-ext/commonMain

```kotlin
val content: String
```

## ai.koog.agents.ext.tool.file.WriteFileTool.Args

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-write-file-tool/-args/index.html`

### :agents:agents-ext/commonMain

```kotlin
@Serializable data class Args(val path: String, val content: String)
```

Specifies which file to write and what text content to put into it.

## ai.koog.agents.ext.tool.file.WriteFileTool.Args.path

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-write-file-tool/-args/path.html`

### :agents:agents-ext/commonMain

```kotlin
val path: String
```

## ai.koog.agents.ext.tool.file.WriteFileTool.Result.Result

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-write-file-tool/-result/-result.html`

### :agents:agents-ext/commonMain

```kotlin
constructor(file: FileSystemEntry.File)
```


Referenced packages: `ai.koog.rag.base.files.model`.

## ai.koog.agents.ext.tool.file.WriteFileTool.Result.file

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-write-file-tool/-result/file.html`

### :agents:agents-ext/commonMain

```kotlin
val file: FileSystemEntry.File
```


Referenced packages: `ai.koog.rag.base.files.model`.

## ai.koog.agents.ext.tool.file.WriteFileTool.Result

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-write-file-tool/-result/index.html`

### :agents:agents-ext/commonMain

```kotlin
@Serializable data class Result(val file: FileSystemEntry.File)
```

Contains the successfully written file with its metadata.

The result encapsulates a FileSystemEntry.File which includes:

File metadata (name, extension, path, hidden, size, contentType)

No content body (this tool writes, it does not return the file text)


Referenced packages: `ai.koog.rag.base.files.model`.

## ai.koog.agents.ext.tool.file.WriteFileTool.WriteFileTool

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-write-file-tool/-write-file-tool.html`

### :agents:agents-ext/commonMain

```kotlin
constructor(fs: FileSystemProvider.ReadWrite<Path>)
```

- Path — the filesystem path type used by the provider

Referenced packages: `ai.koog.rag.base.files`.

## ai.koog.agents.ext.tool.file.WriteFileTool.encodeResultToString

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-write-file-tool/encode-result-to-string.html`

### :agents:agents-ext/commonMain

```kotlin
open override fun encodeResultToString(result: WriteFileTool.Result, serializer: JSONSerializer): String
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.ext.tool.file.WriteFileTool.execute

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-write-file-tool/execute.html`

### :agents:agents-ext/commonMain

```kotlin
open suspend override fun execute(args: WriteFileTool.Args): WriteFileTool.Result
```

Writes text content to the filesystem at the specified absolute path.

Performs validation before writing:

Verifies the content is not empty

Creates parent directories if they don't exist

Overwrites any existing file content

Result containing the written file with its metadata

- args — arguments specifying the file path and content to write
- ToolException.ValidationFailure — if content is empty or the target is not a file after writing the content
## ai.koog.agents.ext.tool.file.WriteFileTool

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file/-write-file-tool/index.html`

### :agents:agents-ext/commonMain

```kotlin
class WriteFileTool<Path>(fs: FileSystemProvider.ReadWrite<Path>) : Tool<WriteFileTool.Args, WriteFileTool.Result>
```

Provides functionality to write text content to files at absolute paths, creating parent directories and overwriting existing content as needed.

- Path — the filesystem path type used by the provider

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.rag.base.files`.

## ai.koog.agents.ext.tool.file.patch.PatchApplyResult.Failure.OriginalNotFound

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file.patch/-patch-apply-result/-failure/-original-not-found/index.html`

### :agents:agents-ext/commonMain

```kotlin
@Serializable object OriginalNotFound : PatchApplyResult.Failure
```

Represents a failure to find the original text in the file content

## ai.koog.agents.ext.tool.file.patch.PatchApplyResult.Failure

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file.patch/-patch-apply-result/-failure/index.html`

### :agents:agents-ext/commonMain

```kotlin
@Serializable sealed class Failure : PatchApplyResult
```

Represents a failed patch application, including the reason for the failure

- OriginalNotFound
## ai.koog.agents.ext.tool.file.patch.PatchApplyResult.Failure.reason

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file.patch/-patch-apply-result/-failure/reason.html`

### :agents:agents-ext/commonMain

```kotlin
val reason: String
```

## ai.koog.agents.ext.tool.file.patch.PatchApplyResult.Success.Success

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file.patch/-patch-apply-result/-success/-success.html`

### :agents:agents-ext/commonMain

```kotlin
constructor(updatedContent: String)
```

## ai.koog.agents.ext.tool.file.patch.PatchApplyResult.Success

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file.patch/-patch-apply-result/-success/index.html`

### :agents:agents-ext/commonMain

```kotlin
@Serializable data class Success(val updatedContent: String) : PatchApplyResult
```

Represents a successful patch application

## ai.koog.agents.ext.tool.file.patch.PatchApplyResult.Success.updatedContent

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file.patch/-patch-apply-result/-success/updated-content.html`

### :agents:agents-ext/commonMain

```kotlin
val updatedContent: String
```

## ai.koog.agents.ext.tool.file.patch.PatchApplyResult

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.file.patch/-patch-apply-result/index.html`

### :agents:agents-ext/commonMain

```kotlin
@Serializable sealed interface PatchApplyResult
```

Represents the result of applying a patch to a file

- Success
- Failure
## ai.koog.agents.ext.tool.search.RegexSearchTool.Args.Args

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.search/-regex-search-tool/-args/-args.html`

### :agents:agents-ext/commonMain

```kotlin
constructor(path: String, regex: String, limit: Int = 25, skip: Int = 0, caseSensitive: Boolean = false)
```

## ai.koog.agents.ext.tool.search.RegexSearchTool.Args.caseSensitive

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.search/-regex-search-tool/-args/case-sensitive.html`

### :agents:agents-ext/commonMain

```kotlin
@SerialName(value = "case_sensitive") val caseSensitive: Boolean
```

## ai.koog.agents.ext.tool.search.RegexSearchTool.Args

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.search/-regex-search-tool/-args/index.html`

### :agents:agents-ext/commonMain

```kotlin
@Serializable data class Args(val path: String, val regex: String, val limit: Int = 25, val skip: Int = 0, val caseSensitive: Boolean = false)
```

Parameters for a regex content search.

## ai.koog.agents.ext.tool.search.RegexSearchTool.Args.limit

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.search/-regex-search-tool/-args/limit.html`

### :agents:agents-ext/commonMain

```kotlin
val limit: Int
```

## ai.koog.agents.ext.tool.search.RegexSearchTool.Args.path

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.search/-regex-search-tool/-args/path.html`

### :agents:agents-ext/commonMain

```kotlin
val path: String
```

## ai.koog.agents.ext.tool.search.RegexSearchTool.Args.regex

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.search/-regex-search-tool/-args/regex.html`

### :agents:agents-ext/commonMain

```kotlin
val regex: String
```

## ai.koog.agents.ext.tool.search.RegexSearchTool.Args.skip

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.search/-regex-search-tool/-args/skip.html`

### :agents:agents-ext/commonMain

```kotlin
val skip: Int
```

## ai.koog.agents.ext.tool.search.RegexSearchTool.RegexSearchTool

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.search/-regex-search-tool/-regex-search-tool.html`

### :agents:agents-ext/commonMain

```kotlin
constructor(fs: FileSystemProvider.ReadOnly<Path>)
```


Referenced packages: `ai.koog.rag.base.files`.

## ai.koog.agents.ext.tool.search.RegexSearchTool.Result.Result

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.search/-regex-search-tool/-result/-result.html`

### :agents:agents-ext/commonMain

```kotlin
constructor(entries: List<FileSystemEntry.File>, original: String)
```


Referenced packages: `ai.koog.rag.base.files.model`.

## ai.koog.agents.ext.tool.search.RegexSearchTool.Result

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.search/-regex-search-tool/-result/index.html`

### :agents:agents-ext/commonMain

```kotlin
@Serializable data class Result(val entries: List<FileSystemEntry.File>, val original: String)
```

Search output.


Referenced packages: `ai.koog.rag.base.files.model`.

## ai.koog.agents.ext.tool.search.RegexSearchTool.Result.original

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.search/-regex-search-tool/-result/original.html`

### :agents:agents-ext/commonMain

```kotlin
val original: String
```

## ai.koog.agents.ext.tool.search.RegexSearchTool.execute

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.search/-regex-search-tool/execute.html`

### :agents:agents-ext/commonMain

```kotlin
open suspend override fun execute(args: RegexSearchTool.Args): RegexSearchTool.Result
```

## ai.koog.agents.ext.tool.search.RegexSearchTool

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.search/-regex-search-tool/index.html`

### :agents:agents-ext/commonMain

```kotlin
class RegexSearchTool<Path>(fs: FileSystemProvider.ReadOnly<Path>) : Tool<RegexSearchTool.Args, RegexSearchTool.Result>
```

Regular expression based content search tool.

Use to find occurrences of a regex pattern across text files under a path.


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.rag.base.files`.

## ai.koog.agents.ext.tool.shell.BraveModeConfirmationHandler.BraveModeConfirmationHandler

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-brave-mode-confirmation-handler/-brave-mode-confirmation-handler.html`

### :agents:agents-ext/commonMain

```kotlin
constructor()
```

## ai.koog.agents.ext.tool.shell.BraveModeConfirmationHandler

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-brave-mode-confirmation-handler/index.html`

### :agents:agents-ext/commonMain

```kotlin
class BraveModeConfirmationHandler : ShellCommandConfirmationHandler
```

Brave mode confirmation handler that bypasses user confirmation.

Use when you trust the agent to execute commands without prompting.

## ai.koog.agents.ext.tool.shell.BraveModeConfirmationHandler.requestConfirmation

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-brave-mode-confirmation-handler/request-confirmation.html`

### :agents:agents-ext/commonMain

```kotlin
open suspend override fun requestConfirmation(args: ExecuteShellCommandTool.Args): ShellCommandConfirmation
```

Requests confirmation to execute a command.

Approval or denial decision

- args — Command execution arguments with full context
## ai.koog.agents.ext.tool.shell.ExecuteShellCommandTool.Args.Args

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-execute-shell-command-tool/-args/-args.html`

### :agents:agents-ext/commonMain

```kotlin
constructor(command: String, timeoutSeconds: Int, workingDirectory: String? = null)
```

## ai.koog.agents.ext.tool.shell.ExecuteShellCommandTool.Args.command

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-execute-shell-command-tool/-args/command.html`

### :agents:agents-ext/commonMain

```kotlin
val command: String
```

## ai.koog.agents.ext.tool.shell.ExecuteShellCommandTool.Args

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-execute-shell-command-tool/-args/index.html`

### :agents:agents-ext/commonMain

```kotlin
@Serializable data class Args(val command: String, val timeoutSeconds: Int, val workingDirectory: String? = null)
```

Parameters for running a shell command.

## ai.koog.agents.ext.tool.shell.ExecuteShellCommandTool.Args.timeoutSeconds

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-execute-shell-command-tool/-args/timeout-seconds.html`

### :agents:agents-ext/commonMain

```kotlin
val timeoutSeconds: Int
```

## ai.koog.agents.ext.tool.shell.ExecuteShellCommandTool.Args.workingDirectory

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-execute-shell-command-tool/-args/working-directory.html`

### :agents:agents-ext/commonMain

```kotlin
val workingDirectory: String?
```

## ai.koog.agents.ext.tool.shell.ExecuteShellCommandTool.ExecuteShellCommandTool

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-execute-shell-command-tool/-execute-shell-command-tool.html`

### :agents:agents-ext/commonMain

```kotlin
constructor(executor: ShellCommandExecutor, confirmationHandler: ShellCommandConfirmationHandler)
```

## ai.koog.agents.ext.tool.shell.ExecuteShellCommandTool.Result.Result

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-execute-shell-command-tool/-result/-result.html`

### :agents:agents-ext/commonMain

```kotlin
constructor(exitCode: Int?, output: String)
```

## ai.koog.agents.ext.tool.shell.ExecuteShellCommandTool.Result.exitCode

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-execute-shell-command-tool/-result/exit-code.html`

### :agents:agents-ext/commonMain

```kotlin
val exitCode: Int?
```

## ai.koog.agents.ext.tool.shell.ExecuteShellCommandTool.Result

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-execute-shell-command-tool/-result/index.html`

### :agents:agents-ext/commonMain

```kotlin
@Serializable data class Result(val exitCode: Int?, val output: String)
```

Result of attempting to run a command.

## ai.koog.agents.ext.tool.shell.ExecuteShellCommandTool.Result.output

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-execute-shell-command-tool/-result/output.html`

### :agents:agents-ext/commonMain

```kotlin
val output: String
```

## ai.koog.agents.ext.tool.shell.ExecuteShellCommandTool.encodeResultToString

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-execute-shell-command-tool/encode-result-to-string.html`

### :agents:agents-ext/commonMain

```kotlin
open override fun encodeResultToString(result: ExecuteShellCommandTool.Result, serializer: JSONSerializer): String
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.ext.tool.shell.ExecuteShellCommandTool.execute

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-execute-shell-command-tool/execute.html`

### :agents:agents-ext/commonMain

```kotlin
open suspend override fun execute(args: ExecuteShellCommandTool.Args): ExecuteShellCommandTool.Result
```

Runs a command after asking the user for permission.

First asks the confirmation handler whether to allow the command. If approved, executes it with the specified timeout. If denied, timed out, or crashes, returns a result explaining what happened.

Result containing the command output and exit code, or an error message explaining why it didn't run

- args — The command string, timeout duration, optional working directory
- CancellationException — if canceled while the command is executing
## ai.koog.agents.ext.tool.shell.ExecuteShellCommandTool

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-execute-shell-command-tool/index.html`

### :agents:agents-ext/commonMain

```kotlin
class ExecuteShellCommandTool(executor: ShellCommandExecutor, confirmationHandler: ShellCommandConfirmationHandler) : Tool<ExecuteShellCommandTool.Args, ExecuteShellCommandTool.Result>
```

Executes shell commands with user approval and automatic timeout.

Before running any command, asks the user for confirmation. If approved, runs the command and captures everything it prints. If the command takes too long, cancels it automatically.


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.ext.tool.shell.JvmShellCommandExecutor.JvmShellCommandExecutor

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-jvm-shell-command-executor/-jvm-shell-command-executor.html`

### :agents:agents-ext/jvmMain

```kotlin
constructor()
```

## ai.koog.agents.ext.tool.shell.JvmShellCommandExecutor.execute

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-jvm-shell-command-executor/execute.html`

### :agents:agents-ext/jvmMain

```kotlin
open suspend override fun execute(command: String, workingDirectory: String?, timeoutSeconds: Int): ShellCommandExecutor.ExecutionResult
```

Executes a shell command and returns combined output and exit code.

ExecutionResult containing combined stdout/stderr output and process exit code

- command — Shell command string to execute
- workingDirectory — Working directory, or null to use the current directory
- timeoutSeconds — Maximum execution time in seconds
## ai.koog.agents.ext.tool.shell.JvmShellCommandExecutor

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-jvm-shell-command-executor/index.html`

### :agents:agents-ext/jvmMain

```kotlin
class JvmShellCommandExecutor : ShellCommandExecutor
```

Shell command executor using ProcessBuilder for JVM platforms.

- ShellCommandExecutor
## ai.koog.agents.ext.tool.shell.PrintShellCommandConfirmationHandler.PrintShellCommandConfirmationHandler

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-print-shell-command-confirmation-handler/-print-shell-command-confirmation-handler.html`

### :agents:agents-ext/commonMain

```kotlin
constructor()
```

## ai.koog.agents.ext.tool.shell.PrintShellCommandConfirmationHandler

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-print-shell-command-confirmation-handler/index.html`

### :agents:agents-ext/commonMain

```kotlin
class PrintShellCommandConfirmationHandler : ShellCommandConfirmationHandler
```

Confirmation handler that prompts user via console input.

Prints command details and waits for y/yes to approve, any other input denies.

## ai.koog.agents.ext.tool.shell.PrintShellCommandConfirmationHandler.requestConfirmation

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-print-shell-command-confirmation-handler/request-confirmation.html`

### :agents:agents-ext/commonMain

```kotlin
open suspend override fun requestConfirmation(args: ExecuteShellCommandTool.Args): ShellCommandConfirmation
```

Requests confirmation to execute a command.

Approval or denial decision

- args — Command execution arguments with full context
## ai.koog.agents.ext.tool.shell.ShellCommandConfirmation.Approved

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-shell-command-confirmation/-approved/index.html`

### :agents:agents-ext/commonMain

```kotlin
data object Approved : ShellCommandConfirmation
```

Command execution approved.

## ai.koog.agents.ext.tool.shell.ShellCommandConfirmation.Denied.Denied

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-shell-command-confirmation/-denied/-denied.html`

### :agents:agents-ext/commonMain

```kotlin
constructor(userResponse: String)
```

## ai.koog.agents.ext.tool.shell.ShellCommandConfirmation.Denied

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-shell-command-confirmation/-denied/index.html`

### :agents:agents-ext/commonMain

```kotlin
data class Denied(val userResponse: String) : ShellCommandConfirmation
```

Command execution denied with explanation.

## ai.koog.agents.ext.tool.shell.ShellCommandConfirmation.Denied.userResponse

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-shell-command-confirmation/-denied/user-response.html`

### :agents:agents-ext/commonMain

```kotlin
val userResponse: String
```

## ai.koog.agents.ext.tool.shell.ShellCommandConfirmation

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-shell-command-confirmation/index.html`

### :agents:agents-ext/commonMain

```kotlin
sealed class ShellCommandConfirmation
```

User's decision on whether to execute a shell command.

- Approved
- Denied
## ai.koog.agents.ext.tool.shell.ShellCommandConfirmationHandler

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-shell-command-confirmation-handler/index.html`

### :agents:agents-ext/commonMain

```kotlin
fun interface ShellCommandConfirmationHandler
```

Strategy for obtaining user confirmation before executing shell commands.

- BraveModeConfirmationHandler
- PrintShellCommandConfirmationHandler
## ai.koog.agents.ext.tool.shell.ShellCommandConfirmationHandler.requestConfirmation

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-shell-command-confirmation-handler/request-confirmation.html`

### :agents:agents-ext/commonMain

```kotlin
abstract suspend fun requestConfirmation(args: ExecuteShellCommandTool.Args): ShellCommandConfirmation
```

Requests confirmation to execute a command.

Approval or denial decision

- args — Command execution arguments with full context
## ai.koog.agents.ext.tool.shell.ShellCommandExecutor.ExecutionResult.ExecutionResult

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-shell-command-executor/-execution-result/-execution-result.html`

### :agents:agents-ext/commonMain

```kotlin
constructor(output: String, exitCode: Int?)
```

## ai.koog.agents.ext.tool.shell.ShellCommandExecutor.ExecutionResult.exitCode

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-shell-command-executor/-execution-result/exit-code.html`

### :agents:agents-ext/commonMain

```kotlin
val exitCode: Int?
```

## ai.koog.agents.ext.tool.shell.ShellCommandExecutor.ExecutionResult

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-shell-command-executor/-execution-result/index.html`

### :agents:agents-ext/commonMain

```kotlin
data class ExecutionResult(val output: String, val exitCode: Int?)
```

Command execution result.

## ai.koog.agents.ext.tool.shell.ShellCommandExecutor.ExecutionResult.output

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-shell-command-executor/-execution-result/output.html`

### :agents:agents-ext/commonMain

```kotlin
val output: String
```

## ai.koog.agents.ext.tool.shell.ShellCommandExecutor.execute

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-shell-command-executor/execute.html`

### :agents:agents-ext/commonMain

```kotlin
abstract suspend fun execute(command: String, workingDirectory: String?, timeoutSeconds: Int): ShellCommandExecutor.ExecutionResult
```

Executes a command and captures what it prints.

Output and exit code

- command — Command string (e.g., "ls -la | grep txt")
- workingDirectory — Working directory, or null to use the current directory
- timeoutSeconds — Maximum execution time in seconds, or null for no timeout
## ai.koog.agents.ext.tool.shell.ShellCommandExecutor

Module: `agents-ext`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-ext/ai.koog.agents.ext.tool.shell/-shell-command-executor/index.html`

### :agents:agents-ext/commonMain

```kotlin
interface ShellCommandExecutor
```

Shell command executor using platform-specific shells (cmd.exe on Windows, sh on Unix).

- JvmShellCommandExecutor