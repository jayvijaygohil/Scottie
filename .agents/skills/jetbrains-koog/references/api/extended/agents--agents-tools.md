# agents / agents-tools

Additional Kotlin contracts from the supplied Dokka build. Read [API coverage](../../api-index.md) before use.

## ai.koog.agents.core.tools.ToolCallMetadata.equals

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-call-metadata/equals.html`

### :agents:agents-tools/commonMain

```kotlin
open operator override fun equals(other: Any?): Boolean
```

## ai.koog.agents.core.tools.ToolCallMetadata.hashCode

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-call-metadata/hash-code.html`

### :agents:agents-tools/commonMain

```kotlin
open override fun hashCode(): Int
```

## ai.koog.agents.core.tools.ToolCallMetadata.toString

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-call-metadata/to-string.html`

### :agents:agents-tools/commonMain

```kotlin
open override fun toString(): String
```

## ai.koog.agents.core.tools.ToolDescriptor.copy

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-descriptor/copy.html`

### :agents:agents-tools/commonMain

```kotlin
fun copy(name: String = this.name, description: String = this.description, requiredParameters: List<ToolParameterDescriptor> = this.requiredParameters.toList(), optionalParameters: List<ToolParameterDescriptor> = this.optionalParameters.toList(), cacheControl: CacheControl? = this.cacheControl): ToolDescriptor
```

Creates a copy of the current ToolDescriptor with the option to modify specific attributes.

A new instance of ToolDescriptor with the updated attributes.

- name — The name of the tool. Defaults to the current tool's name if not provided.
- description — The description of the tool. Defaults to the current tool's description if not provided.
- requiredParameters — A list of ToolParameterDescriptor representing the required parameters for the tool. Defaults to the current required parameters if not provided.
- optionalParameters — A list of ToolParameterDescriptor representing the optional parameters for the tool. Defaults to the current optional parameters if not provided.
- cacheControl — Optional cache control to apply after this tool definition.

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.tools.ToolDescriptor.equals

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-descriptor/equals.html`

### :agents:agents-tools/commonMain

```kotlin
open operator override fun equals(other: Any?): Boolean
```

## ai.koog.agents.core.tools.ToolDescriptor.hashCode

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-descriptor/hash-code.html`

### :agents:agents-tools/commonMain

```kotlin
open override fun hashCode(): Int
```

## ai.koog.agents.core.tools.ToolDescriptor.toString

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-descriptor/to-string.html`

### :agents:agents-tools/commonMain

```kotlin
open override fun toString(): String
```

## ai.koog.agents.core.tools.ToolParameterDescriptor.toString

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-descriptor/to-string.html`

### :agents:agents-tools/commonMain

```kotlin
open override fun toString(): String
```

## ai.koog.agents.core.tools.ToolParameterType.AnyOf.equals

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-any-of/equals.html`

### :agents:agents-tools/commonMain

```kotlin
open operator override fun equals(other: Any?): Boolean
```

## ai.koog.agents.core.tools.ToolParameterType.AnyOf.hashCode

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-any-of/hash-code.html`

### :agents:agents-tools/commonMain

```kotlin
open override fun hashCode(): Int
```

## ai.koog.agents.core.tools.ToolParameterType.AnyOf.toString

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-any-of/to-string.html`

### :agents:agents-tools/commonMain

```kotlin
open override fun toString(): String
```

## ai.koog.agents.core.tools.ToolParameterType.Enum.equals

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-enum/equals.html`

### :agents:agents-tools/commonMain

```kotlin
open operator override fun equals(other: Any?): Boolean
```

## ai.koog.agents.core.tools.ToolParameterType.Enum.toString

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-enum/to-string.html`

### :agents:agents-tools/commonMain

```kotlin
open override fun toString(): String
```

## ai.koog.agents.core.tools.ToolParameterType.List.toString

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-list/to-string.html`

### :agents:agents-tools/commonMain

```kotlin
open override fun toString(): String
```

## ai.koog.agents.core.tools.ToolParameterType.Object.toString

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-object/to-string.html`

### :agents:agents-tools/commonMain

```kotlin
open override fun toString(): String
```

## ai.koog.agents.core.tools.annotations.InternalAgentToolsApi

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.annotations/-internal-agent-tools-api/index.html`

### :agents:agents-tools/commonMain

```kotlin
annotation class InternalAgentToolsApi
```

Marks elements of the agent tools API that are internal and primarily intended for use within the implementation of tools and agents. APIs marked with this annotation are not considered stable and may change or be removed without warning in any release.

Opting into these APIs indicates an understanding that they may undergo breaking changes, and should be used with caution in any external implementations or client code.

## ai.koog.agents.core.tools.reflect.ToolFromCallable.Args.Args

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.reflect/-tool-from-callable/-args/-args.html`

### :agents:agents-tools/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
constructor(parameters: Map<ERROR CLASS: Symbol not found for KParameter, Any?>)
```

## ai.koog.agents.core.tools.reflect.ToolFromCallable.Args

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.reflect/-tool-from-callable/-args/index.html`

### :agents:agents-tools/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
class Args(val parameters: Map<ERROR CLASS: Symbol not found for KParameter, Any?>)
```

Arguments for ToolFromCallable.

## ai.koog.agents.core.tools.reflect.ToolFromCallable.Args.parameters

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.reflect/-tool-from-callable/-args/parameters.html`

### :agents:agents-tools/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
val parameters: Map<ERROR CLASS: Symbol not found for KParameter, Any?>
```

## ai.koog.agents.core.tools.reflect.ToolFromCallable.ToolFromCallable

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.reflect/-tool-from-callable/-tool-from-callable.html`

### :agents:agents-tools/jvmCommonMain

```kotlin
constructor(callable: KCallable<TResult>, thisRef: Any? = null, name: String? = null, description: String? = null)
```

- callable — The Kotlin callable (KFunction or KProperty) to be wrapped and executed by this tool.
- thisRef — An optional instance reference required if the callable is non-static.
- name — The name of the tool. If not provided, the name of the callable will be used.
- description — The description of the tool. If not provided, the description from the ai.koog.agents.core.tools.annotations.LLMDescription annotation on the callable will be used.
## ai.koog.agents.core.tools.reflect.ToolFromCallable.callable

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.reflect/-tool-from-callable/callable.html`

### :agents:agents-tools/jvmCommonMain

```kotlin
val callable: KCallable<TResult>
```

- callable — The Kotlin callable (KFunction or KProperty) to be wrapped and executed by this tool.
## ai.koog.agents.core.tools.reflect.ToolFromCallable.decodeArgs

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.reflect/-tool-from-callable/decode-args.html`

### :agents:agents-tools/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
open override fun decodeArgs(rawArgs: ERROR CLASS: Symbol not found for JSONObject, serializer: ERROR CLASS: Symbol not found for JSONSerializer): ToolFromCallable.Args
```

## ai.koog.agents.core.tools.reflect.ToolFromCallable.decodeResult

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.reflect/-tool-from-callable/decode-result.html`

### :agents:agents-tools/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
open override fun decodeResult(rawResult: ERROR CLASS: Symbol not found for JSONElement, serializer: ERROR CLASS: Symbol not found for JSONSerializer): TResult
```

## ai.koog.agents.core.tools.reflect.ToolFromCallable.encodeArgs

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.reflect/-tool-from-callable/encode-args.html`

### :agents:agents-tools/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
open override fun encodeArgs(args: ToolFromCallable.Args, serializer: ERROR CLASS: Symbol not found for JSONSerializer): ERROR CLASS: Symbol not found for JSONObject
```

## ai.koog.agents.core.tools.reflect.ToolFromCallable.encodeResult

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.reflect/-tool-from-callable/encode-result.html`

### :agents:agents-tools/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
open override fun encodeResult(result: TResult, serializer: ERROR CLASS: Symbol not found for JSONSerializer): ERROR CLASS: Symbol not found for JSONElement
```

## ai.koog.agents.core.tools.reflect.ToolFromCallable.execute

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.reflect/-tool-from-callable/execute.html`

### :agents:agents-tools/jvmCommonMain

```kotlin
open suspend override fun execute(args: ToolFromCallable.Args): TResult
```

Executes the tool's logic with the provided arguments.

In the actual agent implementation, it is not recommended to call tools directly as this might cause issues, such as:

Bugs with feature pipelines

Inability to test/mock

Consider using methods like findTool(tool: Class) or similar, to retrieve a SafeTool, and then call execute on it. This ensures that the tool call is delegated properly to the underlying environment object.

The result of the tool's execution.

- args — The input arguments required to execute the tool.
## ai.koog.agents.core.tools.reflect.ToolFromCallable

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.reflect/-tool-from-callable/index.html`

### :agents:agents-tools/jvmCommonMain

```kotlin
class ToolFromCallable<TResult>(val callable: KCallable<TResult>, val thisRef: Any? = null, name: String? = null, description: String? = null) : Tool<ToolFromCallable.Args, TResult>
```

A tool implementation that wraps a Kotlin callable (function, method, etc.).

- callable — The Kotlin callable (KFunction or KProperty) to be wrapped and executed by this tool.
- thisRef — An optional instance reference required if the callable is non-static.
- name — The name of the tool. If not provided, the name of the callable will be used.
- description — The description of the tool. If not provided, the description from the ai.koog.agents.core.tools.annotations.LLMDescription annotation on the callable will be used.

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.tools.reflect.ToolFromCallable.thisRef

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.reflect/-tool-from-callable/this-ref.html`

### :agents:agents-tools/jvmCommonMain

```kotlin
val thisRef: Any?
```

- thisRef — An optional instance reference required if the callable is non-static.