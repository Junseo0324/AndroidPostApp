package com.devhjs.androidstudy.presentation.postdetail

sealed interface PostDetailAction {
    data object onBackClick: PostDetailAction
}