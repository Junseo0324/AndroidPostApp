package com.devhjs.androidstudy.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import com.devhjs.androidstudy.domain.network.NetworkMonitor
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.distinctUntilChanged
import javax.inject.Inject

/**
 * ConnectivityManager를 사용한 NetworkMonitor 구현체
 * callbackFlow로 NetworkCallback을 래핑하여 네트워크 상태를 Flow로 방출
 */
class DefaultNetworkMonitor @Inject constructor(
    @ApplicationContext private val context: Context
) : NetworkMonitor {

    override val isOnline: Flow<Boolean> = callbackFlow {
        val connectivityManager = context.getSystemService(ConnectivityManager::class.java)

        // 현재 네트워크 상태를 즉시 방출
        val currentNetwork = connectivityManager.activeNetwork
        val isCurrentlyConnected = connectivityManager
            .getNetworkCapabilities(currentNetwork)
            ?.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED) == true
        trySend(isCurrentlyConnected)

        val callback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                trySend(true)
            }

            override fun onLost(network: Network) {
                trySend(false)
            }

            override fun onCapabilitiesChanged(
                network: Network,
                networkCapabilities: NetworkCapabilities
            ) {
                // 실제 인터넷 접근 가능 여부 확인 (단순 연결이 아닌 검증된 연결)
                val validated = networkCapabilities
                    .hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
                trySend(validated)
            }
        }

        val request = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()

        connectivityManager.registerNetworkCallback(request, callback)

        // Flow가 취소될 때 콜백 해제 (메모리 누수 방지)
        awaitClose {
            connectivityManager.unregisterNetworkCallback(callback)
        }
    }
        .distinctUntilChanged() // 동일한 상태의 중복 방출 방지
        .conflate() // 최신 상태만 유지
}
