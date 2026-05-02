package com.devhjs.androidstudy.data.repository

import android.util.Log
import com.devhjs.androidstudy.data.mapper.toModel
import com.devhjs.androidstudy.data.remote.api.UserApi
import com.devhjs.androidstudy.domain.model.User
import com.devhjs.androidstudy.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UserApi
) : UserRepository {
    override suspend fun getUsers(): List<User> {
        Log.d("TAG", "getUsers: ${api.getUsers().map { it.toModel() }}")
        Log.d("TAG", "getUsers: ${api.getUsers()}")
        return api.getUsers().map { it.toModel() }
    }

    override suspend fun getUser(id: Int): User {
        return api.getUser(id).toModel()
    }

}