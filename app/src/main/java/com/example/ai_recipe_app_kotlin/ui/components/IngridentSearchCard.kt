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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun IngredientSearchCard(
    onRecipeClick: (String) -> Unit = {}
){
    var searchInput by remember { mutableStateOf("") }
    var showModal by remember { mutableStateOf(false) }
    var currentProgress by remember { mutableFloatStateOf(0f) }
    var isSearchInputFocused by remember { mutableStateOf(false) }

    fun onChangeSearchInput(input: String){
        searchInput = input
    }
    fun updateProgress(progress: Float){
        currentProgress = progress
    }
    fun handleSearchInputFocus(isFocused: Boolean){
        isSearchInputFocused = isFocused
    }

    /** Iterate the progress value */
    suspend fun loadProgress(updateProgress: (Float) -> Unit){
        for (i in 1..100){
            updateProgress(i.toFloat() / 100f)
            delay(100)
        }
    }

    LaunchedEffect(showModal) {
        if (showModal) {
            loadProgress { progress ->
                currentProgress = progress
            }
        }
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
                    IngredientList()
                    Spacer(modifier = Modifier.size(16.dp))
                    PrimaryButton(
                        btnText = "Generate Recipe",
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            showModal = true
                        }
                    )
                }
                if(isSearchInputFocused){
                    Spacer(modifier = Modifier.size(16.dp))
                    SearchSuggestionList()
                }
            }
        }

        AppModal(
            isVisible = showModal,
            onDismiss = {
                showModal = false
                currentProgress = 0f
                        },
            content = {
                Column(
                    modifier = Modifier.padding(
                        top = 24.dp,
                        bottom = 0.dp,
                        start = 24.dp,
                        end = 24.dp
                    )
                ) {
                    Text(
                        text = "Finding recipes for you...",
                        fontSize = 16.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.size(6.dp))
                    Text(
                        text = "Mixing your Ingredients to create delicious ideas",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Normal
                    )
                    Spacer(modifier = Modifier.size(6.dp))
                    RecipeProgressIndicator(
                        currentProgress = currentProgress,
                    )
                    Spacer(modifier = Modifier.size(6.dp))
                    AppAsyncImage(
                        model = "https://img.magnific.com/free-vector/vegetables-pot-realistic-concept-with-ingredients-cooking-symbols-vector-illustration_1284-16244.jpg?semt=ais_hybrid&w=740&q=80",
                        contentDescription = "Ingredients",
                        modifier = Modifier.fillMaxWidth().background(Color.White).height(400.dp)
                    )
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun IngredientSearchCardPreview(){
    IngredientSearchCard()
}