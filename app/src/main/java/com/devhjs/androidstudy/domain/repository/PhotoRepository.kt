package com.devhjs.androidstudy.domain.repository

import androidx.paging.PagingData
import com.devhjs.androidstudy.domain.model.Photo
import kotlinx.coroutines.flow.Flow

interface PhotoRepository {
    suspend fun getPhotosByAlbumId(albumId: Int): List<Photo>
    fun getPhotosByAlbumIdPaged(albumId: Int): Flow<PagingData<Photo>>
}