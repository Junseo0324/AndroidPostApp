package com.devhjs.androidstudy.domain.usecase

import com.devhjs.androidstudy.core.util.Result
import com.devhjs.androidstudy.domain.model.Post
import com.devhjs.androidstudy.domain.repository.PostRepository
import javax.inject.Inject

class GetPostByUserUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend fun execute(userId: Int): Result<List<Post>, String> {
        return try {
            val posts = postRepository.getPostsByUserId(userId)
            Result.Success(posts)
        } catch (e: Exception) {
            Result.Error("해당 유저의 post를 가져오지 못했습니다.")
        }
    }
}