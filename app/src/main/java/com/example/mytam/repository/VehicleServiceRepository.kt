package com.example.mytam.repository

import com.example.mytam.model.VehicleService
import com.example.mytam.network.ApiClient

class VehicleServiceRepository {

    suspend fun getServices(): List<VehicleService> {
        return try {
            ApiClient.apiService.getServices()
        } catch (e: Exception) {
            emptyList()
        }
    }
}