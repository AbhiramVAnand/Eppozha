package com.abhiram.eppozha.ui.pages

import android.app.Activity
import android.app.TimePickerDialog
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.abhiram.eppozha.ui.pages.navigation.Routes
import com.abhiram.eppozha.ui.theme.ButtonBackground
import com.abhiram.eppozha.ui.theme.CardBorder
import com.abhiram.eppozha.ui.theme.Grey
import com.abhiram.eppozha.ui.theme.LightGrey
import com.abhiram.eppozha.ui.theme.OffWhite
import com.abhiram.eppozha.viewmodels.ApiViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(viewModel: ApiViewModel, navController: NavHostController){
    val view = LocalView.current

    if (!view.isInEditMode){
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Grey.toArgb()
            window.navigationBarColor = OffWhite.toArgb()
        }
    }
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
                Spacer(modifier = Modifier.height(48.dp))
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

        ) {
            SearchBox(viewModel,navController)
        }
    }

}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBox(viewModel: ApiViewModel, navController: NavHostController){
    var context = LocalContext.current
    var from by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var to by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var currentTime = LocalDateTime.now()
    var hour by remember {
        mutableStateOf(currentTime.hour)
    }
    var minute by remember {
        mutableStateOf(currentTime.minute)
    }
    var time = remember {
        mutableStateOf("$hour : $minute")
    }
    val timePickerDialog = TimePickerDialog(
        context,
        {
        _, hour : Int, minute : Int ->
        time.value = "$hour : $minute"
        },
        hour,
        minute,
        true
    )


    Column(
        modifier = Modifier
            .padding(start = 24.dp, top = 24.dp, end = 24.dp, bottom = 32.dp)
            .fillMaxWidth(1F)
    ) {
        Text(
            text = "Where are you going?",
            style = MaterialTheme.typography.headlineSmall,
            color = Grey
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = from,
            onValueChange = { from = it},
            modifier = Modifier.fillMaxWidth(1F),
            textStyle = TextStyle(
                color = Grey
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedTextColor = Grey,
                focusedLabelColor = Grey,
                focusedBorderColor = Grey,
                unfocusedBorderColor = LightGrey
            ),
            label = {
                Text(
                    text = "From",
                    color = Grey
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.LocationOn,
                    contentDescription = "Departure",
                    tint = Grey
                )
            }
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = to,
            onValueChange = { to = it},
            modifier = Modifier.fillMaxWidth(1F),
            label = {
                Text(
                    text = "To",
                    color = Grey
                )
            },
            textStyle = TextStyle(
                color = Grey
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedTextColor = Grey,
                focusedLabelColor = Grey,
                focusedBorderColor = Grey,
                unfocusedBorderColor = LightGrey
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.LocationOn,
                    contentDescription = "Destination",
                    tint = Grey
                )
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedButton(
            onClick = {
                timePickerDialog.show()
            },
            modifier = Modifier
                .fillMaxWidth(1F),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(containerColor = OffWhite, contentColor = Grey)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(1F)
                    .padding(start = 0.dp, top = 8.dp, bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ){
                Icon(imageVector = Icons.Outlined.AccessTime, contentDescription = "Time", tint = Grey)
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = time.value,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (from.text.isNotEmpty()&&to.text.isNotEmpty()&&time.value.isNotEmpty()){
                    viewModel.viewModelScope.launch {
                        var res = viewModel.GetSchedule(from.text, to.text,time.value, true)
                        viewModel.result = res
                        Toast.makeText(context, res.toString(), Toast.LENGTH_SHORT).show()
                        if (viewModel.result!!.isSuccessful){
                            navController.navigate(Routes.Results.route)
                        }
//                        TODO : Handle this with a progress loader
                    }


                }
            },
            modifier = Modifier
                .fillMaxWidth(1F)
                .padding(top = 8.dp, bottom = 8.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = ButtonBackground, contentColor = OffWhite)
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp),
                text = "Get Results",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
