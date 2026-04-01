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
            tanggalTerakhir = "25-02-2025",
            kmBerikutnya = 25000,
            catatan = "Cek kampas rem depan",
            imageRes = R.drawable.rem
        ),
        VehicleService(
            namaServis = "Ganti Aki",
            tanggalTerakhir = "10-03-2025",
            kmBerikutnya = 30000,
            catatan = "Aki GS Astra",
            imageRes = R.drawable.aki
        ),
        VehicleService(
            namaServis = "Ban Dalam",
            tanggalTerakhir = "05-04-2025",
            kmBerikutnya = 35000,
            catatan = "Cek tekanan ban dalam",
            imageRes = R.drawable.bandalam
        ),
        VehicleService(
            namaServis = "Ban Luar",
            tanggalTerakhir = "20-05-2025",
            kmBerikutnya = 40000,
            catatan = "Ganti ban luar baru",
            imageRes = R.drawable.banluar
        )
    )
}