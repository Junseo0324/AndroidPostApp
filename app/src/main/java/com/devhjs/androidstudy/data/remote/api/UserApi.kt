package com.devhjs.androidstudy.data.remote.api

import com.devhjs.androidstudy.data.remote.dto.UserDto
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    @GET("/users")
    suspend fun getUsers(): List<UserDto>

    @GET("/users/{id}")
    suspend fun getUser(@Path("id") id: Int): UserDto
}