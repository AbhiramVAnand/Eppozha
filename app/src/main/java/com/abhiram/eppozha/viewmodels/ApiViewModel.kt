package com.abhiram.eppozha.viewmodels

import android.util.Log
import android.widget.Toast
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
    suspend fun GetSchedule(
        departure : String,
        destination  : String,
        time : String?,
        restrict : Boolean?
    ): String {
        val api = RetrofitHelper.getInstance().create(BusApi::class.java)
        var res: Response<ApiResponse>? = null
        val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
            throwable.printStackTrace()
        }
        res = api.GetSchedule(departure,departure,time,restrict)
        Log.e("Response",res.toString())
        return res.toString()
    }
}