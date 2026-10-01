# rag / rag-base

Additional Kotlin contracts from the supplied Dokka build. Read [API coverage](../../api-index.md) before use.

## ai.koog.rag.base.files.DocumentProvider.DocumentRange.DocumentRange

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-document-provider/-document-range/-document-range.html`

### :rag:rag-base/commonMain

```kotlin
constructor(start: DocumentProvider.Position, end: DocumentProvider.Position)
```

## ai.koog.rag.base.files.DocumentProvider.DocumentRange.end

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-document-provider/-document-range/end.html`

### :rag:rag-base/commonMain

```kotlin
val end: DocumentProvider.Position
```

## ai.koog.rag.base.files.DocumentProvider.DocumentRange

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-document-provider/-document-range/index.html`

### :rag:rag-base/commonMain

```kotlin
@Serializable data class DocumentRange(val start: DocumentProvider.Position, val end: DocumentProvider.Position)
```

Represents a range within a document, defined by a start and end position.

A DocumentRange encapsulates two Position objects, representing the beginning and end of the range, respectively. These positions are zero-based and valid for navigating and selecting content within a textual document.

This class provides utilities for working with document ranges, including calculating the number of lines covered by the range, determining if the range spans multiple lines, and extracting a substring from a given text based on the range.

## ai.koog.rag.base.files.DocumentProvider.DocumentRange.isMultiline

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-document-provider/-document-range/is-multiline.html`

### :rag:rag-base/commonMain

```kotlin
val isMultiline: Boolean
```

Indicates whether the range spans across multiple lines.

This property is true if the number of lines in the range is greater than one. It provides a convenient way to determine if the range is multiline or confined to a single line.

## ai.koog.rag.base.files.DocumentProvider.DocumentRange.lines

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-document-provider/-document-range/lines.html`

### :rag:rag-base/commonMain

```kotlin
val lines: Int
```

The number of lines covered by the range defined by the start and end positions. This computation includes both the start and end lines in the count.

## ai.koog.rag.base.files.DocumentProvider.DocumentRange.start

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-document-provider/-document-range/start.html`

### :rag:rag-base/commonMain

```kotlin
val start: DocumentProvider.Position
```

## ai.koog.rag.base.files.DocumentProvider.DocumentRange.substring

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-document-provider/-document-range/substring.html`

### :rag:rag-base/commonMain

```kotlin
fun substring(text: CharSequence): String
```

Extracts a substring from the given text based on the start and end positions of the DocumentRange.

A substring of the text starting from the resolved offset of the start position and ending at the resolved offset of the end position.

- text — The source text from which the substring will be extracted. This is a sequence of characters to operate on.
## ai.koog.rag.base.files.DocumentProvider.Edit

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-document-provider/-edit/index.html`

### :rag:rag-base/commonMain

```kotlin
interface Edit<Path, Document>
```

Represents an interface for performing edit operations on a document.

- Path — The type representing the document's path or identifier.
- Document — The type representing the document to perform edits on.
- Edit
## ai.koog.rag.base.files.DocumentProvider.Edit.setText

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-document-provider/-edit/set-text.html`

### :rag:rag-base/commonMain

```kotlin
abstract suspend fun setText(document: Document, text: String, range: DocumentProvider.DocumentRange? = null)
```

Sets the text content of the specified document, optionally within the provided range.

- document — The document where the text will be set.
- text — The new text to replace within the document.
- range — An optional range specifying the portion of the document to be replaced. If null, the entire document will be replaced.
## ai.koog.rag.base.files.DocumentProvider.Position.Position

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-document-provider/-position/-position.html`

### :rag:rag-base/commonMain

```kotlin
constructor(line: Int, column: Int)
```

## ai.koog.rag.base.files.DocumentProvider.Position.column

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-document-provider/-position/column.html`

### :rag:rag-base/commonMain

```kotlin
val column: Int
```

## ai.koog.rag.base.files.DocumentProvider.Position.compareTo

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-document-provider/-position/compare-to.html`

### :rag:rag-base/commonMain

```kotlin
open operator override fun compareTo(other: DocumentProvider.Position): Int
```

Compares this Position instance to another Position based on their line and column values.

A negative integer, zero, or a positive integer if this Position is less than, equal to, or greater than the specified Position, respectively.

- other — The Position instance to compare to this instance.
## ai.koog.rag.base.files.DocumentProvider.Position

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-document-provider/-position/index.html`

### :rag:rag-base/commonMain

```kotlin
@Serializable data class Position(val line: Int, val column: Int) : Comparable<DocumentProvider.Position>
```

Represents a position in a text document identified by a specific line and column. Used for precise referencing of specific locations within multi-line text content.

## ai.koog.rag.base.files.DocumentProvider.Position.line

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-document-provider/-position/line.html`

### :rag:rag-base/commonMain

```kotlin
val line: Int
```

## ai.koog.rag.base.files.DocumentProvider.document

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-document-provider/document.html`

### :rag:rag-base/commonMain

```kotlin
abstract suspend fun document(path: Path): Document?
```

Retrieves a document corresponding to the specified path.

The document represents the content or metadata associated with the given path. If no document can be retrieved for the provided path, null is returned.

A document corresponding to the path, or null if no document is available.

- path — The path for which the document is to be retrieved.
## ai.koog.rag.base.files.DocumentProvider

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-document-provider/index.html`

### :rag:rag-base/commonMain

```kotlin
interface DocumentProvider<Path, Document>
```

Interface representing a provider for managing documents and their contents. It allows retrieval of documents, manipulation of text, and extraction of content fragments.

- Path — The type representing the path or identifier for locating documents.
- Document — The type representing the document being operated on.
- JVMDocumentProvider
## ai.koog.rag.base.files.DocumentProvider.textFragment

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-document-provider/text-fragment.html`

### :rag:rag-base/commonMain

```kotlin
open suspend fun textFragment(document: Document, range: DocumentProvider.DocumentRange): String
```

Extracts a specified fragment of text from a given document based on a defined range.

A string containing the text fragment within the specified range of the document.

- document — The document from which the text fragment will be extracted.
- range — The range in the document that defines the start and end positions of the text fragment.
## ai.koog.rag.base.files.DocumentProvider.text

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-document-provider/text.html`

### :rag:rag-base/commonMain

```kotlin
abstract suspend fun text(document: Document): CharSequence
```

Retrieves the full text content of the given document as a character sequence.

A CharSequence representing the text content of the document.

- document — The document whose text content is to be retrieved.
## ai.koog.rag.base.files.FileMetadata.FileContentType.Binary

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-metadata/-file-content-type/-binary/index.html`

### :rag:rag-base/commonMain

```kotlin
Binary
```

Represents the binary file content type within the FileContent enum.

This value is used to denote that the content of a file is binary data, as opposed to plain text or other types. It provides a display string ("binary") to identify this content type.

## ai.koog.rag.base.files.FileMetadata.FileContentType.Text

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-metadata/-file-content-type/-text/index.html`

### :rag:rag-base/commonMain

```kotlin
Text
```

Represents textual file content. Associated with the string display value "text".

## ai.koog.rag.base.files.FileMetadata.FileContentType.display

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-metadata/-file-content-type/display.html`

### :rag:rag-base/commonMain

```kotlin
val display: String
```

## ai.koog.rag.base.files.FileMetadata.FileContentType.entries

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-metadata/-file-content-type/entries.html`

### :rag:rag-base/commonMain

```kotlin
val entries: EnumEntries<FileMetadata.FileContentType>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.rag.base.files.FileMetadata.FileContentType

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-metadata/-file-content-type/index.html`

### :rag:rag-base/commonMain

```kotlin
enum FileContentType : Enum<FileMetadata.FileContentType>
```

Enum representing the nature of a file's content.

This can be used to classify files based on their content type or determine how to handle specific file operations and interactions.

## ai.koog.rag.base.files.FileMetadata.FileContentType.valueOf

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-metadata/-file-content-type/value-of.html`

### :rag:rag-base/commonMain

```kotlin
fun valueOf(value: String): FileMetadata.FileContentType
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.rag.base.files.FileMetadata.FileContentType.values

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-metadata/-file-content-type/values.html`

### :rag:rag-base/commonMain

```kotlin
fun values(): Array<FileMetadata.FileContentType>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.rag.base.files.FileMetadata.FileMetadata

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-metadata/-file-metadata.html`

### :rag:rag-base/commonMain

```kotlin
constructor(type: FileMetadata.FileType, hidden: Boolean)
```

## ai.koog.rag.base.files.FileMetadata.FileType.Directory

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-metadata/-file-type/-directory/index.html`

### :rag:rag-base/commonMain

```kotlin
Directory
```

Represents a directory in the file system.

The Directory class is used to model a directory and its behavior within a file system. The class distinguishes between different file types, with FileType.Directory being explicitly associated with instances of this class.

This abstraction is useful for operations that involve hierarchical file structures, such as listing contents, locating parent directories, or performing file system navigation.

Features:

Encapsulates information and behavior specific to directories.

Used in conjunction with other classes (e.g., FileSystemProvider) for file system management.

Considerations:

Instances of Directory are not directly concerned with file contents but with structure and navigation within the file system.

The class may be utilized for tasks like directory traversal, metadata analysis, or adopting domain-specific implementations.

## ai.koog.rag.base.files.FileMetadata.FileType.File

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-metadata/-file-type/-file/index.html`

### :rag:rag-base/commonMain

```kotlin
File
```

Represents a file in the system. Used to denote a single file entity within a hierarchical filesystem structure. This enumeration value is part of the FileType enum which distinguishes between files and directories.

## ai.koog.rag.base.files.FileMetadata.FileType.entries

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-metadata/-file-type/entries.html`

### :rag:rag-base/commonMain

```kotlin
val entries: EnumEntries<FileMetadata.FileType>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.rag.base.files.FileMetadata.FileType

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-metadata/-file-type/index.html`

### :rag:rag-base/commonMain

```kotlin
enum FileType : Enum<FileMetadata.FileType>
```

Represents the type of a file in the context of file metadata.

## ai.koog.rag.base.files.FileMetadata.FileType.valueOf

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-metadata/-file-type/value-of.html`

### :rag:rag-base/commonMain

```kotlin
fun valueOf(value: String): FileMetadata.FileType
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.rag.base.files.FileMetadata.FileType.values

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-metadata/-file-type/values.html`

### :rag:rag-base/commonMain

```kotlin
fun values(): Array<FileMetadata.FileType>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.rag.base.files.FileMetadata.hidden

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-metadata/hidden.html`

### :rag:rag-base/commonMain

```kotlin
val hidden: Boolean
```

## ai.koog.rag.base.files.FileMetadata

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-metadata/index.html`

### :rag:rag-base/commonMain

```kotlin
@Serializable data class FileMetadata(val type: FileMetadata.FileType, val hidden: Boolean)
```

Represents metadata associated with a file or directory.

## ai.koog.rag.base.files.FileMetadata.type

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-metadata/type.html`

### :rag:rag-base/commonMain

```kotlin
@SerialName(value = "content_type") val type: FileMetadata.FileType
```

## ai.koog.rag.base.files.FileSystemProvider.ReadOnly.exists

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-system-provider/-read-only/exists.html`

### :rag:rag-base/commonMain

```kotlin
abstract suspend fun exists(path: Path): Boolean
```

Checks if a path exists in the filesystem.

true if the path exists, false otherwise.

- path — The path to check.
- IOException — if an I/O error occurs while checking path existence.
## ai.koog.rag.base.files.FileSystemProvider.ReadOnly.extension

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-system-provider/-read-only/extension.html`

### :rag:rag-base/commonMain

```kotlin
abstract fun extension(path: Path): String
```

Gets the extension of a path. This method works with the path structure and doesn't check if the path actually exists in the filesystem.

The extension of path or empty string if path doesn't have an extension.

- path — The path to examine.
## ai.koog.rag.base.files.FileSystemProvider.ReadOnly.fromAbsolutePathString

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-system-provider/-read-only/from-absolute-path-string.html`

### :rag:rag-base/commonMain

```kotlin
abstract fun fromAbsolutePathString(path: String): Path
```

Creates a Path object from an absolute path string. This method works with the path structure and doesn't check if the path actually exists in the filesystem.

A path object representing the absolute path.

- path — The absolute path string to convert.
- IllegalArgumentException — if path is not absolute.
## ai.koog.rag.base.files.FileSystemProvider.ReadOnly.getFileContentType

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-system-provider/-read-only/get-file-content-type.html`

### :rag:rag-base/commonMain

```kotlin
abstract suspend fun getFileContentType(path: Path): FileMetadata.FileContentType
```

Detects the type of content stored in a file using a path.

FileMetadata.FileContentType.Text for text files, FileMetadata.FileContentType.Binary for binary files.

- path — The path to a file whose content type is to be detected.
- IllegalArgumentException — if the path doesn't exist or isn't a regular file.
- IOException — if an I/O error occurs while detecting the file content type.
## ai.koog.rag.base.files.FileSystemProvider.ReadOnly

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-system-provider/-read-only/index.html`

### :rag:rag-base/commonMain

```kotlin
interface ReadOnly<Path>
```

Provides operations for path serialization, structure navigation, and content reading in a read-only manner without modifying the filesystem.

- ReadWrite
- ReadOnly
- ReadWrite
## ai.koog.rag.base.files.FileSystemProvider.ReadOnly.inputStream

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-system-provider/-read-only/input-stream.html`

### :rag:rag-base/commonMain

```kotlin
abstract suspend fun inputStream(path: Path): Source
```

Creates a Source for reading from a file at the specified path. The returned Source is buffered.

A buffered Source object for reading.

- path — The path to read from.
- IllegalArgumentException — if path doesn't exist or isn't a regular file.
- IOException — if an I/O error occurs during Source creation.
## ai.koog.rag.base.files.FileSystemProvider.ReadOnly.joinPath

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-system-provider/-read-only/join-path.html`

### :rag:rag-base/commonMain

```kotlin
abstract fun joinPath(base: Path, vararg parts: String): Path
```

Resolves strings from parts against a base path. This method works with the path structure and doesn't check if the path actually exists in the filesystem.

The resolved path object.

- base — The base path for resolution.
- parts — The path strings to resolve.
- IllegalArgumentException — if any of the parts is an absolute path.
## ai.koog.rag.base.files.FileSystemProvider.ReadOnly.list

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-system-provider/-read-only/list.html`

### :rag:rag-base/commonMain

```kotlin
abstract suspend fun list(directory: Path): List<Path>
```

Lists contents of a directory. Children are sorted by name. The listing is not recursive.

List of paths contained in the directory, sorted by name. Returns an empty list if the directory is empty.

- directory — The directory path to list.
- IllegalArgumentException — if directory is not a directory or doesn't exist.
- IOException — if an I/O error occurs during listing.
## ai.koog.rag.base.files.FileSystemProvider.ReadOnly.metadata

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-system-provider/-read-only/metadata.html`

### :rag:rag-base/commonMain

```kotlin
abstract suspend fun metadata(path: Path): FileMetadata?
```

Retrieves metadata for a file or directory using a path.

FileMetadata object or null if the path doesn't exist or isn't a regular file or directory.

- path — The path to examine.
- IOException — if an I/O error occurs while retrieving metadata.
## ai.koog.rag.base.files.FileSystemProvider.ReadOnly.name

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-system-provider/-read-only/name.html`

### :rag:rag-base/commonMain

```kotlin
abstract fun name(path: Path): String
```

Gets the name component of a path. This method works with the path structure and doesn't check if the path actually exists in the filesystem.

The name of the file or directory, or an empty string if the path has no name component.

- path — The path to examine.
## ai.koog.rag.base.files.FileSystemProvider.ReadOnly.parent

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-system-provider/-read-only/parent.html`

### :rag:rag-base/commonMain

```kotlin
abstract fun parent(path: Path): Path?
```

Gets the parent path of a given path. This method works with the path structure and doesn't check if the path actually exists in the filesystem.

The parent path or null if no parent exists.

- path — The path to examine.
## ai.koog.rag.base.files.FileSystemProvider.ReadOnly.readBytes

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-system-provider/-read-only/read-bytes.html`

### :rag:rag-base/commonMain

```kotlin
abstract suspend fun readBytes(path: Path): ByteArray
```

Reads the content of a file at the specified path.

The file content as a byte array.

- path — The path to read.
- readText
- IllegalArgumentException — if the path doesn't exist or isn't a regular file.
- IOException — if an I/O error occurs during reading.
## ai.koog.rag.base.files.FileSystemProvider.ReadOnly.relativize

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-system-provider/-read-only/relativize.html`

### :rag:rag-base/commonMain

```kotlin
abstract fun relativize(root: Path, path: Path): String?
```

Computes the relative path from a root to a target path. It doesn't check if the paths actually exist in the filesystem.

The relative path as a string, or null if the paths cannot be relativized (e.g., they have no common prefix).

- root — The root path.
- path — The target path.
## ai.koog.rag.base.files.FileSystemProvider.ReadOnly.size

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-system-provider/-read-only/size.html`

### :rag:rag-base/commonMain

```kotlin
abstract suspend fun size(path: Path): Long
```

Gets the size of a file in bytes.

The file size in bytes.

- path — The path to examine.
- IllegalArgumentException — if the path doesn't exist or isn't a regular file.
- IOException — if an I/O error occurs while determining the file size.
## ai.koog.rag.base.files.FileSystemProvider.ReadOnly.toAbsolutePathString

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-system-provider/-read-only/to-absolute-path-string.html`

### :rag:rag-base/commonMain

```kotlin
abstract fun toAbsolutePathString(path: Path): String
```

Converts a path to its absolute path string representation. This method works with the path structure and doesn't check if the path actually exists in the filesystem.

Absolute path as a string.

- path — The path to convert.
## ai.koog.rag.base.files.FileSystemProvider.ReadWrite.copy

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-system-provider/-read-write/copy.html`

### :rag:rag-base/commonMain

```kotlin
abstract suspend fun copy(source: Path, target: Path)
```

Copies a file or directory from source to target. If the source is a directory, all its contents are copied recursively. Parent directories of the target will be created if they don't exist.

- source — The source path to copy from.
- target — The target path to copy to.
- IOException — or its inheritor if the source doesn't exist, isn't a file or directory, target already exists, or any I/O error occurs.
## ai.koog.rag.base.files.FileSystemProvider.ReadWrite.create

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-system-provider/-read-write/create.html`

### :rag:rag-base/commonMain

```kotlin
abstract suspend fun create(path: Path, type: FileMetadata.FileType)
```

Creates a new file or directory denoted by the path using the specified type. Parent directories will be created if they don't exist.

- path — The path of the new file or directory.
- type — The type (file or directory) to create.
- createDirectory
- createFile
- IOException — or its inheritor if the path already exists, or path is invalid (e.g., contains reserved characters), or if any other I/O error occurs.
## ai.koog.rag.base.files.FileSystemProvider.ReadWrite.delete

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-system-provider/-read-write/delete.html`

### :rag:rag-base/commonMain

```kotlin
abstract suspend fun delete(path: Path)
```

Deletes a file or directory denoted by the path. If the item is a directory, it will be deleted recursively with all its contents.

- parent — The path of the item to delete.
- IOException — or its inheritor if the file or directory doesn't exist or can't be deleted for any other reason.
## ai.koog.rag.base.files.FileSystemProvider.ReadWrite

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-system-provider/-read-write/index.html`

### :rag:rag-base/commonMain

```kotlin
interface ReadWrite<Path> : FileSystemProvider.ReadOnly<Path>
```

This is the most comprehensive interface, offering complete filesystem operations including reading, writing, and path manipulation.

- ReadWrite
## ai.koog.rag.base.files.FileSystemProvider.ReadWrite.move

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-system-provider/-read-write/move.html`

### :rag:rag-base/commonMain

```kotlin
abstract suspend fun move(source: Path, target: Path)
```

Moves a file or directory from source to target. If the source is a directory, all its contents are moved recursively. Parent directories of the target will be created if they don't exist.

- source — The source path to move from.
- target — The target path to move to.
- IOException — or its inheritor if the source doesn't exist, isn't a file or directory, target already exists, or any I/O error occurs.
## ai.koog.rag.base.files.FileSystemProvider.ReadWrite.outputStream

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-system-provider/-read-write/output-stream.html`

### :rag:rag-base/commonMain

```kotlin
abstract suspend fun outputStream(path: Path, append: Boolean = false): Sink
```

Creates a Sink for writing to a file. If the file doesn't exist, it will be created. If the parent directories don't exist, they will be created. The returned Sink is buffered.

A buffered Sink object for writing.

- path — The path where Sink will be created.
- append — Append to existing content (true) or overwrite (false). Default is false (overwrite).
- IOException — if the path is a directory or any other I/O error occurs during Sink creation.
## ai.koog.rag.base.files.FileSystemProvider.ReadWrite.writeBytes

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-system-provider/-read-write/write-bytes.html`

### :rag:rag-base/commonMain

```kotlin
abstract suspend fun writeBytes(path: Path, data: ByteArray)
```

Writes content to a file. If the file doesn't exist, it will be created. If the file exists, its content will be overwritten. Parent directories will be created if they don't exist.

- path — The path to write to.
- data — The data to write as a byte array.
- writeText
- IOException — if the path is a directory or any other I/O error occurs during writing.
## ai.koog.rag.base.files.FileSystemProvider

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-file-system-provider/index.html`

### :rag:rag-base/commonMain

```kotlin
object FileSystemProvider
```

Provides ReadOnly and ReadWrite interfaces for interacting with a filesystem through file operations and content reading/writing.

## ai.koog.rag.base.files.JVMDocumentProvider.Edit

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-document-provider/-edit/index.html`

### :rag:rag-base/jvmMain

```kotlin
object Edit : DocumentProvider.Edit<Path, Path>
```

An implementation of the DocumentProvider.Edit interface for editing document contents.

This object provides functionality to modify the text content of a specified document, either entirely or partially based on a given range. It handles reading and writing text to the document with a focus on ensuring that the range and content modifications are valid.

## ai.koog.rag.base.files.JVMDocumentProvider.Edit.setText

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-document-provider/-edit/set-text.html`

### :rag:rag-base/jvmMain

```kotlin
open suspend override fun setText(document: Path, text: String, range: DocumentProvider.DocumentRange? = null)
```

Sets the text content of the specified document, optionally within the provided range.

- document — The document where the text will be set.
- text — The new text to replace within the document.
- range — An optional range specifying the portion of the document to be replaced. If null, the entire document will be replaced.
## ai.koog.rag.base.files.JVMDocumentProvider.document

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-document-provider/document.html`

### :rag:rag-base/jvmMain

```kotlin
open suspend override fun document(path: Path): Path
```

Retrieves a document corresponding to the specified path.

The document represents the content or metadata associated with the given path. If no document can be retrieved for the provided path, null is returned.

A document corresponding to the path, or null if no document is available.

- path — The path for which the document is to be retrieved.
## ai.koog.rag.base.files.JVMDocumentProvider

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-document-provider/index.html`

### :rag:rag-base/jvmMain

```kotlin
object JVMDocumentProvider : DocumentProvider<Path, Path>
```

An implementation of the DocumentProvider interface for handling documents represented as Path objects. This object provides functionality to read and write text from files, allowing for document editing and text transformation while normalizing line separators.

## ai.koog.rag.base.files.JVMDocumentProvider.text

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-document-provider/text.html`

### :rag:rag-base/jvmMain

```kotlin
open suspend override fun text(document: Path): CharSequence
```

Retrieves the full text content of the given document as a character sequence.

A CharSequence representing the text content of the document.

- document — The document whose text content is to be retrieved.
## ai.koog.rag.base.files.JVMFileSystemProvider.ReadOnly.exists

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-file-system-provider/-read-only/exists.html`

### :rag:rag-base/jvmMain

```kotlin
open suspend override fun exists(path: Path): Boolean
```

Checks if the specified file or directory exists at the given path.

The operation is performed with Dispatchers.IO context.

true if the file or directory exists, false otherwise.

- path — The path to the file or directory to be checked.
## ai.koog.rag.base.files.JVMFileSystemProvider.ReadOnly.extension

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-file-system-provider/-read-only/extension.html`

### :rag:rag-base/jvmMain

```kotlin
open override fun extension(path: Path): String
```

Retrieves the extension of the specified path.

the extension of path as a string.

- path — the path from which to extract the extension.
## ai.koog.rag.base.files.JVMFileSystemProvider.ReadOnly.fromAbsolutePathString

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-file-system-provider/-read-only/from-absolute-path-string.html`

### :rag:rag-base/jvmMain

```kotlin
open override fun fromAbsolutePathString(path: String): Path
```

Converts the given absolute file path string to a normalized Path object.

The normalized Path representation of the given string.

- path — The absolute file path as a string.
- IllegalArgumentException — if the resolved path is not absolute.
## ai.koog.rag.base.files.JVMFileSystemProvider.ReadOnly.getFileContentType

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-file-system-provider/-read-only/get-file-content-type.html`

### :rag:rag-base/jvmMain

```kotlin
open suspend override fun getFileContentType(path: Path): FileMetadata.FileContentType
```

Detects the type of content stored in a file using a path.

The operation is performed with Dispatchers.IO context.

FileContentType.Text for text files, FileContentType.Binary for binary files.

- path — The path to the file whose content type is to be detected.
- IllegalArgumentException — if the path doesn't exist or isn't a regular file.
- IOException — if an I/O error occurs while detecting the file content type.
## ai.koog.rag.base.files.JVMFileSystemProvider.ReadOnly

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-file-system-provider/-read-only/index.html`

### :rag:rag-base/jvmMain

```kotlin
object ReadOnly : FileSystemProvider.ReadOnly<Path>
```

Provides operations for path serialization, structure navigation, and content reading using Path objects in a read-only manner without modifying the filesystem.

## ai.koog.rag.base.files.JVMFileSystemProvider.ReadOnly.inputStream

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-file-system-provider/-read-only/input-stream.html`

### :rag:rag-base/jvmMain

```kotlin
open suspend override fun inputStream(path: Path): Source
```

Creates a Source for reading from a file at the specified path. The returned Source is buffered. It is created with Dispatchers.IO context.

A buffered Source object for reading.

- path — The path to read from.
- IllegalArgumentException — if path doesn't exist or isn't a regular file.
- IOException — if an I/O error occurs during Source creation.
## ai.koog.rag.base.files.JVMFileSystemProvider.ReadOnly.joinPath

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-file-system-provider/-read-only/join-path.html`

### :rag:rag-base/jvmMain

```kotlin
open override fun joinPath(base: Path, vararg parts: String): Path
```

Resolves strings from parts against a base path. This method works with the path structure and doesn't check if the path actually exists in the filesystem.

A normalized Path object representing the resolved path.

- base — The base path for resolution.
- parts — The path strings to resolve.
- IllegalArgumentException — if any of the parts is an absolute path.
## ai.koog.rag.base.files.JVMFileSystemProvider.ReadOnly.list

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-file-system-provider/-read-only/list.html`

### :rag:rag-base/jvmMain

```kotlin
open suspend override fun list(directory: Path): List<Path>
```

Retrieves a sorted list of paths within the specified directory. The listing is not recursive.

The operation is performed with Dispatchers.IO context.

A list of paths within the specified directory, sorted by name. Returns an empty list if an error occurs or the directory is empty.

- directory — The directory path whose contents are to be listed.
- IllegalArgumentException — if directory is not a directory or doesn't exist.
- IOException — if an I/O error occurs during listing.
## ai.koog.rag.base.files.JVMFileSystemProvider.ReadOnly.metadata

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-file-system-provider/-read-only/metadata.html`

### :rag:rag-base/jvmMain

```kotlin
open suspend override fun metadata(path: Path): FileMetadata?
```

Retrieves metadata for a given file or directory path.

The method determines whether the provided path represents a regular file or directory, and constructs the metadata accordingly. If the path does not represent a regular file or directory, it returns null.

The operation is performed with Dispatchers.IO context.

A FileMetadata instance containing information about the file or directory, or null if the path does not represent a valid file or directory.

- path — The path for which the metadata is to be retrieved.
- IOException — if an I/O error occurs while retrieving metadata.
## ai.koog.rag.base.files.JVMFileSystemProvider.ReadOnly.name

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-file-system-provider/-read-only/name.html`

### :rag:rag-base/jvmMain

```kotlin
open override fun name(path: Path): String
```

Retrieves the name of the given file path.

the name of the file or directory represented by the provided path

- path — the file path from which to extract the name
## ai.koog.rag.base.files.JVMFileSystemProvider.ReadOnly.parent

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-file-system-provider/-read-only/parent.html`

### :rag:rag-base/jvmMain

```kotlin
open override fun parent(path: Path): Path?
```

Retrieves the parent directory of the specified path, if it exists.

the parent path if it exists, or null if the path does not have a parent

- path — the path for which to retrieve the parent directory
## ai.koog.rag.base.files.JVMFileSystemProvider.ReadOnly.readBytes

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-file-system-provider/-read-only/read-bytes.html`

### :rag:rag-base/jvmMain

```kotlin
open suspend override fun readBytes(path: Path): ByteArray
```

Reads the content of a file at the specified path. Bytes are read with Dispatchers.IO context.

The file content as a byte array.

- path — The path to read.
- IllegalArgumentException — if the path doesn't exist or isn't a regular file.
- IOException — if an I/O error occurs during reading.
## ai.koog.rag.base.files.JVMFileSystemProvider.ReadOnly.relativize

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-file-system-provider/-read-only/relativize.html`

### :rag:rag-base/jvmMain

```kotlin
open override fun relativize(root: Path, path: Path): String?
```

Computes the relative path from the given root to the specified path.

the relative path from the root to the given path as a normalized string, or null if the paths have no common prefix.

- root — the root path to which the provided path will be relativized.
- path — the path for which the relative path needs to be determined.
## ai.koog.rag.base.files.JVMFileSystemProvider.ReadOnly.size

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-file-system-provider/-read-only/size.html`

### :rag:rag-base/jvmMain

```kotlin
open suspend override fun size(path: Path): Long
```

Returns the size of the regular file at the specified path.

The operation is performed with Dispatchers.IO context.

the size of the file in bytes.

- path — the path to the file whose size is to be obtained. Must be a regular file and exist.
- IllegalArgumentException — if path doesn't exist or isn't a regular file.
- IOException — if an I/O error occurs while determining the file size.
## ai.koog.rag.base.files.JVMFileSystemProvider.ReadOnly.toAbsolutePathString

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-file-system-provider/-read-only/to-absolute-path-string.html`

### :rag:rag-base/jvmMain

```kotlin
open override fun toAbsolutePathString(path: Path): String
```

Converts the given path to its absolute path representation as a string. The path is normalized before being converted.

the absolute path string representation of the given path

- path — the relative or absolute path to be converted to an absolute string representation
## ai.koog.rag.base.files.JVMFileSystemProvider.ReadWrite.copy

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-file-system-provider/-read-write/copy.html`

### :rag:rag-base/jvmMain

```kotlin
open suspend override fun copy(source: Path, target: Path)
```

Copies a file or directory from source to target. If the source is a directory, all its contents are copied recursively. Parent directories of the target will be created if they don't exist. The operation is performed with Dispatchers.IO context.

- source — The source path to copy from.
- target — The target path to copy to.
- IOException — or its inheritor if the source doesn't exist, isn't a file or directory, target already exists, or any I/O error occurs.
## ai.koog.rag.base.files.JVMFileSystemProvider.ReadWrite.create

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-file-system-provider/-read-write/create.html`

### :rag:rag-base/jvmMain

```kotlin
open suspend override fun create(path: Path, type: FileMetadata.FileType)
```

Creates a new file or directory denoted by the path using the specified type. It is created with Dispatchers.IO context. Parent directories will be created if they don't exist.

- path — The path of the new file or directory.
- type — The type (file or directory) to create.
- IOException — or its inheritor if the path already exists, or path is invalid (e.g., contains reserved characters), or if any other I/O error occurs.
## ai.koog.rag.base.files.JVMFileSystemProvider.ReadWrite.delete

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-file-system-provider/-read-write/delete.html`

### :rag:rag-base/jvmMain

```kotlin
open suspend override fun delete(path: Path)
```

Deletes a file or directory denoted by the path. If the item is a directory, it will be deleted recursively with all its contents. The operation is performed with Dispatchers.IO context.

- parent — The path of the item to delete.
- IOException — or its inheritor if the file or directory doesn't exist or can't be deleted for any other reason.
## ai.koog.rag.base.files.JVMFileSystemProvider.ReadWrite

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-file-system-provider/-read-write/index.html`

### :rag:rag-base/jvmMain

```kotlin
object ReadWrite : FileSystemProvider.ReadWrite<Path> , FileSystemProvider.ReadOnly<Path>
```

This is the most comprehensive interface, offering complete filesystem operations using Path objects including reading, writing, and path manipulation.

## ai.koog.rag.base.files.JVMFileSystemProvider.ReadWrite.move

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-file-system-provider/-read-write/move.html`

### :rag:rag-base/jvmMain

```kotlin
open suspend override fun move(source: Path, target: Path)
```

Moves a file or directory from source to target. If the source is a directory, all its contents are moved recursively. Parent directories of the target will be created if they don't exist. The operation is performed with Dispatchers.IO context.

- source — The source path to move from.
- target — The target path to move to.
- IOException — or its inheritor if the source doesn't exist, isn't a file or directory, target already exists, or any I/O error occurs.
## ai.koog.rag.base.files.JVMFileSystemProvider.ReadWrite.outputStream

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-file-system-provider/-read-write/output-stream.html`

### :rag:rag-base/jvmMain

```kotlin
open suspend override fun outputStream(path: Path, append: Boolean = false): Sink
```

Creates a Sink for writing to a file. If the file doesn't exist, it will be created. If the parent directories don't exist, they will be created. The returned Sink is buffered. It is created with Dispatchers.IO context.

A buffered Sink object for writing.

- path — The path where Sink will be created.
- append — Append to existing content (true) or overwrite (false). Default is false (overwrite).
- IOException — if the path is a directory or any other I/O error occurs during Sink creation.
## ai.koog.rag.base.files.JVMFileSystemProvider.ReadWrite.writeBytes

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-file-system-provider/-read-write/write-bytes.html`

### :rag:rag-base/jvmMain

```kotlin
open suspend override fun writeBytes(path: Path, data: ByteArray)
```

Writes content to a file. If the file doesn't exist, it will be created. If the file exists, its content will be overwritten. Parent directories will be created if they don't exist. The operation is performed with Dispatchers.IO context.

- path — The path to write to.
- data — The data to write as a byte array.
- IOException — if the path is a directory or any other I/O error occurs during writing.
## ai.koog.rag.base.files.JVMFileSystemProvider

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/-j-v-m-file-system-provider/index.html`

### :rag:rag-base/jvmMain

```kotlin
object JVMFileSystemProvider
```

Provides access to the JVM-specific file system functionality. This object includes implementations for operations like serialization of Path objects, file selection, read, write, and combined read-write operations.

## ai.koog.rag.base.files.createDirectory

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/create-directory.html`

### :rag:rag-base/commonMain

```kotlin
suspend fun <Path> FileSystemProvider.ReadWrite<Path>.createDirectory(path: Path)
```

Creates a directory at the specified path. Parent directories will be created automatically if they don't exist.

- path — The path where the directory should be created.
- FileSystemProvider.ReadWrite.create
## ai.koog.rag.base.files.createFile

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/create-file.html`

### :rag:rag-base/commonMain

```kotlin
suspend fun <Path> FileSystemProvider.ReadWrite<Path>.createFile(path: Path)
```

Creates a file at the specified path. Parent directories will be created automatically if they don't exist.

- path — The path where the file should be created.
- FileSystemProvider.ReadWrite.create
## ai.koog.rag.base.files.extendRangeByLines

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/extend-range-by-lines.html`

### :rag:rag-base/commonMain

```kotlin
fun extendRangeByLines(content: CharSequence, range: DocumentProvider.DocumentRange, linesBefore: Int = 2, linesAfter: Int = 2): DocumentProvider.DocumentRange
```

Expands a DocumentRange by a number of full lines before and after. Returns a new range clamped to the content bounds.

## ai.koog.rag.base.files.filter

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/filter.html`

### :rag:rag-base/commonMain

```kotlin
fun <Path> FileSystemProvider.ReadOnly<Path>.filter(filter: TraversalFilter<Path>): FileSystemProvider.ReadOnly<Path>
```

Filters the current read-only file system implementation such that only paths that are accepted by filter are visible and accessible.


Referenced packages: `ai.koog.rag.base.files.filter`.

### :rag:rag-base/commonMain

```kotlin
fun <Path> FileSystemProvider.ReadWrite<Path>.filter(filter: TraversalFilter<Path>): FileSystemProvider.ReadWrite<Path>
```

Filters the current read-write file system implementation such that only paths that are accepted by filter are visible and accessible.


Referenced packages: `ai.koog.rag.base.files.filter`.

## ai.koog.rag.base.files.readText

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/read-text.html`

### :rag:rag-base/commonMain

```kotlin
suspend fun <Path, Document> FileSystemProvider.ReadOnly<Path>.readText(path: Path, documentProvider: DocumentProvider<Path, Document>?): String
```

Reads the entire content of a file as a string.

The file content as a string.

- path — The file path to read.
- documentProvider — document provider to get unsaved text from.
- FileSystemProvider.ReadOnly.readBytes
- DocumentProvider.document
- DocumentProvider.text
### :rag:rag-base/commonMain

```kotlin
suspend fun <Path> FileSystemProvider.ReadOnly<Path>.readText(path: Path): String
```

Reads the entire content of a file as a string.

The file content as a string.

- path — The file path to read.
- FileSystemProvider.ReadOnly.readBytes
## ai.koog.rag.base.files.toPosition

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/to-position.html`

### :rag:rag-base/commonMain

```kotlin
fun Int.toPosition(content: CharSequence): DocumentProvider.Position
```

Converts an integer representing a character offset to a Position object, which includes line and column information within the given content.

A Position object that represents the line and column corresponding to the given offset.

- content — The multi-line text content in which the position is calculated.
## ai.koog.rag.base.files.writeText

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files/write-text.html`

### :rag:rag-base/commonMain

```kotlin
suspend fun <Path> FileSystemProvider.ReadWrite<Path>.writeText(path: Path, content: String)
```

Writes a string to a file, replacing any existing content.

- path — The file path to write to.
- content — The string content to write.
- FileSystemProvider.ReadWrite.writeBytes
## ai.koog.rag.base.files.filter.GlobPattern.Companion.ANY

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.filter/-glob-pattern/-companion/-a-n-y.html`

### :rag:rag-base/commonMain

```kotlin
val ANY: GlobPattern
```

A pattern that matches any path.

## ai.koog.rag.base.files.filter.GlobPattern.Companion

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.filter/-glob-pattern/-companion/index.html`

### :rag:rag-base/commonMain

```kotlin
object Companion
```

## ai.koog.rag.base.files.filter.GlobPattern.GlobPattern

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.filter/-glob-pattern/-glob-pattern.html`

### :rag:rag-base/commonMain

```kotlin
constructor(pattern: String, caseSensitive: Boolean = true)
```

- pattern — the glob pattern string
- caseSensitive — whether the pattern matching should be case-sensitive (default: true)
## ai.koog.rag.base.files.filter.GlobPattern

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.filter/-glob-pattern/index.html`

### :rag:rag-base/commonMain

```kotlin
class GlobPattern(pattern: String, caseSensitive: Boolean = true)
```

A pattern for matching file paths using glob syntax.

Supports standard glob pattern syntax:

matches any sequence of characters within a path segment

** matches any sequence of characters across path segments

? matches any single character

\[abc\] matches any character in the set

!abc matches any character not in the set

{a,b,c} matches any of the alternatives a, b, or c

- pattern — the glob pattern string
- caseSensitive — whether the pattern matching should be case-sensitive (default: true)
## ai.koog.rag.base.files.filter.GlobPattern.matches

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.filter/-glob-pattern/matches.html`

### :rag:rag-base/commonMain

```kotlin
fun matches(path: String): Boolean
```

Tests if the given path matches this glob pattern.

true if the path matches the pattern, false otherwise

- path — the file system path to test, using / as separator
## ai.koog.rag.base.files.filter.PathFilters.byRoot

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.filter/-path-filters/by-root.html`

### :rag:rag-base/commonMain

```kotlin
fun <Path> byRoot(root: Path): TraversalFilter<Path>
```

Accepts only paths that are contained within the given root or paths that contain the root.

## ai.koog.rag.base.files.filter.PathFilters

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.filter/-path-filters/index.html`

### :rag:rag-base/commonMain

```kotlin
object PathFilters
```

Contains factory methods with predefined path filters.

## ai.koog.rag.base.files.filter.TraversalFilter.Companion.any

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.filter/-traversal-filter/-companion/any.html`

### :rag:rag-base/commonMain

```kotlin
fun <Path> any(): TraversalFilter<Path>
```

A filter that always returns true.

## ai.koog.rag.base.files.filter.TraversalFilter.Companion

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.filter/-traversal-filter/-companion/index.html`

### :rag:rag-base/commonMain

```kotlin
object Companion
```

Contains static methods for TraversalFilter.

## ai.koog.rag.base.files.filter.TraversalFilter.Companion.not

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.filter/-traversal-filter/-companion/not.html`

### :rag:rag-base/commonMain

```kotlin
fun <Path> not(filter: TraversalFilter<Path>): TraversalFilter<Path>
```

Returns a reversed version of the filter.

## ai.koog.rag.base.files.filter.TraversalFilter.and

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.filter/-traversal-filter/and.html`

### :rag:rag-base/commonMain

```kotlin
open infix fun and(other: TraversalFilter<Path>): TraversalFilter<Path>
```

Returns a conjunction of this filter and the other filter.

## ai.koog.rag.base.files.filter.TraversalFilter.hide

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.filter/-traversal-filter/hide.html`

### :rag:rag-base/commonMain

```kotlin
open suspend fun hide(path: Path, fs: FileSystemProvider.ReadOnly<Path>): Boolean
```

Returns true if the path is not accepted, false otherwise.


Referenced packages: `ai.koog.rag.base.files`.

## ai.koog.rag.base.files.filter.TraversalFilter

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.filter/-traversal-filter/index.html`

### :rag:rag-base/commonMain

```kotlin
fun interface TraversalFilter<Path>
```

A class that is used for path filtering while traversing a file system.

## ai.koog.rag.base.files.filter.TraversalFilter.or

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.filter/-traversal-filter/or.html`

### :rag:rag-base/commonMain

```kotlin
open infix fun or(other: TraversalFilter<Path>): TraversalFilter<Path>
```

Returns a disjunction of this filter and the other filter.

## ai.koog.rag.base.files.filter.TraversalFilter.show

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.filter/-traversal-filter/show.html`

### :rag:rag-base/commonMain

```kotlin
abstract suspend fun show(path: Path, fs: FileSystemProvider.ReadOnly<Path>): Boolean
```

Returns true if the filter accepts the path, false otherwise.


Referenced packages: `ai.koog.rag.base.files`.

## ai.koog.rag.base.files.model.FileSize.Bytes.Bytes

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-size/-bytes/-bytes.html`

### :rag:rag-base/commonMain

```kotlin
constructor(bytes: Long)
```

## ai.koog.rag.base.files.model.FileSize.Bytes.bytes

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-size/-bytes/bytes.html`

### :rag:rag-base/commonMain

```kotlin
val bytes: Long
```

## ai.koog.rag.base.files.model.FileSize.Bytes.display

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-size/-bytes/display.html`

### :rag:rag-base/commonMain

```kotlin
open override fun display(): String
```

Formats the byte count as a human-readable string.

Rules:

0 → "0 bytes"

≥ 1 MiB → value in MiB with one decimal place

< 0.1 KiB → "<0.1 KiB"

Otherwise → value in KiB with one decimal place

## ai.koog.rag.base.files.model.FileSize.Bytes

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-size/-bytes/index.html`

### :rag:rag-base/commonMain

```kotlin
@Serializable data class Bytes(val bytes: Long) : FileSize
```

Represents a file's size in bytes with automatic unit selection for display.

## ai.koog.rag.base.files.model.FileSize.Companion.KIB

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-size/-companion/-k-i-b.html`

### :rag:rag-base/commonMain

```kotlin
const val KIB: Long = 1024
```

Defines 1 kibibyte as 1024 bytes

## ai.koog.rag.base.files.model.FileSize.Companion.MIB

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-size/-companion/-m-i-b.html`

### :rag:rag-base/commonMain

```kotlin
const val MIB: Long
```

Defines 1 mebibyte as 1024 × 1024 bytes

## ai.koog.rag.base.files.model.FileSize.Companion

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-size/-companion/index.html`

### :rag:rag-base/commonMain

```kotlin
object Companion
```

Provides utility methods and constants for file size handling

## ai.koog.rag.base.files.model.FileSize.Lines.Lines

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-size/-lines/-lines.html`

### :rag:rag-base/commonMain

```kotlin
constructor(lines: Int)
```

## ai.koog.rag.base.files.model.FileSize.Lines.display

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-size/-lines/display.html`

### :rag:rag-base/commonMain

```kotlin
open override fun display(): String
```

Returns the line count as "1 line" when the value is one or "N lines" otherwise

## ai.koog.rag.base.files.model.FileSize.Lines

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-size/-lines/index.html`

### :rag:rag-base/commonMain

```kotlin
@Serializable data class Lines(val lines: Int) : FileSize
```

Represents a file's size as line count.

## ai.koog.rag.base.files.model.FileSize.Lines.lines

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-size/-lines/lines.html`

### :rag:rag-base/commonMain

```kotlin
val lines: Int
```

## ai.koog.rag.base.files.model.FileSize.display

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-size/display.html`

### :rag:rag-base/commonMain

```kotlin
abstract fun display(): String
```

Returns a formatted string representation of the file size

## ai.koog.rag.base.files.model.FileSize

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-size/index.html`

### :rag:rag-base/commonMain

```kotlin
@Serializable sealed interface FileSize
```

Provides human-readable file size information.

Represents sizes as Bytes (in bytes, kibibytes, or mebibyte) or as Lines (a count of text lines).

- Bytes
- Lines
## ai.koog.rag.base.files.model.FileSystemEntry.File.Content.Excerpt.Excerpt

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-file/-content/-excerpt/-excerpt.html`

### :rag:rag-base/commonMain

```kotlin
constructor(snippets: List<FileSystemEntry.File.Content.Excerpt.Snippet>)
```

### :rag:rag-base/commonMain

```kotlin
constructor(vararg snippets: FileSystemEntry.File.Content.Excerpt.Snippet)
```

Creates an Excerpt from multiple Snippets.

- snippets — the snippets to include
## ai.koog.rag.base.files.model.FileSystemEntry.File.Content.Excerpt.Snippet.Snippet

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-file/-content/-excerpt/-snippet/-snippet.html`

### :rag:rag-base/commonMain

```kotlin
constructor(text: String, range: DocumentProvider.DocumentRange)
```


Referenced packages: `ai.koog.rag.base.files`.

## ai.koog.rag.base.files.model.FileSystemEntry.File.Content.Excerpt.Snippet

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-file/-content/-excerpt/-snippet/index.html`

### :rag:rag-base/commonMain

```kotlin
@Serializable data class Snippet(val text: String, val range: DocumentProvider.DocumentRange)
```

Represents a text selection with its location in the source file.


Referenced packages: `ai.koog.rag.base.files`.

## ai.koog.rag.base.files.model.FileSystemEntry.File.Content.Excerpt.Snippet.range

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-file/-content/-excerpt/-snippet/range.html`

### :rag:rag-base/commonMain

```kotlin
val range: DocumentProvider.DocumentRange
```


Referenced packages: `ai.koog.rag.base.files`.

## ai.koog.rag.base.files.model.FileSystemEntry.File.Content.Excerpt.Snippet.text

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-file/-content/-excerpt/-snippet/text.html`

### :rag:rag-base/commonMain

```kotlin
val text: String
```

## ai.koog.rag.base.files.model.FileSystemEntry.File.Content.Excerpt

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-file/-content/-excerpt/index.html`

### :rag:rag-base/commonMain

```kotlin
@Serializable data class Excerpt(val snippets: List<FileSystemEntry.File.Content.Excerpt.Snippet>) : FileSystemEntry.File.Content
```

Represents multiple separate text selections from a file.

Each snippet contains text from a different part of the file, allowing non-contiguous selections.

## ai.koog.rag.base.files.model.FileSystemEntry.File.Content.Excerpt.snippets

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-file/-content/-excerpt/snippets.html`

### :rag:rag-base/commonMain

```kotlin
val snippets: List<FileSystemEntry.File.Content.Excerpt.Snippet>
```

## ai.koog.rag.base.files.model.FileSystemEntry.File.Content.None

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-file/-content/-none/index.html`

### :rag:rag-base/commonMain

```kotlin
@Serializable data object None : FileSystemEntry.File.Content
```

Represents no file content.

## ai.koog.rag.base.files.model.FileSystemEntry.File.Content.Text.Text

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-file/-content/-text/-text.html`

### :rag:rag-base/commonMain

```kotlin
constructor(text: String)
```

## ai.koog.rag.base.files.model.FileSystemEntry.File.Content.Text

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-file/-content/-text/index.html`

### :rag:rag-base/commonMain

```kotlin
@Serializable data class Text(val text: String) : FileSystemEntry.File.Content
```

Represents full file content.

## ai.koog.rag.base.files.model.FileSystemEntry.File.Content.Text.text

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-file/-content/-text/text.html`

### :rag:rag-base/commonMain

```kotlin
val text: String
```

## ai.koog.rag.base.files.model.FileSystemEntry.File.Content

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-file/-content/index.html`

### :rag:rag-base/commonMain

```kotlin
@Serializable sealed interface Content
```

Represents file content as none, full text, or excerpt.

- None
- Text
- Excerpt
## ai.koog.rag.base.files.model.FileSystemEntry.File.File

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-file/-file.html`

### :rag:rag-base/commonMain

```kotlin
constructor(name: String, extension: String?, path: String, hidden: Boolean, size: List<FileSize>, contentType: FileMetadata.FileContentType, content: FileSystemEntry.File.Content = Content.None)
```


Referenced packages: `ai.koog.rag.base.files`.

## ai.koog.rag.base.files.model.FileSystemEntry.File.contentType

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-file/content-type.html`

### :rag:rag-base/commonMain

```kotlin
@SerialName(value = "content_type") val contentType: FileMetadata.FileContentType
```


Referenced packages: `ai.koog.rag.base.files`.

## ai.koog.rag.base.files.model.FileSystemEntry.File.content

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-file/content.html`

### :rag:rag-base/commonMain

```kotlin
val content: FileSystemEntry.File.Content
```

## ai.koog.rag.base.files.model.FileSystemEntry.File.extension

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-file/extension.html`

### :rag:rag-base/commonMain

```kotlin
open override val extension: String?
```

Represents the optional file extension of the file system entry.

The extension is the portion of the filename following the last dot ('.'), excluding the dot itself. For example, in the file name "document.txt", the extension would be "txt". If the file does not have an extension or the entry is not a file, this value may be null.

## ai.koog.rag.base.files.model.FileSystemEntry.File.hidden

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-file/hidden.html`

### :rag:rag-base/commonMain

```kotlin
open override val hidden: Boolean
```

Indicates whether the file system entry is hidden.

A hidden file or folder is typically not visible in directory listings unless explicitly configured to show hidden items. The visibility may depend on the underlying file system's settings or user preferences.

## ai.koog.rag.base.files.model.FileSystemEntry.File

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-file/index.html`

### :rag:rag-base/commonMain

```kotlin
@Serializable data class File(val name: String, val extension: String?, val path: String, val hidden: Boolean, val size: List<FileSize>, val contentType: FileMetadata.FileContentType, val content: FileSystemEntry.File.Content = Content.None) : FileSystemEntry
```

Represents a file in the filesystem.


Referenced packages: `ai.koog.rag.base.files`.

## ai.koog.rag.base.files.model.FileSystemEntry.File.name

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-file/name.html`

### :rag:rag-base/commonMain

```kotlin
open override val name: String
```

Represents the name as a string value. This variable is typically used to hold textual data corresponding to a name.

## ai.koog.rag.base.files.model.FileSystemEntry.File.path

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-file/path.html`

### :rag:rag-base/commonMain

```kotlin
open override val path: String
```

Represents a filesystem or resource path.

This variable is typically used to store the string representation of an absolute or relative path to a file, directory, or resource.

## ai.koog.rag.base.files.model.FileSystemEntry.File.size

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-file/size.html`

### :rag:rag-base/commonMain

```kotlin
val size: List<FileSize>
```

## ai.koog.rag.base.files.model.FileSystemEntry.File.visit

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-file/visit.html`

### :rag:rag-base/commonMain

```kotlin
open suspend override fun visit(depth: Int, visitor: suspend (FileSystemEntry) -> Unit)
```

Visits this file by calling visitor once.

- depth — ignored for files
- visitor — function called with this file
## ai.koog.rag.base.files.model.FileSystemEntry.Folder.Folder

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-folder/-folder.html`

### :rag:rag-base/commonMain

```kotlin
constructor(name: String, path: String, hidden: Boolean, entries: List<FileSystemEntry>? = null)
```

## ai.koog.rag.base.files.model.FileSystemEntry.Folder.entries

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-folder/entries.html`

### :rag:rag-base/commonMain

```kotlin
val entries: List<FileSystemEntry>?
```

## ai.koog.rag.base.files.model.FileSystemEntry.Folder.extension

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-folder/extension.html`

### :rag:rag-base/commonMain

```kotlin
open override val extension: String? = null
```

Always null since directories have no file extensions.

## ai.koog.rag.base.files.model.FileSystemEntry.Folder.hidden

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-folder/hidden.html`

### :rag:rag-base/commonMain

```kotlin
open override val hidden: Boolean
```

## ai.koog.rag.base.files.model.FileSystemEntry.Folder

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-folder/index.html`

### :rag:rag-base/commonMain

```kotlin
@Serializable data class Folder(val name: String, val path: String, val hidden: Boolean, val entries: List<FileSystemEntry>? = null) : FileSystemEntry
```

Represents a folder in a filesystem.

A folder is a directory that can contain other entries, including files and subfolders. This class implements FileSystemEntry and includes metadata and optional child entries.

## ai.koog.rag.base.files.model.FileSystemEntry.Folder.name

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-folder/name.html`

### :rag:rag-base/commonMain

```kotlin
open override val name: String
```

## ai.koog.rag.base.files.model.FileSystemEntry.Folder.path

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-folder/path.html`

### :rag:rag-base/commonMain

```kotlin
open override val path: String
```

## ai.koog.rag.base.files.model.FileSystemEntry.Folder.visit

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/-folder/visit.html`

### :rag:rag-base/commonMain

```kotlin
open suspend override fun visit(depth: Int, visitor: suspend (FileSystemEntry) -> Unit)
```

Visits this folder and its descendants up to the specified depth.

- depth — how deep to traverse (0 = this folder only, negative values treated as 0)
- visitor — function called for each visited entry
## ai.koog.rag.base.files.model.FileSystemEntry.extension

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/extension.html`

### :rag:rag-base/commonMain

```kotlin
abstract val extension: String?
```

Represents the optional file extension of the file system entry.

The extension is the portion of the filename following the last dot ('.'), excluding the dot itself. For example, in the file name "document.txt", the extension would be "txt". If the file does not have an extension or the entry is not a file, this value may be null.

## ai.koog.rag.base.files.model.FileSystemEntry.hidden

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/hidden.html`

### :rag:rag-base/commonMain

```kotlin
abstract val hidden: Boolean
```

Indicates whether the file system entry is hidden.

A hidden file or folder is typically not visible in directory listings unless explicitly configured to show hidden items. The visibility may depend on the underlying file system's settings or user preferences.

## ai.koog.rag.base.files.model.FileSystemEntry

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/index.html`

### :rag:rag-base/commonMain

```kotlin
@Serializable sealed interface FileSystemEntry
```

Provides a common interface for files and directories in a filesystem.

- File
- Folder
## ai.koog.rag.base.files.model.FileSystemEntry.name

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/name.html`

### :rag:rag-base/commonMain

```kotlin
abstract val name: String
```

Represents the name as a string value. This variable is typically used to hold textual data corresponding to a name.

## ai.koog.rag.base.files.model.FileSystemEntry.path

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/path.html`

### :rag:rag-base/commonMain

```kotlin
abstract val path: String
```

Represents a filesystem or resource path.

This variable is typically used to store the string representation of an absolute or relative path to a file, directory, or resource.

## ai.koog.rag.base.files.model.FileSystemEntry.visit

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/-file-system-entry/visit.html`

### :rag:rag-base/commonMain

```kotlin
abstract suspend fun visit(depth: Int, visitor: suspend (FileSystemEntry) -> Unit)
```

Visits this entry and its descendants in depth-first order.

- depth — maximum depth to traverse; 0 visits only this entry
- visitor — function called for each visited entry
## ai.koog.rag.base.files.model.buildFileEntry

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/build-file-entry.html`

### :rag:rag-base/commonMain

```kotlin
suspend fun <Path> buildFileEntry(fs: FileSystemProvider.ReadOnly<Path>, path: Path, metadata: FileMetadata): FileSystemEntry.File
```

Creates a File from the path and metadata without loading file content.

a File with metadata and no content (Content.None)

- fs — the filesystem provider used to access file attributes
- path — the file path to describe
- metadata — metadata for the file at path
- Path — the filesystem path type

Referenced packages: `ai.koog.rag.base.files`.

## ai.koog.rag.base.files.model.buildFileSize

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/build-file-size.html`

### :rag:rag-base/commonMain

```kotlin
suspend fun <Path> buildFileSize(fs: FileSystemProvider.ReadOnly<Path>, path: Path, contentType: FileMetadata.FileContentType? = null): List<FileSize>
```

Creates FileSize representations for the given file.

Always returns a FileSize.Bytes instance. For text files ≤ 1 MiB, also returns a FileSize.Lines instance. For files > 1 MiB or non-text files, only FileSize.Bytes is returned to avoid loading large or unsupported content.

a list containing FileSize.Bytes and, for small text files, FileSize.Lines

- fs — the filesystem provider used to access the file
- path — the file path to measure
- contentType — optional file content type
- Path — the filesystem path type

Referenced packages: `ai.koog.rag.base.files`.

## ai.koog.rag.base.files.model.buildFileSystemEntry

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/build-file-system-entry.html`

### :rag:rag-base/commonMain

```kotlin
suspend fun <Path> buildFileSystemEntry(fs: FileSystemProvider.ReadOnly<Path>, path: Path, metadata: FileMetadata): FileSystemEntry
```

Creates a FileSystemEntry (File or Folder) based on the metadata type.

Decides whether to build a File or Folder according to FileMetadata.type. Does not load file content; files will have Content.None.

a FileSystemEntry corresponding to the provided metadata

- fs — the filesystem provider used to access attributes
- path — the path to the file or directory
- metadata — metadata describing the entry at path
- Path — the filesystem path type

Referenced packages: `ai.koog.rag.base.files`.

## ai.koog.rag.base.files.model.buildFolderEntry

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.files.model/build-folder-entry.html`

### :rag:rag-base/commonMain

```kotlin
fun <Path> buildFolderEntry(fs: FileSystemProvider.ReadOnly<Path>, path: Path, metadata: FileMetadata, entries: List<FileSystemEntry>?): FileSystemEntry.Folder
```

Creates a Folder from the path, metadata, and optional entries.

a Folder with metadata and optional children

- fs — the filesystem provider used to access directory attributes
- path — the directory path to describe
- metadata — metadata for the directory at path
- entries — child entries (files and folders), or null if not loaded
- Path — the filesystem path type

Referenced packages: `ai.koog.rag.base.files`.

## ai.koog.rag.base.storage.FilteringDeletionStorage.delete

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage/-filtering-deletion-storage/delete.html`

### :rag:rag-base/commonMain

```kotlin
abstract suspend fun delete(filterExpression: String, namespace: String? = null): List<String>
```

Deletes documents by filter expression from the storage.

The list of identifiers that were successfully deleted.

- filterExpression — The filter expression to use for deletion.
- namespace — An optional namespace to scope the deletion. If null, the default namespace is used.
## ai.koog.rag.base.storage.FilteringDeletionStorage

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage/-filtering-deletion-storage/index.html`

### :rag:rag-base/commonMain

```kotlin
interface FilteringDeletionStorage : DeletionStorage
```

Storage interface that provides the ability to delete documents by filter expression.

## ai.koog.rag.base.storage.capability.CapabilityAwareStorage.capabilities

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.capability/-capability-aware-storage/capabilities.html`

### :rag:rag-base/commonMain

```kotlin
abstract val capabilities: Set<StorageCapability>
```

The set of capabilities supported by this storage implementation.

## ai.koog.rag.base.storage.capability.CapabilityAwareStorage

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.capability/-capability-aware-storage/index.html`

### :rag:rag-base/commonMain

```kotlin
interface CapabilityAwareStorage
```

Mixin interface for storage implementations that can report their supported capabilities.

Storage backends implement this interface to advertise which search and filtering features they support (e.g., similarity search, keyword search, hybrid search, metadata filtering). Consumers can query capabilities at runtime to adapt their search strategy accordingly.

- StorageCapability — for the list of available capabilities
## ai.koog.rag.base.storage.capability.CapabilityAwareStorage.supports

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.capability/-capability-aware-storage/supports.html`

### :rag:rag-base/commonMain

```kotlin
open fun supports(capability: StorageCapability): Boolean
```

Checks whether this storage supports the given capability.

true if the capability is supported, false otherwise

- capability — the capability to check
## ai.koog.rag.base.storage.capability.StorageCapability.FILTER_EXPRESSION

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.capability/-storage-capability/-f-i-l-t-e-r_-e-x-p-r-e-s-s-i-o-n/index.html`

### :rag:rag-base/commonMain

```kotlin
FILTER_EXPRESSION
```

## ai.koog.rag.base.storage.capability.StorageCapability.HYBRID_SEARCH

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.capability/-storage-capability/-h-y-b-r-i-d_-s-e-a-r-c-h/index.html`

### :rag:rag-base/commonMain

```kotlin
HYBRID_SEARCH
```

## ai.koog.rag.base.storage.capability.StorageCapability.KEYWORD_SEARCH

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.capability/-storage-capability/-k-e-y-w-o-r-d_-s-e-a-r-c-h/index.html`

### :rag:rag-base/commonMain

```kotlin
KEYWORD_SEARCH
```

## ai.koog.rag.base.storage.capability.StorageCapability.NAMESPACE_ISOLATION

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.capability/-storage-capability/-n-a-m-e-s-p-a-c-e_-i-s-o-l-a-t-i-o-n/index.html`

### :rag:rag-base/commonMain

```kotlin
NAMESPACE_ISOLATION
```

## ai.koog.rag.base.storage.capability.StorageCapability.SIMILARITY_SEARCH

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.capability/-storage-capability/-s-i-m-i-l-a-r-i-t-y_-s-e-a-r-c-h/index.html`

### :rag:rag-base/commonMain

```kotlin
SIMILARITY_SEARCH
```

## ai.koog.rag.base.storage.capability.StorageCapability.VECTOR_QUERY

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.capability/-storage-capability/-v-e-c-t-o-r_-q-u-e-r-y/index.html`

### :rag:rag-base/commonMain

```kotlin
VECTOR_QUERY
```

## ai.koog.rag.base.storage.capability.StorageCapability.entries

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.capability/-storage-capability/entries.html`

### :rag:rag-base/commonMain

```kotlin
val entries: EnumEntries<StorageCapability>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.rag.base.storage.capability.StorageCapability

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.capability/-storage-capability/index.html`

### :rag:rag-base/commonMain

```kotlin
enum StorageCapability : Enum<StorageCapability>
```

Capabilities that a storage implementation may support.

## ai.koog.rag.base.storage.capability.StorageCapability.valueOf

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.capability/-storage-capability/value-of.html`

### :rag:rag-base/commonMain

```kotlin
fun valueOf(value: String): StorageCapability
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.rag.base.storage.capability.StorageCapability.values

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.capability/-storage-capability/values.html`

### :rag:rag-base/commonMain

```kotlin
fun values(): Array<StorageCapability>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.rag.base.storage.search.HasFilterExpression.filterExpression

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-has-filter-expression/filter-expression.html`

### :rag:rag-base/commonMain

```kotlin
abstract val filterExpression: String?
```

optional filter expression to narrow down search results based on metadata

## ai.koog.rag.base.storage.search.HasFilterExpression

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-has-filter-expression/index.html`

### :rag:rag-base/commonMain

```kotlin
interface HasFilterExpression
```

Mixin interface indicating that a search request supports metadata filtering.

- SimilaritySearchRequest
- KeywordSearchRequest
- HybridSearchRequest
## ai.koog.rag.base.storage.search.HasScoreThreshold

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-has-score-threshold/index.html`

### :rag:rag-base/commonMain

```kotlin
interface HasScoreThreshold
```

Mixin interface indicating that a search request supports a minimum score threshold.

- SimilaritySearchRequest
- KeywordSearchRequest
- HybridSearchRequest
## ai.koog.rag.base.storage.search.HasScoreThreshold.minScore

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-has-score-threshold/min-score.html`

### :rag:rag-base/commonMain

```kotlin
abstract val minScore: Double?
```

optional minimum relevance score; results below this threshold are excluded

## ai.koog.rag.base.storage.search.HasTextQuery

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-has-text-query/index.html`

### :rag:rag-base/commonMain

```kotlin
interface HasTextQuery
```

Mixin interface indicating that a search request contains a text query.

- SimilaritySearchRequest
- KeywordSearchRequest
- HybridSearchRequest
## ai.koog.rag.base.storage.search.HasTextQuery.queryText

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-has-text-query/query-text.html`

### :rag:rag-base/commonMain

```kotlin
abstract val queryText: String
```

the text query string to search for

## ai.koog.rag.base.storage.search.ScoreMetric.BM25

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-score-metric/-b-m25/index.html`

### :rag:rag-base/commonMain

```kotlin
BM25
```

BM25 (Best Matching 25) text relevance score, commonly used in full-text search. The value is non-negative and unbounded. Higher values indicate greater relevance.

## ai.koog.rag.base.storage.search.ScoreMetric.COSINE_DISTANCE

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-score-metric/-c-o-s-i-n-e_-d-i-s-t-a-n-c-e/index.html`

### :rag:rag-base/commonMain

```kotlin
COSINE_DISTANCE
```

Cosine distance between two vectors, defined as 1 - cosine_similarity, ranging from 0 to 2. A value of 0 indicates identical vectors, while 2 indicates opposite vectors. Lower values mean greater similarity.

## ai.koog.rag.base.storage.search.ScoreMetric.COSINE_SIMILARITY

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-score-metric/-c-o-s-i-n-e_-s-i-m-i-l-a-r-i-t-y/index.html`

### :rag:rag-base/commonMain

```kotlin
COSINE_SIMILARITY
```

Cosine similarity between two vectors, ranging from -1 to 1. A value of 1 indicates identical direction, 0 indicates orthogonality, and -1 indicates opposite direction. Higher values mean greater similarity.

## ai.koog.rag.base.storage.search.ScoreMetric.CUSTOM

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-score-metric/-c-u-s-t-o-m/index.html`

### :rag:rag-base/commonMain

```kotlin
CUSTOM
```

A custom scoring metric defined by the storage implementation. The range and interpretation are implementation-specific.

## ai.koog.rag.base.storage.search.ScoreMetric.DOT_PRODUCT

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-score-metric/-d-o-t_-p-r-o-d-u-c-t/index.html`

### :rag:rag-base/commonMain

```kotlin
DOT_PRODUCT
```

Dot product (inner product) of two vectors. The value is unbounded and depends on vector magnitudes. Higher values indicate greater similarity when vectors are normalized.

## ai.koog.rag.base.storage.search.ScoreMetric.EUCLIDEAN_DISTANCE

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-score-metric/-e-u-c-l-i-d-e-a-n_-d-i-s-t-a-n-c-e/index.html`

### :rag:rag-base/commonMain

```kotlin
EUCLIDEAN_DISTANCE
```

Euclidean (L2) distance between two vectors, ranging from 0 to infinity. A value of 0 indicates identical vectors. Lower values mean greater similarity.

## ai.koog.rag.base.storage.search.ScoreMetric.HYBRID

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-score-metric/-h-y-b-r-i-d/index.html`

### :rag:rag-base/commonMain

```kotlin
HYBRID
```

A hybrid score combining multiple retrieval strategies (e.g., vector similarity and keyword search). The range and interpretation depend on the specific combination and normalization used by the storage implementation.

## ai.koog.rag.base.storage.search.ScoreMetric.entries

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-score-metric/entries.html`

### :rag:rag-base/commonMain

```kotlin
val entries: EnumEntries<ScoreMetric>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.rag.base.storage.search.ScoreMetric

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-score-metric/index.html`

### :rag:rag-base/commonMain

```kotlin
enum ScoreMetric : Enum<ScoreMetric>
```

Score metric semantics exposed by storage.

Defines how similarity or relevance scores are computed and interpreted when querying a vector or document store.

## ai.koog.rag.base.storage.search.ScoreMetric.valueOf

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-score-metric/value-of.html`

### :rag:rag-base/commonMain

```kotlin
fun valueOf(value: String): ScoreMetric
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.rag.base.storage.search.ScoreMetric.values

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-score-metric/values.html`

### :rag:rag-base/commonMain

```kotlin
fun values(): Array<ScoreMetric>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.
