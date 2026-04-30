package com.devhjs.androidstudy.presentation.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devhjs.androidstudy.domain.model.Post

@Composable
fun PostItem(post: Post) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "userId", color = Color.Black, fontSize = 20.sp)
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "${post.userId}",
                color = Color.Black,
                fontSize = 20.sp,
                modifier = Modifier.width(100.dp)
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "id", color = Color.Black, fontSize = 20.sp)
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "${post.id}",
                color = Color.Black,
                fontSize = 20.sp,
                modifier = Modifier.width(100.dp)
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "title", color = Color.Black, fontSize = 20.sp)
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = post.title,
                color = Color.Black,
                fontSize = 20.sp,
                modifier = Modifier.width(100.dp)
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "body", color = Color.Black, fontSize = 20.sp)
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = post.body,
                color = Color.Black,
                fontSize = 20.sp,
                modifier = Modifier.width(100.dp)
            )
        }
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