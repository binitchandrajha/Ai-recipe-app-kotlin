package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ai_recipe_app_kotlin.model.IngredientItem
import com.example.ai_recipe_app_kotlin.ui.theme.LightPrimaryColor

@Composable
fun IngredientCard(
    item: IngredientItem
){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = LightPrimaryColor
        ),
        modifier = Modifier.padding(6.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically){
            Box(
                modifier = Modifier.size(40.dp).clip(CircleShape).background(Color.White),
                contentAlignment = Alignment.Center
            ){
                AsyncImage(
                    model = item.ingredientImage,
                    contentDescription = item.title,
                    modifier = Modifier.size(30.dp).clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = item.title,
                modifier = Modifier.padding(8.dp,0.dp),
                fontWeight = FontWeight.Medium,
                color = Color.Black.copy(alpha = 0.6f)
            )
        }
    }
}

@Preview
@Composable
fun IngredientCardPreview(){
    IngredientCard(
        item = IngredientItem(
            title = "Flour",
            description = "All purpose flour",
            ingredientImage = "https://www.thespruceeats.com/thmb/J1_oUODgxQi9Gm6iccam2LNYPpQ=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-126372385-58950f353df78caebc239b4d.jpg"
        )
    )
}