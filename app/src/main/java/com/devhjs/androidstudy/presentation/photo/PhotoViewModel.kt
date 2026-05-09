package com.devhjs.androidstudy.presentation.photo

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.devhjs.androidstudy.core.routing.MainRoute
import com.devhjs.androidstudy.domain.model.Photo
import com.devhjs.androidstudy.domain.usecase.GetPhotoPagingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    getPhotoPagingUseCase: GetPhotoPagingUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
//    private val _state = MutableStateFlow(PhotoState())
//    val state = _state.asStateFlow()

    private val _event = MutableSharedFlow<PhotoEvent>()
    val event = _event.asSharedFlow()

    private val albumId = savedStateHandle.toRoute<MainRoute.Photo>().albumId


    val photoPagingData: Flow<PagingData<Photo>> =
        getPhotoPagingUseCase.execute(albumId)
            .cachedIn(viewModelScope)

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