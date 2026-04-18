package com.devhjs.androidstudy.domain.repository

import com.devhjs.androidstudy.domain.model.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
    suspend fun getPost(id: Int): Post
}