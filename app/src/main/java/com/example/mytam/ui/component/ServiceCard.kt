package com.example.mytam.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.mytam.R
import com.example.mytam.data.model.VehicleService
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ServiceMiniCard(service: VehicleService) {
    Card(
        modifier = Modifier.width(160.dp),
        shape = RoundedCornerShape(14.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            AsyncImage(
                model = service.imageUrl,
                contentDescription = service.namaServis,
                placeholder = painterResource(id = R.drawable.ic_service),
                error = painterResource(id = R.drawable.ic_notification),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = service.namaServis,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "KM ${service.kmBerikutnya}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
fun ServiceCard(
    service: VehicleService,
    onScheduleSuccess: () -> Unit
) {
    var isFavorite by remember { mutableStateOf(false) }
    var isButtonLoading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column {
            Box {
                AsyncImage(
                    model = service.imageUrl,
                    contentDescription = service.namaServis,
                    placeholder = painterResource(id = R.drawable.ic_service),
                    error = painterResource(id = R.drawable.ic_notification),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )

                IconButton(
                    onClick = {
                        isFavorite = !isFavorite
                    },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_service),
                        contentDescription = "Favorite",
                        tint = if (isFavorite) Color.Red else Color.White
                    )
                }
            }

            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = service.namaServis,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "Tanggal Servis: ${service.tanggalTerakhir}")
                Text(text = "KM Berikutnya: ${service.kmBerikutnya}")
                Text(text = service.catatan)

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        isButtonLoading = true

                        scope.launch {
                            delay(1500)
                            isButtonLoading = false
                            onScheduleSuccess()
                        }
                    },
                    enabled = !isButtonLoading,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    if (isButtonLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(20.dp),
                            strokeWidth = 2.dp
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_calendar),
                            contentDescription = "Jadwalkan",
                            modifier = Modifier.size(18.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(text = "Jadwalkan Servis")
                    }
                }
            }
        }
    }
}