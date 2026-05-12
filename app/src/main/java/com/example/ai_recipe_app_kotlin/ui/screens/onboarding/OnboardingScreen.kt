package com.example.ai_recipe_app_kotlin.ui.screens.onboarding

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ai_recipe_app_kotlin.data.SimpleData
import com.example.ai_recipe_app_kotlin.ui.components.HorizontalCarousel
import com.example.ai_recipe_app_kotlin.ui.theme.PrimaryColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.rememberCoroutineScope
import com.example.ai_recipe_app_kotlin.ui.theme.DarkPrimaryColor
import kotlinx.coroutines.launch


@Composable
fun OnboardingScreen(){
    val pagerState = rememberPagerState(pageCount = { SimpleData.onboardingList.size})
    val scope = rememberCoroutineScope()
    Scaffold(
        containerColor = PrimaryColor,
    ) { innerPadding ->
        Box(
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            contentAlignment = Alignment.Center
        ){
            HorizontalCarousel(
                state = pagerState,
            )

          if(pagerState.currentPage == SimpleData.onboardingList.size - 1) {
              Button(
                  onClick = { /*TODO*/ },
                  modifier = Modifier.align(Alignment.BottomCenter).fillMaxWidth().padding(horizontal = 16.dp),
                  colors = ButtonDefaults.buttonColors(
                      containerColor = DarkPrimaryColor
                  )
              ) {
                  Text(
                      text = "Get started"
                  )
              }
          } else {
              Button(
                  onClick = {
                      scope.launch {
                          pagerState.animateScrollToPage(pagerState.currentPage + 1)
                      }
                  },
                  modifier = Modifier.align(Alignment.BottomCenter),
                  colors = ButtonDefaults.buttonColors(
                      containerColor = DarkPrimaryColor
                  )
              ) {
                  Icon(
                      imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                      contentDescription = "Submit", // Accessibility label
                      tint = Color.White // Optional color styling
                  )
              }
          }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview(){
    OnboardingScreen()
}