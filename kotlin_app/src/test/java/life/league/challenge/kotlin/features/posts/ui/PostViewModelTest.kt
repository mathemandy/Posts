package life.league.challenge.kotlin.features.posts.ui

import app.cash.turbine.test
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import life.league.challenge.kotlin.CoroutineTestRule
import life.league.challenge.kotlin.DummyData.posts
import life.league.challenge.kotlin.TestPostExecutionThread
import life.league.challenge.kotlin.features.posts.contract.GetPostRemote
import life.league.challenge.kotlin.features.posts.repository.GetPostRepositoryImpl
import life.league.challenge.kotlin.ui.posts.PostState
import life.league.challenge.kotlin.ui.posts.PostViewModel
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import java.lang.Exception

class PostViewModelTest {

    private var getPostRemote: GetPostRemote = mockk(relaxed = true)

    @get:Rule
    var coroutinesTestRule = CoroutineTestRule()

    private val viewModel by lazy { PostViewModel(TestPostExecutionThread(), GetPostRepositoryImpl(getPostRemote)) }

    @Test
    fun `Whenever PostViewModel loads, has Loading state`() = coroutinesTestRule.runBlockingTest {
        viewModel.postState.first().let {
            assertEquals(it, PostState.Loading)
        }
    }

    @Test
    fun `Whenever PostViewModel tries to getPosts and succeeds, gets Success state`() = coroutinesTestRule.runBlockingTest {
        coEvery { getPostRemote.getPosts() } returns posts

        viewModel.postState.test {
            assertEquals(awaitItem(), PostState.Loaded(posts))
        }
    }

    @Test
    fun `rWhenever PostViewModel tries to getPost and fails,  gets Error state`() = coroutinesTestRule.runBlockingTest {
        coEvery { getPostRemote.getPosts() } throws Exception()

        viewModel.postState.test {
            assertEquals(awaitItem(), PostState.Error(reason = "An error occurred"))
        }
    }
}
