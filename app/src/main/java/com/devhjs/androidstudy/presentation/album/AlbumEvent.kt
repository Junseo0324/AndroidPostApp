package com.devhjs.androidstudy.presentation.album

sealed interface AlbumEvent {
    data class OnNavigateToPhoto(val photoId: Int) : AlbumEvent
    object OnBackClick : AlbumEvent
}