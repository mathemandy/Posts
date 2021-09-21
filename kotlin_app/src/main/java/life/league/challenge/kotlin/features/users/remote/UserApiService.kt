package life.league.challenge.kotlin.features.users.remote

import life.league.challenge.kotlin.model.User
import retrofit2.http.GET
import retrofit2.http.Header

interface UserApiService {

    @GET("users")
    suspend fun getUsers(@Header("x-access-token") apiToken: String?): List<User>
}
