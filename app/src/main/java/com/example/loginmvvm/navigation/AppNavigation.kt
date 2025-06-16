package com.example.loginmvvm.navigation

sealed class AppScreens(val route: String) {
    object Login : AppScreens("login")
    // Add more screens here as needed
}

object AppNavigation {
    const val Login = "login"
} 