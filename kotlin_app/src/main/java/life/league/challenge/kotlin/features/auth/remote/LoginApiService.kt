package life.league.challenge.kotlin.features.auth.remote

import life.league.challenge.kotlin.model.Account
import retrofit2.http.GET
import retrofit2.http.Header

/**
 * Retrofit API interface definition using coroutines. Feel free to change this implementation to
 * suit your chosen architecture pattern and concurrency tools
 */
interface LoginApiService {

    @GET("login")
    suspend fun login(@Header("Authorization") credentials: String?): Account
}
