package example.a2ui

import androidx.a2ui.compose.runtime.A2uiComponentProperties
import androidx.a2ui.compose.runtime.A2uiComponentScope
import androidx.a2ui.compose.runtime.A2uiProperty
import androidx.a2ui.compose.ui.A2uiCatalog
import androidx.a2ui.compose.ui.A2uiComponent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/** Example application component. Rename its catalog URI for the consuming app. */
object NoteEditor : A2uiComponent {
    private val Label = A2uiProperty.dynamicString("label", required = true)
    private val Value = A2uiProperty.dynamicString("value", required = true)
    private val Action = A2uiProperty.action("action")

    override val name = "NoteEditor"
    override val description = "An editable note with an optional save action."
    override val properties: List<A2uiProperty<*>> = listOf(Label, Value, Action)

    @Composable
    override fun A2uiComponentScope.isReady(properties: A2uiComponentProperties): Boolean {
        val label = properties.bind(Label)
        val value = properties.bind(Value)
        return label != null && value != null
    }

    @Composable
    override fun A2uiComponentScope.Content(
        properties: A2uiComponentProperties,
        modifier: Modifier,
    ) {
        val label = properties.bind(Label) ?: return
        val value = properties.bind(Value) ?: return
        val updateValue = properties.bindUpdater(Value)
        val action = properties[Action]

        Column(modifier = modifier) {
            OutlinedTextField(
                value = value,
                onValueChange = { updateValue?.invoke(it) },
                label = { Text(label) },
                enabled = updateValue != null,
            )
            if (action != null) {
                Button(onClick = { dispatchAction(action) }) { Text("Save note") }
            }
        }
    }
}

fun noteCatalog(): A2uiCatalog = A2uiCatalog(
    catalogId = "https://example.com/a2ui/catalog/notes/v1",
    components = listOf(NoteEditor),
    isInline = true,
)
