package com.example.ai_recipe_app_kotlin.ui.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ai_recipe_app_kotlin.data.BottomNavItems
import com.example.ai_recipe_app_kotlin.ui.navigation.Screen
import com.example.ai_recipe_app_kotlin.ui.theme.DarkPrimaryColor

@Composable
fun MainScreen(
    onRecipeClick: (String) -> Unit = {},
    onEditProfileClick: () -> Unit = {}
){
    val navController = rememberNavController()

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar(windowInsets = NavigationBarDefaults.windowInsets) {
               BottomNavItems.forEachIndexed { index, item ->
                   val isSelected = currentBackStackEntry
                       ?.destination
                       ?.hasRoute(item.route::class) == true
                   NavigationBarItem(
                       selected = isSelected,
                       onClick = {
                           navController.navigate(item.route) {
                               popUpTo(navController.graph.findStartDestination().id) {
                                   saveState = true
                               }
                               launchSingleTop = true
                               restoreState = true
                           }
                       },
                       label = {
                           Text(
                               text = item.label,
                               color = if(isSelected) DarkPrimaryColor else Color.Black
                           )
                               },
                       icon = {
                           Icon(
                               imageVector = item.icon,
                               contentDescription = item.label,
                               tint = if(isSelected) DarkPrimaryColor else Color.Black
                           )
                       }
                   )
               }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable <Screen.Home> {
                HomeScreen(
                    onRecipeClick = onRecipeClick
                )
            }
            composable<Screen.Saved> {
                SavedScreen()
            }
            composable<Screen.Profile> {
                ProfileScreen(
                    onEditClick = {
                        onEditProfileClick()
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview(){
    MainScreen()
}