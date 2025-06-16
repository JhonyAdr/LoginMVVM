package com.example.loginmvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginmvvm.ui.screens.LoginScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppNavigation.Login) {
        composable(AppNavigation.Login) {
            LoginScreen()
        }
    }
} 