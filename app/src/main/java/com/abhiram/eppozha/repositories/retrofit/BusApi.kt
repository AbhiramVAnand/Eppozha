package com.abhiram.eppozha.repositories.retrofit

import com.abhiram.eppozha.repositories.datamodels.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BusApi {

    @GET("/api/v1/schedules")
    suspend fun GetSchedule(
        @Query("departure") departure : String,
        @Query("destination") destination : String,
        @Query("time") time : String?,
        @Query("restrict") restrict : Boolean?
    ) : Response<ApiResponse>

}