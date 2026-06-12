package com.example.mytam.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mytam.ui.screen.AccountScreen
import com.example.mytam.ui.screen.DashboardScreen
import com.example.mytam.ui.screen.HistoryScreen
import com.example.mytam.ui.screen.LoginScreen
import com.example.mytam.ui.screen.ServiceScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = {
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
                onOpenService = {
                    navController.navigate(Screen.Service.route)
                },
                onOpenAccount = {
                    navController.navigate(Screen.Account.route)
                },
                onOpenHistory = {
                    navController.navigate(Screen.History.route)
                },
                onLogout = {
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
                onBack = {
                    navController.popBackStack()
                },
                onLogout = {
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