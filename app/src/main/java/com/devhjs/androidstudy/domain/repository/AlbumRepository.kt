package com.devhjs.androidstudy.domain.repository

import com.devhjs.androidstudy.domain.model.Album

interface AlbumRepository {
    suspend fun getAlbumsByUserId(userId: Int): List<Album>
}