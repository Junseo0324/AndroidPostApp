package com.devhjs.androidstudy.presentation.list

sealed interface ListAction {
    data class OnPostClick(val userId: Int) : ListAction
    data class OnAlbumClick(val userId: Int) : ListAction
}