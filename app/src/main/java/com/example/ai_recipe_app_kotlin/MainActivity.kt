package com.example.ai_recipe_app_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.ai_recipe_app_kotlin.ui.components.AppToast
import com.example.ai_recipe_app_kotlin.ui.theme.AirecipeappkotlinTheme
import com.example.ai_recipe_app_kotlin.ui.theme.PrimaryColor
import com.example.ai_recipe_app_kotlin.ui.navigation.AppNavHost
import com.example.ai_recipe_app_kotlin.utils.ToastManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AirecipeappkotlinTheme {
                val toastState by ToastManager.toast.collectAsState()
                Box(modifier = Modifier.fillMaxSize()){
                    AppNavHost()

                    toastState?.let { state ->
                        LaunchedEffect(state.id) {
                            delay(3000L)
                            ToastManager.dismiss()
                        }

                        Column(modifier = Modifier.align(Alignment.TopCenter)) {
                            Spacer(modifier = Modifier.statusBarsPadding())
                            AppToast(state = state)
                        }
                    }
                }
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
