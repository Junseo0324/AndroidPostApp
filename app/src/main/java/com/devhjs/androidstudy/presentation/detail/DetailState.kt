package com.devhjs.androidstudy.presentation.detail

import com.devhjs.androidstudy.domain.model.Post

data class DetailState(
    val isLoading: Boolean = false,
    val post: Post = Post(
        id = 0,
        title = "",
        body = "",
        userId = 0,
    )
)
