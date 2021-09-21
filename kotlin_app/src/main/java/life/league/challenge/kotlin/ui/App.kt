package life.league.challenge.kotlin.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import life.league.challenge.kotlin.R
import life.league.challenge.kotlin.ui.posts.Posts

@Composable
fun App() {

    Box {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.posts), textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
                    }
                )
            },
            content = {
                Posts()
            }
        )
    }
}
