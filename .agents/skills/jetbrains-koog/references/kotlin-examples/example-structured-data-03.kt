// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleStructuredData03

import ai.koog.agents.core.tools.annotations.LLMDescription
import io.ktor.http.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherNews(val temperature: Double)

@Serializable
data class WeatherSource(val url: Url)

@Serializable
@SerialName("WeatherForecast")
data class WeatherForecast(
    // Other fields
    @property:LLMDescription("List of news articles")
    val news: List<WeatherNews>,
    @property:LLMDescription("Map of weather sources")
    val sources: Map<String, WeatherSource>
)
