package com.devhjs.androidstudy.presentation.list

sealed interface ListAction {
    data object OnPostClick : ListAction
    data object OnAlbumClick : ListAction
    data object OnTodoClick : ListAction
}