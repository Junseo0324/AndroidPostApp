package com.devhjs.androidstudy.data.remote.api

import com.devhjs.androidstudy.data.remote.dto.PostDto
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApi {

    @GET("/posts")
    suspend fun getPosts(): List<PostDto>

    @GET("/posts/{id}")
    suspend fun getPost(@Path("id") id: Int): PostDto
}