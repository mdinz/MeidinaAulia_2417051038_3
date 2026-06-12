package com.example.mytam.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mytam.R
import com.example.mytam.ui.component.IconButtonMenu
import com.example.mytam.ui.component.MenuCard

@Composable
fun DashboardScreen(
    onOpenService: () -> Unit,
    onOpenAccount: () -> Unit,
    onOpenHistory: () -> Unit,
    onLogout: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Dashboard MyTAM",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Halo, selamat datang di aplikasi servis kendaraan.",
            style = MaterialTheme.typography.bodyMedium
        )

        MenuCard(
            title = "Daftar Servis",
            subtitle = "Lihat rekomendasi dan jadwal servis kendaraan",
            iconRes = R.drawable.ic_service,
            onClick = onOpenService
        )

        MenuCard(
            title = "Informasi Akun",
            subtitle = "Lihat data profil dan kendaraan",
            iconRes = R.drawable.ic_account,
            onClick = onOpenAccount
        )

        MenuCard(
            title = "Riwayat Servis",
            subtitle = "Lihat aktivitas servis yang pernah dijadwalkan",
            iconRes = R.drawable.ic_history,
            onClick = onOpenHistory
        )

        MenuCard(
            title = "Pengingat Servis",
            subtitle = "Cek notifikasi jadwal perawatan kendaraan",
            iconRes = R.drawable.ic_notification,
            onClick = onOpenHistory
        )

        IconButtonMenu(
            text = "Logout",
            iconRes = R.drawable.ic_logout,
            onClick = onLogout,
            modifier = Modifier.fillMaxWidth()
        )
    }
}