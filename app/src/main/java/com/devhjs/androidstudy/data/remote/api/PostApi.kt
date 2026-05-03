package com.devhjs.androidstudy.data.remote.api

import com.devhjs.androidstudy.data.remote.dto.PostDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PostApi {

    @GET("/posts")
    suspend fun getPosts(): List<PostDto>

    @GET("/posts/{id}")
    suspend fun getPost(@Path("id") id: Int): PostDto

    @GET("/posts")
    suspend fun getPostsByUserId(@Query("userId") userId: Int): List<PostDto>
}