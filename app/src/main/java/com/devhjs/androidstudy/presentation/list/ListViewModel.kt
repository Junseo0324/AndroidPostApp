package com.devhjs.androidstudy.presentation.list

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class ListViewModel : ViewModel() {
    private val _state = MutableStateFlow(ListState())
    val state = _state.asStateFlow()

    private val _event = MutableSharedFlow<ListEvent>()
    val event = _event.asSharedFlow()


}