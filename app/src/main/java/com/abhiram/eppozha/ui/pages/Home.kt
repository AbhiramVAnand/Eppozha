package com.abhiram.eppozha.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abhiram.eppozha.ui.theme.CardBorder
import com.abhiram.eppozha.ui.theme.Grey
import com.abhiram.eppozha.ui.theme.OffWhite
import com.abhiram.eppozha.ui.theme.Purple40

@Composable
fun Home(){
    Box(modifier = Modifier.fillMaxSize(1F)){
        Box(
            modifier = Modifier
                .background(OffWhite)
                .fillMaxHeight(0.6F)
                .fillMaxWidth(1F)
                .align(Alignment.BottomCenter)
        )
        Box(
            modifier = Modifier
                .fillMaxHeight(0.7F)
                .fillMaxWidth(1F)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                )
                .clip(RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp))
                .background(Grey)
                .padding(start = 24.dp, top = 20.dp)
                .align(Alignment.TopCenter)
        ){
            Column{
                Text(
                    text = "Eppozha",
                    style = MaterialTheme.typography.headlineLarge,
                    color = OffWhite
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "Find Your Bus",
                    style = MaterialTheme.typography.headlineMedium,
                    color = OffWhite
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Kerala Private Bus Finder",
                    style = MaterialTheme.typography.bodyLarge,
                    color = OffWhite
                )
            }
        }

        Box(
            modifier = Modifier
                .padding(top = 82.dp)
                .fillMaxHeight(0.69F)
                .fillMaxWidth(0.9F)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(20.dp)
                )
                .clip(RoundedCornerShape(20.dp))
                .border(width = 2.dp, color = CardBorder, shape = RoundedCornerShape(20.dp))
                .background(OffWhite)
                .align(Alignment.Center)

        ){

        }
    }
}

@Composable
@Preview
fun Preview() {
    Home()
}