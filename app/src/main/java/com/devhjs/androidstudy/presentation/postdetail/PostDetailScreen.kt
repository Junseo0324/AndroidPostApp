package com.devhjs.androidstudy.presentation.postdetail

import androidx.compose.foundation.background
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devhjs.androidstudy.domain.model.Post
import com.devhjs.androidstudy.presentation.component.CommentItem

@Composable
fun PostDetailScreen(
    state: PostDetailState = PostDetailState(),
    onAction: (PostDetailAction) -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                modifier = Modifier.size(20.dp).clickable {
                    onAction(PostDetailAction.onBackClick)
                }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "뒤로 가기",
                fontSize = 16.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = state.post.title,
            fontSize = 24.sp,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 2
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = state.post.body,
            fontSize = 18.sp,
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Comment", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(state.comments) { comment ->
                CommentItem(
                    comment = comment
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun PostDetailScreenPreview() {
    PostDetailScreen(
        state = PostDetailState(
            post = Post(
                id = 1,
                title = "제목",
                body = "내용",
                userId = 1
            )
        )
    )
}