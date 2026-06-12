package com.example.mytam.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Dashboard : Screen("dashboard")
    object Service : Screen("service")
    object Account : Screen("account")
    object History : Screen("history")
}