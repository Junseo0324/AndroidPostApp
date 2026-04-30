package com.devhjs.androidstudy.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devhjs.androidstudy.core.util.Result
import com.devhjs.androidstudy.domain.usecase.GetPostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListScreenViewModel @Inject constructor(
    private val getPostUseCase: GetPostUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(ListState())
    val state = _state.asStateFlow()

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            when (val result = getPostUseCase.execute()) {
                is Result.Success -> {
                    _state.update { it.copy(posts = result.data, isLoading = false) }
                }

                is Result.Error -> {
                    _state.update { it.copy(isLoading = false) }
                }
            }


        }
    }
}