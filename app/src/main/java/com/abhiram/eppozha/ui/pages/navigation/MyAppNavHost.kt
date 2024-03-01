package com.abhiram.eppozha.ui.pages.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abhiram.eppozha.ui.pages.Home
import com.abhiram.eppozha.ui.pages.Results
import com.abhiram.eppozha.viewmodels.ApiViewModel

@SuppressLint("NewApi")
@Composable
fun MyAppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination : String = Routes.Home.route,
    viewModel : ApiViewModel
){
    NavHost(navController = navController, startDestination = startDestination){
        composable(Routes.Home.route){
            Home(viewModel = viewModel, navController = navController)
        }
        composable(Routes.Results.route){
            Results(viewModel = viewModel, navController = navController)
        }
    }
}