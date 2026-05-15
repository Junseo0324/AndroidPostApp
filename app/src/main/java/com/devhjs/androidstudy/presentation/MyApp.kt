package com.devhjs.androidstudy.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.devhjs.androidstudy.domain.network.NetworkMonitor
import com.devhjs.androidstudy.presentation.component.NetworkStatusBar
import com.devhjs.androidstudy.presentation.main.MainScreenRoot

@Composable
fun MyApp(networkMonitor: NetworkMonitor) {
    val isOnline by networkMonitor.isOnline
        .collectAsStateWithLifecycle(initialValue = true)

    Box(modifier = Modifier.fillMaxSize()) {
        MainScreenRoot()
        NetworkStatusBar(
            isOnline = isOnline,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}