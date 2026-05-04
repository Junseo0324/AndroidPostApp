package com.devhjs.androidstudy.presentation.photo

sealed interface PhotoAction {
    data object OnPhotoClick : PhotoAction
    data object OnBackClick : PhotoAction
}