package com.devhjs.androidstudy.presentation.photo

sealed interface PhotoEvent {
    data object OnPhotoClick: PhotoEvent
    data object OnBackClick : PhotoEvent
}