package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IngredientSearchCard(
    onRecipeClick: (String) -> Unit = {}
){
    var searchInput by remember { mutableStateOf("") }
    fun onChangeSearchInput(input: String){
        searchInput = input
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp).clickable(onClick = {}),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            Text(
                text = "We will turn your ingredients into a delicious recipe!",
                fontSize = 16.sp,
                color = Color.Gray,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.size(16.dp))
            SearchInput(
                value = searchInput,
                onValueChange = {
                    onChangeSearchInput(it)
                },
                onMicClick = {
                    println("mic clicked....")
                }
            )
            Spacer(modifier = Modifier.size(16.dp))
            IngredientList()
            Spacer(modifier = Modifier.size(16.dp))
            PrimaryButton(
                btnText = "Generate Recipe",
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IngredientSearchCardPreview(){
    IngredientSearchCard()
}