package com.devhjs.androidstudy.data.remote.api

import com.devhjs.androidstudy.data.remote.dto.CommentDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CommentApi {

    @GET("/comments")
    suspend fun getComments(): List<CommentDto>

    @GET("/comments/{id}")
    suspend fun getComment(@Path("id") id: Int): CommentDto

    @GET("/comments")
    suspend fun getCommentsByPostId(@Query("postId") postId: Int): List<CommentDto>
}