package com.devhjs.androidstudy.presentation.post

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.devhjs.androidstudy.core.routing.MainRoute
import com.devhjs.androidstudy.core.util.Result
import com.devhjs.androidstudy.domain.usecase.GetPostByUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostScreenViewModel @Inject constructor(
    private val getPostByUserUseCase: GetPostByUserUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = MutableStateFlow(PostState())
    val state = _state.asStateFlow()

    private val _event = MutableSharedFlow<PostEvent>()
    val event = _event.asSharedFlow()

    init {
        val route = savedStateHandle.toRoute<MainRoute.Post>()
        fetchPosts(userId = route.userId)
    }

    fun onAction(action: PostAction) {
        when (action) {
            is PostAction.onPostClick -> {
                viewModelScope.launch {
                    _event.emit(PostEvent.onPostClick(action.postId))
                }
            }
        }
    }

    private fun fetchPosts(userId: Int) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            when (val result = getPostByUserUseCase.execute(userId)) {
                is Result.Success -> {
                    _state.update { it.copy(posts = result.data, isLoading = false) }
                }

                is Result.Error -> {
                    _state.update { it.copy(isLoading = false) }
                }
            }

        }
    }
}