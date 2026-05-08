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

class GetUserListUseCaseTest {

    private lateinit var userRepository: UserRepository
    private lateinit var getUserListUseCase: GetUserListUseCase

    private val fakeUsers = listOf(
        User(
            id = 1, email = "test1@test.com", name = "유저1", phone = "010-1234-5678",
            username = "user1", website = "test1.com",
            address = Address(city = "서울", geo = Geo(lat = "37.5", lng = "127.0"), street = "강남대로", suite = "101호", zipcode = "06000"),
            company = Company(bs = "IT", catchPhrase = "혁신", name = "테스트회사1")
        ),
        User(
            id = 2, email = "test2@test.com", name = "유저2", phone = "010-9876-5432",
            username = "user2", website = "test2.com",
            address = Address(city = "부산", geo = Geo(lat = "35.1", lng = "129.0"), street = "해운대로", suite = "202호", zipcode = "48000"),
            company = Company(bs = "금융", catchPhrase = "신뢰", name = "테스트회사2")
        ),
    )

    @Before
    fun setUp() {
        userRepository = mockk()
        getUserListUseCase = GetUserListUseCase(userRepository)
    }

    @Test
    fun `유저 목록 조회 성공 시 Result_Success 반환`() = runTest {
        // Given
        coEvery { userRepository.getUsers() } returns fakeUsers

        // When
        val result = getUserListUseCase.execute()

        // Then
        assertTrue(result is Result.Success)
        assertEquals(fakeUsers, (result as Result.Success).data)
    }

    @Test
    fun `유저 목록 조회 성공 시 반환된 개수가 올바른지 확인`() = runTest {
        // Given
        coEvery { userRepository.getUsers() } returns fakeUsers

        // When
        val result = getUserListUseCase.execute()

        // Then
        assertTrue(result is Result.Success)
        assertEquals(2, (result as Result.Success).data.size)
    }

    @Test
    fun `유저가 없을 때 빈 리스트를 Success로 반환`() = runTest {
        // Given
        coEvery { userRepository.getUsers() } returns emptyList()

        // When
        val result = getUserListUseCase.execute()

        // Then
        assertTrue(result is Result.Success)
        assertTrue((result as Result.Success).data.isEmpty())
    }

    @Test
    fun `네트워크 오류 발생 시 Result_Error 반환`() = runTest {
        // Given
        coEvery { userRepository.getUsers() } throws RuntimeException("네트워크 연결 실패")

        // When
        val result = getUserListUseCase.execute()

        // Then
        assertTrue(result is Result.Error)
        assertEquals("유저 정보를 가져오는데 실패했습니다.", (result as Result.Error).error)
    }
}
