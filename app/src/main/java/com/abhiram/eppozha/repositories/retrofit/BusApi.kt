package com.abhiram.eppozha.repositories.retrofit

import com.abhiram.eppozha.repositories.datamodels.ApiResponse
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface BusApi {

    @GET("/schedules")
    suspend fun GetSchedule(
        @Query("departure") departure : String,
        @Query("destination") destination : String
    ) : List<ApiResponse>

    @GET("/schedules?departure=mannarkkad")
    suspend fun test() : ResponseBody

}