# Ktor integration

Kotlin contracts extracted from the supplied Dokka build. Read [coverage and compatibility](../api-index.md) first. Read individual symbols as needed; source labels and incomplete declarations are preserved.

## ai.koog.ktor.Koog.Companion

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog/-companion/index.html`

### :koog-ktor/commonMain

```kotlin
object Companion : Plugin<ApplicationCallPipeline, KoogAgentsConfig, Koog>
```

A scoped plugin named "KoogAgents" for managing the Koog instance lifecycle in the application context.

The plugin initializes the necessary components such as the MultiLLMPromptExecutor and KoogInstance using configuration parameters provided via pluginConfig. The KoogInstance carries the core functionality for language model communication, agent tools, configurations, and features.

The initialized KoogInstance is then stored in the application's attributes to be accessible across the application.

## ai.koog.ktor.Koog.Companion.install

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog/-companion/install.html`

### :koog-ktor/commonMain

```kotlin
open override fun install(pipeline: ApplicationCallPipeline, configure: KoogAgentsConfig.() -> Unit): Koog
```

## ai.koog.ktor.Koog.Companion.key

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog/-companion/key.html`

### :koog-ktor/commonMain

```kotlin
open override val key: AttributeKey<Koog>
```

Attribute key used to store and retrieve the KoogInstance from the application's attributes.

The KoogInstance holds a reference to the PromptExecutor, the default language model (LLModel), and other necessary configurations and tools required for executing prompts and performing AI-driven operations.

This key is utilized within the application to access the KoogInstance for tasks such as processing language model queries, moderating content, and employing available AI tools in a routing context.

## ai.koog.ktor.Koog.Koog

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog/-koog.html`

### :koog-ktor/commonMain

```kotlin
constructor(application: Application, promptExecutor: PromptExecutor, agentConfig: KoogAgentsConfig.AgentConfig, agentFeatures: List<GraphAIAgent.FeatureContext.() -> Unit>, job: CompletableJob)
```


Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.prompt.executor.model`.

## ai.koog.ktor.Koog.agentConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog/agent-config.html`

### :koog-ktor/commonMain

```kotlin
val agentConfig: KoogAgentsConfig.AgentConfig
```

## ai.koog.ktor.Koog.agentFeatures

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog/agent-features.html`

### :koog-ktor/commonMain

```kotlin
val agentFeatures: List<GraphAIAgent.FeatureContext.() -> Unit>
```


Referenced packages: `ai.koog.agents.core.agent`.

## ai.koog.ktor.Koog.application

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog/application.html`

### :koog-ktor/commonMain

```kotlin
val application: Application
```

## ai.koog.ktor.Koog

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog/index.html`

### :koog-ktor/commonMain

```kotlin
class Koog(val application: Application, val promptExecutor: PromptExecutor, val agentConfig: KoogAgentsConfig.AgentConfig, val agentFeatures: List<GraphAIAgent.FeatureContext.() -> Unit>, job: CompletableJob)
```

Represents an instance of Koog with configuration for prompt execution, language model, tool management, agent setup, and features.


Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.prompt.executor.model`.

## ai.koog.ktor.Koog.promptExecutor

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog/prompt-executor.html`

### :koog-ktor/commonMain

```kotlin
val promptExecutor: PromptExecutor
```


Referenced packages: `ai.koog.prompt.executor.model`.

## ai.koog.ktor.KoogAgentsConfig.AgentConfig.AgentConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-agent-config/-agent-config.html`

### :koog-ktor/commonMain

```kotlin
constructor()
```

## ai.koog.ktor.KoogAgentsConfig.AgentConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-agent-config/index.html`

### :koog-ktor/commonMain

```kotlin
inner class AgentConfig
```

Configuration class for managing agent-specific settings and tools.

The AgentConfig class allows customization of the agent's behavior, including:

Setting the prompt and language model to use

Managing tools available to the agent

Defining strategies for handling missing tools

Installing additional features

## ai.koog.ktor.KoogAgentsConfig.AgentConfig.install

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-agent-config/install.html`

### :koog-ktor/commonMain

```kotlin
fun <TConfig : FeatureConfig> install(feature: AIAgentGraphFeature<TConfig, *>, configure: TConfig.() -> Unit = {})
```

Adds an AI agent feature to the current configuration by applying the specific configuration logic.

- feature — The AI agent feature to be added, which provides functionality and configuration capabilities.
- configure — A lambda function to configure the feature. The default is an empty configuration.
- TConfig — The type of feature configuration that extends FeatureConfig.

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.config`.

## ai.koog.ktor.KoogAgentsConfig.AgentConfig.maxAgentIterations

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-agent-config/max-agent-iterations.html`

### :koog-ktor/commonMain

```kotlin
var maxAgentIterations: Int
```

Specifies the maximum number of iterations an agent is permitted to perform during its execution cycle.

Adjusting this value controls how many steps an agent can take while attempting to fulfill a given task or respond to a prompt. This acts as a constraint to prevent unbounded loops or excessive resource usage in scenarios where the agent's computations or decision-making processes continue indefinitely.

Default value is 50.

## ai.koog.ktor.KoogAgentsConfig.AgentConfig.missingToolsConversionStrategy

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-agent-config/missing-tools-conversion-strategy.html`

### :koog-ktor/commonMain

```kotlin
var missingToolsConversionStrategy: MissingToolsConversionStrategy
```

Defines the strategy for handling tool calls present in the prompt that do not have corresponding tool definitions registered in the current context. This is used to convert missing tool information into a format suitable for processing by the model.

By default, this variable is set to MissingToolsConversionStrategy.Missing, which replaces only the missing tool calls with a descriptive format using the ToolCallDescriber.JSON implementation. This ensures that missing tool calls are represented as plaintext messages in the prompt while leaving other tool-related data intact.

This property can be customized to use other strategies, such as replacing all tool calls irrespective of their presence in the registry or using custom formatting strategies defined by other implementations of the ToolCallDescriber.


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.ktor.KoogAgentsConfig.AgentConfig.prompt

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-agent-config/prompt.html`

### :koog-ktor/commonMain

```kotlin
fun prompt(name: String = "agent", llmParams: LLMParams = LLMParams(), clock: KoogClock = KoogClock.System, build: PromptBuilder.() -> Unit)
```

Configures and sets the prompt for the agent using the provided parameters and a prompt-building function.

- llmParams — The parameters that define the behavior of the language model, such as temperature and tool selection. Defaults to an instance of LLMParams.
- build — A lambda function that is used to construct the prompt using a PromptBuilder.

Referenced packages: `ai.koog.prompt.dsl`, `ai.koog.prompt.params`, `ai.koog.utils.time`.

## ai.koog.ktor.KoogAgentsConfig.AgentConfig.registerTools

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-agent-config/register-tools.html`

### :koog-ktor/commonMain

```kotlin
fun registerTools(block: ToolRegistryBuilder.() -> Unit)
```

Registers tools into the tool registry using the provided configuration lambda.

This method allows adding custom tools to the registry by defining them through the ToolRegistry.Builder. The tools are applied to the internal toolRegistry of the AgentConfig class instance by merging existing tools with the newly registered tools.

- block — A lambda function for configuring the tool registry using the ToolRegistry.Builder.

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.ktor.KoogAgentsConfig.AnthropicConfig.AnthropicConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-anthropic-config/-anthropic-config.html`

### :koog-ktor/commonMain

```kotlin
constructor()
```

## ai.koog.ktor.KoogAgentsConfig.AnthropicConfig.apiVersion

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-anthropic-config/api-version.html`

### :koog-ktor/commonMain

```kotlin
var apiVersion: String?
```

Specifies the API version used for requests to the Anthropic API.

This variable determines the version of the API that the client interacts with and ensures compatibility with the desired API features and endpoints. It plays a key role in configuring Anthropic API requests and is initialized to the default API version provided by the system.

The value can be updated to specify a different version if required for a specific use case.

## ai.koog.ktor.KoogAgentsConfig.AnthropicConfig.baseUrl

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-anthropic-config/base-url.html`

### :koog-ktor/commonMain

```kotlin
var baseUrl: String?
```

Specifies the base URL for the Anthropic API used in client requests.

This URL serves as the root endpoint for all API interactions with Anthropic services. It can be customized to point to different server environments (e.g., production, staging, or testing). By default, it is set to AnthropicClientSettings.baseUrl.

## ai.koog.ktor.KoogAgentsConfig.AnthropicConfig.httpClient

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-anthropic-config/http-client.html`

### :koog-ktor/commonMain

```kotlin
var httpClient: HttpClient
```

Represents the HTTP client that is used to perform network operations such as API requests within the AnthropicConfig configuration.

This variable serves as the base client for executing HTTP calls, including request preparation, timeout handling, and connection management, utilizing settings specified in the configuration.

It can be customized or replaced if an alternative HTTP client is required for specific use cases or integrations.

## ai.koog.ktor.KoogAgentsConfig.AnthropicConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-anthropic-config/index.html`

### :koog-ktor/commonMain

```kotlin
class AnthropicConfig
```

AnthropicConfig is a configuration class for integrating with the Anthropic API. It allows for customization of base API URL, model versions, API version, timeout settings, and the HTTP client used for requests. This class facilitates specifying all necessary parameters and settings required to interact with Anthropic's LLM services.

## ai.koog.ktor.KoogAgentsConfig.AnthropicConfig.modelVersionsMap

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-anthropic-config/model-versions-map.html`

### :koog-ktor/commonMain

```kotlin
var modelVersionsMap: Map<LLModel, String>?
```

Maps a specific LLModel to its corresponding version string. This configuration is primarily used to associate particular model identifiers with their appropriate versions, allowing the system to select or adjust model behaviors based on these mappings.

By default, this property is initialized with a predefined map (AnthropicClientSettings.modelVersionsMap), but can be customized to support other mappings depending on the requirements.

This property is typically utilized in the configuration of interaction with Anthropic LLM clients to ensure appropriate versioned models are used during LLM execution.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.ktor.KoogAgentsConfig.AnthropicConfig.timeoutConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-anthropic-config/timeout-config.html`

### :koog-ktor/commonMain

```kotlin
var timeoutConfig: ConnectionTimeoutConfig?
```

Configures the timeout settings for API requests, connection establishment, and socket operations when interacting with the Anthropic API. This property is used to customize timeout behavior to handle use cases requiring different default durations for network-related operations.


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.ktor.KoogAgentsConfig.AnthropicConfig.timeouts

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-anthropic-config/timeouts.html`

### :koog-ktor/commonMain

```kotlin
fun timeouts(configure: KoogAgentsConfig.TimeoutConfiguration.() -> Unit)
```

Configures the timeout values for network requests, connection establishment, and socket operations by applying the provided configuration block.

- configure — A lambda function to customize the timeout configuration using the provided TimeoutConfiguration instance.
## ai.koog.ktor.KoogAgentsConfig.DeepSeekConfig.DeepSeekConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-deep-seek-config/-deep-seek-config.html`

### :koog-ktor/commonMain

```kotlin
constructor()
```

## ai.koog.ktor.KoogAgentsConfig.DeepSeekConfig.baseUrl

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-deep-seek-config/base-url.html`

### :koog-ktor/commonMain

```kotlin
var baseUrl: String?
```

Defines the base URL used for configuring the target endpoint of the DeepSeek API. This property allows customization of the API's base endpoint to interact with different server environments or instances beyond the default URL.

The default value is [DeepSeekClientSettings.baseUrl].

## ai.koog.ktor.KoogAgentsConfig.DeepSeekConfig.httpClient

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-deep-seek-config/http-client.html`

### :koog-ktor/commonMain

```kotlin
var httpClient: HttpClient
```

Represents the HTTP client used to handle network requests within the configuration. This client can be customized or replaced to adapt to specific use cases, such as modifying headers, interceptors, or other client-level configurations.

By default, it is initialized with a standard instance of HttpClient.

## ai.koog.ktor.KoogAgentsConfig.DeepSeekConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-deep-seek-config/index.html`

### :koog-ktor/commonMain

```kotlin
class DeepSeekConfig
```

DeepSeekConfig is a configuration class for setting up the DeepSeek client. It manages essential parameters such as API key, base URL, connection timeout settings, and the HTTP client used for requests.

## ai.koog.ktor.KoogAgentsConfig.DeepSeekConfig.timeoutConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-deep-seek-config/timeout-config.html`

### :koog-ktor/commonMain

```kotlin
var timeoutConfig: ConnectionTimeoutConfig
```

Represents the configuration for connection timeouts used in network requests. This configuration specifies the timeout durations in milliseconds for requests, connection establishment, and socket operations.

By default, it is initialized with the default timeout values provided by the ConnectionTimeoutConfig class. It can be modified using the timeouts function in the containing DeepSeekConfig class, or directly assigned with a new instance of ConnectionTimeoutConfig.


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.ktor.KoogAgentsConfig.DeepSeekConfig.timeouts

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-deep-seek-config/timeouts.html`

### :koog-ktor/commonMain

```kotlin
fun timeouts(configure: KoogAgentsConfig.TimeoutConfiguration.() -> Unit)
```

Configures timeout settings to be applied to the client.

- configure — A lambda receiver that configures an instance of TimeoutConfiguration.
## ai.koog.ktor.KoogAgentsConfig.GoogleConfig.GoogleConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-google-config/-google-config.html`

### :koog-ktor/commonMain

```kotlin
constructor()
```

## ai.koog.ktor.KoogAgentsConfig.GoogleConfig.baseUrl

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-google-config/base-url.html`

### :koog-ktor/commonMain

```kotlin
var baseUrl: String?
```

Specifies the base URL for API requests to the Generative Language API. It determines the endpoint to which HTTP requests are made.

By default, this is set to "GoogleClientSettings.baseUrl". Users can customize this value to point to alternative endpoints if needed.

## ai.koog.ktor.KoogAgentsConfig.GoogleConfig.httpClient

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-google-config/http-client.html`

### :koog-ktor/commonMain

```kotlin
var httpClient: HttpClient
```

httpClient is an instance of HttpClient used for making HTTP requests to external services. This property is configurable and allows customization of the HTTP client settings, such as connection timeouts, headers, and other HTTP-specific configurations.

In the context of the containing class, it integrates with the provided timeout configuration and base URL setup to facilitate requests, typically to the Google Generative Language API.

This property acts as the base client for APIs and can be overridden or modified as needed to suit specific requirements in HTTP communication or integration scenarios.

## ai.koog.ktor.KoogAgentsConfig.GoogleConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-google-config/index.html`

### :koog-ktor/commonMain

```kotlin
class GoogleConfig
```

GoogleConfig is a configuration class for setting up and customizing integrations with the Google Generative Language API. It allows for specifying an API key, configuring timeouts, and setting the base URL used for API requests.

## ai.koog.ktor.KoogAgentsConfig.GoogleConfig.timeoutConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-google-config/timeout-config.html`

### :koog-ktor/commonMain

```kotlin
var timeoutConfig: ConnectionTimeoutConfig?
```

Represents the timeout configuration for network interactions with the Google API. This configuration includes parameters for setting the timeouts for request execution, connection establishment, and socket communication.

The default values for the configuration are inherited from the defaults specified in the ConnectionTimeoutConfig class.


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.ktor.KoogAgentsConfig.GoogleConfig.timeouts

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-google-config/timeouts.html`

### :koog-ktor/commonMain

```kotlin
fun timeouts(configure: KoogAgentsConfig.TimeoutConfiguration.() -> Unit)
```

Configures the timeout settings for requests, connections, and socket operations. Applies the settings specified in the provided configuration block to update the timeoutConfig.

- configure — A lambda function where the timeout values can be customized using properties from the TimeoutConfiguration class.
## ai.koog.ktor.KoogAgentsConfig.KoogAgentsConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-koog-agents-config.html`

### :koog-ktor/commonMain

```kotlin
constructor(scope: CoroutineScope)
```

## ai.koog.ktor.KoogAgentsConfig.LLMConfig.FallbackLLMConfig.FallbackLLMConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-l-l-m-config/-fallback-l-l-m-config/-fallback-l-l-m-config.html`

### :koog-ktor/commonMain

```kotlin
constructor()
```

## ai.koog.ktor.KoogAgentsConfig.LLMConfig.FallbackLLMConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-l-l-m-config/-fallback-l-l-m-config/index.html`

### :koog-ktor/commonMain

```kotlin
inner class FallbackLLMConfig
```

Configuration class for defining a fallback Large Language Model (LLM) setup.

This class allows specifying a provider and model to be used as a fallback in cases where the primary LLM configuration is unavailable or fails.

The fallback configuration requires explicitly setting both the provider and model.

## ai.koog.ktor.KoogAgentsConfig.LLMConfig.FallbackLLMConfig.model

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-l-l-m-config/-fallback-l-l-m-config/model.html`

### :koog-ktor/commonMain

```kotlin
var model: LLModel?
```

Represents the fallback Large Language Model (LLM) to be used in cases where the primary configuration is unavailable or a specific fallback is required.

This property defines a large language model with its associated provider, unique identifier, and capabilities. It must be explicitly set when configuring a fallback LLM to ensure proper functionality.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.ktor.KoogAgentsConfig.LLMConfig.FallbackLLMConfig.provider

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-l-l-m-config/-fallback-l-l-m-config/provider.html`

### :koog-ktor/commonMain

```kotlin
var provider: LLMProvider?
```

Defines the provider for the fallback Large Language Model (LLM) to be used when the primary configuration or execution fails. The provider specifies which LLM platform will be utilized, such as OpenAI, Google, or others, derived from the LLMProvider hierarchy.

This property should be set to a specific LLMProvider implementation before configuring a fallback. Failure to specify a provider will result in an error when attempting to use the fallback configuration.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.ktor.KoogAgentsConfig.LLMConfig.LLMConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-l-l-m-config/-l-l-m-config.html`

### :koog-ktor/commonMain

```kotlin
constructor()
```

## ai.koog.ktor.KoogAgentsConfig.LLMConfig.addClient

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-l-l-m-config/add-client.html`

### :koog-ktor/commonMain

```kotlin
fun addClient(provider: LLMProvider, client: LLMClient)
```

Adds a custom Large Language Model (LLM) client to the configuration.

This method allows you to register a specific implementation of an LLM client for a given provider, enabling seamless integration with the desired LLM service.

- provider — The LLM provider associated with the client being added.
- client — The LLM client implementation to be registered for the specified provider.

Referenced packages: `ai.koog.prompt.executor.clients`, `ai.koog.prompt.llm`.

## ai.koog.ktor.KoogAgentsConfig.LLMConfig.anthropic

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-l-l-m-config/anthropic.html`

### :koog-ktor/commonMain

```kotlin
fun anthropic(apiKey: String, configure: KoogAgentsConfig.AnthropicConfig.() -> Unit = {})
```

Configures the Anthropic API client with the specified API key and additional settings.

- apiKey — The API key used for authenticating with the Anthropic API.
- configure — A lambda function for further configuring the Anthropic client. Default is an empty configuration.
## ai.koog.ktor.KoogAgentsConfig.LLMConfig.deepSeek

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-l-l-m-config/deep-seek.html`

### :koog-ktor/commonMain

```kotlin
fun deepSeek(apiKey: String, configure: KoogAgentsConfig.DeepSeekConfig.() -> Unit = {})
```

Configures and initializes the DeepSeek API with the provided API key and optional configuration.

- apiKey — The API key used to authenticate with the DeepSeek API.
- configure — An optional lambda function used to customize the DeepSeek configuration.
## ai.koog.ktor.KoogAgentsConfig.LLMConfig.fallback

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-l-l-m-config/fallback.html`

### :koog-ktor/commonMain

```kotlin
fun fallback(configure: KoogAgentsConfig.LLMConfig.FallbackLLMConfig.() -> Unit)
```

Configures fallback settings for the LLM (Large Language Model) configuration. This is used to define a fallback provider and model in case primary configurations are unavailable.

- configure — A lambda function to configure the fallback provider and model using the FallbackLLMConfig instance. The provider and model must be specified within this configuration.
## ai.koog.ktor.KoogAgentsConfig.LLMConfig.google

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-l-l-m-config/google.html`

### :koog-ktor/commonMain

```kotlin
fun google(apiKey: String, configure: KoogAgentsConfig.GoogleConfig.() -> Unit = {})
```

Configures the Google client for the application.

- apiKey — The API key to authenticate with Google services.
- configure — A lambda to customize the GoogleConfig settings such as base URL, timeouts, or HTTP client configuration.
## ai.koog.ktor.KoogAgentsConfig.LLMConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-l-l-m-config/index.html`

### :koog-ktor/commonMain

```kotlin
inner class LLMConfig
```

Configuration class for managing various Language Learning Model (LLM) providers and their settings. This class allows integration with different LLM services such as OpenAI, Anthropic, Google, MistralAI, OpenRouter, DeepSeek, and Ollama. Users can also define fallback configurations and custom LLM clients.

## ai.koog.ktor.KoogAgentsConfig.LLMConfig.mistral

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-l-l-m-config/mistral.html`

### :koog-ktor/commonMain

```kotlin
fun mistral(apiKey: String, configure: KoogAgentsConfig.MistralAIConfig.() -> Unit = {})
```

Configures the MistralAI client for the application.

- apiKey — The API key to authenticate with MistralAI services.
- configure — A lambda to customize the MistralAIConfig settings such as base URL, timeouts, or HTTP client configuration.
## ai.koog.ktor.KoogAgentsConfig.LLMConfig.ollama

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-l-l-m-config/ollama.html`

### :koog-ktor/commonMain

```kotlin
fun ollama(configure: KoogAgentsConfig.OllamaConfig.() -> Unit = {})
```

Configures the Ollama integration using the provided configuration block. This method allows customization of settings for communicating with the Ollama service.

- configure — A lambda providing a configuration block for customizing the behavior of Ollama integration.
## ai.koog.ktor.KoogAgentsConfig.LLMConfig.openAI

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-l-l-m-config/open-a-i.html`

### :koog-ktor/commonMain

```kotlin
fun openAI(apiKey: String, configure: KoogAgentsConfig.OpenAIConfig.() -> Unit = {})
```

Configures the OpenAI integration for the system using the provided API key and optional configuration.

- apiKey — The API key used to authenticate with the OpenAI service.
- configure — A lambda function to customize the OpenAI configuration, such as setting base URLs, paths, or timeout settings. Defaults to an empty lambda.
## ai.koog.ktor.KoogAgentsConfig.LLMConfig.openRouter

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-l-l-m-config/open-router.html`

### :koog-ktor/commonMain

```kotlin
fun openRouter(apiKey: String, configure: KoogAgentsConfig.OpenRouterConfig.() -> Unit = {})
```

Configures and initializes the OpenRouter API with the provided API key and optional configuration.

- apiKey — The API key used to authenticate with the OpenRouter API.
- configure — An optional lambda function used to customize the OpenRouter configuration.
## ai.koog.ktor.KoogAgentsConfig.MistralAIConfig.MistralAIConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-mistral-a-i-config/-mistral-a-i-config.html`

### :koog-ktor/commonMain

```kotlin
constructor()
```

## ai.koog.ktor.KoogAgentsConfig.MistralAIConfig.baseUrl

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-mistral-a-i-config/base-url.html`

### :koog-ktor/commonMain

```kotlin
var baseUrl: String?
```

The base URL for the MistralAI API. This property defines the endpoint that the client connects to for making API requests. It is used to construct the full URL for various API operations such as chat completions, embeddings, and moderations.

The default value is set to "MistralAIClientSettings.baseUrl". This can be overridden for custom API endpoints or testing purposes by changing its value.

## ai.koog.ktor.KoogAgentsConfig.MistralAIConfig.chatCompletionsPath

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-mistral-a-i-config/chat-completions-path.html`

### :koog-ktor/commonMain

```kotlin
var chatCompletionsPath: String?
```

Represents the API path segment used for MistralAI's chat completions endpoint.

This variable can be configured to specify a custom endpoint path when interacting with the MistralAI chat completions API. By default, it is set to MistralAIClientSettings.chatCompletionsPath.

## ai.koog.ktor.KoogAgentsConfig.MistralAIConfig.embeddingsPath

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-mistral-a-i-config/embeddings-path.html`

### :koog-ktor/commonMain

```kotlin
var embeddingsPath: String?
```

Specifies the API path for embedding operations in the MistralAI API.

This variable determines the endpoint to be used when interacting with embedding-related functionalities provided by the MistralAI service. By default, it is set to MistralAIClientSettings.embeddingsPath.

Can be customized to target a different API path if required.

## ai.koog.ktor.KoogAgentsConfig.MistralAIConfig.httpClient

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-mistral-a-i-config/http-client.html`

### :koog-ktor/commonMain

```kotlin
var httpClient: HttpClient
```

Represents the HTTP client used for making network requests to the MistralAI API. This client is configurable and can be replaced or customized to meet specific requirements, such as adjusting timeouts, adding interceptors, or modifying base client behavior. The default implementation initializes with a standard HttpClient instance.

## ai.koog.ktor.KoogAgentsConfig.MistralAIConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-mistral-a-i-config/index.html`

### :koog-ktor/commonMain

```kotlin
class MistralAIConfig
```

Configuration class for MistralAI integration, providing options to set API-specific paths, network timeouts, and base connection settings.

## ai.koog.ktor.KoogAgentsConfig.MistralAIConfig.moderationPath

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-mistral-a-i-config/moderation-path.html`

### :koog-ktor/commonMain

```kotlin
val moderationPath: String? = null
```

Represents the API path for the moderation endpoint used in MistralAI API requests. This is a constant value and is typically appended to the base URL when making requests to moderation-related services.

By default, it is set to MistralAIClientSettings.moderationPath.

## ai.koog.ktor.KoogAgentsConfig.MistralAIConfig.timeoutConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-mistral-a-i-config/timeout-config.html`

### :koog-ktor/commonMain

```kotlin
var timeoutConfig: ConnectionTimeoutConfig?
```

A configuration property that defines timeout settings for network interactions with the MistralAI API. It specifies limits for request execution time, connection establishment time, and socket operation time. These timeout values are represented in Duration and provide control over handling delayed or unresponsive network operations.

The default values for these timeouts are derived from the ConnectionTimeoutConfig class, but can be customized through the timeouts function in MistralAIConfig.

Used primarily when configuring an MistralAIClientSettings for making API requests.


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.ktor.KoogAgentsConfig.MistralAIConfig.timeouts

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-mistral-a-i-config/timeouts.html`

### :koog-ktor/commonMain

```kotlin
fun timeouts(configure: KoogAgentsConfig.TimeoutConfiguration.() -> Unit)
```

Configures custom timeout settings for the MistralAI API client.

This method allows users to specify custom timeout values by providing a lambda using the TimeoutConfiguration class. The configured timeouts will then be used for API requests, including request timeout, connection timeout, and socket timeout.

- configure — A lambda with the TimeoutConfiguration receiver to define custom timeout values for request, connection, and socket operations.
## ai.koog.ktor.KoogAgentsConfig.OllamaConfig.OllamaConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-ollama-config/-ollama-config.html`

### :koog-ktor/commonMain

```kotlin
constructor()
```

## ai.koog.ktor.KoogAgentsConfig.OllamaConfig.baseUrl

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-ollama-config/base-url.html`

### :koog-ktor/commonMain

```kotlin
var baseUrl: String?
```

The base URL for the Ollama API, used as the endpoint for all HTTP requests made by the Ollama client. By default, it is set to [OllamaClient.DEFAULT_BASE_URL].

This property can be configured to point to a custom server or different instance of the Ollama service, depending on the deployment or development needs.

For example, baseUrl might need to be updated if the Ollama service is hosted on a remote server or a different port.

## ai.koog.ktor.KoogAgentsConfig.OllamaConfig.httpClient

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-ollama-config/http-client.html`

### :koog-ktor/commonMain

```kotlin
var httpClient: HttpClient
```

A configurable HTTP client used for handling HTTP requests and responses. This client is used to interact with external APIs or services requiring network communication. It can be customized with specific timeout configurations and other properties through the containing class.

## ai.koog.ktor.KoogAgentsConfig.OllamaConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-ollama-config/index.html`

### :koog-ktor/commonMain

```kotlin
class OllamaConfig
```

OllamaConfig is a configuration class for managing the settings required to connect and interact with an Ollama-based language model server. It includes properties for setting the server's base URL, connection timeouts, and an HTTP client for underlying network communication.

## ai.koog.ktor.KoogAgentsConfig.OllamaConfig.timeoutConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-ollama-config/timeout-config.html`

### :koog-ktor/commonMain

```kotlin
var timeoutConfig: ConnectionTimeoutConfig?
```

Configuration object for specifying timeout settings for network operations within the OllamaConfig class. It defines timeouts for requests, connection establishment, and socket operations in milliseconds.

The timeout settings can be updated using the timeouts function within the OllamaConfig class, where custom timeout values can be provided.


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.ktor.KoogAgentsConfig.OllamaConfig.timeouts

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-ollama-config/timeouts.html`

### :koog-ktor/commonMain

```kotlin
fun timeouts(configure: KoogAgentsConfig.TimeoutConfiguration.() -> Unit)
```

Configures timeout settings for network connections by applying the provided configuration block.

- configure — A lambda function with TimeoutConfiguration as the receiver, allowing customization of request, connection, and socket timeouts.
## ai.koog.ktor.KoogAgentsConfig.OpenAIConfig.OpenAIConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-open-a-i-config/-open-a-i-config.html`

### :koog-ktor/commonMain

```kotlin
constructor()
```

## ai.koog.ktor.KoogAgentsConfig.OpenAIConfig.baseUrl

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-open-a-i-config/base-url.html`

### :koog-ktor/commonMain

```kotlin
var baseUrl: String?
```

The base URL for the OpenAI API. This property defines the endpoint that the client connects to for making API requests. It is used to construct the full URL for various API operations such as chat completions, embeddings, and moderations.

The default value is set to "OpenAIClientSettings.baseUrl". This can be overridden for custom API endpoints or testing purposes by changing its value.

## ai.koog.ktor.KoogAgentsConfig.OpenAIConfig.chatCompletionsPath

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-open-a-i-config/chat-completions-path.html`

### :koog-ktor/commonMain

```kotlin
var chatCompletionsPath: String?
```

Represents the API path segment used for OpenAI's chat completions endpoint.

This variable can be configured to specify a custom endpoint path when interacting with the OpenAI chat completions API. By default, it is set to OpenAIClientSettings.chatCompletionsPath.

## ai.koog.ktor.KoogAgentsConfig.OpenAIConfig.embeddingsPath

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-open-a-i-config/embeddings-path.html`

### :koog-ktor/commonMain

```kotlin
var embeddingsPath: String?
```

Specifies the API path for embedding operations in the OpenAI API.

This variable determines the endpoint to be used when interacting with embedding-related functionalities provided by the OpenAI service. By default, it is set to OpenAIClientSettings.embeddingsPath.

Can be customized to target a different API path if required.

## ai.koog.ktor.KoogAgentsConfig.OpenAIConfig.httpClient

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-open-a-i-config/http-client.html`

### :koog-ktor/commonMain

```kotlin
var httpClient: HttpClient
```

Represents the HTTP client used for making network requests to the OpenAI API. This client is configurable and can be replaced or customized to meet specific requirements, such as adjusting timeouts, adding interceptors, or modifying base client behavior. The default implementation initializes with a standard HttpClient instance.

## ai.koog.ktor.KoogAgentsConfig.OpenAIConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-open-a-i-config/index.html`

### :koog-ktor/commonMain

```kotlin
class OpenAIConfig
```

Configuration class for OpenAI integration, providing options to set API-specific paths, network timeouts, and base connection settings.

## ai.koog.ktor.KoogAgentsConfig.OpenAIConfig.moderationsPath

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-open-a-i-config/moderations-path.html`

### :koog-ktor/commonMain

```kotlin
var moderationsPath: String?
```

Represents the API path for the moderation endpoint used in OpenAI API requests. This is a constant value and is typically appended to the base URL when making requests to moderation-related services.

By default, it is set to OpenAIClientSettings.moderationsPath.

## ai.koog.ktor.KoogAgentsConfig.OpenAIConfig.timeoutConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-open-a-i-config/timeout-config.html`

### :koog-ktor/commonMain

```kotlin
var timeoutConfig: ConnectionTimeoutConfig?
```

A configuration property that defines timeout settings for network interactions with the OpenAI API. It specifies limits for request execution time, connection establishment time, and socket operation time. These timeout values are represented in Duration and provide control over handling delayed or unresponsive network operations.

The default values for these timeouts are derived from the ConnectionTimeoutConfig class, but can be customized through the timeouts function in OpenAIConfig.

Used primarily when configuring an OpenAILLMClient for making API requests.


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.ktor.KoogAgentsConfig.OpenAIConfig.timeouts

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-open-a-i-config/timeouts.html`

### :koog-ktor/commonMain

```kotlin
fun timeouts(configure: KoogAgentsConfig.TimeoutConfiguration.() -> Unit)
```

Configures custom timeout settings for the OpenAI API client.

This method allows users to specify custom timeout values by providing a lambda using the TimeoutConfiguration class. The configured timeouts will then be used for API requests, including request timeout, connection timeout, and socket timeout.

- configure — A lambda with the TimeoutConfiguration receiver to define custom timeout values for request, connection, and socket operations.
## ai.koog.ktor.KoogAgentsConfig.OpenRouterConfig.OpenRouterConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-open-router-config/-open-router-config.html`

### :koog-ktor/commonMain

```kotlin
constructor()
```

## ai.koog.ktor.KoogAgentsConfig.OpenRouterConfig.baseUrl

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-open-router-config/base-url.html`

### :koog-ktor/commonMain

```kotlin
var baseUrl: String?
```

Defines the base URL used for configuring the target endpoint of the OpenRouter API. This property allows customization of the API's base endpoint to interact with different server environments or instances beyond the default URL.

The default value is [OpenRouterClientSettings.baseUrl].

## ai.koog.ktor.KoogAgentsConfig.OpenRouterConfig.httpClient

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-open-router-config/http-client.html`

### :koog-ktor/commonMain

```kotlin
var httpClient: HttpClient
```

Represents the HTTP client used to handle network requests within the configuration. This client can be customized or replaced to adapt to specific use cases, such as modifying headers, interceptors, or other client-level configurations.

By default, it is initialized with a standard instance of HttpClient.

## ai.koog.ktor.KoogAgentsConfig.OpenRouterConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-open-router-config/index.html`

### :koog-ktor/commonMain

```kotlin
class OpenRouterConfig
```

OpenRouterConfig is a configuration class for setting up the OpenRouter client. It manages essential parameters such as API key, base URL, connection timeout settings, and the HTTP client used for requests.

## ai.koog.ktor.KoogAgentsConfig.OpenRouterConfig.timeoutConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-open-router-config/timeout-config.html`

### :koog-ktor/commonMain

```kotlin
var timeoutConfig: ConnectionTimeoutConfig
```

Represents the configuration for connection timeouts used in network requests. This configuration specifies the timeout durations in milliseconds for requests, connection establishment, and socket operations.

By default, it is initialized with the default timeout values provided by the ConnectionTimeoutConfig class. It can be modified using the timeouts function in the containing OpenRouterConfig class, or directly assigned with a new instance of ConnectionTimeoutConfig.


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.ktor.KoogAgentsConfig.OpenRouterConfig.timeouts

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-open-router-config/timeouts.html`

### :koog-ktor/commonMain

```kotlin
fun timeouts(configure: KoogAgentsConfig.TimeoutConfiguration.() -> Unit)
```

Configures timeout settings to be applied to the client.

- configure — A lambda receiver that configures an instance of TimeoutConfiguration.
## ai.koog.ktor.KoogAgentsConfig.TimeoutConfiguration.TimeoutConfiguration

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-timeout-configuration/-timeout-configuration.html`

### :koog-ktor/commonMain

```kotlin
constructor(requestTimeout: Duration = DEFAULT_TIMEOUT, connectTimeout: Duration = DEFAULT_CONNECT_TIMEOUT, socketTimeout: Duration = DEFAULT_TIMEOUT)
```

## ai.koog.ktor.KoogAgentsConfig.TimeoutConfiguration.connectTimeout

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-timeout-configuration/connect-timeout.html`

### :koog-ktor/commonMain

```kotlin
var connectTimeout: Duration
```

Specifies the connection timeout duration for establishing a network connection. This value determines the maximum time allowed for a connection to be established before the operation is terminated.

Default value is 60 seconds.

## ai.koog.ktor.KoogAgentsConfig.TimeoutConfiguration

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-timeout-configuration/index.html`

### :koog-ktor/commonMain

```kotlin
@Serializable data class TimeoutConfiguration(var requestTimeout: Duration = DEFAULT_TIMEOUT, var connectTimeout: Duration = DEFAULT_CONNECT_TIMEOUT, var socketTimeout: Duration = DEFAULT_TIMEOUT)
```

Configuration class for defining timeout durations in network requests. Used to set and customize the request, connection, and socket timeouts.

## ai.koog.ktor.KoogAgentsConfig.TimeoutConfiguration.requestTimeout

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-timeout-configuration/request-timeout.html`

### :koog-ktor/commonMain

```kotlin
var requestTimeout: Duration
```

Specifies the maximum duration allowed for a network request to complete before timing out. It acts as a safeguard to prevent indefinite waiting for responses.

The default value is 15.minutes.

This is particularly useful for configuring timeout behavior in network-related operations across various integrations.

## ai.koog.ktor.KoogAgentsConfig.TimeoutConfiguration.socketTimeout

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/-timeout-configuration/socket-timeout.html`

### :koog-ktor/commonMain

```kotlin
var socketTimeout: Duration
```

Specifies the maximum amount of time to wait for data over an established socket connection before timing out.

This property is used to configure the timeout duration for socket operations, such as reading or writing data through the network connection. Setting this value appropriately ensures that the application does not hang indefinitely when waiting for data to be transmitted or received over the socket.

The default value is defined by DEFAULT_TIMEOUT, which represents 15.minutes.

## ai.koog.ktor.KoogAgentsConfig.agentConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/agent-config.html`

### :koog-ktor/commonMain

```kotlin
fun agentConfig(configure: KoogAgentsConfig.AgentConfig.() -> Unit)
```

Configures default configuration for all AI agents with the specified settings.

This method allows the customization of an AI agent by providing a suspendable configuration block that modifies the agent's prompt, model, tool registry, and other parameters. The resulting agent setup is created based on the defined configuration.

- configure — A suspendable lambda function that defines the configuration of the agent. The configuration block operates on an instance of AgentConfig, where properties such as prompt, model, maxAgentIterations, and tools can be customized.
## ai.koog.ktor.KoogAgentsConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/index.html`

### :koog-ktor/commonMain

```kotlin
class KoogAgentsConfig(scope: CoroutineScope)
```

Configuration class for setting up a Koog agents server. Provides options to configure LLM connections, agent tools, features, and other related settings.

## ai.koog.ktor.KoogAgentsConfig.llm

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-koog-agents-config/llm.html`

### :koog-ktor/commonMain

```kotlin
fun llm(configure: KoogAgentsConfig.LLMConfig.() -> Unit)
```

Configures the properties and behavior of the large language model (LLM) within the server environment. Allows setting and customizing various aspects of LLM providers, fallbacks, and related configurations.

- configure — A configuration block where the properties and behaviors of the LLM can be specified using the LLMConfig receiver.
## ai.koog.ktor.McpToolsConfig.McpToolsConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-mcp-tools-config/-mcp-tools-config.html`

### :koog-ktor/jvmMain

```kotlin
constructor(agentConfig: KoogAgentsConfig.AgentConfig)
```

- agentConfig — Configuration for the Koog agent server, which includes tool registry details.
## ai.koog.ktor.McpToolsConfig.client

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-mcp-tools-config/client.html`

### :koog-ktor/jvmMain

```kotlin
fun client(mcpClient: Client, mcpToolParser: McpToolDescriptorParser = DefaultMcpToolDescriptorParser)
```

Registers tools from an existing MCP client into the tool registry.

This method retrieves tools from the given MCP client, parses their definitions using the provided or default MCP tool descriptor parser, and adds them to the tool registry.

- mcpClient — The MCP client connected to an MCP server, providing access to tools.
- mcpToolParser — The parser used to convert raw tool information into standardized tool descriptors. Defaults to the standard parser implementation.

Referenced packages: `ai.koog.agents.mcp`.

## ai.koog.ktor.McpToolsConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-mcp-tools-config/index.html`

### :koog-ktor/jvmMain

```kotlin
class McpToolsConfig(agentConfig: KoogAgentsConfig.AgentConfig)
```

Configuration class for MCPTools that manages the integration of various tool registries into the system. Provides methods to process tools using different transport mechanisms.

- agentConfig — Configuration for the Koog agent server, which includes tool registry details.
## ai.koog.ktor.McpToolsConfig.process

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-mcp-tools-config/process.html`

### :koog-ktor/jvmMain

```kotlin
fun process(process: Process, mcpToolParser: McpToolDescriptorParser = DefaultMcpToolDescriptorParser, name: String = DEFAULT_MCP_CLIENT_NAME, version: String = DEFAULT_MCP_CLIENT_VERSION)
```

Processes a given Process instance to register tools from an MCP server.

The method leverages a transport protocol for communication with the MCP server, parses the tool definitions using the specified or default McpToolDescriptorParser, and registers the tools in the agent's tool registry under a given client name and version.

- process — The Process instance representing the MCP server communication process. Its input and output streams will be used for the transport.
- mcpToolParser — The parser that converts MCP tool definitions to standardized descriptors. Defaults to DefaultMcpToolDescriptorParser.
- name — The name of the MCP client for identifying the source of the tools. Defaults to DEFAULT_MCP_CLIENT_NAME.
- version — The version of the MCP client for identifying the source of the tools. Defaults to DEFAULT_MCP_CLIENT_VERSION.

Referenced packages: `ai.koog.agents.mcp`.

## ai.koog.ktor.McpToolsConfig.sse

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-mcp-tools-config/sse.html`

### :koog-ktor/jvmMain

```kotlin
fun sse(url: String, mcpToolParser: McpToolDescriptorParser = DefaultMcpToolDescriptorParser, name: String = DEFAULT_MCP_CLIENT_NAME, version: String = DEFAULT_MCP_CLIENT_VERSION)
```

Registers tools from an MCP server using server-sent events (SSE) transport.

This method establishes an SSE connection to an MCP server at the given URL to retrieve and register tools in the tool registry.

- url — The URL to establish the SSE connection with the MCP server.
- mcpToolParser — A parser for converting the MCP SDK tool definitions into a standardized format. Defaults to DefaultMcpToolDescriptorParser.
- name — The name of the MCP client. Defaults to DEFAULT_MCP_CLIENT_NAME.
- version — The version of the MCP client. Defaults to DEFAULT_MCP_CLIENT_VERSION.

Referenced packages: `ai.koog.agents.mcp`.

## ai.koog.ktor.McpToolsConfig.streamableHttp

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-mcp-tools-config/streamable-http.html`

### :koog-ktor/jvmMain

```kotlin
fun streamableHttp(url: String, httpClient: HttpClient, mcpToolParser: McpToolDescriptorParser = DefaultMcpToolDescriptorParser, name: String = DEFAULT_MCP_CLIENT_NAME, version: String = DEFAULT_MCP_CLIENT_VERSION)
```

Registers tools from an MCP server via Streamable HTTP transport.

This is the recommended way to connect to remote MCP servers. Streamable HTTP supports bidirectional communication, session management, and reconnection.

- url — The URL of the MCP server (e.g., "http://localhost:3000/mcp").
- httpClient — The HttpClient to use for the MCP connection. Must have the Ktor SSE plugin installed. Lifecycle is managed by the caller — the same client can be reused across multiple MCP connections.
- mcpToolParser — A parser for converting the MCP SDK tool definitions into a standardized format.
- name — The name of the MCP client.
- version — The version of the MCP client.

Referenced packages: `ai.koog.agents.mcp`.

## ai.koog.ktor.aiAgent

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/ai-agent.html`

### :koog-ktor/commonMain

```kotlin
suspend fun <Input, Output> RoutingContext.aiAgent(strategy: AIAgentGraphStrategy<Input, Output>, model: LLModel, tools: ToolRegistry = ToolRegistry.EMPTY): AIAgent<Input, Output>
```


Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.tools`, `ai.koog.prompt.llm`.

### :koog-ktor/commonMain

```kotlin
inline suspend fun <Input, Output, Result> RoutingContext.aiAgent(strategy: AIAgentGraphStrategy<Input, Output>, model: LLModel, block: suspend (agent: AIAgent<Input, Output>) -> Result): Result
```

Creates an AI agent using the provided AI agent strategy within the specified route.

An instance of AIAgent configured with the specified strategy and the route's resources.

- strategy — The AI agent strategy defining the workflow and execution logic of the agent.
- Input — The type of input data for the AI agent.
- Output — The type of output data for the AI agent.
- IllegalArgumentException — If the agent configuration (agentConfig) is not set in the route.

Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.entity`, `ai.koog.prompt.llm`.

### :koog-ktor/commonMain

```kotlin
inline suspend fun <Input, Output> RoutingContext.aiAgent(strategy: AIAgentGraphStrategy<Input, Output>, model: LLModel, input: Input): Output
```

Creates an agent using aiAgent, and immediately runs it given the input. When the agent is completed it provides the final Output.


Referenced packages: `ai.koog.agents.core.agent.entity`, `ai.koog.prompt.llm`.

### :koog-ktor/commonMain

```kotlin
suspend fun <Result> RoutingContext.aiAgent(parallelTools: Boolean = false, model: LLModel, block: suspend (agent: AIAgent<String, String>) -> Result): Result
```

A default aiAgent is an agent that runs using singleRunStrategy, by default, it relies on sequential ToolCalls. Inside the block lambda you can use the agent to perform tasks, and calculate a result, such as GraphAIAgent.run.


Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.prompt.llm`.

### :koog-ktor/commonMain

```kotlin
suspend fun RoutingContext.aiAgent(input: String, model: LLModel, parallelTools: Boolean = false): String
```

A default aiAgent is an agent that runs using singleRunStrategy, by default, it relies on sequential ToolCalls. It takes an input, and when the agent finishes running provides a final result String.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.ktor.llm

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/llm.html`

### :koog-ktor/commonMain

```kotlin
fun RoutingContext.llm(): PromptExecutor
```

Retrieve the configured llm, or PromptExecutor instance from the underlying Koog plugin.


Referenced packages: `ai.koog.prompt.executor.model`.

## ai.koog.ktor.mcp

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/mcp.html`

### :koog-ktor/jvmMain

```kotlin
fun KoogAgentsConfig.AgentConfig.mcp(configure: McpToolsConfig.() -> Unit)
```

Configures the MCP (Modular Configuration Protocol) tools for the agent with the provided configuration block.

- configure — A suspend lambda used to configure the MCPToolsConfig instance.