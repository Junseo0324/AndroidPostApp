package com.devhjs.androidstudy.domain.usecase

import com.devhjs.androidstudy.core.util.Result
import com.devhjs.androidstudy.domain.model.Post
import com.devhjs.androidstudy.domain.repository.PostRepository
import javax.inject.Inject

class GetPostListUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend fun execute(): Result<List<Post>,Exception> {
        return try {
            val posts = postRepository.getPosts()
            Result.Success(posts)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}