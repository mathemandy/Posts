package life.league.challenge.kotlin.ui.posts

import life.league.challenge.kotlin.model.Post

sealed class PostState {
    data class Loaded(
        val posts: List<Post>
    ) : PostState()

    object Loading : PostState()
    data class Error(
        val reason: String
    ) : PostState()
}
