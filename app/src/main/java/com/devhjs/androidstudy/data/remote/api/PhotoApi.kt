package com.devhjs.androidstudy.data.remote.api

import com.devhjs.androidstudy.data.remote.dto.PhotoDto
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoApi {

    @GET("photos")
    suspend fun getPhotosByAlbumId(@Query("albumId") albumId: Int): List<PhotoDto>
}