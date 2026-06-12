package com.example.mytam.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mytam.R
import com.example.mytam.ui.component.IconButtonMenu

@Composable
fun AccountScreen(
    onBack: () -> Unit,
    onLogout: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Informasi Akun",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("Nama: Meidina Aulia")
                Text("Email: user@gmail.com")
                Text("Kendaraan: Honda Beat")
                Text("Nomor Polisi: BE 1234 TAM")
                Text("Status Akun: Aktif")
            }
        }

        IconButtonMenu(
            text = "Kembali",
            iconRes = R.drawable.ic_home,
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        )

        IconButtonMenu(
            text = "Logout",
            iconRes = R.drawable.ic_logout,
            onClick = onLogout,
            modifier = Modifier.fillMaxWidth()
        )
    }
}