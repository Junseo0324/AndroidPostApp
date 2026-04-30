package com.devhjs.androidstudy.domain.usecase

import com.devhjs.androidstudy.core.util.Result
import com.devhjs.androidstudy.domain.model.Post
import com.devhjs.androidstudy.domain.repository.PostRepository
import javax.inject.Inject

class GetPostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend fun execute(postId: Int): Result<Post, Exception> {
        return try {
            val post = postRepository.getPost(postId)
            Result.Success(post)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}