package com.devhjs.androidstudy.presentation.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devhjs.androidstudy.domain.model.Post

@Composable
fun PostItem(post: Post) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "userId")
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "${post.userId}")
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "id")
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "${post.id}")
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "title")
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = post.title)
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "body")
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = post.body)
        }
    }
}