package com.devhjs.androidstudy.core.di

import com.devhjs.androidstudy.data.repository.AlbumRepositoryImpl
import com.devhjs.androidstudy.data.repository.CommentRepositoryImpl
import com.devhjs.androidstudy.data.network.DefaultNetworkMonitor
import com.devhjs.androidstudy.data.repository.PhotoRepositoryImpl
import com.devhjs.androidstudy.data.repository.PostRepositoryImpl
import com.devhjs.androidstudy.data.repository.TodoRepositoryImpl
import com.devhjs.androidstudy.data.repository.UserRepositoryImpl
import com.devhjs.androidstudy.domain.repository.AlbumRepository
import com.devhjs.androidstudy.domain.repository.CommentRepository
import com.devhjs.androidstudy.domain.network.NetworkMonitor
import com.devhjs.androidstudy.domain.repository.PhotoRepository
import com.devhjs.androidstudy.domain.repository.PostRepository
import com.devhjs.androidstudy.domain.repository.TodoRepository
import com.devhjs.androidstudy.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindNetworkMonitor(
        defaultNetworkMonitor: DefaultNetworkMonitor
    ): NetworkMonitor

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

    @Binds
    abstract fun bindAlbumRepository(
        albumRepositoryImpl: AlbumRepositoryImpl
    ): AlbumRepository

    @Binds
    abstract fun bindPhotoRepository(
        photoRepositoryImpl: PhotoRepositoryImpl
    ): PhotoRepository

    @Binds
    abstract fun bindTodoRepository(
        todoRepositoryImpl: TodoRepositoryImpl
    ): TodoRepository

}