package com.devhjs.androidstudy.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devhjs.androidstudy.domain.model.Post
import com.devhjs.androidstudy.presentation.list.ListAction

@Composable
fun PostItem(
    post: Post,
    onAction: (ListAction) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(color = Color.White)
            .border(1.dp, color = Color.Black)
            .padding(16.dp)
            .clickable {
                onAction(ListAction.onPostClick(post.id))
            }
    ) {
        Text(
            text = post.title,
            color = Color.Black,
            fontSize = 40.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = post.body,
            color = Color.Black,
            fontSize = 20.sp,

        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PostItemPreview() {
    PostItem(
        post = Post(
            userId = 1,
            id = 1,
            title = "title",
            body = "body"
        )
    )
}