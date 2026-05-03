package com.devhjs.androidstudy.data.mapper

import com.devhjs.androidstudy.data.remote.dto.AlbumDto
import com.devhjs.androidstudy.domain.model.Album

fun Album.toDto(): AlbumDto {
    return AlbumDto(
        userId = userId,
        id = id,
        title = title
    )
}

fun AlbumDto.toModel(): Album {
    return Album(
        userId = userId ?: 0,
        id = id ?: 0,
        title = title ?: ""
    )
}