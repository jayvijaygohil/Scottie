package com.jayvijay.scottie.feature.interacbanking.domain.repository

import com.jayvijay.scottie.feature.interacbanking.domain.entities.TextModelOption
import kotlinx.coroutines.flow.Flow

interface TextModelSource {
  /** Downloaded text models, catalog order. */
  val models: Flow<List<TextModelOption>>

  /** Active model id; null when none is downloaded. */
  val active: Flow<String?>

  /** Makes [id] active for subsequent replies; ignored unless it is a downloaded text model. */
  fun select(id: String)
}
