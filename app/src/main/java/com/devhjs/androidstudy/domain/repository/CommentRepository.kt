package com.devhjs.androidstudy.domain.repository

import com.devhjs.androidstudy.domain.model.Comment

interface CommentRepository {
    suspend fun getComments(): List<Comment>
    suspend fun getComment(id: Int): Comment
    suspend fun getCommentsByPostId(postId: Int): List<Comment>
}