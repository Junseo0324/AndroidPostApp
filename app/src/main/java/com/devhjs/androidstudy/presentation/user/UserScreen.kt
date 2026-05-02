package com.devhjs.androidstudy.presentation.user

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devhjs.androidstudy.presentation.component.UserItem

@Composable
fun UserScreen(
    state: UserState = UserState(),
    onAction: (UserAction) -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxSize().background(color = Color.White).padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "사용자 목록", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = "${state.users.size} 명", fontSize = 12.sp, color = Color.Gray)
        }
        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider()

        LazyColumn {
            items(state.users) { user ->
                UserItem(user)
            }
        }
    }
}

@Preview
@Composable
private fun UserScreenPreview() {
    UserScreen()
}