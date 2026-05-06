package com.devhjs.androidstudy.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devhjs.androidstudy.domain.model.Todo

@Composable
fun TodoItem(
    todo: Todo
) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .background(Color.White)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            checked = todo.completed,
            onCheckedChange = {},
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Blue,
                uncheckedColor = Color.Gray
            )
        )
        Text(
            text = todo.title
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun TodoItemPreview() {
    TodoItem(
        todo = Todo(
            userId = 1,
            id = 1,
            title = "title",
            completed = true
        )
    )
}