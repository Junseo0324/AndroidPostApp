package com.devhjs.androidstudy.domain.usecase

import com.devhjs.androidstudy.domain.model.Post
import com.devhjs.androidstudy.domain.repository.PostRepository
import javax.inject.Inject

class GetPostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend fun execute(): List<Post> {
        return postRepository.getPosts()
    }
}