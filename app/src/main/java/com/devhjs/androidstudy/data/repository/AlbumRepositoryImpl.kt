package com.devhjs.androidstudy.data.repository

import com.devhjs.androidstudy.data.mapper.toModel
import com.devhjs.androidstudy.data.remote.api.AlbumApi
import com.devhjs.androidstudy.domain.model.Album
import com.devhjs.androidstudy.domain.repository.AlbumRepository
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(
    private val api: AlbumApi
) : AlbumRepository {
    override suspend fun getAlbumsByUserId(userId: Int): List<Album> {
        return api.getAlbumsByUserId(userId).map { it.toModel() }
    }

}