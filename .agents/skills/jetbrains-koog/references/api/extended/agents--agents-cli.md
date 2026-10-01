# agents / agents-cli

Additional Kotlin contracts from the supplied Dokka build. Read [API coverage](../../api-index.md) before use.

## ai.koog.agents.cli.AIAgentCliContext.AIAgentCliContext

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-a-i-agent-cli-context/-a-i-agent-cli-context.html`

### :agents:agents-cli/commonMain

```kotlin
constructor(environment: AIAgentEnvironment, agentId: String, runId: String, agentInput: Any?, config: AIAgentConfig, llm: AIAgentLLMContext, stateManager: AIAgentStateManager, storage: AIAgentStorage, strategyName: String, pipeline: AIAgentFunctionalPipeline, executionInfo: AgentExecutionInfo, parentContext: AIAgentContext? = null)
```


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.environment`, `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.cli.AIAgentCliContext.agentId

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-a-i-agent-cli-context/agent-id.html`

### :agents:agents-cli/commonMain

```kotlin
open override val agentId: String
```

## ai.koog.agents.cli.AIAgentCliContext.agentInput

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-a-i-agent-cli-context/agent-input.html`

### :agents:agents-cli/commonMain

```kotlin
open override val agentInput: Any?
```

## ai.koog.agents.cli.AIAgentCliContext.config

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-a-i-agent-cli-context/config.html`

### :agents:agents-cli/commonMain

```kotlin
open override val config: AIAgentConfig
```


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.cli.AIAgentCliContext.copy

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-a-i-agent-cli-context/copy.html`

### :agents:agents-cli/commonMain

```kotlin
fun copy(environment: AIAgentEnvironment = this.environment, agentId: String = this.agentId, runId: String = this.runId, agentInput: Any? = this.agentInput, config: AIAgentConfig = this.config, llm: AIAgentLLMContext = this.llm, stateManager: AIAgentStateManager = this.stateManager, storage: AIAgentStorage = this.storage, strategyName: String = this.strategyName, pipeline: AIAgentFunctionalPipeline = this.pipeline, executionInfo: AgentExecutionInfo = this.executionInfo, parentRootContext: AIAgentContext? = this.parentContext): AIAgentCliContext
```

Copies the current AIAgentCliContext with the specified parameters.


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.environment`, `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.cli.AIAgentCliContext.environment

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-a-i-agent-cli-context/environment.html`

### :agents:agents-cli/commonMain

```kotlin
open override val environment: AIAgentEnvironment
```


Referenced packages: `ai.koog.agents.core.environment`.

## ai.koog.agents.cli.AIAgentCliContext.executionInfo

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-a-i-agent-cli-context/execution-info.html`

### :agents:agents-cli/commonMain

```kotlin
open override var executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.cli.AIAgentCliContext

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-a-i-agent-cli-context/index.html`

### :agents:agents-cli/commonMain

```kotlin
class AIAgentCliContext(val environment: AIAgentEnvironment, val agentId: String, val runId: String, val agentInput: Any?, val config: AIAgentConfig, val llm: AIAgentLLMContext, val stateManager: AIAgentStateManager, val storage: AIAgentStorage, val strategyName: String, val pipeline: AIAgentFunctionalPipeline, var executionInfo: AgentExecutionInfo, val parentContext: AIAgentContext? = null) : AIAgentContext
```

Context for CLI-based AI agents.

This context uses the functional pipeline which provides raw pipeline functionality without any additional features beyond the base ai.koog.agents.core.agent.context.AIAgentContext interface.


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.environment`, `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.cli.AIAgentCliContext.llm

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-a-i-agent-cli-context/llm.html`

### :agents:agents-cli/commonMain

```kotlin
open override val llm: AIAgentLLMContext
```


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.cli.AIAgentCliContext.parentContext

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-a-i-agent-cli-context/parent-context.html`

### :agents:agents-cli/commonMain

```kotlin
open override val parentContext: AIAgentContext?
```


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.cli.AIAgentCliContext.pipeline

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-a-i-agent-cli-context/pipeline.html`

### :agents:agents-cli/commonMain

```kotlin
open override val pipeline: AIAgentFunctionalPipeline
```


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.cli.AIAgentCliContext.runId

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-a-i-agent-cli-context/run-id.html`

### :agents:agents-cli/commonMain

```kotlin
open override val runId: String
```

## ai.koog.agents.cli.AIAgentCliContext.stateManager

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-a-i-agent-cli-context/state-manager.html`

### :agents:agents-cli/commonMain

```kotlin
open override val stateManager: AIAgentStateManager
```


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.cli.AIAgentCliContext.storage

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-a-i-agent-cli-context/storage.html`

### :agents:agents-cli/commonMain

```kotlin
open override val storage: AIAgentStorage
```


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.cli.AIAgentCliContext.strategyName

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-a-i-agent-cli-context/strategy-name.html`

### :agents:agents-cli/commonMain

```kotlin
open override val strategyName: String
```

## ai.koog.agents.cli.AIAgentCliStrategy.Companion

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-a-i-agent-cli-strategy/-companion/index.html`

### :agents:agents-cli/commonMain

```kotlin
object Companion
```

Json utils for cli agent implementations

## ai.koog.agents.cli.AIAgentCliStrategy.execute

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-a-i-agent-cli-strategy/execute.html`

### :agents:agents-cli/commonMain

```kotlin
open suspend override fun execute(context: AIAgentCliContext, input: Input): Output
```

## ai.koog.agents.cli.AIAgentCliStrategy

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-a-i-agent-cli-strategy/index.html`

### :agents:agents-cli/commonMain

```kotlin
class AIAgentCliStrategy<Input, Output> : AIAgentStrategy<Input, Output, AIAgentCliContext>
```

Strategy for executing AI agents using a command-line interface (CLI).


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.cli.AIAgentCliStrategy.name

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-a-i-agent-cli-strategy/name.html`

### :agents:agents-cli/commonMain

```kotlin
open override val name: String
```

## ai.koog.agents.cli.CliAIAgent.Companion.builder

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent/-companion/builder.html`

### :agents:agents-cli/commonMain

```kotlin
fun builder(transport: CliTransport): CliAgentBuilder
```

Creates a new CliAgentBuilder.


Referenced packages: `ai.koog.agents.cli.transport`.

## ai.koog.agents.cli.CliAIAgent.Companion.claude

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent/-companion/claude.html`

### :agents:agents-cli/commonMain

```kotlin
fun claude(transport: CliTransport, apiKey: String? = null, binaryPath: String? = null, name: String? = null, systemPrompt: String? = null, llModel: LLModel? = null, permissionMode: ClaudePermissionMode? = null, additionalFlags: List<String> = emptyList(), workspace: String = ".", timeout: Duration? = null, id: String? = null, clock: KoogClock = KoogClock.System, installFeatures: CliAIAgent.FeatureContext.() -> Unit = {}): CliAIAgent<String, CliAIAgentResponse>
```

Creates a new instance of CliAIAgent using Claude.

- transport — The transport used to execute cli commands.
- apiKey — The API key for the Claude code.
- binaryPath — The path to the binary.
- name — The name of the cli strategy.
- systemPrompt — The system prompt for the agent.
- llModel — The LLM model to be used for the agent.
- permissionMode — The ClaudePermissionMode mode for the agent.
- additionalFlags — Additional flags to be passed to the claude cli.
- workspace — The workspace directory for the agent.
- timeout — The timeout duration for the agent.
- id — The unique identifier for the agent.
- clock — The clock used to calculate message timestamps.
- installFeatures — Lambda for installing additional features.

Referenced packages: `ai.koog.agents.cli.claude`, `ai.koog.agents.cli.transport`, `ai.koog.prompt.llm`, `ai.koog.utils.time`.

### :agents:agents-cli/commonMain

```kotlin
fun <Input> claude(transport: CliTransport, apiKey: String? = null, binaryPath: String? = null, name: String? = null, systemPrompt: String? = null, llModel: LLModel? = null, permissionMode: ClaudePermissionMode? = null, additionalFlags: List<String> = emptyList(), workspace: String = ".", timeout: Duration? = null, id: String? = null, clock: KoogClock = KoogClock.System, generateRequest: CliConfig.GenerateRequest<Input>, installFeatures: CliAIAgent.FeatureContext.() -> Unit = {}): CliAIAgent<Input, CliAIAgentResponse>
```

Creates a new instance of CliAIAgent using Claude.

- transport — The transport used to execute cli commands.
- apiKey — The API key for the Claude code.
- binaryPath — The path to the binary.
- name — The name of the cli strategy.
- systemPrompt — The system prompt for the agent.
- llModel — The LLM model to be used for the agent.
- permissionMode — The ClaudePermissionMode mode for the agent.
- additionalFlags — Additional flags to be passed to the claude cli.
- workspace — The workspace directory for the agent.
- timeout — The timeout duration for the agent.
- id — The unique identifier for the agent.
- clock — The clock used to calculate message timestamps.
- generateRequest — Lambda for generating the request for the agent.
- installFeatures — Lambda for installing additional features.

Referenced packages: `ai.koog.agents.cli.claude`, `ai.koog.agents.cli.transport`, `ai.koog.prompt.llm`, `ai.koog.utils.time`.

### :agents:agents-cli/commonMain

```kotlin
inline fun <Input, Output> claude(transport: CliTransport, apiKey: String? = null, binaryPath: String? = null, name: String? = null, systemPrompt: String? = null, llModel: LLModel? = null, permissionMode: ClaudePermissionMode? = null, additionalFlags: List<String> = emptyList(), workspace: String = ".", timeout: Duration? = null, id: String? = null, clock: KoogClock = KoogClock.System, generateRequest: CliConfig.GenerateRequest<Input> = { it.toString() }, noinline installFeatures: CliAIAgent.FeatureContext.() -> Unit = {}): CliAIAgent<Input, CliAgentStructuredResponse<Output>>
```


Referenced packages: `ai.koog.agents.cli.claude`, `ai.koog.agents.cli.transport`, `ai.koog.prompt.llm`, `ai.koog.utils.time`.

### :agents:agents-cli/commonMain

```kotlin
fun <Input, Output : Any> claude(transport: CliTransport, outputClass: KClass<Output>, apiKey: String? = null, binaryPath: String? = null, name: String? = null, systemPrompt: String? = null, llModel: LLModel? = null, permissionMode: ClaudePermissionMode? = null, additionalFlags: List<String> = emptyList(), workspace: String = ".", timeout: Duration? = null, id: String? = null, clock: KoogClock = KoogClock.System, generateRequest: CliConfig.GenerateRequest<Input> = { it.toString() }, installFeatures: CliAIAgent.FeatureContext.() -> Unit = {}): CliAIAgent<Input, CliAgentStructuredResponse<Output>>
```

Creates a new instance of CliAIAgent in structured output mode.

- transport — The transport used to execute cli commands.
- apiKey — The API key for the Claude code.
- binaryPath — The path to the binary.
- name — The name of the cli strategy.
- systemPrompt — The system prompt for the agent.
- llModel — The LLM model to be used for the agent.
- permissionMode — The ClaudePermissionMode mode for the agent.
- additionalFlags — Additional flags to be passed to the claude cli.
- workspace — The workspace directory for the agent.
- timeout — The timeout duration for the agent.
- id — The unique identifier for the agent.
- clock — The clock used to calculate message timestamps.
- generateRequest — Lambda for generating the request for the agent.
- installFeatures — Lambda for installing additional features.
- Output — The type of the structured output.

Referenced packages: `ai.koog.agents.cli.claude`, `ai.koog.agents.cli.transport`, `ai.koog.prompt.llm`, `ai.koog.utils.time`.

### :agents:agents-cli/commonMain

```kotlin
fun <Input, Output> claude(transport: CliTransport, structure: Structure<Output, LLMParams.Schema.JSON>, apiKey: String? = null, binaryPath: String? = null, name: String? = null, systemPrompt: String? = null, llModel: LLModel? = null, permissionMode: ClaudePermissionMode? = null, additionalFlags: List<String> = emptyList(), workspace: String = ".", timeout: Duration? = null, id: String? = null, clock: KoogClock = KoogClock.System, generateRequest: CliConfig.GenerateRequest<Input> = { it.toString() }, installFeatures: CliAIAgent.FeatureContext.() -> Unit = {}): CliAIAgent<Input, CliAgentStructuredResponse<Output>>
```

Creates a new instance of CliAIAgent in structured output mode.

- transport — The transport used to execute cli commands.
- structure — Structure defining the structured output format.
- apiKey — The API key for the Claude code.
- binaryPath — The path to the binary.
- name — The name of the cli strategy.
- systemPrompt — The system prompt for the agent.
- llModel — The LLM model to be used for the agent.
- permissionMode — The ClaudePermissionMode mode for the agent.
- additionalFlags — Additional flags to be passed to the claude cli.
- workspace — The workspace directory for the agent.
- timeout — The timeout duration for the agent.
- id — The unique identifier for the agent.
- clock — The clock used to calculate message timestamps.
- generateRequest — Lambda for generating the request for the agent.
- installFeatures — Lambda for installing additional features.

Referenced packages: `ai.koog.agents.cli.claude`, `ai.koog.agents.cli.transport`, `ai.koog.prompt.llm`, `ai.koog.prompt.params`, `ai.koog.prompt.structure`, `ai.koog.utils.time`.

## ai.koog.agents.cli.CliAIAgent.Companion.codex

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent/-companion/codex.html`

### :agents:agents-cli/commonMain

```kotlin
fun codex(transport: CliTransport, apiKey: String? = null, binaryPath: String? = null, name: String? = null, systemPrompt: String? = null, llModel: LLModel? = null, sandbox: CodexSandboxMode? = null, askForApproval: CodexApprovalPolicy? = null, additionalFlags: List<String> = emptyList(), workspace: String = ".", timeout: Duration? = null, id: String? = null, clock: KoogClock = KoogClock.System, installFeatures: CliAIAgent.FeatureContext.() -> Unit = {}): CliAIAgent<String, CliAIAgentResponse>
```

Creates a new instance of CliAIAgent using Codex.

- transport — The transport used to execute cli commands.
- apiKey — The API key for the Codex code.
- binaryPath — The path to the binary.
- name — The name of the cli strategy.
- systemPrompt — The system prompt for the agent.
- llModel — The LLM model to be used for the agent.
- sandbox — The CodexSandboxMode for the agent.
- askForApproval — The CodexApprovalPolicy for the agent.
- additionalFlags — Additional flags to be passed to the codex cli.
- workspace — The workspace directory for the agent.
- timeout — The timeout duration for the agent.
- id — The unique identifier for the agent.
- clock — The clock used to calculate message timestamps.
- installFeatures — Lambda for installing additional features.

Referenced packages: `ai.koog.agents.cli.codex`, `ai.koog.agents.cli.transport`, `ai.koog.prompt.llm`, `ai.koog.utils.time`.

### :agents:agents-cli/commonMain

```kotlin
fun <Input> codex(transport: CliTransport, apiKey: String? = null, binaryPath: String? = null, name: String? = null, systemPrompt: String? = null, llModel: LLModel? = null, sandbox: CodexSandboxMode? = null, askForApproval: CodexApprovalPolicy? = null, additionalFlags: List<String> = emptyList(), workspace: String = ".", timeout: Duration? = null, id: String? = null, clock: KoogClock = KoogClock.System, generateRequest: CliConfig.GenerateRequest<Input>, installFeatures: CliAIAgent.FeatureContext.() -> Unit = {}): CliAIAgent<Input, CliAIAgentResponse>
```

Creates a new instance of CliAIAgent using Codex.

- transport — The transport used to execute cli commands.
- apiKey — The API key for the Codex code.
- binaryPath — The path to the binary.
- name — The name of the cli strategy.
- systemPrompt — The system prompt for the agent.
- llModel — The LLM model to be used for the agent.
- sandbox — The CodexSandboxMode for the agent.
- askForApproval — The CodexApprovalPolicy for the agent.
- additionalFlags — Additional flags to be passed to the codex cli.
- workspace — The workspace directory for the agent.
- timeout — The timeout duration for the agent.
- id — The unique identifier for the agent.
- clock — The clock used to calculate message timestamps.
- generateRequest — Lambda for generating the request for the agent.
- installFeatures — Lambda for installing additional features.

Referenced packages: `ai.koog.agents.cli.codex`, `ai.koog.agents.cli.transport`, `ai.koog.prompt.llm`, `ai.koog.utils.time`.

## ai.koog.agents.cli.CliAIAgent.Companion

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent/-companion/index.html`

### :agents:agents-cli/commonMain

```kotlin
object Companion
```

Companion object containing factory methods for creating instances of CliAIAgent.

## ai.koog.agents.cli.CliAIAgent.Companion.withCliConfig

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent/-companion/with-cli-config.html`

### :agents:agents-cli/commonMain

```kotlin
fun <Input, Output> withCliConfig(cliConfig: CliConfig<Input, Output>, systemPrompt: String? = null, llModel: LLModel? = null, id: String? = null, clock: KoogClock = KoogClock.System, installFeatures: CliAIAgent.FeatureContext.() -> Unit = {}): CliAIAgent<Input, Output>
```

Creates a new instance of CliAIAgent using provided configuration of the cli.

- cliConfig — The configuration for the cli.
- systemPrompt — The system prompt for the agent.
- llModel — The LLM model to be used for the agent.
- id — The unique identifier for the agent.
- clock — The clock used to calculate message timestamps.
- installFeatures — Lambda for installing additional features.

Referenced packages: `ai.koog.prompt.llm`, `ai.koog.utils.time`.

## ai.koog.agents.cli.CliAIAgent.FeatureContext

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent/-feature-context/index.html`

### :agents:agents-cli/commonMain

```kotlin
class FeatureContext
```

Represents a context for managing and configuring features in an AI agent. Provides functionality to install and configure features into a specific instance of an AI agent.

## ai.koog.agents.cli.CliAIAgent.FeatureContext.install

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent/-feature-context/install.html`

### :agents:agents-cli/commonMain

```kotlin
fun <Config : FeatureConfig, Feature : Any> install(feature: AIAgentFunctionalFeature<Config, Feature>, configure: Config.() -> Unit = {})
```

Installs and configures a feature into the current AI agent context.

- feature — the feature to be added, defined by an implementation of AIAgentFeature, which provides specific functionality
- configure — an optional lambda to customize the configuration of the feature, where the provided Config can be modified

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.config`.

## ai.koog.agents.cli.CliAIAgent.agentConfig

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent/agent-config.html`

### :agents:agents-cli/commonMain

```kotlin
open override val agentConfig: AIAgentConfig
```


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.cli.CliAIAgent.clock

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent/clock.html`

### :agents:agents-cli/commonMain

```kotlin
val clock: KoogClock
```


Referenced packages: `ai.koog.utils.time`.

## ai.koog.agents.cli.CliAIAgent

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent/index.html`

### :agents:agents-cli/commonMain

```kotlin
class CliAIAgent<Input, Output> : AIAgentBase<Input, Output, AIAgentCliContext>
```

Represents the core AI agent for processing input and generating output using a defined configuration, toolset, and prompt execution pipeline.

- id — Unique identifier for the agent. Random UUID will be generated if set to null.
- Input — The type of input data expected by the agent.
- Output — The type of output data produced by the agent.

Referenced packages: `ai.koog.agents.core.agent`.

## ai.koog.agents.cli.CliAIAgent.installFeatures

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent/install-features.html`

### :agents:agents-cli/commonMain

```kotlin
val installFeatures: CliAIAgent.FeatureContext.() -> Unit
```

## ai.koog.agents.cli.CliAIAgent.pipeline

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent/pipeline.html`

### :agents:agents-cli/commonMain

```kotlin
open override val pipeline: AIAgentFunctionalPipeline
```


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.cli.CliAIAgent.prepareContext

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent/prepare-context.html`

### :agents:agents-cli/commonMain

```kotlin
open suspend override fun prepareContext(agentInput: Input, runId: String, eventId: String): AIAgentCliContext
```

## ai.koog.agents.cli.CliAIAgent.strategy

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent/strategy.html`

### :agents:agents-cli/commonMain

```kotlin
open override val strategy: AIAgentCliStrategy<Input, Output>
```

## ai.koog.agents.cli.CliAIAgentBuilderBase.binaryPath

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent-builder-base/binary-path.html`

### :agents:agents-cli/commonMain

```kotlin
fun binaryPath(binaryPath: String): Self
```

Sets the CLI binary path.

## ai.koog.agents.cli.CliAIAgentBuilderBase.clock

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent-builder-base/clock.html`

### :agents:agents-cli/commonMain

```kotlin
fun clock(clock: KoogClock): Self
```

Sets the clock.


Referenced packages: `ai.koog.utils.time`.

## ai.koog.agents.cli.CliAIAgentBuilderBase.id

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent-builder-base/id.html`

### :agents:agents-cli/commonMain

```kotlin
fun id(id: String?): Self
```

Sets the agent ID.

## ai.koog.agents.cli.CliAIAgentBuilderBase

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent-builder-base/index.html`

### :agents:agents-cli/commonMain

```kotlin
abstract class CliAIAgentBuilderBase<Self : CliAIAgentBuilderBase<Self>>
```

Base class for CLI AI agent builders.

- CliAgentBuilder
- CustomCliAgentBuilder
- ClaudeAgentBuilderBase
- CodexAgentBuilderBase
## ai.koog.agents.cli.CliAIAgentBuilderBase.install

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent-builder-base/install.html`

### :agents:agents-cli/commonMain

```kotlin
fun install(installer: CliAIAgent.FeatureContext.() -> Unit): Self
```

Installs a feature.

## ai.koog.agents.cli.CliAIAgentBuilderBase.llModel

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent-builder-base/ll-model.html`

### :agents:agents-cli/commonMain

```kotlin
fun llModel(llModel: LLModel): Self
```

Sets the LLM model.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.cli.CliAIAgentBuilderBase.name

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent-builder-base/name.html`

### :agents:agents-cli/commonMain

```kotlin
fun name(name: String): Self
```

Sets the agent name.

## ai.koog.agents.cli.CliAIAgentBuilderBase.systemPrompt

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent-builder-base/system-prompt.html`

### :agents:agents-cli/commonMain

```kotlin
fun systemPrompt(systemPrompt: String): Self
```

Adds the system prompt.

## ai.koog.agents.cli.CliAIAgentBuilderBase.timeoutMin

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent-builder-base/timeout-min.html`

### :agents:agents-cli/commonMain

```kotlin
fun timeoutMin(timeoutMin: Long): Self
```

Sets the execution timeout in minutes.

## ai.koog.agents.cli.CliAIAgentBuilderBase.timeout

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent-builder-base/timeout.html`

### :agents:agents-cli/commonMain

```kotlin
fun timeout(timeout: Duration): Self
```

Sets the execution timeout.

## ai.koog.agents.cli.CliAIAgentBuilderBase.workspace

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent-builder-base/workspace.html`

### :agents:agents-cli/commonMain

```kotlin
fun workspace(workspace: String): Self
```

Sets the workspace directory.

## ai.koog.agents.cli.CliAIAgentResponse.CliAIAgentResponse

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent-response/-cli-a-i-agent-response.html`

### :agents:agents-cli/commonMain

```kotlin
constructor(content: String, isError: Boolean, metaInfo: CliAgentResponseMetaInfo)
```

## ai.koog.agents.cli.CliAIAgentResponse.content

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent-response/content.html`

### :agents:agents-cli/commonMain

```kotlin
val content: String
```

## ai.koog.agents.cli.CliAIAgentResponse

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent-response/index.html`

### :agents:agents-cli/commonMain

```kotlin
@Serializable data class CliAIAgentResponse(val content: String, val isError: Boolean, val metaInfo: CliAgentResponseMetaInfo)
```

Represents the response from a CLI agent.

## ai.koog.agents.cli.CliAIAgentResponse.isError

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent-response/is-error.html`

### :agents:agents-cli/commonMain

```kotlin
val isError: Boolean
```

## ai.koog.agents.cli.CliAIAgentResponse.metaInfo

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-a-i-agent-response/meta-info.html`

### :agents:agents-cli/commonMain

```kotlin
val metaInfo: CliAgentResponseMetaInfo
```

## ai.koog.agents.cli.CliAgentBuilder.claude

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-agent-builder/claude.html`

### :agents:agents-cli/commonMain

```kotlin
fun claude(): ClaudeAgentBuilder
```

Configures the agent to use Claude CLI.


Referenced packages: `ai.koog.agents.cli.claude`.

## ai.koog.agents.cli.CliAgentBuilder.codex

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-agent-builder/codex.html`

### :agents:agents-cli/commonMain

```kotlin
fun codex(): CodexAgentBuilder
```

Configures the agent to use Codex CLI.


Referenced packages: `ai.koog.agents.cli.codex`.

## ai.koog.agents.cli.CliAgentBuilder.custom

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-agent-builder/custom.html`

### :agents:agents-cli/commonMain

```kotlin
fun <Input, Output> custom(): CustomCliAgentBuilder<Input, Output>
```

Configures the agent with a custom CLI configuration.

## ai.koog.agents.cli.CliAgentBuilder

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-agent-builder/index.html`

### :agents:agents-cli/commonMain

```kotlin
class CliAgentBuilder : CliAIAgentBuilderBase<CliAgentBuilder>
```

Builder for CLI AI agents.

## ai.koog.agents.cli.CliAgentResponseMetaInfo.CliAgentResponseMetaInfo

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-agent-response-meta-info/-cli-agent-response-meta-info.html`

### :agents:agents-cli/commonMain

```kotlin
constructor(inputTokensCount: Int? = null, outputTokensCount: Int? = null, metadata: JsonObject? = null)
```

- inputTokensCount — The number of tokens used in the input.
- outputTokensCount — The number of tokens generated in the output.
- metadata — Free-form information associated with a response from a cli agent.
## ai.koog.agents.cli.CliAgentResponseMetaInfo

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-agent-response-meta-info/index.html`

### :agents:agents-cli/commonMain

```kotlin
@Serializable data class CliAgentResponseMetaInfo(val inputTokensCount: Int? = null, val outputTokensCount: Int? = null, val metadata: JsonObject? = null)
```

Represents the usage information from a CLI agent.

- inputTokensCount — The number of tokens used in the input.
- outputTokensCount — The number of tokens generated in the output.
- metadata — Free-form information associated with a response from a cli agent.
## ai.koog.agents.cli.CliAgentResponseMetaInfo.inputTokensCount

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-agent-response-meta-info/input-tokens-count.html`

### :agents:agents-cli/commonMain

```kotlin
val inputTokensCount: Int?
```

- inputTokensCount — The number of tokens used in the input.
## ai.koog.agents.cli.CliAgentResponseMetaInfo.metadata

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-agent-response-meta-info/metadata.html`

### :agents:agents-cli/commonMain

```kotlin
val metadata: JsonObject?
```

- metadata — Free-form information associated with a response from a cli agent.
## ai.koog.agents.cli.CliAgentResponseMetaInfo.outputTokensCount

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-agent-response-meta-info/output-tokens-count.html`

### :agents:agents-cli/commonMain

```kotlin
val outputTokensCount: Int?
```

- outputTokensCount — The number of tokens generated in the output.
## ai.koog.agents.cli.CliAgentStructuredResponse.CliAgentStructuredResponse

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-agent-structured-response/-cli-agent-structured-response.html`

### :agents:agents-cli/commonMain

```kotlin
constructor(structuredResult: T?, response: CliAIAgentResponse)
```

- T — The type of the structured data.
## ai.koog.agents.cli.CliAgentStructuredResponse

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-agent-structured-response/index.html`

### :agents:agents-cli/commonMain

```kotlin
@Serializable data class CliAgentStructuredResponse<out T>(val structuredResult: T?, val response: CliAIAgentResponse)
```

Represents a container for structured data from a CLI agent.

- T — The type of the structured data.
## ai.koog.agents.cli.CliAgentStructuredResponse.response

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-agent-structured-response/response.html`

### :agents:agents-cli/commonMain

```kotlin
val response: CliAIAgentResponse
```

## ai.koog.agents.cli.CliAgentStructuredResponse.structuredResult

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-agent-structured-response/structured-result.html`

### :agents:agents-cli/commonMain

```kotlin
val structuredResult: T?
```

## ai.koog.agents.cli.CliConfig.ExtractOutput.extractOutput

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-config/-extract-output/extract-output.html`

### :agents:agents-cli/commonMain

```kotlin
abstract fun extractOutput(events: List<CliEvent>, logger: KLogger): Output
```

Extracts the output from CLI event lines.


Referenced packages: `ai.koog.agents.cli.transport`.

## ai.koog.agents.cli.CliConfig.ExtractOutput

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-config/-extract-output/index.html`

### :agents:agents-cli/commonMain

```kotlin
fun interface ExtractOutput<Output>
```

Represents a function that extracts the output from CLI event lines.

## ai.koog.agents.cli.CliConfig.GenerateRequest.generateRequest

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-config/-generate-request/generate-request.html`

### :agents:agents-cli/commonMain

```kotlin
abstract fun generateRequest(input: Input): String
```

Generates a request string from context and input.

## ai.koog.agents.cli.CliConfig.GenerateRequest

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-config/-generate-request/index.html`

### :agents:agents-cli/commonMain

```kotlin
fun interface GenerateRequest<Input>
```

Represents a function that generates a request string from context and input.

## ai.koog.agents.cli.CliConfig.binaryPath

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-config/binary-path.html`

### :agents:agents-cli/commonMain

```kotlin
abstract val binaryPath: String
```

Path to the binary of the CLI tool.

## ai.koog.agents.cli.CliConfig.env

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-config/env.html`

### :agents:agents-cli/commonMain

```kotlin
abstract val env: Map<String, String>
```

Environment variables for command execution.

## ai.koog.agents.cli.CliConfig.extractOutput

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-config/extract-output.html`

### :agents:agents-cli/commonMain

```kotlin
abstract fun extractOutput(events: List<CliEvent>, logger: KLogger): Output
```

Extracts the output from CLI event lines.


Referenced packages: `ai.koog.agents.cli.transport`.

## ai.koog.agents.cli.CliConfig.flags

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-config/flags.html`

### :agents:agents-cli/commonMain

```kotlin
abstract fun flags(model: LLModel, systemMessages: List<Message.System>): List<String>
```

Generates command-line flags based on LLM model and system messages.


Referenced packages: `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.agents.cli.CliConfig.generateRequest

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-config/generate-request.html`

### :agents:agents-cli/commonMain

```kotlin
abstract fun generateRequest(input: Input): String
```

Generates the request string from context and input.

## ai.koog.agents.cli.CliConfig

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-config/index.html`

### :agents:agents-cli/commonMain

```kotlin
interface CliConfig<Input, Output>
```

Configuration for AIAgentCliStrategy.

- ClaudeCliStructuredConfig
- ClaudeCliConfig
- CodexCliConfig
## ai.koog.agents.cli.CliConfig.name

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-config/name.html`

### :agents:agents-cli/commonMain

```kotlin
abstract val name: String
```

Name of the CLI tool.

## ai.koog.agents.cli.CliConfig.timeout

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-config/timeout.html`

### :agents:agents-cli/commonMain

```kotlin
abstract val timeout: Duration?
```

Execution timeout.

## ai.koog.agents.cli.CliConfig.transport

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-config/transport.html`

### :agents:agents-cli/commonMain

```kotlin
abstract val transport: CliTransport
```

CLI transport for executing commands.


Referenced packages: `ai.koog.agents.cli.transport`.

## ai.koog.agents.cli.CliConfig.workspace

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-cli-config/workspace.html`

### :agents:agents-cli/commonMain

```kotlin
abstract val workspace: String
```

Working directory for command execution.

## ai.koog.agents.cli.CustomCliAgentBuilder.build

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-custom-cli-agent-builder/build.html`

### :agents:agents-cli/commonMain

```kotlin
fun build(): CliAIAgent<Input, Output>
```

Builds the custom CLI agent.

## ai.koog.agents.cli.CustomCliAgentBuilder.env

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-custom-cli-agent-builder/env.html`

### :agents:agents-cli/commonMain

```kotlin
fun env(env: Map<String, String>): CustomCliAgentBuilder<Input, Output>
```

Sets environment variables.

## ai.koog.agents.cli.CustomCliAgentBuilder.extractOutput

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-custom-cli-agent-builder/extract-output.html`

### :agents:agents-cli/commonMain

```kotlin
fun extractOutput(extractOutput: CliConfig.ExtractOutput<Output>): CustomCliAgentBuilder<Input, Output>
```

Sets the function that extracts the output from CLI event lines.

## ai.koog.agents.cli.CustomCliAgentBuilder.flags

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-custom-cli-agent-builder/flags.html`

### :agents:agents-cli/commonMain

```kotlin
fun flags(flags: (LLModel, List<Message.System>) -> List<String>): CustomCliAgentBuilder<Input, Output>
```

Sets the function that generates command-line flags.


Referenced packages: `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.agents.cli.CustomCliAgentBuilder.generateRequest

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-custom-cli-agent-builder/generate-request.html`

### :agents:agents-cli/commonMain

```kotlin
fun generateRequest(generateRequest: CliConfig.GenerateRequest<Input>): CustomCliAgentBuilder<Input, Output>
```

Sets the function that generates the request string.

## ai.koog.agents.cli.CustomCliAgentBuilder

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/-custom-cli-agent-builder/index.html`

### :agents:agents-cli/commonMain

```kotlin
class CustomCliAgentBuilder<Input, Output> : CliAIAgentBuilderBase<CustomCliAgentBuilder<Input, Output>>
```

Builder for custom CLI agent.

## ai.koog.agents.cli.asNode

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli/as-node.html`

### :agents:agents-cli/commonMain

```kotlin
inline fun <Input, Output> AIAgent<Input, Output>.asNode(name: String? = null, noinline generateSessionId: (String) -> String? = { it }): AIAgentNodeDelegate<Input, Output>
```

Generates a node that runs the AIAgent.

- name — Optional name of the node.
- generateSessionId — Lambda defining the sessionId based on the sessionId of the outer agent. Provide sessionId = { null } to generate a random sessionId on every execution of this node. Defaults to sessionId identical to the sessionId of the outer agent.

Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.dsl.builder`.

## ai.koog.agents.cli.claude.ClaudeAgentBuilder

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-agent-builder/index.html`

### :agents:agents-cli/commonMain

```kotlin
expect class ClaudeAgentBuilder : ClaudeAgentBuilderCommon<ClaudeAgentBuilder>
```

Default builder for Claude CLI agent.

### :agents:agents-cli/jvmCommonMain

```kotlin
actual class ClaudeAgentBuilder : ClaudeAgentBuilderCommon<ClaudeAgentBuilder>
```

Default builder for Claude CLI agent.

### :agents:agents-cli/nonJvmCommonMain

```kotlin
actual class ClaudeAgentBuilder : ClaudeAgentBuilderCommon<ClaudeAgentBuilder>
```

Default builder for Claude CLI agent.

## ai.koog.agents.cli.claude.ClaudeAgentBuilder.self

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-agent-builder/self.html`

### :agents:agents-cli/jvmCommonMain

```kotlin
actual open override fun self(): ClaudeAgentBuilder
```

### :agents:agents-cli/nonJvmCommonMain

```kotlin
actual open override fun self(): ClaudeAgentBuilder
```

## ai.koog.agents.cli.claude.ClaudeAgentBuilder.structure

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-agent-builder/structure.html`

### :agents:agents-cli/jvmCommonMain

```kotlin
fun <Output : Any> structure(outputClass: Class<Output>): ClaudeAgentStructuredOutputBuilder<Output>
```

Sets the structured output.

## ai.koog.agents.cli.claude.ClaudeAgentBuilderBase.additionalFlags

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-agent-builder-base/additional-flags.html`

### :agents:agents-cli/commonMain

```kotlin
fun additionalFlags(flags: List<String>): Self
```

Sets additional command-line flags to pass to Claude CLI.

This builder instance for chaining.

- flags — List of additional flags.
## ai.koog.agents.cli.claude.ClaudeAgentBuilderBase.apiKey

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-agent-builder-base/api-key.html`

### :agents:agents-cli/commonMain

```kotlin
fun apiKey(apiKey: String): Self
```

Sets the API key for Claude.

This builder instance for chaining.

- apiKey — The Anthropic API key.
## ai.koog.agents.cli.claude.ClaudeAgentBuilderBase

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-agent-builder-base/index.html`

### :agents:agents-cli/commonMain

```kotlin
abstract class ClaudeAgentBuilderBase<Input, Output, Self : ClaudeAgentBuilderBase<Input, Output, Self>> : CliAIAgentBuilderBase<Self>
```

Base class for Claude agent builders.

- ClaudeAgentStructuredOutputBuilder
- ClaudeAgentGenericInputStructuredOutputBuilder
- ClaudeAgentBuilderCommon
- ClaudeAgentGenericInputBuilderCommon

Referenced packages: `ai.koog.agents.cli`.

## ai.koog.agents.cli.claude.ClaudeAgentBuilderBase.permissionMode

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-agent-builder-base/permission-mode.html`

### :agents:agents-cli/commonMain

```kotlin
fun permissionMode(mode: ClaudePermissionMode): Self
```

Sets the permission mode for Claude CLI.

This builder instance for chaining.

- mode — The permission mode to use during agent execution.
## ai.koog.agents.cli.claude.ClaudeAgentBuilderCommon.build

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-agent-builder-common/build.html`

### :agents:agents-cli/commonMain

```kotlin
fun build(): CliAIAgent<String, CliAIAgentResponse>
```

Builds the Claude CLI agent.

A configured CliAIAgent instance that accepts String input and produces CliAIAgentResponse.


Referenced packages: `ai.koog.agents.cli`.

## ai.koog.agents.cli.claude.ClaudeAgentBuilderCommon.generateRequest

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-agent-builder-common/generate-request.html`

### :agents:agents-cli/commonMain

```kotlin
fun <Input> generateRequest(generateRequest: CliConfig.GenerateRequest<Input>): ClaudeAgentGenericInputBuilder<Input>
```

Configures a custom request generator for the agent.

Builder for Claude CLI agent with custom input type.

- generateRequest — Function to generate the request string from the input.
- Input — The type of the input data.

Referenced packages: `ai.koog.agents.cli`.

## ai.koog.agents.cli.claude.ClaudeAgentBuilderCommon

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-agent-builder-common/index.html`

### :agents:agents-cli/commonMain

```kotlin
abstract class ClaudeAgentBuilderCommon<Self : ClaudeAgentBuilderCommon<Self>> : ClaudeAgentBuilderBase<String, CliAIAgentResponse, Self>
```

Common logic for ClaudeAgentBuilder.

- ClaudeAgentBuilder

Referenced packages: `ai.koog.agents.cli`.

## ai.koog.agents.cli.claude.ClaudeAgentBuilderCommon.structure

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-agent-builder-common/structure.html`

### :agents:agents-cli/commonMain

```kotlin
fun <Output : Any> structure(outputClass: KClass<Output>): ClaudeAgentStructuredOutputBuilder<Output>
```

Configures the agent to produce structured output using the specified output class.

Builder for Claude CLI agent with structured output.

- outputClass — The Kotlin class representing the output structure.
- Output — The type of the structured output.
### :agents:agents-cli/commonMain

```kotlin
fun <Output> structure(structure: Structure<Output, LLMParams.Schema.JSON>): ClaudeAgentStructuredOutputBuilder<Output>
```

Configures the agent to produce structured output using the specified structure definition.

Builder for Claude CLI agent with structured output.

- structure — The structure definition for parsing the output.
- Output — The type of the structured output.

Referenced packages: `ai.koog.prompt.params`, `ai.koog.prompt.structure`.

## ai.koog.agents.cli.claude.ClaudeAgentGenericInputBuilder

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-agent-generic-input-builder/index.html`

### :agents:agents-cli/commonMain

```kotlin
expect class ClaudeAgentGenericInputBuilder<Input> : ClaudeAgentGenericInputBuilderCommon<Input, ClaudeAgentGenericInputBuilder<Input>>
```

Builder for Claude CLI agent with custom input type.

### :agents:agents-cli/jvmCommonMain

```kotlin
actual class ClaudeAgentGenericInputBuilder<Input> : ClaudeAgentGenericInputBuilderCommon<Input, ClaudeAgentGenericInputBuilder<Input>>
```

Builder for Claude CLI agent with custom input type.

### :agents:agents-cli/nonJvmCommonMain

```kotlin
actual class ClaudeAgentGenericInputBuilder<Input> : ClaudeAgentGenericInputBuilderCommon<Input, ClaudeAgentGenericInputBuilder<Input>>
```

Builder for Claude CLI agent with custom input type.

## ai.koog.agents.cli.claude.ClaudeAgentGenericInputBuilder.self

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-agent-generic-input-builder/self.html`

### :agents:agents-cli/jvmCommonMain

```kotlin
actual open override fun self(): ClaudeAgentGenericInputBuilder<Input>
```

### :agents:agents-cli/nonJvmCommonMain

```kotlin
actual open override fun self(): ClaudeAgentGenericInputBuilder<Input>
```

## ai.koog.agents.cli.claude.ClaudeAgentGenericInputBuilder.structure

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-agent-generic-input-builder/structure.html`

### :agents:agents-cli/jvmCommonMain

```kotlin
fun <Output : Any> structure(outputClass: Class<Output>): ClaudeAgentGenericInputStructuredOutputBuilder<Input, Output>
```

Sets the structured output.

## ai.koog.agents.cli.claude.ClaudeAgentGenericInputBuilderCommon.build

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-agent-generic-input-builder-common/build.html`

### :agents:agents-cli/commonMain

```kotlin
fun build(): CliAIAgent<Input, CliAIAgentResponse>
```

Builds the Claude CLI agent with custom input type.

A configured CliAIAgent instance that accepts custom input and produces CliAIAgentResponse.


Referenced packages: `ai.koog.agents.cli`.

## ai.koog.agents.cli.claude.ClaudeAgentGenericInputBuilderCommon

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-agent-generic-input-builder-common/index.html`

### :agents:agents-cli/commonMain

```kotlin
abstract class ClaudeAgentGenericInputBuilderCommon<Input, Self : ClaudeAgentGenericInputBuilderCommon<Input, Self>> : ClaudeAgentBuilderBase<Input, CliAIAgentResponse, Self>
```

Common logic for ClaudeAgentGenericInputBuilder.

- ClaudeAgentGenericInputBuilder

Referenced packages: `ai.koog.agents.cli`.

## ai.koog.agents.cli.claude.ClaudeAgentGenericInputBuilderCommon.structure

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-agent-generic-input-builder-common/structure.html`

### :agents:agents-cli/commonMain

```kotlin
fun <Output : Any> structure(outputClass: KClass<Output>): ClaudeAgentGenericInputStructuredOutputBuilder<Input, Output>
```

Configures the agent to produce structured output using the specified output class.

Builder for Claude CLI agent with custom input type and structured output.

- outputClass — The Kotlin class representing the output structure.
- Output — The type of the structured output.
### :agents:agents-cli/commonMain

```kotlin
fun <Output> structure(structure: Structure<Output, LLMParams.Schema.JSON>): ClaudeAgentGenericInputStructuredOutputBuilder<Input, Output>
```

Configures the agent to produce structured output using the specified structure definition.

Builder for Claude CLI agent with custom input type and structured output.

- structure — The structure definition for parsing the output.
- Output — The type of the structured output.

Referenced packages: `ai.koog.prompt.params`, `ai.koog.prompt.structure`.

## ai.koog.agents.cli.claude.ClaudeAgentGenericInputStructuredOutputBuilder.build

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-agent-generic-input-structured-output-builder/build.html`

### :agents:agents-cli/commonMain

```kotlin
fun build(): CliAIAgent<Input, CliAgentStructuredResponse<Output>>
```

Builds the Claude CLI agent with custom input type and structured output.

A configured CliAIAgent instance that accepts custom input and produces structured output.


Referenced packages: `ai.koog.agents.cli`.

## ai.koog.agents.cli.claude.ClaudeAgentGenericInputStructuredOutputBuilder

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-agent-generic-input-structured-output-builder/index.html`

### :agents:agents-cli/commonMain

```kotlin
class ClaudeAgentGenericInputStructuredOutputBuilder<Input, Output> : ClaudeAgentBuilderBase<Input, CliAgentStructuredResponse<Output>, ClaudeAgentGenericInputStructuredOutputBuilder<Input, Output>>
```

Builder for Claude CLI agent with custom input type and structured output.


Referenced packages: `ai.koog.agents.cli`.

## ai.koog.agents.cli.claude.ClaudeAgentStructuredOutputBuilder.build

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-agent-structured-output-builder/build.html`

### :agents:agents-cli/commonMain

```kotlin
fun build(): CliAIAgent<String, CliAgentStructuredResponse<Output>>
```

Builds the Claude CLI agent with structured output.

A configured CliAIAgent instance that accepts String input and produces structured output.


Referenced packages: `ai.koog.agents.cli`.

## ai.koog.agents.cli.claude.ClaudeAgentStructuredOutputBuilder.generateRequest

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-agent-structured-output-builder/generate-request.html`

### :agents:agents-cli/commonMain

```kotlin
fun <Input> generateRequest(generateRequest: CliConfig.GenerateRequest<Input>): ClaudeAgentGenericInputStructuredOutputBuilder<Input, Output>
```

Configures a custom request generator for the agent.

Builder for Claude CLI agent with custom input type and structured output.

- generateRequest — Function to generate the request string from the input.
- Input — The type of the input data.

Referenced packages: `ai.koog.agents.cli`.

## ai.koog.agents.cli.claude.ClaudeAgentStructuredOutputBuilder

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-agent-structured-output-builder/index.html`

### :agents:agents-cli/commonMain

```kotlin
class ClaudeAgentStructuredOutputBuilder<Output> : ClaudeAgentBuilderBase<String, CliAgentStructuredResponse<Output>, ClaudeAgentStructuredOutputBuilder<Output>>
```

Builder for Claude CLI agent with structured output.


Referenced packages: `ai.koog.agents.cli`.

## ai.koog.agents.cli.claude.ClaudeCliConfig.ClaudeCliConfig

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-config/-claude-cli-config.html`

### :agents:agents-cli/commonMain

```kotlin
constructor(transport: CliTransport, apiKey: String? = null, binaryPath: String? = null, name: String? = null, permissionMode: ClaudePermissionMode? = null, additionalFlags: List<String> = emptyList(), workspace: String = ".", timeout: Duration? = null, generateRequest: CliConfig.GenerateRequest<Input>)
```

- Input — The type of input the agent accepts.

Referenced packages: `ai.koog.agents.cli`, `ai.koog.agents.cli.transport`.

## ai.koog.agents.cli.claude.ClaudeCliConfig.additionalFlags

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-config/additional-flags.html`

### :agents:agents-cli/commonMain

```kotlin
val additionalFlags: List<String>
```

## ai.koog.agents.cli.claude.ClaudeCliConfig.apiKey

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-config/api-key.html`

### :agents:agents-cli/commonMain

```kotlin
val apiKey: String?
```

## ai.koog.agents.cli.claude.ClaudeCliConfig.binaryPath

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-config/binary-path.html`

### :agents:agents-cli/commonMain

```kotlin
open override val binaryPath: String
```

## ai.koog.agents.cli.claude.ClaudeCliConfig.env

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-config/env.html`

### :agents:agents-cli/commonMain

```kotlin
open override val env: Map<String, String>
```

Environment variables for command execution.

## ai.koog.agents.cli.claude.ClaudeCliConfig.extractOutput

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-config/extract-output.html`

### :agents:agents-cli/commonMain

```kotlin
open override fun extractOutput(events: List<CliEvent>, logger: KLogger): CliAIAgentResponse
```

Extracts the output from CLI event lines.


Referenced packages: `ai.koog.agents.cli`, `ai.koog.agents.cli.transport`.

## ai.koog.agents.cli.claude.ClaudeCliConfig.flags

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-config/flags.html`

### :agents:agents-cli/commonMain

```kotlin
open override fun flags(model: LLModel, systemMessages: List<Message.System>): List<String>
```

Generates command-line flags based on LLM model and system messages.


Referenced packages: `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.agents.cli.claude.ClaudeCliConfig.generateRequest

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-config/generate-request.html`

### :agents:agents-cli/commonMain

```kotlin
open override fun generateRequest(input: Input): String
```

Generates the request string from context and input.

## ai.koog.agents.cli.claude.ClaudeCliConfig

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-config/index.html`

### :agents:agents-cli/commonMain

```kotlin
class ClaudeCliConfig<Input>(val transport: CliTransport, val apiKey: String? = null, binaryPath: String? = null, name: String? = null, val permissionMode: ClaudePermissionMode? = null, val additionalFlags: List<String> = emptyList(), val workspace: String = ".", val timeout: Duration? = null, generateRequest: CliConfig.GenerateRequest<Input>) : CliConfig<Input, CliAIAgentResponse>
```

Configuration for Claude CLI agent.

- Input — The type of input the agent accepts.

Referenced packages: `ai.koog.agents.cli`, `ai.koog.agents.cli.transport`.

## ai.koog.agents.cli.claude.ClaudeCliConfig.name

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-config/name.html`

### :agents:agents-cli/commonMain

```kotlin
open override val name: String
```

## ai.koog.agents.cli.claude.ClaudeCliConfig.permissionMode

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-config/permission-mode.html`

### :agents:agents-cli/commonMain

```kotlin
val permissionMode: ClaudePermissionMode?
```

## ai.koog.agents.cli.claude.ClaudeCliConfig.timeout

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-config/timeout.html`

### :agents:agents-cli/commonMain

```kotlin
open override val timeout: Duration?
```

## ai.koog.agents.cli.claude.ClaudeCliConfig.transport

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-config/transport.html`

### :agents:agents-cli/commonMain

```kotlin
open override val transport: CliTransport
```


Referenced packages: `ai.koog.agents.cli.transport`.

## ai.koog.agents.cli.claude.ClaudeCliConfig.workspace

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-config/workspace.html`

### :agents:agents-cli/commonMain

```kotlin
open override val workspace: String
```

## ai.koog.agents.cli.claude.ClaudeCliHelper.env

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-helper/env.html`

### :agents:agents-cli/commonMain

```kotlin
fun env(apiKey: String?): Map<String, String>
```

Generates environment with provided API key.

## ai.koog.agents.cli.claude.ClaudeCliHelper.extractOutput

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-helper/extract-output.html`

### :agents:agents-cli/commonMain

```kotlin
fun extractOutput(events: List<CliEvent>, logger: KLogger): CliAIAgentResponse
```

Extracts output from Claude CLI events.


Referenced packages: `ai.koog.agents.cli`, `ai.koog.agents.cli.transport`.

## ai.koog.agents.cli.claude.ClaudeCliHelper.extractStructuredOutput

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-helper/extract-structured-output.html`

### :agents:agents-cli/commonMain

```kotlin
fun <T> extractStructuredOutput(events: List<CliEvent>, structure: Structure<T, *>, logger: KLogger): CliAgentStructuredResponse<T>
```

Extracts structured output from Claude CLI events.


Referenced packages: `ai.koog.agents.cli`, `ai.koog.agents.cli.transport`, `ai.koog.prompt.structure`.

## ai.koog.agents.cli.claude.ClaudeCliHelper.flags

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-helper/flags.html`

### :agents:agents-cli/commonMain

```kotlin
fun flags(model: LLModel, systemMessages: List<Message.System>, permissionMode: ClaudePermissionMode?, additionalFlags: List<String>): List<String>
```

Generates flags for Claude cli in autonomous mode.


Referenced packages: `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.agents.cli.claude.ClaudeCliHelper

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-helper/index.html`

### :agents:agents-cli/commonMain

```kotlin
object ClaudeCliHelper
```

Helper functions for Claude CLI agent

## ai.koog.agents.cli.claude.ClaudeCliHelper.structuredFlags

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-helper/structured-flags.html`

### :agents:agents-cli/commonMain

```kotlin
fun structuredFlags(model: LLModel, systemMessages: List<Message.System>, permissionMode: ClaudePermissionMode?, additionalFlags: List<String>, structure: Structure<*, LLMParams.Schema.JSON>): List<String>
```

Generates flags for Claude cli in structured mode.


Referenced packages: `ai.koog.prompt.llm`, `ai.koog.prompt.message`, `ai.koog.prompt.params`, `ai.koog.prompt.structure`.

## ai.koog.agents.cli.claude.ClaudeCliStructuredConfig.ClaudeCliStructuredConfig

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-structured-config/-claude-cli-structured-config.html`

### :agents:agents-cli/commonMain

```kotlin
constructor(transport: CliTransport, apiKey: String? = null, binaryPath: String? = null, name: String? = null, structure: Structure<Output, LLMParams.Schema.JSON>, permissionMode: ClaudePermissionMode? = null, additionalFlags: List<String> = emptyList(), workspace: String = ".", timeout: Duration? = null, generateRequest: CliConfig.GenerateRequest<Input>)
```

- Input — The type of input the agent accepts.
- Output — The type of structured output the agent produces.

Referenced packages: `ai.koog.agents.cli`, `ai.koog.agents.cli.transport`, `ai.koog.prompt.params`, `ai.koog.prompt.structure`.

## ai.koog.agents.cli.claude.ClaudeCliStructuredConfig.additionalFlags

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-structured-config/additional-flags.html`

### :agents:agents-cli/commonMain

```kotlin
val additionalFlags: List<String>
```

## ai.koog.agents.cli.claude.ClaudeCliStructuredConfig.apiKey

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-structured-config/api-key.html`

### :agents:agents-cli/commonMain

```kotlin
val apiKey: String?
```

## ai.koog.agents.cli.claude.ClaudeCliStructuredConfig.binaryPath

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-structured-config/binary-path.html`

### :agents:agents-cli/commonMain

```kotlin
open override val binaryPath: String
```

## ai.koog.agents.cli.claude.ClaudeCliStructuredConfig.env

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-structured-config/env.html`

### :agents:agents-cli/commonMain

```kotlin
open override val env: Map<String, String>
```

Environment variables for command execution.

## ai.koog.agents.cli.claude.ClaudeCliStructuredConfig.extractOutput

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-structured-config/extract-output.html`

### :agents:agents-cli/commonMain

```kotlin
open override fun extractOutput(events: List<CliEvent>, logger: KLogger): CliAgentStructuredResponse<Output>
```

Extracts the output from CLI event lines.


Referenced packages: `ai.koog.agents.cli`, `ai.koog.agents.cli.transport`.

## ai.koog.agents.cli.claude.ClaudeCliStructuredConfig.flags

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-structured-config/flags.html`

### :agents:agents-cli/commonMain

```kotlin
open override fun flags(model: LLModel, systemMessages: List<Message.System>): List<String>
```

Generates command-line flags based on LLM model and system messages.


Referenced packages: `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.agents.cli.claude.ClaudeCliStructuredConfig.generateRequest

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-structured-config/generate-request.html`

### :agents:agents-cli/commonMain

```kotlin
open override fun generateRequest(input: Input): String
```

Generates the request string from context and input.

## ai.koog.agents.cli.claude.ClaudeCliStructuredConfig

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-structured-config/index.html`

### :agents:agents-cli/commonMain

```kotlin
class ClaudeCliStructuredConfig<Input, Output>(val transport: CliTransport, val apiKey: String? = null, binaryPath: String? = null, name: String? = null, val structure: Structure<Output, LLMParams.Schema.JSON>, val permissionMode: ClaudePermissionMode? = null, val additionalFlags: List<String> = emptyList(), val workspace: String = ".", val timeout: Duration? = null, generateRequest: CliConfig.GenerateRequest<Input>) : CliConfig<Input, CliAgentStructuredResponse<Output>>
```

Configuration for Claude CLI agent with structured output.

- Input — The type of input the agent accepts.
- Output — The type of structured output the agent produces.

Referenced packages: `ai.koog.agents.cli`, `ai.koog.agents.cli.transport`, `ai.koog.prompt.params`, `ai.koog.prompt.structure`.

## ai.koog.agents.cli.claude.ClaudeCliStructuredConfig.name

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-structured-config/name.html`

### :agents:agents-cli/commonMain

```kotlin
open override val name: String
```

## ai.koog.agents.cli.claude.ClaudeCliStructuredConfig.permissionMode

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-structured-config/permission-mode.html`

### :agents:agents-cli/commonMain

```kotlin
val permissionMode: ClaudePermissionMode?
```

## ai.koog.agents.cli.claude.ClaudeCliStructuredConfig.structure

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-structured-config/structure.html`

### :agents:agents-cli/commonMain

```kotlin
val structure: Structure<Output, LLMParams.Schema.JSON>
```


Referenced packages: `ai.koog.prompt.params`, `ai.koog.prompt.structure`.

## ai.koog.agents.cli.claude.ClaudeCliStructuredConfig.timeout

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-structured-config/timeout.html`

### :agents:agents-cli/commonMain

```kotlin
open override val timeout: Duration?
```

## ai.koog.agents.cli.claude.ClaudeCliStructuredConfig.transport

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-structured-config/transport.html`

### :agents:agents-cli/commonMain

```kotlin
open override val transport: CliTransport
```


Referenced packages: `ai.koog.agents.cli.transport`.

## ai.koog.agents.cli.claude.ClaudeCliStructuredConfig.workspace

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-cli-structured-config/workspace.html`

### :agents:agents-cli/commonMain

```kotlin
open override val workspace: String
```

## ai.koog.agents.cli.claude.ClaudePermissionMode.AcceptEdits

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-permission-mode/-accept-edits/index.html`

### :agents:agents-cli/commonMain

```kotlin
AcceptEdits
```

Automatically accept all edits.

## ai.koog.agents.cli.claude.ClaudePermissionMode.Auto

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-permission-mode/-auto/index.html`

### :agents:agents-cli/commonMain

```kotlin
Auto
```

Auto mode: automatically accept all edits and plan actions.

## ai.koog.agents.cli.claude.ClaudePermissionMode.BypassPermissions

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-permission-mode/-bypass-permissions/index.html`

### :agents:agents-cli/commonMain

```kotlin
BypassPermissions
```

Bypass all permission checks.

## ai.koog.agents.cli.claude.ClaudePermissionMode.Default

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-permission-mode/-default/index.html`

### :agents:agents-cli/commonMain

```kotlin
Default
```

Default permission mode.

## ai.koog.agents.cli.claude.ClaudePermissionMode.DontAsk

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-permission-mode/-dont-ask/index.html`

### :agents:agents-cli/commonMain

```kotlin
DontAsk
```

Do not ask for permissions.

## ai.koog.agents.cli.claude.ClaudePermissionMode.Plan

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-permission-mode/-plan/index.html`

### :agents:agents-cli/commonMain

```kotlin
Plan
```

Plan mode: only show planned actions without executing them.

## ai.koog.agents.cli.claude.ClaudePermissionMode.entries

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-permission-mode/entries.html`

### :agents:agents-cli/commonMain

```kotlin
val entries: EnumEntries<ClaudePermissionMode>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.agents.cli.claude.ClaudePermissionMode

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-permission-mode/index.html`

### :agents:agents-cli/commonMain

```kotlin
enum ClaudePermissionMode : Enum<ClaudePermissionMode>
```

Claude Code permission mode.

## ai.koog.agents.cli.claude.ClaudePermissionMode.valueOf

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-permission-mode/value-of.html`

### :agents:agents-cli/commonMain

```kotlin
fun valueOf(value: String): ClaudePermissionMode
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.agents.cli.claude.ClaudePermissionMode.value

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-permission-mode/value.html`

### :agents:agents-cli/commonMain

```kotlin
val value: String
```

## ai.koog.agents.cli.claude.ClaudePermissionMode.values

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.claude/-claude-permission-mode/values.html`

### :agents:agents-cli/commonMain

```kotlin
fun values(): Array<ClaudePermissionMode>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.agents.cli.codex.CodexAgentBuilder.build

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-agent-builder/build.html`

### :agents:agents-cli/commonMain

```kotlin
fun build(): CliAIAgent<String, CliAIAgentResponse>
```

Builds the Codex CLI agent.

A configured CliAIAgent instance that accepts String input and produces CliAIAgentResponse.


Referenced packages: `ai.koog.agents.cli`.

## ai.koog.agents.cli.codex.CodexAgentBuilder.generateRequest

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-agent-builder/generate-request.html`

### :agents:agents-cli/commonMain

```kotlin
fun <Input> generateRequest(generateRequest: CliConfig.GenerateRequest<Input>): CodexAgentGenericInputBuilder<Input>
```

Configures a custom request generator for the agent.


Referenced packages: `ai.koog.agents.cli`.

## ai.koog.agents.cli.codex.CodexAgentBuilder

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-agent-builder/index.html`

### :agents:agents-cli/commonMain

```kotlin
class CodexAgentBuilder : CodexAgentBuilderBase<String, CodexAgentBuilder>
```

Default builder for Codex CLI agent.

## ai.koog.agents.cli.codex.CodexAgentBuilderBase.additionalFlags

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-agent-builder-base/additional-flags.html`

### :agents:agents-cli/commonMain

```kotlin
fun additionalFlags(flags: List<String>): Self
```

Sets additional flags.

## ai.koog.agents.cli.codex.CodexAgentBuilderBase.apiKey

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-agent-builder-base/api-key.html`

### :agents:agents-cli/commonMain

```kotlin
fun apiKey(apiKey: String?): Self
```

Sets the API key.

## ai.koog.agents.cli.codex.CodexAgentBuilderBase.askForApproval

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-agent-builder-base/ask-for-approval.html`

### :agents:agents-cli/commonMain

```kotlin
fun askForApproval(policy: CodexApprovalPolicy): Self
```

Sets the approval policy.

## ai.koog.agents.cli.codex.CodexAgentBuilderBase

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-agent-builder-base/index.html`

### :agents:agents-cli/commonMain

```kotlin
abstract class CodexAgentBuilderBase<Input, Self : CodexAgentBuilderBase<Input, Self>> : CliAIAgentBuilderBase<Self>
```

Base class for Codex agent builders.

- CodexAgentBuilder
- CodexAgentGenericInputBuilder

Referenced packages: `ai.koog.agents.cli`.

## ai.koog.agents.cli.codex.CodexAgentBuilderBase.sandbox

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-agent-builder-base/sandbox.html`

### :agents:agents-cli/commonMain

```kotlin
fun sandbox(sandbox: CodexSandboxMode): Self
```

Sets the sandbox mode.

## ai.koog.agents.cli.codex.CodexAgentGenericInputBuilder.build

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-agent-generic-input-builder/build.html`

### :agents:agents-cli/commonMain

```kotlin
fun build(): CliAIAgent<Input, CliAIAgentResponse>
```

Builds the Codex CLI agent with custom input type.

A configured CliAIAgent instance that accepts custom input and produces CliAIAgentResponse.


Referenced packages: `ai.koog.agents.cli`.

## ai.koog.agents.cli.codex.CodexAgentGenericInputBuilder

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-agent-generic-input-builder/index.html`

### :agents:agents-cli/commonMain

```kotlin
class CodexAgentGenericInputBuilder<Input> : CodexAgentBuilderBase<Input, CodexAgentGenericInputBuilder<Input>>
```

Generic builder for Codex CLI agent with custom input type.

## ai.koog.agents.cli.codex.CodexApprovalPolicy.Never

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-approval-policy/-never/index.html`

### :agents:agents-cli/commonMain

```kotlin
Never
```

Never ask for approval.

## ai.koog.agents.cli.codex.CodexApprovalPolicy.OnFailure

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-approval-policy/-on-failure/index.html`

### :agents:agents-cli/commonMain

```kotlin
OnFailure
```

Ask for approval only if a command fails.

## ai.koog.agents.cli.codex.CodexApprovalPolicy.OnRequest

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-approval-policy/-on-request/index.html`

### :agents:agents-cli/commonMain

```kotlin
OnRequest
```

The model decides when to ask for approval.

## ai.koog.agents.cli.codex.CodexApprovalPolicy.Untrusted

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-approval-policy/-untrusted/index.html`

### :agents:agents-cli/commonMain

```kotlin
Untrusted
```

Ask for approval for all untrusted commands.

## ai.koog.agents.cli.codex.CodexApprovalPolicy.entries

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-approval-policy/entries.html`

### :agents:agents-cli/commonMain

```kotlin
val entries: EnumEntries<CodexApprovalPolicy>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.agents.cli.codex.CodexApprovalPolicy

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-approval-policy/index.html`

### :agents:agents-cli/commonMain

```kotlin
enum CodexApprovalPolicy : Enum<CodexApprovalPolicy>
```

Codex approval policy.

## ai.koog.agents.cli.codex.CodexApprovalPolicy.valueOf

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-approval-policy/value-of.html`

### :agents:agents-cli/commonMain

```kotlin
fun valueOf(value: String): CodexApprovalPolicy
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.agents.cli.codex.CodexApprovalPolicy.value

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-approval-policy/value.html`

### :agents:agents-cli/commonMain

```kotlin
val value: String
```

## ai.koog.agents.cli.codex.CodexApprovalPolicy.values

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-approval-policy/values.html`

### :agents:agents-cli/commonMain

```kotlin
fun values(): Array<CodexApprovalPolicy>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.agents.cli.codex.CodexCliConfig.CodexCliConfig

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-cli-config/-codex-cli-config.html`

### :agents:agents-cli/commonMain

```kotlin
constructor(transport: CliTransport, apiKey: String? = null, binaryPath: String? = null, name: String? = null, sandbox: CodexSandboxMode? = null, askForApproval: CodexApprovalPolicy? = null, additionalFlags: List<String> = emptyList(), workspace: String = ".", timeout: Duration? = null, generateRequest: CliConfig.GenerateRequest<Input>)
```

- Input — The type of input the agent accepts.

Referenced packages: `ai.koog.agents.cli`, `ai.koog.agents.cli.transport`.

## ai.koog.agents.cli.codex.CodexCliConfig.additionalFlags

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-cli-config/additional-flags.html`

### :agents:agents-cli/commonMain

```kotlin
val additionalFlags: List<String>
```

## ai.koog.agents.cli.codex.CodexCliConfig.apiKey

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-cli-config/api-key.html`

### :agents:agents-cli/commonMain

```kotlin
val apiKey: String?
```

## ai.koog.agents.cli.codex.CodexCliConfig.askForApproval

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-cli-config/ask-for-approval.html`

### :agents:agents-cli/commonMain

```kotlin
val askForApproval: CodexApprovalPolicy?
```

## ai.koog.agents.cli.codex.CodexCliConfig.binaryPath

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-cli-config/binary-path.html`

### :agents:agents-cli/commonMain

```kotlin
open override val binaryPath: String
```

Path to the binary of the CLI tool.

## ai.koog.agents.cli.codex.CodexCliConfig.env

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-cli-config/env.html`

### :agents:agents-cli/commonMain

```kotlin
open override val env: Map<String, String>
```

Environment variables for command execution.

## ai.koog.agents.cli.codex.CodexCliConfig.extractOutput

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-cli-config/extract-output.html`

### :agents:agents-cli/commonMain

```kotlin
open override fun extractOutput(events: List<CliEvent>, logger: KLogger): CliAIAgentResponse
```

Extracts the output from CLI event lines.


Referenced packages: `ai.koog.agents.cli`, `ai.koog.agents.cli.transport`.

## ai.koog.agents.cli.codex.CodexCliConfig.flags

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-cli-config/flags.html`

### :agents:agents-cli/commonMain

```kotlin
open override fun flags(model: LLModel, systemMessages: List<Message.System>): List<String>
```

Generates command-line flags based on LLM model and system messages.


Referenced packages: `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.agents.cli.codex.CodexCliConfig.generateRequest

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-cli-config/generate-request.html`

### :agents:agents-cli/commonMain

```kotlin
open override fun generateRequest(input: Input): String
```

Generates the request string from context and input.

## ai.koog.agents.cli.codex.CodexCliConfig

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-cli-config/index.html`

### :agents:agents-cli/commonMain

```kotlin
class CodexCliConfig<Input>(val transport: CliTransport, val apiKey: String? = null, binaryPath: String? = null, name: String? = null, val sandbox: CodexSandboxMode? = null, val askForApproval: CodexApprovalPolicy? = null, val additionalFlags: List<String> = emptyList(), val workspace: String = ".", val timeout: Duration? = null, generateRequest: CliConfig.GenerateRequest<Input>) : CliConfig<Input, CliAIAgentResponse>
```

Configuration for Codex CLI agent.

- Input — The type of input the agent accepts.

Referenced packages: `ai.koog.agents.cli`, `ai.koog.agents.cli.transport`.

## ai.koog.agents.cli.codex.CodexCliConfig.name

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-cli-config/name.html`

### :agents:agents-cli/commonMain

```kotlin
open override val name: String
```

Name of the CLI tool.

## ai.koog.agents.cli.codex.CodexCliConfig.sandbox

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-cli-config/sandbox.html`

### :agents:agents-cli/commonMain

```kotlin
val sandbox: CodexSandboxMode?
```

## ai.koog.agents.cli.codex.CodexCliConfig.timeout

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-cli-config/timeout.html`

### :agents:agents-cli/commonMain

```kotlin
open override val timeout: Duration?
```

## ai.koog.agents.cli.codex.CodexCliConfig.transport

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-cli-config/transport.html`

### :agents:agents-cli/commonMain

```kotlin
open override val transport: CliTransport
```


Referenced packages: `ai.koog.agents.cli.transport`.

## ai.koog.agents.cli.codex.CodexCliConfig.workspace

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-cli-config/workspace.html`

### :agents:agents-cli/commonMain

```kotlin
open override val workspace: String
```

## ai.koog.agents.cli.codex.CodexSandboxMode.DangerFullAccess

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-sandbox-mode/-danger-full-access/index.html`

### :agents:agents-cli/commonMain

```kotlin
DangerFullAccess
```

Full access to the system.

## ai.koog.agents.cli.codex.CodexSandboxMode.ReadOnly

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-sandbox-mode/-read-only/index.html`

### :agents:agents-cli/commonMain

```kotlin
ReadOnly
```

Read-only access to the filesystem.

## ai.koog.agents.cli.codex.CodexSandboxMode.WorkspaceWrite

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-sandbox-mode/-workspace-write/index.html`

### :agents:agents-cli/commonMain

```kotlin
WorkspaceWrite
```

Write access to the workspace directory.

## ai.koog.agents.cli.codex.CodexSandboxMode.entries

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-sandbox-mode/entries.html`

### :agents:agents-cli/commonMain

```kotlin
val entries: EnumEntries<CodexSandboxMode>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.agents.cli.codex.CodexSandboxMode

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-sandbox-mode/index.html`

### :agents:agents-cli/commonMain

```kotlin
enum CodexSandboxMode : Enum<CodexSandboxMode>
```

Codex sandbox mode.

## ai.koog.agents.cli.codex.CodexSandboxMode.valueOf

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-sandbox-mode/value-of.html`

### :agents:agents-cli/commonMain

```kotlin
fun valueOf(value: String): CodexSandboxMode
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.agents.cli.codex.CodexSandboxMode.value

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-sandbox-mode/value.html`

### :agents:agents-cli/commonMain

```kotlin
val value: String
```

## ai.koog.agents.cli.codex.CodexSandboxMode.values

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.codex/-codex-sandbox-mode/values.html`

### :agents:agents-cli/commonMain

```kotlin
fun values(): Array<CodexSandboxMode>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.agents.cli.transport.CliAvailability

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-availability/index.html`

### :agents:agents-cli/commonMain

```kotlin
sealed interface CliAvailability
```

Represents the availability of a Cli tool.

- CliAvailable
- CliUnavailable
## ai.koog.agents.cli.transport.CliAvailable

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-available/index.html`

### :agents:agents-cli/commonMain

```kotlin
object CliAvailable : CliAvailability
```

Indicates that the tool is available.

## ai.koog.agents.cli.transport.CliEvent.Exit.Exit

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-event/-exit/-exit.html`

### :agents:agents-cli/commonMain

```kotlin
constructor(code: Int)
```

## ai.koog.agents.cli.transport.CliEvent.Exit.code

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-event/-exit/code.html`

### :agents:agents-cli/commonMain

```kotlin
val code: Int
```

## ai.koog.agents.cli.transport.CliEvent.Exit

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-event/-exit/index.html`

### :agents:agents-cli/commonMain

```kotlin
data class Exit(val code: Int) : CliEvent
```

Reports the exit status of the CLI execution.

## ai.koog.agents.cli.transport.CliEvent.Failed.Failed

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-event/-failed/-failed.html`

### :agents:agents-cli/commonMain

```kotlin
constructor(message: String)
```

## ai.koog.agents.cli.transport.CliEvent.Failed

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-event/-failed/index.html`

### :agents:agents-cli/commonMain

```kotlin
data class Failed(val message: String) : CliEvent
```

Reports a failure during cli execution.

## ai.koog.agents.cli.transport.CliEvent.Failed.message

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-event/-failed/message.html`

### :agents:agents-cli/commonMain

```kotlin
val message: String
```

## ai.koog.agents.cli.transport.CliEvent.Line.content

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-event/-line/content.html`

### :agents:agents-cli/commonMain

```kotlin
abstract val content: String
```

Content of the line.

## ai.koog.agents.cli.transport.CliEvent.Line

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-event/-line/index.html`

### :agents:agents-cli/commonMain

```kotlin
sealed interface Line : CliEvent
```

Regular line of text output from the CLI.

- Stdout
- Stderr
## ai.koog.agents.cli.transport.CliEvent.Stderr.Stderr

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-event/-stderr/-stderr.html`

### :agents:agents-cli/commonMain

```kotlin
constructor(content: String)
```

## ai.koog.agents.cli.transport.CliEvent.Stderr.content

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-event/-stderr/content.html`

### :agents:agents-cli/commonMain

```kotlin
open override val content: String
```

Content of the line.

## ai.koog.agents.cli.transport.CliEvent.Stderr

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-event/-stderr/index.html`

### :agents:agents-cli/commonMain

```kotlin
data class Stderr(val content: String) : CliEvent.Line
```

Reports a line from stderr

## ai.koog.agents.cli.transport.CliEvent.Stdout.Stdout

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-event/-stdout/-stdout.html`

### :agents:agents-cli/commonMain

```kotlin
constructor(content: String)
```

## ai.koog.agents.cli.transport.CliEvent.Stdout.content

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-event/-stdout/content.html`

### :agents:agents-cli/commonMain

```kotlin
open override val content: String
```

Content of the line.

## ai.koog.agents.cli.transport.CliEvent.Stdout

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-event/-stdout/index.html`

### :agents:agents-cli/commonMain

```kotlin
data class Stdout(val content: String) : CliEvent.Line
```

Reports a line from stdout

## ai.koog.agents.cli.transport.CliEvent

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-event/index.html`

### :agents:agents-cli/commonMain

```kotlin
sealed interface CliEvent
```

Events reporting signals from a running cli tool.

- Line
- Exit
- Failed
## ai.koog.agents.cli.transport.CliException.CliException

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-exception/-cli-exception.html`

### :agents:agents-cli/commonMain

```kotlin
constructor(message: String, cause: Throwable? = null)
```

## ai.koog.agents.cli.transport.CliException

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-exception/index.html`

### :agents:agents-cli/commonMain

```kotlin
open class CliException(message: String, cause: Throwable? = null) : Exception
```

Base class for cli-agent-related exceptions.

- CliNotFoundException
- CliTimeoutException
## ai.koog.agents.cli.transport.CliNotFoundException.CliNotFoundException

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-not-found-exception/-cli-not-found-exception.html`

### :agents:agents-cli/commonMain

```kotlin
constructor(message: String, cause: Throwable? = null)
```

## ai.koog.agents.cli.transport.CliNotFoundException

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-not-found-exception/index.html`

### :agents:agents-cli/commonMain

```kotlin
class CliNotFoundException(message: String, cause: Throwable? = null) : CliException
```

Exception indicating that a CLI agent binary was not found.

## ai.koog.agents.cli.transport.CliTimeoutException.CliTimeoutException

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-timeout-exception/-cli-timeout-exception.html`

### :agents:agents-cli/commonMain

```kotlin
constructor(timeout: Duration)
```

## ai.koog.agents.cli.transport.CliTimeoutException

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-timeout-exception/index.html`

### :agents:agents-cli/commonMain

```kotlin
class CliTimeoutException(val timeout: Duration) : CliException
```

Exception indicating that a CLI agent run timed out.

## ai.koog.agents.cli.transport.CliTimeoutException.timeout

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-timeout-exception/timeout.html`

### :agents:agents-cli/commonMain

```kotlin
val timeout: Duration
```

## ai.koog.agents.cli.transport.CliTransport.Companion.default

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-transport/-companion/default.html`

### :agents:agents-cli/jvmCommonMain

```kotlin
fun default(): CliTransport
```

Default implementation of ProcessTransport using a ProcessBuilder to spawn a new process in available shell.

## ai.koog.agents.cli.transport.CliTransport.Companion

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-transport/-companion/index.html`

### :agents:agents-cli/jvmCommonMain

```kotlin
object Companion
```

Companion object defining factory methods for CliTransport implementations.

## ai.koog.agents.cli.transport.CliTransport.Companion.withDocker

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-transport/-companion/with-docker.html`

### :agents:agents-cli/jvmCommonMain

```kotlin
fun withDocker(imageName: String, volumes: List<DockerVolume> = emptyList()): CliTransport
```

Creates an instance of CliTransport spawning a docker process with the specified image and optional volumes and executing the provided command in the container.

## ai.koog.agents.cli.transport.CliTransport.Companion.withLocalProcess

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-transport/-companion/with-local-process.html`

### :agents:agents-cli/jvmCommonMain

```kotlin
fun withLocalProcess(): CliTransport
```

Creates an instance of CliTransport that uses a local process via the ProcessBuilder to execute the command.

## ai.koog.agents.cli.transport.CliTransport.LocalProcess

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-transport/-local-process/index.html`

### :agents:agents-cli/jvmCommonMain

```kotlin
object LocalProcess : ProcessCliTransport
```

Default implementation of ProcessCliTransport using a ProcessBuilder to spawn a new process in available shell.

## ai.koog.agents.cli.transport.CliTransport.checkAvailability

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-transport/check-availability.html`

### :agents:agents-cli/commonMain

```kotlin
expect abstract suspend fun checkAvailability(binaryPath: String, workspace: String, timeout: Duration? = null): CliAvailability
```

Checks if the cli is available at the specified path.

- binaryPath — The path to the cli binary.
- workspace — The workspace directory where the cli will be executed.
- timeout — The maximum duration to wait for the cli availability check.
### :agents:agents-cli/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
actual abstract suspend fun checkAvailability(binaryPath: String, workspace: String, timeout: ERROR CLASS: Symbol not found for Duration??): CliAvailability
```

Checks if the cli is available at the specified path.

- binaryPath — The path to the cli binary.
- workspace — The workspace directory where the cli will be executed.
- timeout — The maximum duration to wait for the cli availability check.
### :agents:agents-cli/nonJvmCommonMain

```kotlin
actual abstract suspend fun checkAvailability(binaryPath: String, workspace: String, timeout: Duration?): CliAvailability
```

Checks if the cli is available at the specified path.

- binaryPath — The path to the cli binary.
- workspace — The workspace directory where the cli will be executed.
- timeout — The maximum duration to wait for the cli availability check.
## ai.koog.agents.cli.transport.CliTransport.execute

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-transport/execute.html`

### :agents:agents-cli/commonMain

```kotlin
expect abstract fun execute(command: List<String>, workspace: String, env: Map<String, String> = emptyMap(), timeout: Duration? = null): Flow<CliEvent>
```

Executes the cli command and returns a Flow of AgentEvents.

- command — The command to execute.
- workspace — The workspace directory where the cli will be executed.
- env — The environment variables to set for the cli process.
- timeout — The maximum duration to wait for the cli process to complete.
### :agents:agents-cli/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
actual abstract fun execute(command: List<String>, workspace: String, env: Map<String, String>, timeout: ERROR CLASS: Symbol not found for Duration??): ERROR CLASS: Symbol not found for Flow<ai/koog/agents/cli/transport/CliEvent>
```

Executes the cli command and returns a Flow of AgentEvents.

- command — The command to execute.
- workspace — The workspace directory where the cli will be executed.
- env — The environment variables to set for the cli process.
- timeout — The maximum duration to wait for the cli process to complete.
### :agents:agents-cli/nonJvmCommonMain

```kotlin
actual abstract fun execute(command: List<String>, workspace: String, env: Map<String, String>, timeout: Duration?): Flow<CliEvent>
```

Executes the cli command and returns a Flow of AgentEvents.

- command — The command to execute.
- workspace — The workspace directory where the cli will be executed.
- env — The environment variables to set for the cli process.
- timeout — The maximum duration to wait for the cli process to complete.
## ai.koog.agents.cli.transport.CliTransport

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-transport/index.html`

### :agents:agents-cli/commonMain

```kotlin
expect interface CliTransport
```

Interface for cli transport implementations.

### :agents:agents-cli/jvmCommonMain

```kotlin
actual interface CliTransport
```

Interface for running cli tools.

- ProcessCliTransport
### :agents:agents-cli/nonJvmCommonMain

```kotlin
actual interface CliTransport
```

Interface for cli transport implementations.

## ai.koog.agents.cli.transport.CliUnavailable.CliUnavailable

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-unavailable/-cli-unavailable.html`

### :agents:agents-cli/commonMain

```kotlin
constructor(reason: String? = null, cause: Throwable? = null)
```

## ai.koog.agents.cli.transport.CliUnavailable.cause

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-unavailable/cause.html`

### :agents:agents-cli/commonMain

```kotlin
val cause: Throwable?
```

## ai.koog.agents.cli.transport.CliUnavailable

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-unavailable/index.html`

### :agents:agents-cli/commonMain

```kotlin
class CliUnavailable(val reason: String? = null, val cause: Throwable? = null) : CliAvailability
```

Indicates that the tool is unavailable.

## ai.koog.agents.cli.transport.CliUnavailable.reason

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-cli-unavailable/reason.html`

### :agents:agents-cli/commonMain

```kotlin
val reason: String?
```

## ai.koog.agents.cli.transport.DockerCliTransport.DockerCliTransport

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-docker-cli-transport/-docker-cli-transport.html`

### :agents:agents-cli/jvmCommonMain

```kotlin
constructor(imageName: String, volumes: List<DockerVolume> = emptyList(), dockerPath: String? = null)
```

## ai.koog.agents.cli.transport.DockerCliTransport.checkAvailability

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-docker-cli-transport/check-availability.html`

### :agents:agents-cli/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
open suspend override fun checkAvailability(binaryPath: String, workspace: String, timeout: ERROR CLASS: Symbol not found for Duration??): CliAvailability
```

Checks if the cli is available at the specified path.

- binaryPath — The path to the cli binary.
- workspace — The workspace directory where the cli will be executed.
- timeout — The maximum duration to wait for the cli availability check.
## ai.koog.agents.cli.transport.DockerCliTransport

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-docker-cli-transport/index.html`

### :agents:agents-cli/jvmCommonMain

```kotlin
class DockerCliTransport(imageName: String, volumes: List<DockerVolume> = emptyList(), dockerPath: String? = null) : ProcessCliTransport
```

Executes CLI commands inside a Docker container.

## ai.koog.agents.cli.transport.DockerVolume.DockerVolume

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-docker-volume/-docker-volume.html`

### :agents:agents-cli/jvmCommonMain

```kotlin
constructor(hostPath: File, containerPath: String, readOnly: Boolean = false)
```

## ai.koog.agents.cli.transport.DockerVolume.containerPath

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-docker-volume/container-path.html`

### :agents:agents-cli/jvmCommonMain

```kotlin
val containerPath: String
```

## ai.koog.agents.cli.transport.DockerVolume.hostPath

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-docker-volume/host-path.html`

### :agents:agents-cli/jvmCommonMain

```kotlin
val hostPath: File
```

## ai.koog.agents.cli.transport.DockerVolume

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-docker-volume/index.html`

### :agents:agents-cli/jvmCommonMain

```kotlin
class DockerVolume(val hostPath: File, val containerPath: String, val readOnly: Boolean = false)
```

A volume mapping for Docker.

## ai.koog.agents.cli.transport.DockerVolume.readOnly

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-docker-volume/read-only.html`

### :agents:agents-cli/jvmCommonMain

```kotlin
val readOnly: Boolean
```

## ai.koog.agents.cli.transport.DockerVolume.toMountArg

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-docker-volume/to-mount-arg.html`

### :agents:agents-cli/jvmCommonMain

```kotlin
fun toMountArg(): String
```

Converts the volume mapping to a Docker mount argument string.

A string in the format "type=bind,source=,target=,readonly".

## ai.koog.agents.cli.transport.ProcessCliTransport.ProcessCliTransport

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-process-cli-transport/-process-cli-transport.html`

### :agents:agents-cli/jvmCommonMain

```kotlin
constructor()
```

## ai.koog.agents.cli.transport.ProcessCliTransport.checkAvailability

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-process-cli-transport/check-availability.html`

### :agents:agents-cli/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
open suspend override fun checkAvailability(binaryPath: String, workspace: String, timeout: ERROR CLASS: Symbol not found for Duration??): CliAvailability
```

Checks if the cli is available at the specified path.

- binaryPath — The path to the cli binary.
- workspace — The workspace directory where the cli will be executed.
- timeout — The maximum duration to wait for the cli availability check.
## ai.koog.agents.cli.transport.ProcessCliTransport.execute

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-process-cli-transport/execute.html`

### :agents:agents-cli/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
open override fun execute(command: List<String>, workspace: String, env: Map<String, String>, timeout: ERROR CLASS: Symbol not found for Duration??): ERROR CLASS: Symbol not found for Flow<ai/koog/agents/cli/transport/CliEvent>
```

Executes the cli command and returns a Flow of AgentEvents.

- command — The command to execute.
- workspace — The workspace directory where the cli will be executed.
- env — The environment variables to set for the cli process.
- timeout — The maximum duration to wait for the cli process to complete.
## ai.koog.agents.cli.transport.ProcessCliTransport

Module: `agents-cli`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-cli/ai.koog.agents.cli.transport/-process-cli-transport/index.html`

### :agents:agents-cli/jvmCommonMain

```kotlin
abstract class ProcessCliTransport : CliTransport
```

Base class for transports that execute a local Process.

- DockerCliTransport
- LocalProcess