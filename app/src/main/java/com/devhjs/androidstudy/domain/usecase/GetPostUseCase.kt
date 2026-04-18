package com.devhjs.androidstudy.domain.usecase

import com.devhjs.androidstudy.domain.model.Post
import com.devhjs.androidstudy.domain.repository.PostRepository

class GetPostUseCase(private val postRepository: PostRepository) {
    suspend fun execute(): List<Post> {
        return postRepository.getPosts()
    }
}