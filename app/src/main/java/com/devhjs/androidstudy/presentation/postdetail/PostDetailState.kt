package com.devhjs.androidstudy.presentation.postdetail

import com.devhjs.androidstudy.domain.model.Post

data class PostDetailState(
    val isLoading: Boolean = false,
    val post: Post = Post(
        id = 0,
        title = "",
        body = "",
        userId = 0,
    )
)
