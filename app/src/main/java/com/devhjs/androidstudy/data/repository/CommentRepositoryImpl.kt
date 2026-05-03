package com.devhjs.androidstudy.data.repository

import com.devhjs.androidstudy.data.mapper.toModel
import com.devhjs.androidstudy.data.remote.api.CommentApi
import com.devhjs.androidstudy.domain.model.Comment
import com.devhjs.androidstudy.domain.repository.CommentRepository
import javax.inject.Inject

class CommentRepositoryImpl @Inject constructor(
    private val api: CommentApi
) : CommentRepository {
    override suspend fun getComments(): List<Comment> {
        return api.getComments().map { it.toModel() }
    }

    override suspend fun getComment(id: Int): Comment {
        return api.getComment(id).toModel()
    }

    override suspend fun getCommentsByPostId(postId: Int): List<Comment> {
        return api.getCommentsByPostId(postId).map { it.toModel() }
    }

}