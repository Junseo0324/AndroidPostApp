package com.devhjs.androidstudy.data.remote.api

import com.devhjs.androidstudy.data.remote.dto.AlbumDto
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumApi {

    @GET("albums")
    suspend fun getAlbumsByUserId(@Query("userId") userId: Int): List<AlbumDto>
}