package com.devhjs.androidstudy.data.mapper

import com.devhjs.androidstudy.data.remote.dto.PostDto
import com.devhjs.androidstudy.domain.model.Post

fun Post.toPostDto(): PostDto {
    return PostDto(
        userId = userId,
        id = id,
        title = title,
        body = body,
    )
}

fun PostDto.toModel(): Post {
    return Post(
        userId = userId ?: 0,
        id = id ?: 0,
        title = title ?: "",
        body = body ?: "",
    )
}