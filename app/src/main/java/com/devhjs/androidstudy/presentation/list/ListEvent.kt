package com.devhjs.androidstudy.presentation.list

sealed interface ListEvent {
    data class OnNavigateToPost(val userId: Int) : ListEvent
    data class OnNavigateToAlbum(val userId: Int) : ListEvent
}