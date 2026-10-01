// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleStructuredData06

import ai.koog.agents.example.exampleStructuredData03.WeatherForecast
import ai.koog.agents.example.exampleStructuredData03.WeatherNews
import ai.koog.agents.example.exampleStructuredData03.WeatherSource
import io.ktor.http.*

val exampleForecasts = listOf(
  WeatherForecast(
    news = listOf(WeatherNews(0.0), WeatherNews(5.0)),
    sources = mutableMapOf(
      "openweathermap" to WeatherSource(Url("https://api.openweathermap.org/data/2.5/weather")),
      "googleweather" to WeatherSource(Url("https://weather.google.com"))
    )
    // Other fields
  ),
  WeatherForecast(
    news = listOf(WeatherNews(25.0), WeatherNews(35.0)),
    sources = mutableMapOf(
      "openweathermap" to WeatherSource(Url("https://api.openweathermap.org/data/2.5/weather")),
      "googleweather" to WeatherSource(Url("https://weather.google.com"))
    )
  )
)

