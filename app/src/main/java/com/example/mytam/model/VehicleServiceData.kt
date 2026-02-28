package com.example.mytam.model

import com.example.mytam.R

object VehicleServiceData {

    val dummyServices = listOf(
        VehicleService(
            namaServis = "Ganti Oli",
            tanggalTerakhir = "12-01-2025",
            kmBerikutnya = 20000,
            catatan = "Oli 10W40",
            imageRes = R.drawable.oli
        ),
        VehicleService(
            namaServis = "Servis Rem",
            tanggalTerakhir = "05-12-2024",
            kmBerikutnya = 22000,
            catatan = "Rem mulai tipis",
            imageRes = R.drawable.rem
        ),
        VehicleService(
            namaServis = "Cek Ban",
            tanggalTerakhir = "20-08-2024",
            kmBerikutnya = 30000,
            catatan = "Ban retak",
            imageRes = R.drawable.banluar
        )
    )
}