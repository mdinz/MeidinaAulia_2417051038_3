package com.example.mytam.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mytam.data.model.UserSession
import com.example.mytam.ui.screen.AccountScreen
import com.example.mytam.ui.screen.DashboardScreen
import com.example.mytam.ui.screen.HistoryScreen
import com.example.mytam.ui.screen.LoginScreen
import com.example.mytam.ui.screen.ServiceScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    var currentUser by remember {
        mutableStateOf<UserSession?>(null)
    }

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = { user ->
                    currentUser = user

                    navController.navigate(Screen.Dashboard.route) {
                        popUpTo(Screen.Login.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(Screen.Dashboard.route) {
            DashboardScreen(
                user = currentUser,
                onOpenService = {
                    navController.navigate(Screen.Service.route)
                },
                onOpenAccount = {
                    navController.navigate(Screen.Account.route)
                },
                onLogout = {
                    currentUser = null

                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Dashboard.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(Screen.Service.route) {
            ServiceScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.Account.route) {
            AccountScreen(
                user = currentUser,
                onBack = {
                    navController.popBackStack()
                },
                onLogout = {
                    currentUser = null

                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Dashboard.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(Screen.History.route) {
            HistoryScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}