package com.example.mytam.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mytam.R
import com.example.mytam.data.model.UserSession

@Composable
fun DashboardScreen(
    user: UserSession?,
    onOpenService: () -> Unit,
    onOpenAccount: () -> Unit,
    onLogout: () -> Unit
) {
    val activeUser = user ?: UserSession(
        name = "User",
        email = "user@gmail.com",
        vehicle = "Honda Beat",
        plateNumber = "BE 1234 TAM",
        status = "Aktif"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Halo, ${activeUser.name}",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "${activeUser.vehicle} • ${activeUser.plateNumber}",
            style = MaterialTheme.typography.bodyMedium
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = MaterialTheme.colorScheme.primaryContainer
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_car),
                            contentDescription = "Kendaraan",
                            modifier = Modifier.padding(14.dp)
                        )
                    }

                    Column(
                        modifier = Modifier.padding(start = 14.dp)
                    ) {
                        Text(
                            text = "Servis Berikutnya",
                            style = MaterialTheme.typography.bodySmall
                        )

                        Text(
                            text = "Cek kondisi kendaraan",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Text(
                    text = "Lihat rekomendasi servis, jadwalkan perawatan, dan cek kondisi kendaraan kamu dari satu halaman.",
                    style = MaterialTheme.typography.bodyMedium
                )

                Button(
                    onClick = onOpenService,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_service),
                        contentDescription = "Servis"
                    )

                    Text(
                        text = "Mulai Servis",
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            InfoMiniCard(
                title = "Akun",
                value = activeUser.status,
                modifier = Modifier.weight(1f)
            )

            InfoMiniCard(
                title = "Data",
                value = "API",
                modifier = Modifier.weight(1f)
            )
        }

        OutlinedButton(
            onClick = onOpenAccount,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_account),
                contentDescription = "Akun"
            )

            Text(
                text = "Informasi Akun",
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        TextButton(
            onClick = onLogout,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_logout),
                contentDescription = "Logout"
            )

            Text(
                text = "Logout",
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Composable
fun InfoMiniCard(
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(18.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(14.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodySmall
            )

            Text(
                text = value,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }
}