package com.devhjs.androidstudy.domain.usecase

import com.devhjs.androidstudy.core.util.Result
import com.devhjs.androidstudy.domain.model.Comment
import com.devhjs.androidstudy.domain.repository.CommentRepository
import javax.inject.Inject

class GetCommentByPostUseCase @Inject constructor(
    private val commentRepository: CommentRepository
) {
    suspend fun execute(postId: Int): Result<List<Comment>, String> {
        return try {
            val comments = commentRepository.getCommentsByPostId(postId)
            Result.Success(comments)
        } catch (e: Exception) {
            Result.Error("에러가 발생했습니다.")
        }
    }
}