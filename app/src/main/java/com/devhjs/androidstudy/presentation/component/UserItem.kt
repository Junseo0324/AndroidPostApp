package com.devhjs.androidstudy.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.devhjs.androidstudy.domain.model.Address
import com.devhjs.androidstudy.domain.model.Company
import com.devhjs.androidstudy.domain.model.Geo
import com.devhjs.androidstudy.domain.model.User
import com.devhjs.androidstudy.presentation.user.UserAction

@Composable
fun UserItem(
    user: User,
    onAction: (UserAction) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .border(1.dp, Color.LightGray)
            .padding(16.dp)
            .clickable {
                onAction(UserAction.UserClick(user.id))
            }
    ) {
        Text(text = user.name, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Text(text = "@ ${user.username}", fontSize = 14.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(10.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = "이메일", fontSize = 12.sp, color = Color.Gray)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = user.email, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
            Column {
                Text(text = "전화번호", fontSize = 12.sp, color = Color.Gray)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = user.phone, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "웹사이트", fontSize = 12.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = user.website,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "주소", fontSize = 12.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "${user.address.street}, ${user.address.suite}\n${user.address.city} ${user.address.zipcode}",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.LightGray.copy(alpha = 0.3f))
                .padding(vertical = 12.dp, horizontal = 8.dp)
        ) {
            Text(text = "회사", fontSize = 12.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = user.company.name, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = user.company.catchPhrase, fontSize = 10.sp, color = Color.Gray)
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun UserItemPreview() {
    UserItem(
        user = User(
            id = 1,
            name = "Leanne Graham",
            username = "Bret",
            email = "Sincere@april.biz",
            address = Address(
                street = "Kulas Light",
                suite = "Apt. 556",
                city = "Gwenborough",
                zipcode = "92998-3874",
                geo = Geo(
                    lat = "-37.3159",
                    lng = "81.1496"
                )
            ),
            phone = "1-770-736-8031 x56442",
            website = "hildegard.org",
            company = Company(
                name = "Romaguera-Crona",
                catchPhrase = "Multi-layered client-server neural-net",
                bs = "harness real-time e-markets"
            )
        )
    )
}