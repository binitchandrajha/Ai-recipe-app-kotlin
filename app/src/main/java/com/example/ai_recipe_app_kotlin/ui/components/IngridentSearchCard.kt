package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai_recipe_app_kotlin.model.network.IngredientData
import kotlinx.coroutines.delay

@Composable
fun IngredientSearchCard(
    onRecipeClick: (String) -> Unit = {},
    ingredientList: List<IngredientData>? = null,
    searchInput: String = "",
    onChangeSearchInput: (String) -> Unit = {},
    selectedIngredientList: List<IngredientData> = emptyList(),
    handleSelectedIngredient: (IngredientData) -> Unit = {},
    onGenerateRecipeClick: () -> Unit = {}
){
    var showModal by remember { mutableStateOf(false) }
    var currentProgress by remember { mutableFloatStateOf(0f) }
    var isSearchInputFocused by remember { mutableStateOf(false) }

    val focusManager = LocalFocusManager.current

    fun updateProgress(progress: Float){
        currentProgress = progress
    }
    fun handleSearchInputFocus(isFocused: Boolean){
        isSearchInputFocused = isFocused
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
                },
                onFocusChange = {
                    handleSearchInputFocus(it)
                }
            )
            Box(){
                Column() {
                    Spacer(modifier = Modifier.size(16.dp))
                    IngredientList(
                        ingredientList = selectedIngredientList
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                    PrimaryButton(
                        btnText = "Generate Recipe",
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
//                            showModal = true
                            onGenerateRecipeClick()
                        }
                    )
                }
                if(isSearchInputFocused){
                    Spacer(modifier = Modifier.size(16.dp))
                    SearchSuggestionList(
                        ingredientList = ingredientList,
                        selectedIngredientList = selectedIngredientList,
                        handleSelectedIngredient = {
                            handleSelectedIngredient(it)
                        },
                        onDismissRequest = {
                            isSearchInputFocused = false
                            focusManager.clearFocus()
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IngredientSearchCardPreview(){
    IngredientSearchCard()
}