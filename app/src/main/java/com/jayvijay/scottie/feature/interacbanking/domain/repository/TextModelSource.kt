package com.jayvijay.scottie.feature.interacbanking.domain.repository

import kotlinx.coroutines.flow.Flow

interface TextModelSource {
  /** Active model id; null when no text model is available. */
  val active: Flow<String?>

  /** Active speech-to-text model id; null when "None" is selected. */
  val activeAudio: Flow<String?>
}
