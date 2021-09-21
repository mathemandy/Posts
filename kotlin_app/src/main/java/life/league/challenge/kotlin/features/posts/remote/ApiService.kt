package life.league.challenge.kotlin.features.posts.remote

import life.league.challenge.kotlin.model.Post
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {

    @GET("posts")
    suspend fun getPosts(@Header("x-access-token") apiToken : String?): List<Post>
}
