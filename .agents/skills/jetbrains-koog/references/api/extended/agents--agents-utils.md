# agents / agents-utils

Additional Kotlin contracts from the supplied Dokka build. Read [API coverage](../../api-index.md) before use.

## ai.koog.agents.annotations.KtLintIgnoreNaming

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.annotations/-kt-lint-ignore-naming/index.html`

### :agents:agents-utils/commonMain

```kotlin
@Target(allowedTargets = [AnnotationTarget.CLASS, AnnotationTarget.FUNCTION]) annotation class KtLintIgnoreNaming
```

Indicates that the annotated class or function should be excluded from KtLint naming rule checks.

## ai.koog.agents.exception.rootCause

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.exception/root-cause.html`

### :agents:agents-utils/commonMain

```kotlin
val CancellationException.rootCause: Throwable?
```

Extension property that retrieves the root cause of a CancellationException.

This is used in cases when non-suspended code launches a coroutine that raises exceptions. The method helps to get the root exception causing the outer coroutine cancellation.

## ai.koog.agents.lock.KeyedMutex.KeyedMutex

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.lock/-keyed-mutex/-keyed-mutex.html`

### :agents:agents-utils/commonMain

```kotlin
constructor()
```

## ai.koog.agents.lock.KeyedMutex.holdsLock

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.lock/-keyed-mutex/holds-lock.html`

### :agents:agents-utils/commonMain

```kotlin
suspend fun holdsLock(key: K, owner: Any): Boolean
```

Checks whether this key is locked by the specified owner.

## ai.koog.agents.lock.KeyedMutex

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.lock/-keyed-mutex/index.html`

### :agents:agents-utils/commonMain

```kotlin
class KeyedMutex<K>
```

A keyed, suspend-friendly mutex for Kotlin Multiplatform.

Guarantees mutual exclusion per key, without blocking threads. API mirrors the kotlinx.coroutines Mutex:

lock(key, owner)

tryLock(key, owner)

unlock(key, owner)

withLock(key, owner) { ... }

Internals:

A per-key entry holds a Mutex and a reference count (holders/waiters).

We increment refs before suspending for lock(key) so entries aren’t removed while waiting.

Cleanup removes the entry only when refs == 0 and the mutex is not locked.

## ai.koog.agents.lock.KeyedMutex.isLocked

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.lock/-keyed-mutex/is-locked.html`

### :agents:agents-utils/commonMain

```kotlin
suspend fun isLocked(key: K): Boolean
```

Optional: observe whether a key appears locked. For diagnostics/metrics only (not a synchronization primitive).

## ai.koog.agents.lock.KeyedMutex.lock

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.lock/-keyed-mutex/lock.html`

### :agents:agents-utils/commonMain

```kotlin
suspend fun lock(key: K, owner: Any? = null)
```

Suspends until the lock for key is acquired. Not re-entrant for the same key within the same coroutine.

## ai.koog.agents.lock.KeyedMutex.tryLock

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.lock/-keyed-mutex/try-lock.html`

### :agents:agents-utils/commonMain

```kotlin
suspend fun tryLock(key: K, owner: Any? = null): Boolean
```

Attempts to acquire the lock for key without suspension. Returns true if a lock was acquired.

## ai.koog.agents.lock.KeyedMutex.unlock

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.lock/-keyed-mutex/unlock.html`

### :agents:agents-utils/commonMain

```kotlin
suspend fun unlock(key: K, owner: Any? = null)
```

Releases the lock for key. Must be called exactly once per successful lock/tryLock.

- IllegalStateException — on misuse (mirrors Mutex behavior).
## ai.koog.agents.lock.RWLock.RWLock

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.lock/-r-w-lock/-r-w-lock.html`

### :agents:agents-utils/commonMain

```kotlin
constructor()
```

## ai.koog.agents.lock.RWLock

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.lock/-r-w-lock/index.html`

### :agents:agents-utils/commonMain

```kotlin
class RWLock
```

A Kotlin Multiplatform read-write lock that allows concurrent read access while guaranteeing exclusive write access.

The implementation uses two Mutex instances:

writeMutex is held while a writer runs, or while there is at least one active reader. The first reader acquires it, and the last reader releases it.

readersCountMutex protects readersCount so that reader acquisition/release is atomic.

Concurrency warnings:

Not reentrant. The underlying Mutex has no notion of an owning coroutine, and this lock does not track owners either. Calling withWriteLock from inside another withWriteLock, or calling withWriteLock from inside withReadLock on the same instance, will deadlock. Nested withReadLock calls from the same coroutine do not deadlock but still serialize briefly on readersCountMutex at entry and exit.

Fairness / writer starvation. A writer suspended on writeMutex does not block new readers from joining an already active read section — new readers only contend for writeMutex on the first-reader transition. Steady overlapping reader traffic can therefore delay a pending writer.

Cancellation safety. The reader path uses try { ... } finally { ... }, so cancellation or exceptions inside the block still decrement readersCount and release writeMutex. Cancellation while suspended on either mutex is propagated and the lock is not acquired.

Suspension inside critical sections. The block may suspend; keep critical sections short and avoid launching child coroutines that re-acquire the same lock.

Suspend-only. There is no blocking or tryLock API; this lock is usable only from coroutine code.

## ai.koog.agents.lock.RWLock.withReadLock

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.lock/-r-w-lock/with-read-lock.html`

### :agents:agents-utils/commonMain

```kotlin
suspend fun <T> withReadLock(block: suspend () -> T): T
```

Run the given block of code while holding the read lock. Multiple coroutines may run their read blocks concurrently. See the class-level KDoc for reentrancy and cancellation warnings.

## ai.koog.agents.lock.RWLock.withWriteLock

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.lock/-r-w-lock/with-write-lock.html`

### :agents:agents-utils/commonMain

```kotlin
suspend fun <T> withWriteLock(block: suspend () -> T): T
```

Run the given block of code while holding the write lock. Only one coroutine at a time may run under the write lock, and no readers are active while it runs. Must not be called from a coroutine that already holds the read or write lock on this instance — see the class-level KDoc for reentrancy warnings.

## ai.koog.agents.lock.withLockCheck

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.lock/with-lock-check.html`

### :agents:agents-utils/commonMain

```kotlin
suspend fun Mutex.withLockCheck(check: () -> Boolean, message: () -> String, action: suspend () -> Unit)
```

Executes the given action within a lock provided by the Mutex. Before acquiring the lock, it checks a condition specified by check. If the condition is satisfied, the lock is not acquired, and the operation returns early after logging a message provided by message. If the condition is not satisfied, the lock is acquired, the condition is rechecked, and if still not satisfied, the action is executed.

## ai.koog.agents.lock.withLock

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.lock/with-lock.html`

### :agents:agents-utils/commonMain

```kotlin
inline suspend fun <K, T> KeyedMutex<K>.withLock(key: K, owner: Any? = null, action: suspend () -> T): T
```

Convenience function mirroring Mutex.withLock

## ai.koog.agents.utils.HiddenString.Companion.HIDDEN_STRING_PLACEHOLDER

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.utils/-hidden-string/-companion/-h-i-d-d-e-n_-s-t-r-i-n-g_-p-l-a-c-e-h-o-l-d-e-r.html`

### :agents:agents-utils/commonMain

```kotlin
const val HIDDEN_STRING_PLACEHOLDER: String
```

A constant string used as a placeholder to represent hidden or sensitive string values.

Typically used in scenarios where the actual value of a string needs to be obscured, such as in logs or debug outputs, to protect sensitive or confidential information.

The placeholder value "HIDDEN:non-empty" indicates that the actual string is not empty, but its content is intentionally hidden.

## ai.koog.agents.utils.HiddenString.Companion

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.utils/-hidden-string/-companion/index.html`

### :agents:agents-utils/commonMain

```kotlin
object Companion
```

A companion object for holding constant values and shared logic associated with the enclosing class.

Objects and properties defined in this companion can be accessed without an instance of the enclosing class.

## ai.koog.agents.utils.HiddenString.HiddenString

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.utils/-hidden-string/-hidden-string.html`

### :agents:agents-utils/commonMain

```kotlin
constructor(value: String, placeholder: String = HIDDEN_STRING_PLACEHOLDER)
```

- value — The original string value to be hidden.
- placeholder — The placeholder text to display when the instance is converted to a string. Defaults to "HIDDEN:non-empty".
## ai.koog.agents.utils.HiddenString

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.utils/-hidden-string/index.html`

### :agents:agents-utils/commonMain

```kotlin
data class HiddenString(val value: String, placeholder: String = HIDDEN_STRING_PLACEHOLDER)
```

Represents a string whose actual value is hidden when converted to a string representation.

This class is useful for scenarios where sensitive or confidential information needs to be obscured in logs or other outputs. The value is only accessible programmatically and will not be displayed in plain text when the toString method is called. The original value is accessible through a public value field.

- value — The original string value to be hidden.
- placeholder — The placeholder text to display when the instance is converted to a string. Defaults to "HIDDEN:non-empty".
## ai.koog.agents.utils.HiddenString.toString

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.utils/-hidden-string/to-string.html`

### :agents:agents-utils/commonMain

```kotlin
open override fun toString(): String
```

## ai.koog.agents.utils.HiddenString.value

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.utils/-hidden-string/value.html`

### :agents:agents-utils/commonMain

```kotlin
val value: String
```

- value — The original string value to be hidden.
## ai.koog.agents.utils.ModelInfo.Companion.UNDEFINED

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.utils/-model-info/-companion/-u-n-d-e-f-i-n-e-d.html`

### :agents:agents-utils/commonMain

```kotlin
val UNDEFINED: ModelInfo
```

Represents an undefined or invalid ModelInfo instance Used when model information cannot be determined or parsed

## ai.koog.agents.utils.ModelInfo.Companion.fromString

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.utils/-model-info/-companion/from-string.html`

### :agents:agents-utils/commonMain

```kotlin
fun fromString(modelString: String): ModelInfo
```

Creates a ModelInfo instance from a string in the format "provider:model" This provides backwards compatibility with existing string-based model representations

A ModelInfo instance parsed from the string, or UNDEFINED if parsing fails

- modelString — The model string in "provider:model" format
## ai.koog.agents.utils.ModelInfo.Companion

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.utils/-model-info/-companion/index.html`

### :agents:agents-utils/commonMain

```kotlin
object Companion
```

Companion object for the ModelInfo class that provides utility methods and constants related to model information parsing and representation.

## ai.koog.agents.utils.ModelInfo.ModelInfo

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.utils/-model-info/-model-info.html`

### :agents:agents-utils/commonMain

```kotlin
constructor(provider: String, model: String, displayName: String? = null, contextLength: Long? = null, maxOutputTokens: Long? = null)
```

## ai.koog.agents.utils.ModelInfo.contextLength

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.utils/-model-info/context-length.html`

### :agents:agents-utils/commonMain

```kotlin
val contextLength: Long?
```

## ai.koog.agents.utils.ModelInfo.displayName

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.utils/-model-info/display-name.html`

### :agents:agents-utils/commonMain

```kotlin
val displayName: String?
```

## ai.koog.agents.utils.ModelInfo

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.utils/-model-info/index.html`

### :agents:agents-utils/commonMain

```kotlin
@Serializable data class ModelInfo(val provider: String, val model: String, val displayName: String? = null, val contextLength: Long? = null, val maxOutputTokens: Long? = null)
```

Represents model information for agent events with a focus on essential data.

This data class provides the core model identification needed for agent events, including key model characteristics that are useful for debugging and monitoring. It serves as a lightweight representation optimized for serialization and backwards compatibility.

## ai.koog.agents.utils.ModelInfo.maxOutputTokens

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.utils/-model-info/max-output-tokens.html`

### :agents:agents-utils/commonMain

```kotlin
val maxOutputTokens: Long?
```

## ai.koog.agents.utils.ModelInfo.modelIdentifierName

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.utils/-model-info/model-identifier-name.html`

### :agents:agents-utils/commonMain

```kotlin
val modelIdentifierName: String
```

Model identifier name for display purposes Falls back to "provider/model" if displayName is not provided

## ai.koog.agents.utils.ModelInfo.model

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.utils/-model-info/model.html`

### :agents:agents-utils/commonMain

```kotlin
val model: String
```

## ai.koog.agents.utils.ModelInfo.provider

Module: `agents-utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-utils/ai.koog.agents.utils/-model-info/provider.html`

### :agents:agents-utils/commonMain

```kotlin
val provider: String
```
