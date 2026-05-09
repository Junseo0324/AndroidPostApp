package com.devhjs.androidstudy.domain.usecase

import androidx.paging.PagingData
import com.devhjs.androidstudy.domain.model.Photo
import com.devhjs.androidstudy.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPhotoPagingUseCase @Inject constructor(
    private val photoRepository: PhotoRepository
) {
    fun execute(albumId: Int): Flow<PagingData<Photo>> {
        return photoRepository.getPhotosByAlbumIdPaged(albumId)
    }
}
