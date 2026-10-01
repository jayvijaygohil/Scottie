// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleSkillsUsage01


import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.tools.ToolRegistry
import ai.koog.agents.ext.tool.file.ListDirectoryTool
import ai.koog.agents.ext.tool.file.ReadFileTool
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor
import ai.koog.rag.base.files.JVMFileSystemProvider
import ai.koog.skills.discovery.discoverSkills
import ai.koog.skills.prompt.SkillsPromptFormat
import ai.koog.skills.prompt.generateSkillsPrompt
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val skillsRoot = "/absolute/path/to/skills"
    val discoveredSkills = discoverSkills(JVMFileSystemProvider.ReadOnly, listOf(skillsRoot))
    val generatedSkillsPrompt = generateSkillsPrompt(discoveredSkills, SkillsPromptFormat.XML)

    // Replace with your script execution tool implementation.
    val apiKey = System.getenv("OPENAI_API_KEY")
        ?: error("The API key is not set.")

    val agent = AIAgent(
        promptExecutor = simpleOpenAIExecutor(apiKey),
        systemPrompt = """
                You are a careful assistant.
                Use the available skills listed below.
                Before using a skill script, disclose the skills by listing and reading files with tools.

                $generatedSkillsPrompt
                """.trimIndent(),
        llmModel = OpenAIModels.Chat.GPT4o,
        toolRegistry = ToolRegistry {
            tool(ListDirectoryTool(JVMFileSystemProvider.ReadOnly))
            tool(ReadFileTool(JVMFileSystemProvider.ReadOnly))
            // Additional tools...
        },
    )
}

