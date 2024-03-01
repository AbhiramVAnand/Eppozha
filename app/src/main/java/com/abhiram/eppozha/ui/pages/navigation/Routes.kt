package com.abhiram.eppozha.ui.pages.navigation


sealed class Routes(val route : String) {
    object Home : Routes("home")
    object Results : Routes("results")
}