package com.jayvijay.scottie.feature.interacbanking.presentation

import com.slack.circuit.runtime.screen.Screen

/**
 * The model download and settings screen; bound in `di/` so this feature never imports the feature
 * that owns it.
 */
fun interface ModelSettingsDestination {
  fun screen(): Screen
}
