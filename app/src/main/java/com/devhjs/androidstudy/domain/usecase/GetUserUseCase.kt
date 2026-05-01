package com.devhjs.androidstudy.domain.usecase

import com.devhjs.androidstudy.core.util.Result
import com.devhjs.androidstudy.domain.model.User
import com.devhjs.androidstudy.domain.repository.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userRepository: UserRepository,
) {
    suspend fun getUser(id: Int): Result<User, String> {
        return try {
            val user = userRepository.getUser(id)
            Result.Success(user)
        } catch (e: Exception) {
            Result.Error("해당 유저 정보를 가져오는데 실패했습니다.")
        }
    }
}