package com.example.mytam.data.api

import com.example.mytam.data.api.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://gist.githubusercontent.com/mdinz/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}