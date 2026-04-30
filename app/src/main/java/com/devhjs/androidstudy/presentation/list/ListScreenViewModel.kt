package com.devhjs.androidstudy.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devhjs.androidstudy.core.util.Result
import com.devhjs.androidstudy.domain.usecase.GetPostListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListScreenViewModel @Inject constructor(
    private val getPostListUseCase: GetPostListUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(ListState())
    val state = _state.asStateFlow()

    private val _event = MutableSharedFlow<ListEvent>()
    val event = _event.asSharedFlow()

    init {
        fetchPosts()
    }

    fun onAction(action: ListAction) {
        when (action) {
            is ListAction.onPostClick -> {
                viewModelScope.launch {
                    _event.emit(ListEvent.onPostClick(action.postId))
                }
            }
        }
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            when (val result = getPostListUseCase.execute()) {
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