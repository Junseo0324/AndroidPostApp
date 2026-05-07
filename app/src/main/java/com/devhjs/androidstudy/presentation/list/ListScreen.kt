package com.devhjs.androidstudy.presentation.list

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListScreen(
    state: ListState = ListState(),
    onAction: (ListAction) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .height(150.dp)
                    .border(1.dp, Color.Black, shape = RoundedCornerShape(8.dp))
                    .clickable {
                        onAction(ListAction.OnPostClick)
                    },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("게시물", fontSize = 20.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(state.postSize.toString(),fontSize = 20.sp)
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .height(150.dp)
                    .border(1.dp, Color.Black, shape = RoundedCornerShape(8.dp))
                    .clickable {
                        onAction(ListAction.OnAlbumClick)
                    },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("앨범", fontSize = 20.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(state.albumSize.toString(), fontSize = 20.sp)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(150.dp)
                .border(1.dp, Color.Black, shape = RoundedCornerShape(8.dp))
                .clickable {
                    onAction(ListAction.OnTodoClick)
                },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("할 일", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(state.albumSize.toString(), fontSize = 20.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ListScreenPreview() {
    ListScreen()
}