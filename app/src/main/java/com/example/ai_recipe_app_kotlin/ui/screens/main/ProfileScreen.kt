package com.example.ai_recipe_app_kotlin.ui.screens.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai_recipe_app_kotlin.data.SimpleData
import com.example.ai_recipe_app_kotlin.model.ProfileMenuItem
import com.example.ai_recipe_app_kotlin.ui.components.AppAsyncImage
import com.example.ai_recipe_app_kotlin.ui.components.PrimaryButton
import com.example.ai_recipe_app_kotlin.ui.theme.DarkPrimaryColor
import com.example.ai_recipe_app_kotlin.ui.theme.LightPrimaryColor
import com.example.ai_recipe_app_kotlin.ui.theme.PrimaryColor
import com.example.ai_recipe_app_kotlin.utils.AppSettings

@Composable
fun ProfileHeader(onEditClick: () -> Unit){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = 16.dp
            )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Row(
                modifier = Modifier.weight(1f)
            ) {
                AppAsyncImage(
                    model = "https://play-lh.googleusercontent.com/dSAi-HxlHjZDB0ycNR0t3BmIqKHE9Ix1-xgvvM-zeDW-QJa3mW7A8iHR6qgB3UQlJqaRwlcEavzRGScXMYjNeg=w240-h480-rw",
                    contentDescription = "Profile picture",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(60.dp),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier.padding(start = 12.dp)
                ) {
                    Text(
                        text = "Binit Chandra Jha",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        maxLines = 2
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(
                        text = "+1234567890",
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    )
                }
            }
            Row() {
                PrimaryButton(
                    btnText = "Edit",
                    containerColor = LightPrimaryColor,
                    border = BorderStroke(2.dp, DarkPrimaryColor),
                    btnTextColor = Color.Black,
                    modifier = Modifier.wrapContentWidth(),
                    onClick = { onEditClick() }
                )
            }
        }
    }
}

@Composable
fun ProfileMenu(title: String, lists: List<ProfileMenuItem>, onItemClick: (String) -> Unit){
    Column(
        modifier = Modifier.padding(start = 16.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
        )
        Spacer(modifier = Modifier.size(12.dp))
        lists.forEach { item ->
            Row(
                modifier = Modifier
                    .clickable(onClick = {
                        onItemClick(item.menuTitle)
                    })
                    .padding(start = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = item.menuIcon,
                    contentDescription = item.menuTitle,
                    tint = DarkPrimaryColor,
                    modifier = Modifier.size(24.dp)
                )
               Text(
                   text = item.menuTitle,
                   fontSize = 16.sp,
                   modifier = Modifier.padding(start = 8.dp)
               )
            }
            Spacer(modifier = Modifier.size(14.dp))
        }
    }
}

@Composable
fun ProfileScreen(
    onEditClick: () -> Unit = {},
    onPrivacyPolicyClick: () -> Unit = {}
){
    Scaffold(
        containerColor = PrimaryColor,
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding)) {
            Text(
                text = "Profile",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(20.dp))

            ProfileHeader(onEditClick)

            Spacer(modifier = Modifier.size(24.dp))
            ProfileMenu("Your Activity", SimpleData.activityItems, onItemClick = {

            })
            Spacer(modifier = Modifier.size(16.dp))
            ProfileMenu("App Settings", SimpleData.appSettings, onItemClick = {
                if(it == AppSettings.PRIVACY_POLICY){
                    onPrivacyPolicyClick()
                }
            })
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview(){
    ProfileScreen()
}