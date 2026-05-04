package com.devhjs.androidstudy.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devhjs.androidstudy.domain.model.Album

@Composable
fun AlbumItem(
    album: Album,
    onItemClick: (Int) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White, shape = RoundedCornerShape(10.dp))
            .border(1.dp,Color.Gray)
            .padding(12.dp)
            .clickable {
                onItemClick(album.id)
            }
    ) {
        Text(text = album.title, color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true)
@Composable
private fun AlbumItemPreview() {
    AlbumItem(
        album = Album(
            userId = 1,
            id = 1,
            title = "title"
        )
    )
}