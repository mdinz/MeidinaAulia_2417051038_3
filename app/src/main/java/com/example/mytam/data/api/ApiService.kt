package com.example.mytam.data.api

import com.example.mytam.data.model.VehicleService
import retrofit2.http.GET

interface ApiService {
    @GET("f054b852eacdb92ce20b6766bc669c25/raw/f89e4bc7dbb53a027e3245355fb9aa34e0b4e3b0/services.json")
    suspend fun getServices(): List<VehicleService>
}