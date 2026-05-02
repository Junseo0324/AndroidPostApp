package com.devhjs.androidstudy.presentation.postdetail

sealed interface PostDetailEvent {
    data object onBackClick: PostDetailEvent
}