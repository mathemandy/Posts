package life.league.challenge.kotlin.ui.posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import life.league.challenge.kotlin.core.executor.PostExecutionThread
import life.league.challenge.kotlin.core.extension.errorMessage
import life.league.challenge.kotlin.features.posts.contract.GetPostRepository
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val postExecutionThread: PostExecutionThread,
    private val getPostRepository: GetPostRepository
) : ViewModel() {

    val postState = MutableStateFlow<PostState>(value = PostState.Loading)

    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch(postExecutionThread.io) {
            flow {
                emit(getPostRepository.getPosts())
            }.catch { cause: Throwable ->
                postState.emit(PostState.Error(reason = cause.errorMessage))
            }.collect {
                postState.emit(PostState.Loaded(it))
            }
        }
    }
}
