package com.devhjs.androidstudy.presentation.photo

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.devhjs.androidstudy.core.routing.MainRoute
import com.devhjs.androidstudy.core.util.Result
import com.devhjs.androidstudy.domain.usecase.GetPhotoListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    private val getPhotoListUseCase: GetPhotoListUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state = MutableStateFlow(PhotoState())
    val state = _state.asStateFlow()

    private val _event = MutableSharedFlow<PhotoEvent>()
    val event = _event.asSharedFlow()

    init {
        val albumId = savedStateHandle.toRoute<MainRoute.Photo>().albumId
        fetchPhoto(albumId = albumId)
    }

    private fun fetchPhoto(albumId: Int) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            when (val result = getPhotoListUseCase.execute(albumId = albumId)) {
                is Result.Success -> {
                    _state.update { it.copy(photos = result.data) }
                }

                is Result.Error -> {
                    _state.update { it.copy(error = result.error) }
                }
            }
        }
    }

    fun onAction(action: PhotoAction) {
        when (action) {
            is PhotoAction.OnPhotoClick -> {
                viewModelScope.launch {
                    _event.emit(PhotoEvent.OnPhotoClick)
                }
            }
            is PhotoAction.OnBackClick -> {
                viewModelScope.launch {
                    _event.emit(PhotoEvent.OnBackClick)
                }
            }
        }

    }
}