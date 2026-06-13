package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.example.ai_recipe_app_kotlin.data.SimpleData
import com.example.ai_recipe_app_kotlin.model.network.IngredientData

@Composable
fun SearchSuggestionList(
    ingredientList: List<IngredientData>? = null
){
   Card(
       colors = CardDefaults.cardColors(
           containerColor = Color.White,
       ),
       elevation = CardDefaults.cardElevation(
           defaultElevation = 8.dp
       )
   ) {
       LazyColumn(
           modifier = Modifier.heightIn(max = 300.dp)
       ) {
           ingredientList?.let { list ->
               items(list) {
                       item ->
                   IngredientCard(item, cardModifier = Modifier.fillMaxWidth().padding(4.dp), cardContainerContainer = Color.White)
               }
           }
       }
   }
}

@Preview(showBackground = true)
@Composable
fun SearchSuggestionListPreview(){
    SearchSuggestionList()
}