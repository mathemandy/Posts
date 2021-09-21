package life.league.challenge.kotlin.utils

import com.google.common.io.Resources
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import life.league.challenge.kotlin.model.Post
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.lang.reflect.ParameterizedType
import java.net.URL

internal const val REQUEST_PATH: String = "/posts"
internal const val USERS_REQUEST_PATH: String = "/users"

private val okHttpClient: OkHttpClient
    get() = OkHttpClient.Builder().build()

internal val moshi: Moshi
    get() = Moshi.Builder()
        .add(KotlinJsonAdapterFactory()).build()

internal val adapter: JsonAdapter<List<Post>>
    get() {
        val type: ParameterizedType = Types.newParameterizedType(
            List::class.java,
            Post::class.java,
            String::class.java
        )
        return moshi.adapter(type)
    }

@Suppress("UnstableApiUsage")
internal fun getJson(path: String): String {
    val uri: URL = Resources.getResource(path)
    val file = File(uri.path)
    return String(file.readBytes())
}

internal inline fun <reified T> makeTestApiService(mockWebServer: MockWebServer): T = Retrofit.Builder()
    .baseUrl(mockWebServer.url("/"))
    .client(okHttpClient)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()
    .create(T::class.java)
