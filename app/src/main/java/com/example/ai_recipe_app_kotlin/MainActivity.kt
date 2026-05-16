package com.example.ai_recipe_app_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.ai_recipe_app_kotlin.ui.theme.AirecipeappkotlinTheme
import com.example.ai_recipe_app_kotlin.ui.theme.PrimaryColor
import com.example.ai_recipe_app_kotlin.ui.navigation.AppNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AirecipeappkotlinTheme {
                AppNavHost()
            }
        }
    }
}

@Composable
fun App(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = PrimaryColor
    ) { innerPadding ->
        Text("Hello, world!")
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview(){
    App()
}
