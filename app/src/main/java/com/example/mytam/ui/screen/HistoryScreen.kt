package com.example.mytam.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
fun HistoryScreen(
    onBack: () -> Unit
) {
    val histories = listOf(
        "Ganti Oli dijadwalkan pada 12-01-2025",
        "Servis Rem dijadwalkan pada 25-02-2025",
        "Cek Aki dijadwalkan pada 10-03-2025"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "Riwayat Servis",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        IconButtonMenu(
            text = "Kembali",
            iconRes = R.drawable.ic_home,
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(histories.size) { index ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = histories[index],
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}