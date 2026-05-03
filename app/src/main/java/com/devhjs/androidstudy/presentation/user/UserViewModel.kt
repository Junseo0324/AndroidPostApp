package com.devhjs.androidstudy.presentation.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devhjs.androidstudy.core.util.Result
import com.devhjs.androidstudy.domain.usecase.GetUserListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserListUseCase: GetUserListUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(UserState())
    val state = _state.asStateFlow()

    private val _event = MutableSharedFlow<UserEvent>()
    val event = _event.asSharedFlow()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            when(val result = getUserListUseCase.execute()) {
                is Result.Success -> {
                    _state.update { it.copy(isLoading = true, users = result.data) }
                }
                is Result.Error -> {
                    _state.update { it.copy(isLoading = false, error = result.error) }
                }
            }
        }
    }

    fun onAction(action: UserAction) {
        when (action) {
            is UserAction.UserClick -> {
                viewModelScope.launch {
                    _event.emit(UserEvent.NavigateToPost(action.id))
                }
            }
        }
    }
}