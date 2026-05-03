package com.devhjs.androidstudy.data.repository

import com.devhjs.androidstudy.data.mapper.toModel
import com.devhjs.androidstudy.data.remote.api.PostApi
import com.devhjs.androidstudy.domain.model.Post
import com.devhjs.androidstudy.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val api: PostApi
) : PostRepository {
    override suspend fun getPosts(): List<Post> {
        return api.getPosts().map { it.toModel() }
    }

    override suspend fun getPost(id: Int): Post {
        return api.getPost(id).toModel()
    }

    override suspend fun getPostsByUserId(userId: Int): List<Post> {
        return api.getPostsByUserId(userId).map { it.toModel() }
    }
}