package com.jayvijay.scottie.feature.interacbanking.presentation

import androidx.a2ui.model.processor.A2uiSurfaceModel
import androidx.a2ui.model.protocol.A2uiClientErrorMessage
import androidx.a2ui.model.protocol.A2uiClientEventMessage
import androidx.a2ui.model.protocol.A2uiClientToServerMessage
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.A2uiBridge
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.boolean
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

/** Records accepted JSON lines; tests inject surfaces and client events. */
class FakeA2uiBridge : A2uiBridge {
  val accepted = MutableStateFlow<List<String>>(emptyList())
  var throwOnAccept = false
  override val surfaces = MutableStateFlow<List<A2uiSurfaceModel>>(emptyList())
  override val events = MutableSharedFlow<A2uiClientToServerMessage>()

  override fun accept(json: String) {
    check(!throwOnAccept) { "bridge down" }
    accepted.value = accepted.value + json
  }

  override fun close() = Unit

  suspend fun emitEvent(type: String, surfaceId: String, context: Map<String, Any?> = emptyMap()) =
    events.emit(A2uiClientEventMessage(type, surfaceId, "form", 0L, context))

  suspend fun emitError(surfaceId: String) =
    events.emit(A2uiClientErrorMessage("RUNTIME", surfaceId, "boom"))

  fun showSurface(id: String) {
    surfaces.value =
      surfaces.value +
        object : A2uiSurfaceModel {
          override val id = id
        }
  }

  /** Waits until a line matching [predicate] has been accepted and returns it. */
  suspend fun awaitLine(predicate: (String) -> Boolean): String =
    accepted.first { lines -> lines.any(predicate) }.last(predicate)

  /** Waits for an `updateDataModel` at exactly [path] and returns its serialized value. */
  suspend fun awaitUpdate(path: String): String {
    val marker = "\"path\":\"$path\""
    val line = awaitLine { "updateDataModel" in it && marker in it }
    val update = Json.parseToJsonElement(line).jsonObject["updateDataModel"]!!.jsonObject
    return update["value"].toString()
  }

  fun lines(op: String) =
    accepted.value.map { Json.parseToJsonElement(it).jsonObject }.filter { op in it }

  fun surfaceIds(op: String) =
    lines(op).map { it[op]!!.jsonObject["surfaceId"]!!.jsonPrimitive.content }

  /** The `/`-level data of the most recent surface, e.g. `form` or `accounts`. */
  fun rootData(): JsonObject {
    val updates = lines("updateDataModel").map { it["updateDataModel"]!!.jsonObject }
    return updates.last { it["path"]!!.jsonPrimitive.content == "/" }["value"]!!.jsonObject
  }

  fun form(): JsonObject = rootData()["form"]!!.jsonObject

  fun components(): List<JsonObject> {
    val update = lines("updateComponents").last()["updateComponents"]!!.jsonObject
    return update["components"]!!.jsonArray.map { it.jsonObject }
  }

  fun component(id: String): JsonObject? =
    components().find { it["id"]!!.jsonPrimitive.content == id }

  /** A `submit` context as the real surface would resolve it from the form data plus [edits]. */
  fun submitContext(vararg edits: Pair<String, Any?>): Map<String, Any?> =
    form().mapValues { (_, v) -> v.plain() } + edits.toMap()

  private fun JsonElement.plain(): Any? =
    (this as? JsonPrimitive)?.let { p ->
      if (p.isString) p.content else p.content.toBooleanStrictOrNull() ?: p.content
    }
}

fun JsonObject.str(key: String) = this[key]!!.jsonPrimitive.content

fun JsonObject.bool(key: String) = this[key]!!.jsonPrimitive.boolean
