package com.devhjs.androidstudy.presentation.postdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.devhjs.androidstudy.core.routing.MainRoute
import com.devhjs.androidstudy.core.util.Result
import com.devhjs.androidstudy.domain.usecase.GetCommentByPostUseCase
import com.devhjs.androidstudy.domain.usecase.GetPostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailViewModel @Inject constructor(
    private val getPostUseCase: GetPostUseCase,
    private val getCommentByPostUseCase: GetCommentByPostUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(PostDetailState())
    val state = _state.asStateFlow()

    private val _event = MutableSharedFlow<PostDetailEvent>()
    val event = _event.asSharedFlow()

    init {
        val route = savedStateHandle.toRoute<MainRoute.PostDetail>()
        fetchPost(postId = route.id)
    }


    fun onAction(action: PostDetailAction) {
        when (action) {
            PostDetailAction.onBackClick -> {
                viewModelScope.launch {
                    _event.emit(PostDetailEvent.onBackClick)
                }
            }
        }
    }


    private fun fetchPost(postId: Int) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            when (val result = getPostUseCase.execute(postId)) {
                is Result.Success -> {
                    _state.update { it.copy(post = result.data) }
                }
                is Result.Error -> {
                    _state.update { it.copy(isLoading = false) }
                }
            }
            when (val result = getCommentByPostUseCase.execute(postId)) {
                is Result.Success -> {
                    _state.update { it.copy(comments = result.data) }
                }
                is Result.Error -> {
                    _state.update { it.copy(isLoading = false) }
                }
            }
            _state.update { it.copy(isLoading = false) }
        }
    }

}