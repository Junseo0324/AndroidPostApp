package com.devhjs.androidstudy.domain.model

data class Comment(
    val postId: Int? = null,
    val id: Int? = null,
    val name: String,
    val email: String,
    val body: String,
)
