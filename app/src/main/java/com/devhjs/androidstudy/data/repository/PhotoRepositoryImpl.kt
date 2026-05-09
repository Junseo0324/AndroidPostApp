package com.devhjs.androidstudy.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.devhjs.androidstudy.data.mapper.toModel
import com.devhjs.androidstudy.data.paging.PhotoPagingSource
import com.devhjs.androidstudy.data.remote.api.PhotoApi
import com.devhjs.androidstudy.domain.model.Photo
import com.devhjs.androidstudy.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val api: PhotoApi
) : PhotoRepository {
    override suspend fun getPhotosByAlbumId(albumId: Int): List<Photo> {
        return api.getPhotosByAlbumId(albumId).map { it.toModel() }
    }

    override fun getPhotosByAlbumIdPaged(albumId: Int): Flow<PagingData<Photo>> {
        return Pager(
            config = PagingConfig(pageSize = 30),
            pagingSourceFactory = { PhotoPagingSource(api, albumId) }
        ).flow
    }
}