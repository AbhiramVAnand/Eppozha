package com.abhiram.eppozha.repositories.datamodels

data class ApiResponseItem(
    val stations: List<Station>,
    val trip: Int,
    val vehicle_number: String
)