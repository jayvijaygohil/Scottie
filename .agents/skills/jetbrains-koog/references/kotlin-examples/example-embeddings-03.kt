// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleEmbeddings03

import ai.koog.embeddings.local.LLMEmbedder
import ai.koog.prompt.executor.clients.bedrock.BedrockClientSettings
import ai.koog.prompt.executor.clients.bedrock.BedrockLLMClient
import ai.koog.prompt.executor.clients.bedrock.BedrockModels
import aws.sdk.kotlin.runtime.auth.credentials.StaticCredentialsProvider

suspend fun bedrockEmbed(text: String) {
    // Get AWS credentials from environment/configuration
    val awsAccessKeyId = System.getenv("AWS_ACCESS_KEY_ID") ?: error("AWS_ACCESS_KEY_ID not set")
    val awsSecretAccessKey = System.getenv("AWS_SECRET_ACCESS_KEY") ?: error("AWS_SECRET_ACCESS_KEY not set")
    // (Optional) AWS_SESSION_TOKEN for temporary credentials
    val awsSessionToken = System.getenv("AWS_SESSION_TOKEN")
    // Create a BedrockLLMClient instance
    val client = BedrockLLMClient(
        identityProvider = StaticCredentialsProvider {
            this.accessKeyId = awsAccessKeyId
            this.secretAccessKey = awsSecretAccessKey
            awsSessionToken?.let { this.sessionToken = it }
        },
        settings = BedrockClientSettings()
    )
    // Create an embedder
    val embedder = LLMEmbedder(client, BedrockModels.Embeddings.AmazonTitanEmbedText)
    // Create embeddings
    val embedding = embedder.embed(text)
    // Print embeddings to the output
    println(embedding)
}
