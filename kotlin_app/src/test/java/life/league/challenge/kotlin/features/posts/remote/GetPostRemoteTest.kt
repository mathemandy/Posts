package life.league.challenge.kotlin.features.posts.remote

import android.util.Base64
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.slot
import kotlinx.coroutines.runBlocking
import life.league.challenge.kotlin.DummyData.apiKey
import life.league.challenge.kotlin.DummyData.users
import life.league.challenge.kotlin.features.auth.remote.LoginApiService
import life.league.challenge.kotlin.features.auth.remote.impl.LoginRemoteImpl
import life.league.challenge.kotlin.features.posts.contract.GetPostRemote
import life.league.challenge.kotlin.features.posts.remote.impl.GetPostRemoteImpl
import life.league.challenge.kotlin.features.users.remote.UserApiService
import life.league.challenge.kotlin.features.users.remote.impl.GetUsersRemoteImpl
import life.league.challenge.kotlin.model.Post
import life.league.challenge.kotlin.utils.POSTS_RESPONSE_PATH
import life.league.challenge.kotlin.utils.REQUEST_PATH
import life.league.challenge.kotlin.utils.RequestDispatcher
import life.league.challenge.kotlin.utils.adapter
import life.league.challenge.kotlin.utils.getJson
import life.league.challenge.kotlin.utils.makeTestApiService
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test

class GetPostRemoteTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var getPostRemote: GetPostRemote
    private val loginApiService: LoginApiService = mockk(relaxed = true)
    private val userApiService: UserApiService = mockk(relaxed = true)

    @Before
    fun setup() {
        coEvery { loginApiService.login(any()) } returns apiKey
        coEvery { userApiService.getUsers(any()) } returns users

        mockBase64Class()
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher = RequestDispatcher()
        mockWebServer.start()
        getPostRemote =
            GetPostRemoteImpl(
                makeTestApiService(mockWebServer),
                LoginRemoteImpl(loginApiService), GetUsersRemoteImpl(userApiService)
            )
    }

    @Test
    fun `check that getPosts returns posts list of same size`() = runBlocking {
        val posts: List<Post> = getPostRemote.getPosts()
        val responseSize: Int =
            POSTS_RESPONSE_PATH.getResponseList().size
        Truth.assertThat(posts).isNotEmpty()
        Truth.assertThat(posts.size).isEqualTo(responseSize)
    }

    @Test
    fun `check that calling getPosts makes request to correct path`() = runBlocking {
        getPostRemote.getPosts()
        Truth.assertThat(REQUEST_PATH)
            .isEqualTo(mockWebServer.takeRequest().path)
    }

    @Test
    fun `check that calling getPosts makes a GET request`() = runBlocking {
        getPostRemote.getPosts()
        Truth.assertThat("GET $REQUEST_PATH HTTP/1.1")
            .isEqualTo(mockWebServer.takeRequest().requestLine)
    }

    @Test
    fun `check that calling getPosts also calls getUser`() = runBlocking {
        getPostRemote.getPosts()
        coVerify(exactly = 1) { userApiService.getUsers(any()) }
    }

    @Test
    fun `check that calling getPosts returns the correct Data`() = runBlocking {
        val posts: List<Post> = getPostRemote.getPosts()
        Truth.assertThat(posts[0].author).isEqualTo(users[3].name)
        Truth.assertThat(posts[0].imageUrl).isEqualTo(users[3].avatar?.medium)
    }

    private fun getResponse(responsePath: String): List<Post> {
        return adapter.fromJson(getJson(responsePath))!!
    }

    private fun String.getResponseList(): List<Post> {
        return getResponse(this)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}

fun mockBase64Class() {
    mockkStatic(Base64::class)
    val arraySlot = slot<ByteArray>()
    every {
        Base64.encodeToString(capture(arraySlot), Base64.NO_WRAP)
    } answers {
        java.util.Base64.getEncoder().encodeToString(arraySlot.captured)
    }

    val stringSlot = slot<String>()
    every {
        Base64.decode(capture(stringSlot), Base64.NO_WRAP)
    } answers {
        java.util.Base64.getDecoder().decode(stringSlot.captured)
    }
}
