package com.devhjs.androidstudy.core.di

import com.devhjs.androidstudy.data.remote.api.AlbumApi
import com.devhjs.androidstudy.data.remote.api.CommentApi
import com.devhjs.androidstudy.data.remote.api.PhotoApi
import com.devhjs.androidstudy.data.remote.api.PostApi
import com.devhjs.androidstudy.data.remote.api.UserApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    fun provideJson(): Json {
        return Json {
            ignoreUnknownKeys = true
        }
    }

    @Provides
    @Singleton
    fun provideRetrofit(json: Json): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(
                json.asConverterFactory("application/json".toMediaType())
            ).build()
    }

    @Provides
    @Singleton
    fun providePostApi(retrofit: Retrofit): PostApi {
        return retrofit.create(PostApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserApi(retrofit: Retrofit): UserApi {
        return retrofit.create(UserApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCommentApi(retrofit: Retrofit): CommentApi {
        return retrofit.create(CommentApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAlbumApi(retrofit: Retrofit): AlbumApi {
        return retrofit.create(AlbumApi::class.java)
    }

    @Provides
    @Singleton
    fun providePhotoApi(retrofit: Retrofit): PhotoApi {
        return retrofit.create(PhotoApi::class.java)
    }
}