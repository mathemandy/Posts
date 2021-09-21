package life.league.challenge.kotlin.features.posts.repository

import life.league.challenge.kotlin.features.posts.contract.GetPostRemote
import life.league.challenge.kotlin.features.posts.contract.GetPostRepository
import life.league.challenge.kotlin.model.Post
import javax.inject.Inject

class GetPostRepositoryImpl @Inject constructor(private val remote: GetPostRemote) : GetPostRepository {
    override suspend fun getPosts(): List<Post> {
        return remote.getPosts()
    }
}
