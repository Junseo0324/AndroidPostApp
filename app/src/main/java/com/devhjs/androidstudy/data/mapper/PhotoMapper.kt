package com.devhjs.androidstudy.data.mapper

import com.devhjs.androidstudy.data.remote.dto.PhotoDto
import com.devhjs.androidstudy.domain.model.Photo

fun Photo.toDto(): PhotoDto {
    return PhotoDto(
        albumId = albumId,
        id = id,
        title = title,
        url = url,
        thumbnailUrl = thumbnailUrl
    )
}

fun PhotoDto.toModel(): Photo {
    return Photo(
        albumId = albumId ?: 0,
        id = id ?: 0,
        title = title ?: "",
        url = url ?: "",
        thumbnailUrl = thumbnailUrl ?: ""
    )
}