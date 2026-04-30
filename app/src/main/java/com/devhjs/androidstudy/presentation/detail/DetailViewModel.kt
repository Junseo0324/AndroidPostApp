package com.devhjs.androidstudy.presentation.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.devhjs.androidstudy.core.routing.MainRoute
import com.devhjs.androidstudy.core.util.Result
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
class DetailViewModel @Inject constructor(
    private val getPostUseCase: GetPostUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val _state = MutableStateFlow(DetailState())
    val state = _state.asStateFlow()

    val _event = MutableSharedFlow<DetailEvent>()
    val event = _event.asSharedFlow()

    init {
        val route = savedStateHandle.toRoute<MainRoute.Detail>()
        fetchPost(postId = route.id)
    }
    fun onAction(action: DetailAction) {
        when (action) {
            DetailAction.onBackClick -> {
                viewModelScope.launch {
                    _event.emit(DetailEvent.onBackClick)
                }
            }
        }
    }
    private fun fetchPost(postId: Int) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            when (val result = getPostUseCase.execute(postId)) {
                is Result.Success -> {
                    _state.update { it.copy(post = result.data, isLoading = false) }
                }
                is Result.Error -> {
                    _state.update { it.copy(isLoading = false) }
                }
            }

        }
    }

}