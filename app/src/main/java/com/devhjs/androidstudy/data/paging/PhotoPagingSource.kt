package com.devhjs.androidstudy.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.devhjs.androidstudy.data.mapper.toModel
import com.devhjs.androidstudy.data.remote.api.PhotoApi
import com.devhjs.androidstudy.domain.model.Photo

class PhotoPagingSource(
    private val api: PhotoApi,
    private val albumId: Int,
) : PagingSource<Int, Photo>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        val page = params.key ?: 1

        return try {
            val photos = api.getPhotosByAlbumIdPaged(
                albumId = albumId,
                page = page,
                limit = params.loadSize
            )

            LoadResult.Page(
                data = photos.map { it.toModel() },
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (photos.isEmpty()) null else page + 1,
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return state.anchorPosition?.let { anchor ->
            state.closestPageToPosition(anchor)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchor)?.nextKey?.minus(1)
        }
    }
}
