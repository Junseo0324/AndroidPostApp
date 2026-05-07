package com.devhjs.androidstudy.presentation.list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.devhjs.androidstudy.core.routing.MainRoute
import com.devhjs.androidstudy.core.util.Result
import com.devhjs.androidstudy.domain.usecase.GetPostAndAlbumUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getPostAndAlbumUseCase: GetPostAndAlbumUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = MutableStateFlow(ListState())
    val state = _state.asStateFlow()

    private val userId = savedStateHandle.toRoute<MainRoute.List>().userId

    private val _event = MutableSharedFlow<ListEvent>()
    val event = _event.asSharedFlow()


    init {
        fetchData(userId)
    }

    private fun fetchData(userId: Int) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            when (val result = getPostAndAlbumUseCase.execute(userId)) {
                is Result.Success -> {
                    _state.update { it.copy(postSize = result.data.first, albumSize = result.data.second, todoSize = result.data.third) }
                }
                is Result.Error -> {
                    _state.update { it.copy(error = result.error) }
                }
            }
            _state.update { it.copy(isLoading = false) }
        }
    }


    fun onAction(action: ListAction) {
        when (action) {
            is ListAction.OnPostClick -> {
                viewModelScope.launch {
                    _event.emit(ListEvent.OnNavigateToPost(userId))
                }
            }
            is ListAction.OnAlbumClick -> {
                viewModelScope.launch {
                    _event.emit(ListEvent.OnNavigateToAlbum(userId))
                }
            }
            is ListAction.OnTodoClick -> {
                viewModelScope.launch {
                    _event.emit(ListEvent.OnNavigateToTodo(userId))
                }
            }
        }
    }

}