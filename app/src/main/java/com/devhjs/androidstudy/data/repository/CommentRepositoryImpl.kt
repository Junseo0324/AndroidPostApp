package com.devhjs.androidstudy.data.repository

import com.devhjs.androidstudy.data.mapper.toModel
import com.devhjs.androidstudy.data.remote.api.CommentApi
import com.devhjs.androidstudy.domain.model.Comment
import com.devhjs.androidstudy.domain.repository.CommentRepository
import javax.inject.Inject

class CommentRepositoryImpl @Inject constructor(
    private val commentApi: CommentApi
) : CommentRepository {
    override suspend fun getComments(): List<Comment> {
        return commentApi.getComments().map { it.toModel() }
    }

    override suspend fun getComment(id: Int): Comment {
        return commentApi.getComment(id).toModel()
    }

    override suspend fun getCommentsByPostId(postId: Int): List<Comment> {
        return commentApi.getCommentsByPostId(postId).map { it.toModel() }
    }

}