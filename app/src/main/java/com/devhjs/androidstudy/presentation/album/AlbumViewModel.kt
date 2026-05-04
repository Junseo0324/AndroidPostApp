package com.devhjs.androidstudy.presentation.album

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.devhjs.androidstudy.core.routing.MainRoute
import com.devhjs.androidstudy.core.util.Result
import com.devhjs.androidstudy.domain.usecase.GetAlbumListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(
    private val getAlbumUseCase: GetAlbumListUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = MutableStateFlow(AlbumState())
    val state = _state.asStateFlow()

    private val _event = MutableSharedFlow<AlbumEvent>()
    val event = _event.asSharedFlow()

    init {
        val userId = savedStateHandle.toRoute<MainRoute.Album>().userId
        fetchAlbum(userId)
    }

    private fun fetchAlbum(userId: Int) {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)

            when (val result = getAlbumUseCase.execute(userId)) {
                is Result.Success -> {
                    _state.update { it.copy(albums = result.data) }
                }

                is Result.Error -> {
                    _state.update { it.copy(error = result.error) }
                }
            }
            _state.value = _state.value.copy(isLoading = false)
        }
    }

    fun onAction(action: AlbumAction) {
        when (action) {
            is AlbumAction.OnPhotoClick -> {
                viewModelScope.launch {
                    _event.emit(AlbumEvent.OnNavigateToPhoto(action.photoId))
                }
            }

            is AlbumAction.OnBackClick -> {
                viewModelScope.launch {
                    _event.emit(AlbumEvent.OnBackClick)
                }
            }
        }
    }
}