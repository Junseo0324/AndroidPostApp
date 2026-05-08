package com.devhjs.androidstudy.domain.usecase

import com.devhjs.androidstudy.core.util.Result
import com.devhjs.androidstudy.domain.model.Address
import com.devhjs.androidstudy.domain.model.Company
import com.devhjs.androidstudy.domain.model.Geo
import com.devhjs.androidstudy.domain.model.User
import com.devhjs.androidstudy.domain.repository.UserRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GetUserUseCaseTest {

    private lateinit var userRepository: UserRepository
    private lateinit var getUserUseCase: GetUserUseCase

    private val fakeUser = User(
        id = 1, email = "test@test.com", name = "테스트 유저", phone = "010-1234-5678",
        username = "testuser", website = "test.com",
        address = Address(city = "서울", geo = Geo(lat = "37.5", lng = "127.0"), street = "강남대로", suite = "101호", zipcode = "06000"),
        company = Company(bs = "IT", catchPhrase = "혁신", name = "테스트회사")
    )

    @Before
    fun setUp() {
        userRepository = mockk()
        getUserUseCase = GetUserUseCase(userRepository)
    }

    @Test
    fun `유저 단건 조회 성공 시 Result_Success 반환`() = runTest {
        // Given
        coEvery { userRepository.getUser(1) } returns fakeUser

        // When
        val result = getUserUseCase.getUser(1)

        // Then
        assertTrue(result is Result.Success)
        assertEquals(fakeUser, (result as Result.Success).data)
    }

    @Test
    fun `유저 단건 조회 성공 시 데이터 필드가 올바른지 확인`() = runTest {
        // Given
        coEvery { userRepository.getUser(1) } returns fakeUser

        // When
        val result = getUserUseCase.getUser(1)

        // Then
        assertTrue(result is Result.Success)
        val user = (result as Result.Success).data
        assertEquals(1, user.id)
        assertEquals("테스트 유저", user.name)
        assertEquals("test@test.com", user.email)
        assertEquals("서울", user.address.city)
        assertEquals("테스트회사", user.company.name)
    }

    @Test
    fun `네트워크 오류 발생 시 Result_Error 반환`() = runTest {
        // Given
        coEvery { userRepository.getUser(1) } throws RuntimeException("네트워크 연결 실패")

        // When
        val result = getUserUseCase.getUser(1)

        // Then
        assertTrue(result is Result.Error)
        assertEquals("해당 유저 정보를 가져오는데 실패했습니다.", (result as Result.Error).error)
    }
}
