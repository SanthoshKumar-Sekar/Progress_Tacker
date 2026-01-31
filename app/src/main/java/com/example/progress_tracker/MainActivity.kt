package com.example.progress_tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.progress_tracker.constants.NavigationRoutes
import com.example.progress_tracker.pages.HomeScreen
import com.example.progress_tracker.ui.theme.ProgressTrackerTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var navController: NavHostController
        enableEdgeToEdge()
        setContent {
            navController = rememberNavController()
            ProgressTrackerTheme {
                NavHost(
                    startDestination = NavigationRoutes.START_DESTINATION,
                    navController = navController
                ) {
                    composable("HomePage") {
                        HomeScreen(navController = navController)
                    }

                }
            }
        }
    }
}