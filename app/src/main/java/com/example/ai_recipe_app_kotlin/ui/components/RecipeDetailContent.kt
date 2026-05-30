package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.SoupKitchen
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material.icons.outlined.SoupKitchen
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai_recipe_app_kotlin.data.SimpleData
import com.example.ai_recipe_app_kotlin.ui.theme.DarkPrimaryColor

@Composable
fun RecipeDetailContent(){
    Column(
        modifier = Modifier.padding(24.dp)
    ) {
        Text(
            text = "Tomato Bail Pasta",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.DarkGray
            )
        Spacer(modifier = Modifier.size(12.dp))
        Row() {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ){
                Icon(
                    imageVector = Icons.Default.AccessTime,
                    contentDescription = "AcesTimer",
                    modifier = Modifier.size(14.dp),
                    tint = DarkPrimaryColor

                )
                Spacer(modifier = Modifier.size(2.dp))
                Text(
                    text = "30mins",
                    fontSize = 14.sp
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 10.dp)
            ){
                Icon(
                    imageVector = Icons.Default.Restaurant,
                    contentDescription = "AcesTimer",
                    modifier = Modifier.size(14.dp),
                    tint = DarkPrimaryColor

                )
                Spacer(modifier = Modifier.size(2.dp))
                Text(
                    text = "30mins",
                    fontSize = 14.sp
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 10.dp)
            ){
                Icon(
                    imageVector = Icons.Default.SoupKitchen,
                    contentDescription = "AcesTimer",
                    modifier = Modifier.size(14.dp),
                    tint = DarkPrimaryColor

                )
                Spacer(modifier = Modifier.size(2.dp))
                Text(
                    text = "30mins",
                    fontSize = 14.sp
                )
            }
        }

        Spacer(modifier = Modifier.size(12.dp))
        Text(
            text = "Ingridents",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.DarkGray
        )
        Spacer(modifier = Modifier.size(12.dp))

        SimpleData.recipeDetailIngredients.forEach { item ->
                Column() {
                    Row () {
                        Text(
                            text = item.title,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp
                        )
                        Text(
                            text = "-",
                            modifier = Modifier.padding(start = 4.dp)
                        )
                        Text(
                            text = item.quantity,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }
                    Spacer(modifier = Modifier.size(10.dp))
                }
            }
        Spacer(modifier = Modifier.size(12.dp))

        SimpleData.recipeMakingSteps.forEach { item ->
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                ),
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(16.dp)
                ) {
                    Text(
                        text = item.step,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.size(12.dp))
                    Text(
                        text = item.stepDescription,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeDetailContentPreview(){
    RecipeDetailContent()
}