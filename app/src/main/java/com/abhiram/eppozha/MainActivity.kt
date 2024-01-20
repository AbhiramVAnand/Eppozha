package com.abhiram.eppozha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abhiram.eppozha.ui.pages.Home
import com.abhiram.eppozha.ui.theme.EppozhaTheme
import com.abhiram.eppozha.viewmodels.ApiViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EppozhaTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Home()
                }
            }
        }
    }

    @Composable
    fun MyAppNavHost(
        navController: NavHostController = rememberNavController(),
        startDestination : String = "home"
    ){
        NavHost(navController = navController, startDestination = startDestination){
            composable("home"){
                Home()
            }
        }
    }


}