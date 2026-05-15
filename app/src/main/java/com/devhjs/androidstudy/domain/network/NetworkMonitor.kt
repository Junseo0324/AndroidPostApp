package com.devhjs.androidstudy.domain.network

import kotlinx.coroutines.flow.Flow

/**
 * 네트워크 연결 상태를 관찰하는 인터페이스
 */
interface NetworkMonitor {
    /** 네트워크 연결 여부를 실시간으로 방출하는 Flow */
    val isOnline: Flow<Boolean>
}
