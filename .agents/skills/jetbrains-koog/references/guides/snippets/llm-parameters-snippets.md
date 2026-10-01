> Retained Kotlin guide from JetBrains/Koog, version family 1.3.0 / 1.3.0-beta. See [source caveats](../../version-and-migration.md) before adapting snippets.

## heading
|Parameter|Type| Description |
|---------|----|-------------|
## topP
| `topP` | Double | Also referred to as nucleus sampling. Creates a subset of next tokens by adding tokens with the highest probability values to the subset until the sum of their probabilities reaches the specified `topP` value. Takes a value greater than 0.0 and lower than or equal to 1.0. |
## logprobs
| `logprobs` | Boolean | If `true`, includes log-probabilities for output tokens. |
## topLogprobs
| `topLogprobs` | Integer | Number of top most likely tokens per position. Takes a value in the range of 0–20. Requires the `logprobs` parameter to be set to `true`. |
## frequencyPenalty
| `frequencyPenalty` | Double | Penalizes frequent tokens to reduce repetition. Higher `frequencyPenalty` values result in larger variations of phrasing and reduced repetition. Takes a value in the range of -2.0 to 2.0. |
## presencePenalty
| `presencePenalty` | Double | Prevents the model from reusing tokens that have already been included in the output. Higher values encourage the introduction of new tokens and topics. Takes a value in the range of -2.0 to 2.0. |
## stop
| `stop` | List&lt;String&gt; | Strings that signal to the model that it should stop generating content when it encounters any of them. For example, to make the model stop generating content when it produces two newlines, specify the stop sequence as `stop = listOf("/n/n")`. |
## parallelToolCalls
| `parallelToolCalls` | Boolean | If `true`, multiple tool calls can run in parallel. Particularly applicable to custom nodes or LLM interactions outside of agent strategies. |
## promptCacheKey
| `promptCacheKey` | String | Stable cache key for prompt caching. OpenAI uses it to cache responses for similar requests. |
## safetyIdentifier
| `safetyIdentifier` | String | A stable and unique user identifier that may be used to detect users who violate OpenAI policies. |
## serviceTier
| `serviceTier` | ServiceTier | OpenAI processing tier selection that lets you prioritize performance over cost or vice versa. For more information, see the API documentation for [ServiceTier](../../api/extended/prompt--prompt-executor--prompt-executor-clients--prompt-executor-openai-client-base.md#aikoogpromptexecutorclientsopenaibasemodelsservicetier). |
## store
| `store` | Boolean | If `true`, the provider may store outputs for later retrieval. |
## audio
| `audio` | OpenAIAudioConfig | Audio output configuration when using audio-capable models. For more information, see the API documentation for [OpenAIAudioConfig](../../api/extended/prompt--prompt-executor--prompt-executor-clients--prompt-executor-openai-client-base.md#aikoogpromptexecutorclientsopenaibasemodelsopenaiaudioconfig). |
## reasoningEffort
| `reasoningEffort` | ReasoningEffort | Specifies the level of reasoning effort that the model will use. For more information and available values, see the API documentation for [ReasoningEffort](../../api/extended/prompt--prompt-executor--prompt-executor-clients--prompt-executor-openai-client-base.md#aikoogpromptexecutorclientsopenaibasemodelsreasoningeffort). |
## webSearchOptions
| `webSearchOptions` | OpenAIWebSearchOptions | Configure web search tool usage (if supported). For more information, see the API documentation for [OpenAIWebSearchOptions](../../api/extended/prompt--prompt-executor--prompt-executor-clients--prompt-executor-openai-client-base.md#aikoogpromptexecutorclientsopenaibasemodelsopenaiwebsearchoptions). |
## background
| `background` | Boolean | Run the response in the background. |
## include
| `include` | List&lt;OpenAIInclude&gt; | Additional data to include in the model's response, such as sources of web search tool call or search results of a file search tool call. For detailed reference information, see [OpenAIInclude](../../api/extended/prompt--prompt-executor--prompt-executor-clients--prompt-executor-openai-client.md#aikoogpromptexecutorclientsopenaimodelsopenaiinclude) in the Koog API reference. To learn more about the `include` parameter, see [OpenAI's documentation](https://platform.openai.com/docs/api-reference/responses/create#responses-create-include). |
## maxToolCalls
| `maxToolCalls` | Integer | Maximum total number of built-in tool calls allowed in this response. Takes a value equal to or greater than `0`. |
## reasoning
| `reasoning` | ReasoningConfig | Reasoning configuration for reasoning-capable models. For more information, see the API documentation for [ReasoningConfig](../../api/extended/prompt--prompt-executor--prompt-executor-clients--prompt-executor-openai-client.md#aikoogpromptexecutorclientsopenaimodelsreasoningconfig). |
## truncation
| `truncation` | Truncation | Truncation strategy when nearing the context window. For more information, see the API documentation for [Truncation](../../api/extended/prompt--prompt-executor--prompt-executor-clients--prompt-executor-openai-client.md#aikoogpromptexecutorclientsopenaimodelstruncation). |
## topK
| `topK` | Integer | Number of top tokens to consider when generating the output. Takes a value greater than or equal to 0 (provider-specific minimums may apply). |
## repetitionPenalty
| `repetitionPenalty` | Double | Penalizes token repetition. Next-token probabilities for tokens that already appeared in the output are divided by the value of `repetitionPenalty`, which makes them less likely to appear again if `repetitionPenalty > 1`. Takes a value greater than 0.0 and lower than or equal to 2.0. |
## minP
| `minP` | Double | Filters out tokens whose relative probability to the most likely token is below the defined `minP` value. Takes a value in the range of 0.0–0.1. |
## topA
| `topA` | Double | Dynamically adjusts the sampling window based on model confidence. If the model is confident (there are dominant high-probability next tokens), it keeps the sampling window limited to a few top tokens. If the confidence is low (there are many tokens with similar probabilities), keeps more tokens in the sampling window. Takes a value in the range of 0.0–0.1 (inclusive). Higher value means greater dynamic adaptation. |
## transforms
| `transforms` | List&lt;String&gt; | List of context transforms. Defines how context is transformed when it exceeds the model's token limit. The default transformation is `middle-out` which truncates from the middle of the prompt. Use empty list for no transformations. For more information, see [Message Transforms](https://openrouter.ai/docs/guides/features/message-transforms) in OpenRouter documentation. |
## models
| `models` | List&lt;String&gt; | List of allowed models for the request. |
## route
| `route` | String | Request routing strategy to use. |
## provider
| `provider` | ProviderPreferences | Includes a range of parameters that let you explicitly control how OpenRouter chooses which LLM provider to use. For more information, see the API documentation on [ProviderPreferences](../../api/extended/prompt--prompt-executor--prompt-executor-clients--prompt-executor-openrouter-client.md#aikoogpromptexecutorclientsopenroutermodelsproviderpreferences). |
## stopSequences
| `stopSequences` | List&lt;String&gt; | Custom text sequences that cause the model to stop generating content. If matched, the value of `stop_reason` in the response is `stop_sequence`. |
## container
| `container`  | String | Container identifier for reuse across requests. Containers are used by Anthropic's code execution tool to provide a secure and containerized code execution environment. By providing the container identifier from a previous response, you can reuse containers across multiple requests, which preserves created files between requests. For more information, see [Containers](https://platform.claude.com/docs/en/agents-and-tools/tool-use/code-execution-tool#containers) in Anthropic's documentation. |
## mcpServers
| `mcpServers` | List&lt;AnthropicMCPServerURLDefinition&gt; | Definitions of MCP servers to be used in the request. Supports at most 20 servers. For more information, see the API reference for [AnthropicMCPServerURLDefinition](../../api/extended/prompt--prompt-executor--prompt-executor-clients--prompt-executor-anthropic-client.md#aikoogpromptexecutorclientsanthropicmodelsanthropicmcpserverurldefinition). |
## serviceTier
| `serviceTier` | AnthropicServiceTier | Determines whether to use priority capacity (if available) or standard capacity for the request. For more information, see the API reference for [AnthropicServiceTier](../../api/extended/prompt--prompt-executor--prompt-executor-clients--prompt-executor-anthropic-client.md#aikoogpromptexecutorclientsanthropicmodelsanthropicservicetier) and Anthropic's [Service tiers](https://platform.claude.com/docs/en/api/service-tiers) documentation. |
## thinking
| `thinking` | AnthropicThinking | Configuration for activating Claude's extended thinking. When activated, responses also include thinking content blocks. For more information, see the API reference for [AnthropicThinking](../../api/extended/prompt--prompt-executor--prompt-executor-clients--prompt-executor-anthropic-client.md#aikoogpromptexecutorclientsanthropicmodelsanthropicthinking). |
## thinkingConfig
| `thinkingConfig` | GoogleThinkingConfig | Controls whether the model should expose its chain-of-thought and how many tokens it may spend on it. For more information, see the API reference for [GoogleThinkingConfig](../../api/extended/prompt--prompt-executor--prompt-executor-clients--prompt-executor-google-client.md#aikoogpromptexecutorclientsgooglemodelsgooglethinkingconfig). |
## enableSearch
| `enableSearch` | Boolean | Specifies whether to enable web search functionality. For more information, see Alibaba's [Web search](https://www.alibabacloud.com/help/en/model-studio/web-search?spm=a2c63.p38356.0.i14) documentation. |
## enableThinking
| `enableThinking` | Boolean | Specifies whether to enable thinking mode when using a hybrid thinking model. For more information, see Alibaba's documentation on [Deep thinking](https://www.alibabacloud.com/help/en/model-studio/deep-thinking?spm=a2c63.p38356.0.i11). |
## randomSeed
| `randomSeed` | Integer | The seed to use for random sampling. If set, different calls with the same parameters and the same seed value will generate deterministic results. |
## promptMode
| `promptMode` | String | Lets you toggle between the reasoning mode and no system prompt. When set to `reasoning`, the default system prompt for reasoning models is used. For more information, see Mistral's [Reasoning](https://docs.mistral.ai/capabilities/reasoning) documentation. |
## safePrompt
| `safePrompt` | Boolean | Specifies whether to inject a safety prompt before all conversations. The safety prompt is used to enforce guardrails and protect against harmful content. For more information, see Mistral's [Moderation & Guardarailing](https://docs.mistral.ai/capabilities/guardrailing) documentation. |
## think
| `think` | Boolean | Configuration for activating Ollama extended thinking. When activated, responses also include thinking content blocks. For more information, see the API reference for [Ollama thinking](https://docs.ollama.com/capabilities/thinking#enable-thinking-in-api-calls). |
