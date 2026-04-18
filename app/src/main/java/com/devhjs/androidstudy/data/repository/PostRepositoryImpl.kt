package com.devhjs.androidstudy.data.repository

import com.devhjs.androidstudy.data.mapper.toModel
import com.devhjs.androidstudy.data.remote.api.PostApi
import com.devhjs.androidstudy.domain.model.Post
import com.devhjs.androidstudy.domain.repository.PostRepository

class PostRepositoryImpl(private val postApi: PostApi) : PostRepository {
    override suspend fun getPosts(): List<Post> {
        return postApi.getPosts().map { it.toModel() }
    }

    override suspend fun getPost(id: Int): Post {
        return postApi.getPost(id).toModel()
    }
}