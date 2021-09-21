package life.league.challenge.kotlin.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import life.league.challenge.kotlin.ui.posts.Posts

@Composable
fun App() {
    val viewModel = hiltViewModel<AppViewModel>()

    Box {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Posts", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
                    }
                )
            },
            content = {
                Posts()
            }
        )
    }
}
