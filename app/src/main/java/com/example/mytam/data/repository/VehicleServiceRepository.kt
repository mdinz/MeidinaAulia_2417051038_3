package com.example.mytam.data.repository

import com.example.mytam.data.api.ApiClient
import com.example.mytam.data.model.VehicleService

class VehicleServiceRepository {

    suspend fun getServices(): List<VehicleService> {
        return try {
            ApiClient.apiService.getServices()
        } catch (e: Exception) {
            emptyList()
        }
    }
}