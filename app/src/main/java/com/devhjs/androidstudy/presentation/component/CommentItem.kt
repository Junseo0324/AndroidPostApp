package com.devhjs.androidstudy.presentation.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devhjs.androidstudy.domain.model.Comment

@Composable
fun CommentItem(
    comment: Comment,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.LightGray)
            .padding(16.dp)
    ) {
        Text(
            text = comment.name,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = comment.email,
            fontSize = 12.sp,
            color = Color.LightGray
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = comment.body,
            fontSize = 12.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CommentItemPreview() {
    CommentItem(
        comment = Comment(
            id = 1,
            postId = 1,
            name = "id labore ex et quam laborum",
            email = "Eliseo@gardner.biz",
            body = "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
        )
    )
}