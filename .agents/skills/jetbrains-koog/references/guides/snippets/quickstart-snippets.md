> Retained Kotlin guide from JetBrains/Koog, version family 1.3.0 / 1.3.0-beta. See [source caveats](../../version-and-migration.md) before adapting snippets.

## prerequisites
Ensure your environment and project meet the following requirements:

- JDK 17+
- Kotlin 2.2.0+
## dependencies
Add the [Koog package](https://central.sonatype.com/artifact/ai.koog/koog-agents/) as a dependency:

=== "Gradle (Kotlin)"

    ``` kotlin title="build.gradle.kts"
    dependencies {
        // Stable
        implementation("ai.koog:koog-agents:1.3.0")

        // Beta
        implementation("ai.koog:koog-agents-additions:1.3.0-beta")
    }
    ```

## api-key
Get an API key from an LLM provider or run a local LLM via Ollama.
For more information, see [Quickstart](../quickstart.md).
