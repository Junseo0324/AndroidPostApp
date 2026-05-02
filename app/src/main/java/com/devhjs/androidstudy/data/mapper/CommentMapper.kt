package com.devhjs.androidstudy.data.mapper

import com.devhjs.androidstudy.data.remote.dto.CommentDto
import com.devhjs.androidstudy.domain.model.Comment

fun Comment.toDto(): CommentDto {
    return CommentDto(
        postId = postId,
        id = id,
        name = name,
        email = email,
        body = body,
    )
}

fun CommentDto.toModel(): Comment {
    return Comment(
        postId = postId,
        id = id,
        name = name ?: "",
        email = email ?: "",
        body = body ?: "",
    )
}