package example.a2ui

import androidx.a2ui.compose.ui.testing.A2uiTestController
import androidx.a2ui.compose.ui.testing.A2uiTestSurface
import androidx.a2ui.compose.ui.testing.getData
import androidx.a2ui.model.protocol.A2uiComponentPayload
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextReplacement
import androidx.compose.ui.test.v2.runComposeUiTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NoteEditorTest {
    @Test
    fun serverUpdates_userEdits_andSaveEvent() = runComposeUiTest {
        val controller = A2uiTestController(
            catalog = noteCatalog(),
            initialComponents = listOf(
                A2uiComponentPayload(
                    id = "root",
                    type = "NoteEditor",
                    properties = mapOf(
                        "label" to "Note",
                        "value" to mapOf("path" to "/note"),
                        "action" to mapOf(
                            "event" to mapOf(
                                "name" to "save_note",
                                "context" to mapOf("note" to mapOf("path" to "/note")),
                            ),
                        ),
                    ),
                ),
            ),
            initialData = mapOf("note" to "First note"),
        )
        val surface = controller.start()
        setContent { MaterialTheme { A2uiTestSurface(surface = surface) } }
        onNodeWithText("First note").assertIsDisplayed()

        controller.updateData("/note", "From server")
        controller.waitForIdle()
        waitForIdle()
        onNodeWithText("From server").assertIsDisplayed()

        onNodeWithText("From server").performTextReplacement("Edited locally")
        controller.waitForIdle()
        waitForIdle()
        assertEquals("Edited locally", controller.getData<String>("/note"))

        onNodeWithText("Save note").performClick()
        controller.waitForIdle()
        val event = controller.outboundEvents.single()
        assertEquals("save_note", event.type)
        assertEquals("Edited locally", event.context["note"])
        assertEquals(emptyList<Any>(), controller.outboundErrors)
    }
}
