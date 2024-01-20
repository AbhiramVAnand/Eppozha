package com.abhiram.eppozha.ui.pages

import android.widget.Toast
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import com.abhiram.eppozha.ui.theme.ButtonBackground
import com.abhiram.eppozha.ui.theme.CardBorder
import com.abhiram.eppozha.ui.theme.Grey
import com.abhiram.eppozha.ui.theme.LightGrey
import com.abhiram.eppozha.ui.theme.OffWhite
import com.abhiram.eppozha.ui.theme.Purple40
import com.abhiram.eppozha.viewmodels.ApiViewModel
import kotlinx.coroutines.launch

@Composable
fun Home(){
    val viewModel : ApiViewModel = ApiViewModel()
    var context = LocalContext.current
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
                .fillMaxHeight(0.6F)
                .fillMaxWidth(1F)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                )
                .clip(RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp))
                .background(Grey)
                .padding(start = 24.dp, top = 32.dp)
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
                .padding(top = 64.dp)
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
            Column(
                modifier = Modifier
                    .padding(start = 24.dp, top = 46.dp, end = 24.dp, bottom = 46.dp)
                    .fillMaxWidth(1F)
            ) {
                Text(
                    text = "Where are you going?",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Grey
                )
                Spacer(modifier = Modifier.height(20.dp))
                var from by remember {
                    mutableStateOf(TextFieldValue(""))
                }
                OutlinedTextField(
                    value = from,
                    onValueChange = { from = it},
                    modifier = Modifier.fillMaxWidth(1F),
                    label = {
                        Text(
                            text = "From",
                            color = Grey
                        )
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
                var to by remember {
                    mutableStateOf(TextFieldValue(""))
                }
                OutlinedTextField(
                    value = to,
                    onValueChange = { to = it},
                    modifier = Modifier.fillMaxWidth(1F),
                    label = {
                        Text(
                            text = "To",
                            color = Grey
                        )
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {
                        if (from.text.isNotEmpty()&&to.text.isNotEmpty()){
                            viewModel.viewModelScope.launch {
                                var res = viewModel.GetSchedule(from.text,to.text,null,null)
                                Toast.makeText(context, res, Toast.LENGTH_SHORT).show()
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth(1F),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = ButtonBackground, contentColor = OffWhite)
                ) {
                    Text(
                        text = "Get Results",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }

        }
    }
}

@Composable
@Preview
fun Preview() {
    Home()
}