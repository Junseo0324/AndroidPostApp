package com.devhjs.androidstudy.presentation.postdetail

import androidx.compose.runtime.Immutable
import com.devhjs.androidstudy.domain.model.Comment
import com.devhjs.androidstudy.domain.model.Post

@Immutable
data class PostDetailState(
    val isLoading: Boolean = false,
    val post: Post = Post(
        id = 0,
        title = "",
        body = "",
        userId = 0,
    ),
    val comments: List<Comment> = emptyList(),
)
