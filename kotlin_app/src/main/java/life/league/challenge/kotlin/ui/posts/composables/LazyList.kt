package life.league.challenge.kotlin.ui.posts.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LazyList(
    modifier: Modifier = Modifier,
    onItemSelect: (Int) -> Unit,
    count: Int,
    verticalPadding: Dp = 0.dp,
    item: @Composable (Int) -> Unit,
) {
    ListLayout(
        modifier = modifier,
    ) {
        for (i in 0 until count) {
            item {
                ItemLayout(
                    modifier =
                        Modifier.padding(bottom = verticalPadding)
                            .clickable {
                                onItemSelect(i)
                            },
                ) {
                    item(i)
                }
            }
        }
    }
}

@Composable
fun ListLayout(
    modifier: Modifier,
    content: LazyListScope.() -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        content()
    }
}

@Composable
fun ItemLayout(modifier: Modifier, content: @Composable () -> Unit) {
    Column(modifier = modifier) {
        content()
    }
}
