package com.devhjs.androidstudy.presentation.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

/**
 * 네트워크 연결 상태를 시각적으로 표현하는 Composable
 *
 * - 오프라인: 빨간 배경 + "네트워크 연결이 끊겼습니다" (계속 표시)
 * - 온라인 복귀: 초록 배경 + "네트워크가 연결되었습니다" (2초 후 자동 사라짐)
 */
@Composable
fun NetworkStatusBar(
    isOnline: Boolean,
    modifier: Modifier = Modifier
) {
    var showConnectedMessage by remember { mutableStateOf(false) }
    var wasOffline by remember { mutableStateOf(false) }

    LaunchedEffect(isOnline) {
        if (isOnline && wasOffline) {
            showConnectedMessage = true
            delay(2000L)
            showConnectedMessage = false
        }
        if (!isOnline) {
            wasOffline = true
        }
    }

    val isVisible = !isOnline || showConnectedMessage

    AnimatedVisibility(
        visible = isVisible,
        enter = expandVertically(expandFrom = Alignment.Bottom),
        exit = shrinkVertically(shrinkTowards = Alignment.Bottom),
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        val backgroundColor = if (isOnline) {
            Color(0xFF4CAF50)
        } else {
            Color(0xFFE53935)
        }

        val icon = if (isOnline) {
            Icons.Filled.Check
        } else {
            Icons.Filled.Warning
        }

        val message = if (isOnline) {
            "네트워크가 연결되었습니다"
        } else {
            "네트워크 연결이 끊겼습니다"
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(backgroundColor)
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = message,
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = message,
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
