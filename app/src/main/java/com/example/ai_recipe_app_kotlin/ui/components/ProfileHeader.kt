package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ai_recipe_app_kotlin.model.network.UserData
import com.example.ai_recipe_app_kotlin.utils.FileUtils

@Composable
fun ProfileHeader(
    userInfo: UserData? = null
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ){
        Column(
            modifier = Modifier.weight(1f)
        ) {
            userInfo?.name?.let {
                Text(
                    text = it,
                    fontWeight = FontWeight.Bold,
                )
            }
            Spacer(modifier = Modifier.size(5.dp))
            Text(text = "What will you work on today?")
        }
        AppAsyncImage(
            model = FileUtils.formatImageUrl(userInfo?.profileImage),
            contentDescription = "Profile picture",
            modifier = Modifier.clip(CircleShape).size(50.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileHeaderPreview(){
    ProfileHeader()
}