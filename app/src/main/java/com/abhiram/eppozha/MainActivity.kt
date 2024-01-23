package com.abhiram.eppozha

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abhiram.eppozha.ui.pages.Home
import com.abhiram.eppozha.ui.pages.Results
import com.abhiram.eppozha.ui.pages.navigation.MyAppNavHost
import com.abhiram.eppozha.ui.pages.navigation.Routes
import com.abhiram.eppozha.ui.theme.EppozhaTheme
import com.abhiram.eppozha.viewmodels.ApiViewModel

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel : ApiViewModel = ApiViewModel()
        setContent {
            EppozhaTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MyAppNavHost(viewModel = viewModel)
                }
            }
        }
    }

}