package com.jayvijay.scottie.feature.interacbanking.presentation

import com.slack.circuit.runtime.screen.ParcelableScreen
import kotlinx.parcelize.Parcelize

/** [modelId] is the `.litertlm` file name from the model catalog. */
@Parcelize data class InteracAssistantScreen(val modelId: String) : ParcelableScreen
