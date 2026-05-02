package com.example.mytam.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytam.model.VehicleService
import com.example.mytam.network.ApiClient
import kotlinx.coroutines.launch
import androidx.compose.runtime.*

class ServiceViewModel : ViewModel() {

    var services by mutableStateOf<List<VehicleService>>(emptyList())
    var isLoading by mutableStateOf(true)
    var isError by mutableStateOf(false)

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            try {
                services = ApiClient.apiService.getServices()
                isLoading = false
            } catch (e: Exception) {
                isLoading = false
                isError = true
            }
        }
    }
}