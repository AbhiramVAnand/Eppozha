package com.abhiram.eppozha.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhiram.eppozha.repositories.retrofit.BusApi
import com.abhiram.eppozha.repositories.retrofit.RetrofitHelper
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Test : ViewModel() {
    fun TestApi(){
        val api = RetrofitHelper.getInstance().create(BusApi::class.java)
        val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
            throwable.printStackTrace()
        }
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler){
            val res = api.test()
            Log.e("Response",res.toString())
        }
    }
}