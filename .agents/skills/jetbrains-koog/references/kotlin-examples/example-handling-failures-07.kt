// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleHandlingFailures07

import ai.koog.prompt.executor.clients.anthropic.AnthropicLLMClient
import ai.koog.prompt.executor.clients.bedrock.BedrockLLMClient
import ai.koog.prompt.executor.clients.openai.OpenAILLMClient
import ai.koog.prompt.executor.clients.retry.RetryConfig
import ai.koog.prompt.executor.clients.retry.RetryingLLMClient
import ai.koog.prompt.executor.llms.MultiLLMPromptExecutor
import ai.koog.prompt.llm.LLMProvider
import aws.sdk.kotlin.runtime.auth.credentials.StaticCredentialsProvider

// Single provider executor with retry
val resilientClient = RetryingLLMClient(
    OpenAILLMClient(System.getenv("OPENAI_API_KEY")),
    RetryConfig.PRODUCTION
)
val executor = MultiLLMPromptExecutor(resilientClient)

// Multi-provider executor with flexible client configuration
val multiExecutor = MultiLLMPromptExecutor(
    LLMProvider.OpenAI to RetryingLLMClient(
        OpenAILLMClient(System.getenv("OPENAI_API_KEY")),
        RetryConfig.CONSERVATIVE
    ),
    LLMProvider.Anthropic to RetryingLLMClient(
        AnthropicLLMClient(System.getenv("ANTHROPIC_API_KEY")),
        RetryConfig.AGGRESSIVE  
    ),
    // The Bedrock client already has a built-in AWS SDK retry 
    LLMProvider.Bedrock to BedrockLLMClient(
        identityProvider = StaticCredentialsProvider {
            accessKeyId = System.getenv("AWS_ACCESS_KEY_ID")
            secretAccessKey = System.getenv("AWS_SECRET_ACCESS_KEY")
            sessionToken = System.getenv("AWS_SESSION_TOKEN")
        },
    ),
)
