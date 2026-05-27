package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.ai_recipe_app_kotlin.model.Difficulty
import com.example.ai_recipe_app_kotlin.model.QuickRecipeItem
import com.example.ai_recipe_app_kotlin.ui.theme.DarkPrimaryColor

@Composable
fun QuickIdeasRecipeListItem(
    item: QuickRecipeItem
){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = Modifier.width(200.dp)
    ) {
        AsyncImage(
            model = item.recipeImage,
            contentDescription = item.title,
            modifier = Modifier.fillMaxWidth().height(150.dp),
            contentScale = ContentScale.Crop,
        )
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ){
            Column(
                modifier = Modifier.fillMaxWidth().weight(1f)
            ){
                Text(
                    text = item.title,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.DarkGray
                )

                Spacer(modifier = Modifier.size(6.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.AccessTime,
                            contentDescription = "AcesTimer",
                            modifier = Modifier.size(14.dp),
                            tint = DarkPrimaryColor
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Text(
                            text = item.recipeDuration,
                            fontSize = 14.sp
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Restaurant,
                            contentDescription = "AcesTimer",
                            modifier = Modifier.size(14.dp),
                            tint = DarkPrimaryColor
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Text(
                            text = "${item.difficulty}",
                            fontSize = 14.sp
                        )
                    }
                }
            }

            IconButton(
                onClick = {},
                modifier = Modifier.size(22.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Bookmark,
                    contentDescription = "Bookmark",
                    modifier = Modifier.size(22.dp),
                    tint = if(item.isFavorite) DarkPrimaryColor else Color.Black
                )
            }
        }
    }
}

@Preview
@Composable
fun QuickIdeasRecipeListItemPreview(){
    QuickIdeasRecipeListItem(
        item = QuickRecipeItem(
            recipeImage = "https://vismaifood.com/storage/app/uploads/public/8b4/19e/427/thumb__1200_0_0_0_auto.jpg",
            title = "Masala dosa",
            recipeDuration = "30 min",
            difficulty = Difficulty.Easy,
            isFavorite = false
        )
    )
}