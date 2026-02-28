package com.example.mytam.model

import androidx.annotation.DrawableRes

data class VehicleService(
    val namaServis: String,
    val tanggalTerakhir: String,
    val kmBerikutnya: Int,
    val catatan: String,
    @DrawableRes val imageRes: Int
)