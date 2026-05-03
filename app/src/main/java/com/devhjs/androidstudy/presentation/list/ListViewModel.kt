package com.devhjs.androidstudy.presentation.list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = MutableStateFlow(ListState())
    val state = _state.asStateFlow()

    private val _event = MutableSharedFlow<ListEvent>()
    val event = _event.asSharedFlow()


    fun onAction(action: ListAction) {
        when (action) {
            is ListAction.OnPostClick -> {
                viewModelScope.launch {
                    _event.emit(ListEvent.OnNavigateToPost(1))
                }
            }
            is ListAction.OnAlbumClick -> {
                viewModelScope.launch {
                    _event.emit(ListEvent.OnNavigateToAlbum(1))
                }
            }
        }
    }

}