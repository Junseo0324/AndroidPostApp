package com.devhjs.androidstudy.core.di

import com.devhjs.androidstudy.data.repository.CommentRepositoryImpl
import com.devhjs.androidstudy.data.repository.PostRepositoryImpl
import com.devhjs.androidstudy.data.repository.UserRepositoryImpl
import com.devhjs.androidstudy.domain.repository.CommentRepository
import com.devhjs.androidstudy.domain.repository.PostRepository
import com.devhjs.androidstudy.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindPostRepository(
        postRepositoryImpl: PostRepositoryImpl
    ): PostRepository

    @Binds
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository

    @Binds
    abstract fun bindCommentRepository(
        commentRepositoryImpl: CommentRepositoryImpl
    ): CommentRepository

}