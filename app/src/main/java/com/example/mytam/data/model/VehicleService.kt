package com.example.mytam.data.model

import com.google.gson.annotations.SerializedName

data class VehicleService(
    @SerializedName("namaServis")
    val namaServis: String,

    @SerializedName("tanggalTerakhir")
    val tanggalTerakhir: String,

    @SerializedName("kmBerikutnya")
    val kmBerikutnya: Int,

    @SerializedName("catatan")
    val catatan: String,

    @SerializedName("imageUrl")
    val imageUrl: String
)