package com.devhjs.androidstudy.domain.usecase

import com.devhjs.androidstudy.domain.model.Comment
import com.devhjs.androidstudy.domain.repository.CommentRepository
import javax.inject.Inject

class GetCommentByPostUseCase @Inject constructor(
    private val commentRepository: CommentRepository
) {
    suspend fun execute(postId: Int): List<Comment> {
        return commentRepository.getCommentsByPostId(postId)
    }
}