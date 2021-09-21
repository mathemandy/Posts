package life.league.challenge.kotlin.features.users

import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import life.league.challenge.kotlin.DummyData.apiKey
import life.league.challenge.kotlin.features.posts.remote.mockBase64Class
import life.league.challenge.kotlin.features.users.contract.GetUsersRemote
import life.league.challenge.kotlin.features.users.remote.impl.GetUsersRemoteImpl
import life.league.challenge.kotlin.model.Post
import life.league.challenge.kotlin.model.User
import life.league.challenge.kotlin.utils.RequestDispatcher
import life.league.challenge.kotlin.utils.USERS_REQUEST_PATH
import life.league.challenge.kotlin.utils.USERS_RESPONSE_PATH
import life.league.challenge.kotlin.utils.adapter
import life.league.challenge.kotlin.utils.getJson
import life.league.challenge.kotlin.utils.makeTestApiService
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test

class GetUsersRemoteTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var getUsersRemote: GetUsersRemote

    @Before
    fun setup() {

        mockBase64Class()
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher = RequestDispatcher()
        mockWebServer.start()
        getUsersRemote =
            GetUsersRemoteImpl(
                makeTestApiService(mockWebServer)
            )
    }

    @Test
    fun `check that getUsers returns users list of same size`() = runBlocking {
        val users: List<User> = getUsersRemote.getUsers(apiKey.apiKey)
        val responseSize: Int =
            USERS_RESPONSE_PATH.getResponseList().size
        Truth.assertThat(users).isNotEmpty()
        Truth.assertThat(users.size).isEqualTo(responseSize)
    }

    @Test
    fun `check that calling getPosts makes request to correct path`() = runBlocking {
        getUsersRemote.getUsers()
        Truth.assertThat(USERS_REQUEST_PATH)
            .isEqualTo(mockWebServer.takeRequest().path)
    }

    @Test
    fun `check that calling getPosts makes a GET request`() = runBlocking {
        getUsersRemote.getUsers()
        Truth.assertThat("GET $USERS_REQUEST_PATH HTTP/1.1")
            .isEqualTo(mockWebServer.takeRequest().requestLine)
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
