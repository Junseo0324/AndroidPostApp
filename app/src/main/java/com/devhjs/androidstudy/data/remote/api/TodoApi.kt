package com.devhjs.androidstudy.data.remote.api

import com.devhjs.androidstudy.data.remote.dto.TodoDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TodoApi {
    @GET
    suspend fun getTodo(@Query("userId") userId: Int): List<TodoDto>
}