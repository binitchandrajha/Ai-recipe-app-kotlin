package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai_recipe_app_kotlin.R
import com.example.ai_recipe_app_kotlin.data.SimpleData
import com.example.ai_recipe_app_kotlin.model.OnboardingItem
import com.example.ai_recipe_app_kotlin.ui.theme.TextBlack

@Composable
fun HorizontalCarousel(state: PagerState){
   Column() {
       HorizontalPager(
           state = state
       ) {
               page ->
           Column(
               modifier = Modifier.fillMaxWidth(),
               horizontalAlignment = Alignment.CenterHorizontally
           ) {
               Image(
                   painter = painterResource(id = SimpleData.onboardingList[page].image),
                   contentDescription = SimpleData.onboardingList[page].title,
                   modifier = Modifier.height(300.dp).width(300.dp)
               )
               Spacer(modifier = Modifier.size(10.dp))
               Text(
                   text = SimpleData.onboardingList[page].title,
                   color = TextBlack,
                   fontSize = 25.sp,
                   fontWeight = FontWeight.SemiBold
               )
               Spacer(modifier = Modifier.size(10.dp))
               Text(
                   text = SimpleData.onboardingList[page].description,
                   color = TextBlack,
                   fontSize = 15.sp,
                   fontWeight = FontWeight.Normal
               )
           }
       }
       Spacer(modifier = Modifier.size(10.dp))
       PagingIndicator(state)
   }
}

@Preview
@Composable
fun HorizontalCarouselPreview(){
    val state = rememberPagerState(pageCount = { SimpleData.onboardingList.size})
    val items = listOf(OnboardingItem(
        title = "Welcome to AI Recipe",
        description = "Discover delicious recipes powered by AI.",
        image = R.drawable.onboarding_first
    ))
    HorizontalCarousel(
        state = state,
    )
}