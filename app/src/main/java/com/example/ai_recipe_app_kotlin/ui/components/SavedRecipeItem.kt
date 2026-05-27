package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material.icons.outlined.SoupKitchen
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai_recipe_app_kotlin.model.SavedRecipeItem
import com.example.ai_recipe_app_kotlin.ui.theme.DarkPrimaryColor
import com.example.ai_recipe_app_kotlin.ui.theme.LightPrimaryColor

@Composable
fun SavedRecipeCardItem(
    item: SavedRecipeItem,
    onRecipeClick: (String) -> Unit = {}
){
    Card(
        modifier = Modifier.fillMaxWidth().clickable(onClick = {onRecipeClick(item.id)}),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
        ){
            Box(
                modifier = Modifier.
                    size(60.dp).
                    clip(RoundedCornerShape(22.dp)).
                background(LightPrimaryColor).
                padding(5.dp),
                contentAlignment = Alignment.Center
            ) {

                AppAsyncImage(
                    model = item.recipeImage ,
                    contentDescription = item.title,
                    modifier = Modifier.size(40.dp),
                    contentScale = ContentScale.Fit
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth().weight(1f).padding(start = 16.dp)
            ){
                Text(text = item.title)
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
                            imageVector = Icons.Outlined.Restaurant,
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
                            imageVector = Icons.Outlined.SoupKitchen,
                            contentDescription = "AcesTimer",
                            modifier = Modifier.size(14.dp),
                            tint = DarkPrimaryColor
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Text(
                            text = "${item.numberOfIngredientsUsed}",
                            fontSize = 14.sp
                        )
                    }
                }
            }

            IconButton(
                onClick = {},
                modifier = Modifier.align(Alignment.Top).size(22.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Bookmark,
                    contentDescription = "Bookmark",
                    modifier = Modifier.size(22.dp),
                    tint = DarkPrimaryColor
                )
            }
        }
    }
}

@Preview
@Composable
fun SavedRecipeCardItemPreview(){
    SavedRecipeCardItem(
        item = SavedRecipeItem(
            id = "saved-item-test-id",
            title = "Spaghetti Bolognese",
            recipeImage = "https://png.pngtree.com/png-clipart/20230129/original/pngtree-red-fresh-tomato-with-green-leaf-png-image_8933861.png",
            recipeDuration = "30 min",
            difficulty = com.example.ai_recipe_app_kotlin.model.Difficulty.Medium,
            numberOfIngredientsUsed = 5,
        )
    )
}