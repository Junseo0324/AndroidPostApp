package com.devhjs.androidstudy.presentation.post

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devhjs.androidstudy.presentation.component.PostItem

@Composable
fun PostScreen(
    state: PostState,
    onAction: (PostAction) -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                modifier = Modifier.size(24.dp).clickable {
                    onAction(PostAction.BackClick)
                }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "게시글",
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "${state.posts.size} 개", fontSize = 12.sp, color = Color.Gray)
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.posts) { post ->
                PostItem(
                    post = post,
                    onAction = onAction
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PostScreenPreview() {
    PostScreen(
        state = PostState()
    )
}