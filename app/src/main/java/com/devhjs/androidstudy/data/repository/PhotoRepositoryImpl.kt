package com.devhjs.androidstudy.data.repository

import com.devhjs.androidstudy.data.mapper.toModel
import com.devhjs.androidstudy.data.remote.api.PhotoApi
import com.devhjs.androidstudy.domain.model.Photo
import com.devhjs.androidstudy.domain.repository.PhotoRepository
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val api: PhotoApi
) : PhotoRepository {
    override suspend fun getPhotosByAlbumId(albumId: Int): List<Photo> {
        return api.getPhotosByAlbumId(albumId).map { it.toModel() }
    }
}