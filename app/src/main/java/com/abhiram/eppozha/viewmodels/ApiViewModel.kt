package com.abhiram.eppozha.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhiram.eppozha.repositories.datamodels.ApiResponse
import com.abhiram.eppozha.repositories.retrofit.BusApi
import com.abhiram.eppozha.repositories.retrofit.RetrofitHelper
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class ApiViewModel : ViewModel() {
    var result by mutableStateOf<Response<ApiResponse>?>(null)
    suspend fun GetSchedule(
        departure : String,
        destination  : String,
        time : String,
        restrict : Boolean
    ): Response<ApiResponse> {
        val api = RetrofitHelper.getInstance().create(BusApi::class.java)
        var res: Response<ApiResponse>? = null
        val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
            throwable.printStackTrace()
        }
        res = api.GetSchedule(departure,destination,time,restrict)
        return res
    }
}