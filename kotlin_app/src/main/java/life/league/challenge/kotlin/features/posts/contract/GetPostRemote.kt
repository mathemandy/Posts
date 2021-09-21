package life.league.challenge.kotlin.features.posts.contract

import life.league.challenge.kotlin.model.Post

interface GetPostRemote {
    suspend fun getPosts(): List<Post>
}
