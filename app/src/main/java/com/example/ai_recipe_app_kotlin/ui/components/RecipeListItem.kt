package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import com.example.ai_recipe_app_kotlin.model.network.RecipeItem
import com.example.ai_recipe_app_kotlin.ui.theme.DarkPrimaryColor

@Composable
fun RecipeListItem(
    item: RecipeItem,
    onClick: () -> Unit = {}
){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = Modifier.fillMaxWidth().clickable(onClick = onClick)
    ) {
        AppAsyncImage(
            model = item.recipeImage,
            contentDescription = item.title,
            modifier = Modifier.fillMaxWidth().height(180.dp),
            contentScale = ContentScale.Crop,
        )
        Row(
            modifier = Modifier.fillMaxWidth().padding(12.dp),
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
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.AccessTime,
                            contentDescription = "Duration",
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
                            contentDescription = "Difficulty",
                            modifier = Modifier.size(14.dp),
                            tint = DarkPrimaryColor
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Text(
                            text = item.difficulty,
                            fontSize = 14.sp
                        )
                    }
                }
            }

            Icon(
                imageVector = Icons.Default.Bookmark,
                contentDescription = "Bookmark",
                modifier = Modifier.size(22.dp),
                tint = if (item.isFavorite) DarkPrimaryColor else Color.Black
            )
        }
    }
}

@Preview
@Composable
fun RecipeListItemPreview(){
    RecipeListItem(
        item = RecipeItem(
            title = "Tomato Pasta",
            recipeImage = "https://img.magnific.com/free-photo/penne-pasta-tomato-sauce-with-chicken-tomatoes-wooden-table_2829-19744.jpg",
            recipeDuration = "30 min",
            difficulty = "Easy",
            numberOfIngredientsUsed = 5,
            isQuickIdea = false,
            ingredients = emptyList(),
            steps = emptyList(),
            createdAt = "",
            updatedAt = "",
            id = "preview-id",
            isFavorite = false
        )
    )
}
