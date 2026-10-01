# utils

Additional Kotlin contracts from the supplied Dokka build. Read [API coverage](../../api-index.md) before use.

## ai.koog.utils.annotations.InternalKoogUtils

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.annotations/-internal-koog-utils/index.html`

### :utils/commonMain

```kotlin
annotation class InternalKoogUtils
```

Annotation to mark APIs that are internal to the koog utils and is not intended for public use.

## ai.koog.utils.concurrency.runBlockingReentrant

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.concurrency/run-blocking-reentrant.html`

### :utils/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun <T> runBlockingReentrant(context: ERROR CLASS: Symbol not found for CoroutineContext = EmptyCoroutineContext, block: suspend () -> T): T
```

Runs a suspending block from blocking code in a reentrant-safe way.

The caller thread is blocked until block completes. The block normally runs with context, but if the current execution is already associated with the same continuation interceptor (dispatcher), it strips the interceptor from the context to avoid redispatching. This avoids redispatch deadlocks when all threads in the target context are busy.

- context — The coroutine context in which the block should be executed. Defaults to EmptyCoroutineContext.
- block — The suspend block of code to be executed.
## ai.koog.utils.concurrency.withContextReentrant

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.concurrency/with-context-reentrant.html`

### :utils/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
suspend fun <T> withContextReentrant(context: ERROR CLASS: Symbol not found for CoroutineContext, block: suspend () -> T): T
```

Runs the given block within the specified context in a reentrant-safe way.

The block normally runs with context, but if the current execution is already associated with the same continuation interceptor (dispatcher), it strips the interceptor from the context to avoid redispatching. This avoids redispatch deadlocks when all threads in the target context are busy.

- context — The target coroutine context in which the block should execute.
- block — The suspend function to be executed within the specified context.
## ai.koog.utils.io.Closeable.close

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.io/-closeable/close.html`

### :utils/commonMain

```kotlin
abstract suspend fun close()
```

Closes the current resource and releases any underlying resources associated with it.

## ai.koog.utils.io.Closeable

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.io/-closeable/index.html`

### :utils/commonMain

```kotlin
interface Closeable
```

Represents a resource or entity that can be closed to release any associated resources.

## ai.koog.utils.io.SuitableForIO

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.io/-suitable-for-i-o.html`

### :utils/androidMain

```kotlin
actual val Dispatchers.SuitableForIO: CoroutineDispatcher
```

A platform-specific CoroutineDispatcher optimized for executing IO-intensive operations.

This dispatcher is suitable for tasks that involve blocking or non-blocking IO, such as reading or writing to files, database access, and network communications. It provides an environment optimized for managing IO-bound workloads, ensuring efficient thread utilization.

The actual implementation of this dispatcher may vary depending on the platform, but it is expected to provide a mechanism to handle IO operations without causing unnecessary contention or overloading the system.

### :utils/appleMain

```kotlin
actual val Dispatchers.SuitableForIO: CoroutineDispatcher
```

A kotlinx.coroutines.CoroutineDispatcher that is suitable for IO operations. It delegates to Dispatchers.Default, which is optimized for CPU-intensive tasks but can also be used for IO-bound or mixed workloads when a specific dispatcher for IO is not required or unavailable.

### :utils/commonMain

```kotlin
expect val Dispatchers.SuitableForIO: CoroutineDispatcher
```

A platform-specific CoroutineDispatcher optimized for executing IO-intensive operations.

This dispatcher is suitable for tasks that involve blocking or non-blocking IO, such as reading or writing to files, database access, and network communications. It provides an environment optimized for managing IO-bound workloads, ensuring efficient thread utilization.

The actual implementation of this dispatcher may vary depending on the platform, but it is expected to provide a mechanism to handle IO operations without causing unnecessary contention or overloading the system.

### :utils/jsMain

```kotlin
actual val Dispatchers.SuitableForIO: CoroutineDispatcher
```

Represents a CoroutineDispatcher that is suitable for IO-intensive operations. Delegates to the default dispatcher, which is optimized for tasks such as file I/O, network operations, or database queries that do not heavily utilize CPU resources. It is designed to handle a large number of tasks with minimal thread overhead.

### :utils/jvmMain

```kotlin
actual val Dispatchers.SuitableForIO: CoroutineDispatcher
```

A platform-specific property that represents a coroutine dispatcher suitable for IO-intensive tasks, such as file or network operations. It typically maps to Dispatchers.IO and provides an optimized thread pool for handling such workloads.

### :utils/wasmJsMain

```kotlin
actual val Dispatchers.SuitableForIO: CoroutineDispatcher
```

A kotlinx.coroutines.CoroutineDispatcher that is suitable for IO operations. It delegates to Dispatchers.Default, which is optimized for CPU-intensive tasks but can also be used for IO-bound or mixed workloads when a specific dispatcher for IO is not required or unavailable.

## ai.koog.utils.io.use

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.io/use.html`

### :utils/commonMain

```kotlin
inline suspend fun <Type : Closeable, Return> Type.use(action: suspend (Type) -> Return): Return
```

Executes the given action block on this Closeable resource and ensures that the resource is closed after the block execution, whether it completes normally or with an exception.

## ai.koog.utils.lang.masked

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.lang/masked.html`

### :utils/commonMain

```kotlin
fun String?.masked(maskChar: Char = '*'): String?
```

Returns string with masked symbols using the strictest security level.

This method is designed for masking sensitive secrets and provides maximum security by returning a consistent pattern that reveals no information about the original content.

Examples:

null ->null

"" ->null

" " ->null

"I" ->"***HIDDEN***"

"Hi" ->"***HIDDEN***"

"Hello" ->"***HIDDEN***"

"VeryLongSecretKey123" ->"***HIDDEN***"

## ai.koog.utils.serializers.ByteArrayAsBase64Serializer.ByteArrayAsBase64Serializer

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.serializers/-byte-array-as-base64-serializer/-byte-array-as-base64-serializer.html`

### :utils/commonMain

```kotlin
constructor()
```

## ai.koog.utils.serializers.ByteArrayAsBase64Serializer.descriptor

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.serializers/-byte-array-as-base64-serializer/descriptor.html`

### :utils/commonMain

```kotlin
open override val descriptor: SerialDescriptor
```

The serial descriptor associated with the ByteArrayAsBase64Serializer.

Represents a primitive value with the kind STRING. Used to describe the serialized form of a ByteArray value encoded as a Base64 string.

## ai.koog.utils.serializers.ByteArrayAsBase64Serializer.deserialize

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.serializers/-byte-array-as-base64-serializer/deserialize.html`

### :utils/commonMain

```kotlin
open override fun deserialize(decoder: Decoder): ByteArray
```

Deserializes a Base64-encoded string into a ByteArray.

Reads the Base64-encoded string from the given decoder, decodes it, and returns the resulting ByteArray.

The decoded ByteArray.

- decoder — The decoder used to read the Base64-encoded string.
## ai.koog.utils.serializers.ByteArrayAsBase64Serializer

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.serializers/-byte-array-as-base64-serializer/index.html`

### :utils/commonMain

```kotlin
class ByteArrayAsBase64Serializer : KSerializer<ByteArray>
```

A custom serializer for serializing and deserializing ByteArray objects as Base64-encoded strings.

Uses the Base64.Default encoding and decoding mechanisms from the kotlinx-serialization library to transform ByteArray values into readable Base64 string representation during serialization and to decode Base64 strings back into byte arrays during deserialization.

The underlying serialized form is described as a primitive value of kind STRING.

This serializer is particularly useful when working with data that needs to be encoded as Base64 in JSON or other text-based serialization formats.

## ai.koog.utils.serializers.ByteArrayAsBase64Serializer.serialize

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.serializers/-byte-array-as-base64-serializer/serialize.html`

### :utils/commonMain

```kotlin
open override fun serialize(encoder: Encoder, value: ByteArray)
```

Serializes a ByteArray into a Base64-encoded string.

- encoder — The encoder used for encoding the Base64 string.
- value — The ByteArray that needs to be serialized.
## ai.koog.utils.system.EnvSystemSecretsReader.getSecret

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.system/-env-system-secrets-reader/get-secret.html`

### :utils/jvmMain

```kotlin
open override fun getSecret(name: String): String?
```

Retrieves a secret value by its name from the specified environment variable.

the value of the environment variable as a String, or null if the variable is not found.

- name — the name of the environment variable to retrieve.
## ai.koog.utils.system.EnvSystemSecretsReader

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.system/-env-system-secrets-reader/index.html`

### :utils/jvmMain

```kotlin
object EnvSystemSecretsReader : SystemSecretsReader
```

Reads secrets from environment variables in a JVM environment.

EnvSystemSecretsReader retrieves secret values from environment variables only. It does not check system properties for security reasons, as system properties are JVM-wide and more easily accessible than environment variables.

Implements:

SystemSecretsReader: Provides the ability to retrieve secrets.

## ai.koog.utils.system.JvmSystemConfigReader.getConfigVariable

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.system/-jvm-system-config-reader/get-config-variable.html`

### :utils/jvmMain

```kotlin
open override fun getConfigVariable(name: String): String?
```

Retrieves the value of the specified environment variable or system property.

The method first attempts to retrieve the value from the environment variables. If it is not found, it then attempts to retrieve the value from the system properties. When checking system properties, the name is converted to lowercase and underscores are replaced with dots.

the value of the environment variable or system property, or null if not found

- name — the name of the environment variable or system property to retrieve
## ai.koog.utils.system.JvmSystemConfigReader

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.system/-jvm-system-config-reader/index.html`

### :utils/jvmMain

```kotlin
object JvmSystemConfigReader : SystemConfigReader
```

Reads system configuration properties in a JVM environment.

JvmSystemConfigReader is responsible for retrieving the values of system configuration properties using both environment variables and system properties.

The property name provided is automatically converted to a format compatible with system environment variable conventions by transforming the name to lowercase and replacing underscores with dots. It attempts to fetch the value from both the original name and the transformed format.

Implements:

SystemConfigReader: Provides the ability to retrieve configuration properties.

## ai.koog.utils.system.SystemConfigReader.getConfigVariable

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.system/-system-config-reader/get-config-variable.html`

### :utils/commonMain

```kotlin
abstract fun getConfigVariable(name: String): String?
```

Retrieves the value of a system configuration property by its name.

The value of the configuration property if it exists, or null if not found.

- name — The name of the system configuration property to retrieve.
## ai.koog.utils.system.SystemConfigReader

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.system/-system-config-reader/index.html`

### :utils/commonMain

```kotlin
interface SystemConfigReader
```

An interface for reading system configuration properties.

This interface provides a method to retrieve system configuration values by their names. Implementations can vary based on the operating system or platform being used.

- UserDefaultsSystemConfigReader
- JvmSystemConfigReader
## ai.koog.utils.system.SystemSecretsReader.getSecret

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.system/-system-secrets-reader/get-secret.html`

### :utils/commonMain

```kotlin
abstract fun getSecret(name: String): String?
```

Retrieves a secret value from environment variables.

SECURITY NOTICE: Secrets are returned as Strings because the underlying OS APIs (environment variables, system properties) return Strings. The String cannot be cleared from memory.

Best practices:

Use platform-specific secure storage when possible (Keychain, KeyStore)

Use short-lived tokens instead of long-lived secrets

Rotate secrets regularly

Don't log or print secret values

For maximum security, consider using:

Secrets management services (HashiCorp Vault, AWS Secrets Manager)

Platform secure storage APIs

Memory-mapped files with OS-level protection

The secret value, or null if not found

- name — The secret key
## ai.koog.utils.system.SystemSecretsReader

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.system/-system-secrets-reader/index.html`

### :utils/commonMain

```kotlin
interface SystemSecretsReader
```

An interface for reading secrets.

This interface provides a method to retrieve secret values by their names. Implementations can vary based on the operating system or platform being used.

- EnvSystemSecretsReader
## ai.koog.utils.system.UserDefaultsSystemConfigReader.Companion

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.system/-user-defaults-system-config-reader/-companion/index.html`

### :utils/appleMain

```kotlin
object Companion
```

## ai.koog.utils.system.UserDefaultsSystemConfigReader.Companion.shared

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.system/-user-defaults-system-config-reader/-companion/shared.html`

### :utils/appleMain

```kotlin
val shared: UserDefaultsSystemConfigReader
```

A shared instance of UserDefaultsSystemConfigReader.

This instance provides centralized access to system configuration properties stored in Apple's NSUserDefaults. It uses the standard NSUserDefaults instance for fetching configuration values.

The shared instance is intended for reuse across the application whenever access to system configuration properties is required.

## ai.koog.utils.system.UserDefaultsSystemConfigReader.UserDefaultsSystemConfigReader

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.system/-user-defaults-system-config-reader/-user-defaults-system-config-reader.html`

### :utils/appleMain

```kotlin
constructor(userDefaults: NSUserDefaults)
```

Initializes an instance of UserDefaultsSystemConfigReader with the provided NSUserDefaults.

- userDefaults — The NSUserDefaults instance used to fetch configuration values.
## ai.koog.utils.system.UserDefaultsSystemConfigReader.getConfigVariable

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.system/-user-defaults-system-config-reader/get-config-variable.html`

### :utils/appleMain

```kotlin
open override fun getConfigVariable(name: String): String?
```

Retrieves the value of a system configuration property by its name.

This method interacts with Apple's NSUserDefaults system to fetch a configuration value based on the provided key.

The value of the configuration property if it exists, or null if not found.

- name — The name of the configuration property to retrieve.
## ai.koog.utils.system.UserDefaultsSystemConfigReader

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.system/-user-defaults-system-config-reader/index.html`

### :utils/appleMain

```kotlin
class UserDefaultsSystemConfigReader(userDefaults: NSUserDefaults) : SystemConfigReader
```

A configuration reader implementation backed by Apple's NSUserDefaults.

This class provides a mechanism to retrieve system configuration properties stored in the NSUserDefaults system on Apple platforms.

- userDefaults — The NSUserDefaults instance used to fetch configuration values.

Referenced packages: `ai.koog.utils.system`.

## ai.koog.utils.system.systemConfigReader

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.system/system-config-reader.html`

### :utils/androidMain

```kotlin
actual fun systemConfigReader(): SystemConfigReader
```

Provides an implementation of the SystemConfigReader interface for the current platform.

This function returns an instance of SystemConfigReader that allows access to system-level configuration properties based on platform-specific implementations. On unsupported platforms, this function will throw a NotImplementedError.

An instance of SystemConfigReader for accessing system configuration properties.

- NotImplementedError — if SystemConfigReader is not supported on this platform.
### :utils/appleMain

```kotlin
actual fun systemConfigReader(): SystemConfigReader
```

Provides an implementation of the SystemConfigReader interface for the current platform.

This function returns an instance of SystemConfigReader that allows access to system-level configuration properties based on platform-specific implementations. On unsupported platforms, this function will throw a NotImplementedError.

An instance of SystemConfigReader for accessing system configuration properties.

- NotImplementedError — if SystemConfigReader is not supported on this platform.

Referenced packages: `ai.koog.utils.system`.

### :utils/commonMain

```kotlin
expect fun systemConfigReader(): SystemConfigReader
```

Provides an implementation of the SystemConfigReader interface for the current platform.

This function returns an instance of SystemConfigReader that allows access to system-level configuration properties based on platform-specific implementations. On unsupported platforms, this function will throw a NotImplementedError.

An instance of SystemConfigReader for accessing system configuration properties.

- NotImplementedError — if SystemConfigReader is not supported on this platform.
### :utils/jsMain

```kotlin
actual fun systemConfigReader(): SystemConfigReader
```

Provides an implementation of the SystemConfigReader interface for the current platform.

This function returns an instance of SystemConfigReader that allows access to system-level configuration properties based on platform-specific implementations. On unsupported platforms, this function will throw a NotImplementedError.

An instance of SystemConfigReader for accessing system configuration properties.

- NotImplementedError — if SystemConfigReader is not supported on this platform.

Referenced packages: `ai.koog.utils.system`.

### :utils/jvmMain

```kotlin
actual fun systemConfigReader(): SystemConfigReader
```

Provides an implementation of the SystemConfigReader interface for the current platform.

This function returns an instance of SystemConfigReader that allows access to system-level configuration properties based on platform-specific implementations. On unsupported platforms, this function will throw a NotImplementedError.

An instance of SystemConfigReader for accessing system configuration properties.

- NotImplementedError — if SystemConfigReader is not supported on this platform.
### :utils/wasmJsMain

```kotlin
actual fun systemConfigReader(): SystemConfigReader
```

Provides an implementation of the SystemConfigReader interface for the current platform.

This function returns an instance of SystemConfigReader that allows access to system-level configuration properties based on platform-specific implementations. On unsupported platforms, this function will throw a NotImplementedError.

An instance of SystemConfigReader for accessing system configuration properties.

- NotImplementedError — if SystemConfigReader is not supported on this platform.

Referenced packages: `ai.koog.utils.system`.

## ai.koog.utils.system.systemSecretsReader

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.system/system-secrets-reader.html`

### :utils/androidMain

```kotlin
actual fun systemSecretsReader(): SystemSecretsReader
```

Provides an implementation of the SystemSecretsReader interface for the current platform.

This function returns an instance of SystemSecretsReader that allows access to secrets based on platform-specific implementations. On unsupported platforms, this function will throw a NotImplementedError.

An instance of SystemSecretsReader for accessing system configuration properties.

- NotImplementedError — if SystemSecretsReader is not supported on this platform.
### :utils/appleMain

```kotlin
actual fun systemSecretsReader(): SystemSecretsReader
```

Provides an implementation of the SystemSecretsReader interface for the current platform.

This function returns an instance of SystemSecretsReader that allows access to secrets based on platform-specific implementations. On unsupported platforms, this function will throw a NotImplementedError.

An instance of SystemSecretsReader for accessing system configuration properties.

- NotImplementedError — if SystemSecretsReader is not supported on this platform.

Referenced packages: `ai.koog.utils.system`.

### :utils/commonMain

```kotlin
expect fun systemSecretsReader(): SystemSecretsReader
```

Provides an implementation of the SystemSecretsReader interface for the current platform.

This function returns an instance of SystemSecretsReader that allows access to secrets based on platform-specific implementations. On unsupported platforms, this function will throw a NotImplementedError.

An instance of SystemSecretsReader for accessing system configuration properties.

- NotImplementedError — if SystemSecretsReader is not supported on this platform.
### :utils/jsMain

```kotlin
actual fun systemSecretsReader(): SystemSecretsReader
```

Provides an implementation of the SystemSecretsReader interface for the current platform.

This function returns an instance of SystemSecretsReader that allows access to secrets based on platform-specific implementations. On unsupported platforms, this function will throw a NotImplementedError.

An instance of SystemSecretsReader for accessing system configuration properties.

- NotImplementedError — if SystemSecretsReader is not supported on this platform.

Referenced packages: `ai.koog.utils.system`.

### :utils/jvmMain

```kotlin
actual fun systemSecretsReader(): SystemSecretsReader
```

Provides an implementation of the SystemSecretsReader interface for the current platform.

This function returns an instance of SystemSecretsReader that allows access to secrets based on platform-specific implementations. On unsupported platforms, this function will throw a NotImplementedError.

An instance of SystemSecretsReader for accessing system configuration properties.

- NotImplementedError — if SystemSecretsReader is not supported on this platform.
### :utils/wasmJsMain

```kotlin
actual fun systemSecretsReader(): SystemSecretsReader
```

Provides an implementation of the SystemSecretsReader interface for the current platform.

This function returns an instance of SystemSecretsReader that allows access to secrets based on platform-specific implementations. On unsupported platforms, this function will throw a NotImplementedError.

An instance of SystemSecretsReader for accessing system configuration properties.

- NotImplementedError — if SystemSecretsReader is not supported on this platform.

Referenced packages: `ai.koog.utils.system`.

## ai.koog.utils.time.KoogClock.Companion.System

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.time/-koog-clock/-companion/-system.html`

### :utils/commonMain

```kotlin
@JvmField val System: KoogClock
```

Default KoogClock implementation backed by kotlin.time.Clock.System.

## ai.koog.utils.time.KoogClock.Companion

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.time/-koog-clock/-companion/index.html`

### :utils/commonMain

```kotlin
object Companion
```

## ai.koog.utils.time.KoogClock

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.time/-koog-clock/index.html`

### :utils/commonMain

```kotlin
fun interface KoogClock
```

Time source used across Koog for message timestamps, event timestamps, and any other "what time is it now" call.

Implement this interface (or use KoogClock.System) anywhere a clock is required. Being a functional interface, simple test doubles can be written as lambdas:

## ai.koog.utils.time.KoogClock.now

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.time/-koog-clock/now.html`

### :utils/commonMain

```kotlin
abstract fun now(): Instant
```

Returns the current instant as observed by this clock.

## ai.koog.utils.time.TimeUtils

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.time/-time-utils/index.html`

### :utils/jvmMain

```kotlin
object TimeUtils
```

## ai.koog.utils.time.toKotlinDuration

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.time/to-kotlin-duration.html`

### :utils/jvmMain

```kotlin
fun Duration.toKotlinDuration(): Duration
```

## ai.koog.utils.time.toKotlinInstant

Module: `utils`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `utils/ai.koog.utils.time/to-kotlin-instant.html`

### :utils/jvmMain

```kotlin
fun Instant.toKotlinInstant(): Instant
```
