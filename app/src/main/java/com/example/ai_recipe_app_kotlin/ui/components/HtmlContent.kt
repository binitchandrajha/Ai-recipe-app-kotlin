package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.ai_recipe_app_kotlin.ui.screens.main.PrivacyPolicyContent

@Composable
fun HtmlContent(
    htmlContent: String = PrivacyPolicyContent,
    modifier: Modifier = Modifier
){
    AndroidView(
        modifier = modifier.fillMaxSize(),
        factory = { context ->
            android.webkit.WebView(context).apply {
                loadDataWithBaseURL(
                    null,
                    htmlContent,
                    "text/html",
                    "UTF-8",
                    null
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun HtmlContentPreview(){
    HtmlContent(
        htmlContent = PrivacyPolicyContent
    )
}