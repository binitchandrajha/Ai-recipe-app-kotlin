package com.example.ai_recipe_app_kotlin.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ai_recipe_app_kotlin.ui.components.AppHeader
import com.example.ai_recipe_app_kotlin.ui.components.HtmlContent
import com.example.ai_recipe_app_kotlin.ui.theme.PrimaryColor
import com.example.ai_recipe_app_kotlin.utils.AppSettings

val PrivacyPolicyContent = """
    <html>
    <head>
        <style>
            body {                font-family: sans-serif;
                line-height: 1.6;
                color: #444;
                padding: 10px;
            }
            h3 {
                color: #222;
                margin-top: 20px;
                margin-bottom: 8px;
                font-size: 18px;
            }
            ul {
                padding-left: 20px;
                margin-top: 0;
            }
            li {
                margin-bottom: 5px;
            }
            p {
                margin-top: 0;
            }
        </style>
    </head>
    <body>
        <p>Your privacy is important to us. This Privacy Policy explains how Cook With AI collects, uses, and protects your information.</p>

        <h3>Information We Collect</h3>
        <ul>
            <li>Phone number (for login via OTP)</li>
            <li>Ingredients you add</li>
            <li>Recipes you view or save</li>
            <li>Basic app usage data to improve performance</li>
        </ul>

        <h3>How We Use Your Information</h3>
        <ul>
            <li>To generate recipes based on your ingredients</li>
            <li>To save your favorite recipes</li>
            <li>To improve app experience and features</li>
        </ul>

        <h3>Data Security</h3>
        <p>We use standard security measures to protect your data. Your information is never sold to third parties.</p>

        <h3>Third-Party Services</h3>
        <p>We may use trusted third-party services for authentication and analytics. These services follow their own privacy policies.</p>

        <h3>Your Choices</h3>
        <p>You can clear saved data or stop using the app at any time.</p>

        <h3>Updates</h3>
        <p>We may update this policy occasionally. Any changes will be reflected in the app.</p>

        <h3>Contact Us</h3>
        <p>If you have any questions, contact us at <a href="mailto:support@cookwithaiXXX.com">support@cookwithaiXXX.com</a></p>
    </body>
    </html>
""".trimIndent()

@Composable
fun PrivacyPolicyScreen(navController: NavController){
    Scaffold(
        containerColor = PrimaryColor,
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            AppHeader(
                title = AppSettings.PRIVACY_POLICY,
                onBackClick = {
                    navController.popBackStack()
                }
            )
            Spacer(modifier = Modifier.size(16.dp))
            HtmlContent()
            Text("hello")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrivacyPolicyScreenPreview(){
    PrivacyPolicyScreen(
        navController = NavController(LocalContext.current)
    )
}