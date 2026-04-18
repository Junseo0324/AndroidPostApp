package com.devhjs.androidstudy.data.repository

import com.devhjs.androidstudy.domain.model.Post
import com.devhjs.androidstudy.domain.repository.PostRepository

class PostRepositoryImpl : PostRepository {
    override suspend fun getPosts(): List<Post> {
        TODO("Not yet implemented")
    }

    override suspend fun getPost(id: Int): Post {
        TODO("Not yet implemented")
    }
}