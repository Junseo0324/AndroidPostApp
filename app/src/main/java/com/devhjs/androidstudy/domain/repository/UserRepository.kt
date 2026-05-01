package com.devhjs.androidstudy.domain.repository

import com.devhjs.androidstudy.domain.model.User

interface UserRepository {
    suspend fun getUsers(): List<User>

    suspend fun getUser(id: Int): User
}