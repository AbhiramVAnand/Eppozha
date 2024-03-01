package com.abhiram.eppozha.ui.pages

import android.content.ClipData.Item
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.abhiram.eppozha.ui.theme.CardBorder
import com.abhiram.eppozha.ui.theme.Grey
import com.abhiram.eppozha.ui.theme.OffWhite
import com.abhiram.eppozha.viewmodels.ApiViewModel

@Composable
fun Results(viewModel: ApiViewModel, navController: NavHostController) {
    val result = viewModel.result!!.body()
    val departureStation = result!![0].stations[0].station
    val departureStationIndex = result!![0].stations.lastIndex
    val destinationStation = result!![0].stations[departureStationIndex].station

    Log.e("Stations","${viewModel.result.toString()}")
    Box(
        modifier = Modifier
            .background(Grey)
            .padding(24.dp)
            .fillMaxSize(1F)

    ) {
        Column(
            modifier = Modifier.fillMaxSize(1F)
        ) {
            Icon(
                imageVector = Icons.Outlined.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .size(32.dp)
                    .clickable { navController.popBackStack() },
                tint = OffWhite,
            )
            Spacer(modifier = Modifier.height(8.dp))
            LazyColumn(
                modifier = Modifier.fillMaxSize(1F)
            ){
                this.items(result){ result ->
                    var vehicleItem : ItemData = ItemData(
                        vehicleNumber = result.vehicle_number,
                        depArival = result.stations[0].arrivalTime,
                        depTake = result.stations[0].departureTime,
                        destReach = result.stations[result.stations.lastIndex].arrivalTime,
                        destTake = result.stations[result.stations.lastIndex].departureTime
                    )
                    Item(vehicleItem, departureStation, destinationStation)
                }
            }
        }
    }

}

@Composable
fun Item(vehicleItemData: ItemData, departure : String, destination : String) {
    Box(modifier = Modifier
        .padding(top = 12.dp, bottom = 12.dp)
        .fillMaxWidth(1F)
        .shadow(
            elevation = 10.dp,
            shape = RoundedCornerShape(4.dp)
        )
        .clip(RoundedCornerShape(4.dp))
        .background(OffWhite)
    ){
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text(
                text = vehicleItemData.vehicleNumber,
                color = Grey
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "From : $departure",
                color = Grey
            )
            Spacer(modifier = Modifier.height(1.dp))
            Row(
                modifier = Modifier.fillMaxWidth(1F),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = vehicleItemData.depArival+ "\t\t\t~\t\t\t" + vehicleItemData.depTake,
                    color = Grey
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "To : $destination",
                color = Grey
            )
            Spacer(modifier = Modifier.height(1.dp))
            Row(
                modifier = Modifier.fillMaxWidth(1F),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = vehicleItemData.destReach + "\t\t\t~\t\t\t" + vehicleItemData.destTake,
                    color = Grey
                )
            }
        }
    }
}



data class ItemData(
    var vehicleNumber : String,
    var depArival : String,
    var depTake : String,
    var destReach : String,
    var destTake : String
)