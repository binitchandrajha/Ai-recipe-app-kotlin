package com.example.ai_recipe_app_kotlin.ui.screens.main

import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ai_recipe_app_kotlin.data.SimpleData
import com.example.ai_recipe_app_kotlin.model.ProfileMenuItem
import com.example.ai_recipe_app_kotlin.model.network.UserData
import com.example.ai_recipe_app_kotlin.ui.components.AppAsyncImage
import com.example.ai_recipe_app_kotlin.ui.components.ConfirmationPopupModal
import com.example.ai_recipe_app_kotlin.ui.components.OverlayLoader
import com.example.ai_recipe_app_kotlin.ui.components.PrimaryButton
import com.example.ai_recipe_app_kotlin.ui.theme.DarkPrimaryColor
import com.example.ai_recipe_app_kotlin.ui.theme.LightPrimaryColor
import com.example.ai_recipe_app_kotlin.ui.theme.PrimaryColor
import com.example.ai_recipe_app_kotlin.utils.AppSettings
import com.example.ai_recipe_app_kotlin.utils.FileUtils
import com.example.ai_recipe_app_kotlin.utils.ToastManager
import com.example.ai_recipe_app_kotlin.viewmodel.LoginViewModel
import com.example.ai_recipe_app_kotlin.viewmodel.ProfileViewModel

@Composable
fun ProfileHeader(
    onEditClick: () -> Unit,
    userInfo : UserData?
){
    val imageUrl = FileUtils.formatImageUrl(userInfo?.profileImage)
    val profileImageUri = imageUrl?.toUri() ?: Uri.EMPTY
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = 16.dp
            )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Row(
                modifier = Modifier.weight(1f)
            ) {
                AppAsyncImage(
                    model = profileImageUri,
                    contentDescription = "Profile picture",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(60.dp),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier.padding(start = 12.dp)
                ) {
                    userInfo?.name?.let {
                        Text(
                            text = it,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            maxLines = 2
                        )
                    }
                    Spacer(modifier = Modifier.size(4.dp))
                    userInfo?.mobileNumber?.let {
                        Text(
                            text = "${userInfo.countryCode} ${userInfo.mobileNumber}",
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp
                        )
                    }
                }
            }
            Row() {
                PrimaryButton(
                    btnText = "Edit",
                    containerColor = LightPrimaryColor,
                    border = BorderStroke(2.dp, DarkPrimaryColor),
                    btnTextColor = Color.Black,
                    modifier = Modifier.wrapContentWidth(),
                    onClick = { onEditClick() }
                )
            }
        }
    }
}

@Composable
fun ProfileMenu(title: String, lists: List<ProfileMenuItem>, onItemClick: (String) -> Unit){
    Column(
        modifier = Modifier.padding(start = 16.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
        )
        Spacer(modifier = Modifier.size(12.dp))
        lists.forEach { item ->
            Row(
                modifier = Modifier
                    .clickable(onClick = {
                        onItemClick(item.menuTitle)
                    })
                    .padding(start = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = item.menuIcon,
                    contentDescription = item.menuTitle,
                    tint = DarkPrimaryColor,
                    modifier = Modifier.size(24.dp)
                )
               Text(
                   text = item.menuTitle,
                   fontSize = 16.sp,
                   modifier = Modifier.padding(start = 8.dp)
               )
            }
            Spacer(modifier = Modifier.size(14.dp))
        }
    }
}

@Composable
fun ProfileScreen(
    onEditClick: () -> Unit = {},
    onPrivacyPolicyClick: () -> Unit = {},
    loginViewModel: LoginViewModel = hiltViewModel(),
    profileViewModel: ProfileViewModel = hiltViewModel(),
    onLogoutPress: () -> Unit = {},
){
    var showConfirmationModal by remember { mutableStateOf(false) }
    var userInfo by remember {mutableStateOf<UserData?>(null)}
    val isFetchingProfileInfo by profileViewModel.isFetchingProfileInfo.collectAsState()

    LaunchedEffect(Unit) {
        profileViewModel.getUserProfile({
                profileInfo ->
            userInfo = profileInfo
        }, {
                errorMessage ->
            ToastManager.showError(errorMessage)
        })
    }
    Scaffold(
        containerColor = PrimaryColor,
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding)) {
            Text(
                text = "Profile",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(20.dp))

            ProfileHeader(
                onEditClick,
                userInfo = userInfo
                )

            Spacer(modifier = Modifier.size(24.dp))
            ProfileMenu("Your Activity", SimpleData.activityItems, onItemClick = {

            })
            Spacer(modifier = Modifier.size(16.dp))
            ProfileMenu("App Settings", SimpleData.appSettings, onItemClick = {
                if(it == AppSettings.PRIVACY_POLICY){
                    onPrivacyPolicyClick()
                }
                if(it === AppSettings.LOGOUT){
                    showConfirmationModal = true
                }
            })

            OverlayLoader(
                isLoading = isFetchingProfileInfo
            )

            ConfirmationPopupModal(
                showModal = showConfirmationModal,
                onDismiss = {
                    showConfirmationModal = false
                },
                onConfirm = {
                    showConfirmationModal = false
                    loginViewModel.logout(
                        onSuccess = { successMessage ->
                            ToastManager.showSuccess(successMessage)
                            onLogoutPress()
                        },
                        onFailure = { errorMessage ->
                            ToastManager.showError(errorMessage)
                        }
                    )
                },
                confirmationText = "Are you sure want to logout?"
            )
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview(){
    ProfileScreen()
}