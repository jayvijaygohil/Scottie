package com.jayvijay.scottie.feature.interacbanking.domain.entities

/**
 * A selectable text model; [id] is passed to inference: a downloaded `.litertlm` file name, or a
 * prefixed OpenRouter id.
 */
data class TextModelOption(
  val id: String,
  val name: String,
  /** True for an OpenRouter model; [name] is then the raw model id. */
  val remote: Boolean = false,
)
