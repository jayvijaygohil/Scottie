package com.jayvijay.scottie.feature.modeldownload.presentation

import com.slack.circuit.runtime.screen.Screen

/**
 * Where a downloaded text model is used; bound in `di/` so this feature never imports the feature
 * that owns that screen.
 */
fun interface TextModelDestination {
  fun screen(modelId: String): Screen
}
