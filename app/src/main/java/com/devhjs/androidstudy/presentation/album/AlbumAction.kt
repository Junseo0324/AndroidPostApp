package com.devhjs.androidstudy.presentation.album

sealed interface AlbumAction {
    data class OnPhotoClick(val photoId: Int) : AlbumAction
    object OnBackClick : AlbumAction
}