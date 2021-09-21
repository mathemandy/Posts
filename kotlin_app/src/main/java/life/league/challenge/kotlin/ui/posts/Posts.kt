package life.league.challenge.kotlin.ui.posts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import life.league.challenge.kotlin.ui.composables.PrimaryText
import life.league.challenge.kotlin.ui.posts.composables.LazyList
import life.league.challenge.kotlin.ui.posts.composables.PostItem

@Composable
fun Posts() {
    val viewModel = hiltViewModel<PostViewModel>()
    val postState = viewModel.postState.collectAsState()
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        when (postState.value) {
            is PostState.Error -> {
                PrimaryText(text = (postState.value as PostState.Error).reason)
            }
            is PostState.Loaded -> {
                val posts = (postState.value as PostState.Loaded).posts
                LazyList(count = posts.size, onItemSelect = {}) {
                    PostItem(posts[it])
                }
            }
            PostState.Loading -> {
                CircularProgressIndicator(color = MaterialTheme.colors.onPrimary)
            }
        }
    }
}
