package com.devhjs.androidstudy.data.mapper

import com.devhjs.androidstudy.data.remote.dto.GeoDto
import com.devhjs.androidstudy.domain.model.Geo

fun Geo.toDto(): GeoDto {
    return GeoDto(
        lat = lat,
        lng = lng,
    )
}

fun GeoDto.toModel():  Geo {
    return Geo(
        lat = lat ?: "",
        lng = lng ?: "",
    )
}