package life.league.challenge.kotlin.ui.composables

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit

@Composable
fun PrimaryText(
    text: String,
    modifier: Modifier = Modifier,
    textSize: TextUnit = MaterialTheme.typography.body1.fontSize,
    textAlign: TextAlign = TextAlign.Center,
    allCaps: Boolean = false,
    color: Color = MaterialTheme.typography.body1.color,
    textStyle: TextStyle = MaterialTheme.typography.body1,
    textDecoration: TextDecoration = TextDecoration.None,
    maxLines: Int = Int.MAX_VALUE

) {
    Text(
        text = if (allCaps) text.uppercase() else text,
        fontSize = textSize,
        modifier = modifier,
        textAlign = textAlign,
        color = color,
        style = textStyle,
        textDecoration = textDecoration,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis
    )
}
