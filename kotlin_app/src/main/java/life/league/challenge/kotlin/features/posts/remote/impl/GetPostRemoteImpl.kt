package life.league.challenge.kotlin.features.posts.remote.impl

import life.league.challenge.kotlin.features.auth.contract.LoginRemote
import life.league.challenge.kotlin.features.posts.contract.GetPostRemote
import life.league.challenge.kotlin.features.posts.remote.ApiService
import life.league.challenge.kotlin.features.users.contract.GetUserByIdRemote
import life.league.challenge.kotlin.model.Post
import javax.inject.Inject

internal class GetPostRemoteImpl @Inject constructor(
    private val apiService: ApiService,
    private val loginApiService: LoginRemote,
    private val userByIdRemote: GetUserByIdRemote
) : GetPostRemote {

    override suspend fun getPosts(): List<Post> {
        val apiToken = loginApiService.login().apiKey
        val users = userByIdRemote.getUserById(apiToken)
        return apiService.getPosts(apiToken).map { post ->
            val currentUser = users.find { it.id == post.userId }
            post.imageUrl = currentUser?.avatar?.medium
            post.author = currentUser?.name
            post
        }
    }
}
