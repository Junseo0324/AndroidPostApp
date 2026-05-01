package com.devhjs.androidstudy.domain.usecase

import com.devhjs.androidstudy.core.util.Result
import com.devhjs.androidstudy.domain.model.User
import com.devhjs.androidstudy.domain.repository.UserRepository
import javax.inject.Inject

class GetUserListUseCase @Inject constructor(
    private val userRepository: UserRepository,
) {
    suspend fun execute(): Result<List<User>, String> {
        return try {
            val users = userRepository.getUsers()
            Result.Success(users)
        } catch (e: Exception) {
            Result.Error("유저 정보를 가져오는데 실패했습니다.")
        }
    }
}