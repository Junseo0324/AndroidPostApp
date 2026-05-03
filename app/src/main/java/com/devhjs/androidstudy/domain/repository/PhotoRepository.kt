package com.devhjs.androidstudy.domain.repository

import com.devhjs.androidstudy.domain.model.Photo

interface PhotoRepository {
    suspend fun getPhotosByAlbumId(albumId: Int): List<Photo>
}