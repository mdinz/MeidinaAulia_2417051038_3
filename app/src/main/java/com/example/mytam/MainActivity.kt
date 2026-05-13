package com.example.mytam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.mytam.data.model.VehicleService
import com.example.mytam.data.repository.VehicleServiceRepository
import com.example.mytam.ui.theme.MyTAMTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyTAMTheme {
                DaftarServisScreen()
            }
        }
    }
}

@Composable
fun DaftarServisScreen() {
    val repository = remember { VehicleServiceRepository() }

    var services by remember { mutableStateOf<List<VehicleService>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var isError by remember { mutableStateOf(false) }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        isLoading = true

        val result = repository.getServices()

        services = result
        isLoading = false
        isError = result.isEmpty()
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) { paddingValues ->

        when {
            isLoading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            isError -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Gagal Memuat Data",
                            color = Color.Red,
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Pastikan koneksi internet Anda menyala"
                        )
                    }
                }
            }

            else -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    item {
                        Text(
                            text = "Rekomendasi Servis",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            items(services.take(3)) { service ->
                                ServisRowItem(service)
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "Daftar Servis Lengkap",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    items(services) { service ->
                        DetailServisItem(
                            service = service,
                            onSuccess = {
                                scope.launch {
                                    snackbarHostState.showSnackbar(
                                        "Berhasil dijadwalkan"
                                    )
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ServisRowItem(service: VehicleService) {
    Card(
        modifier = Modifier.width(160.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            AsyncImage(
                model = service.imageUrl,
                contentDescription = service.namaServis,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.padding(8.dp)
            ) {
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
fun DetailServisItem(
    service: VehicleService,
    onSuccess: () -> Unit
) {
    var isFavorite by remember { mutableStateOf(false) }
    var isButtonLoading by remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column {
            Box {
                AsyncImage(
                    model = service.imageUrl,
                    contentDescription = service.namaServis,
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
                        imageVector = if (isFavorite) {
                            Icons.Filled.Favorite
                        } else {
                            Icons.Outlined.FavoriteBorder
                        },
                        contentDescription = "Favorite",
                        tint = if (isFavorite) {
                            Color.Red
                        } else {
                            Color.White
                        }
                    )
                }
            }

            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = service.namaServis,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text("Tanggal Servis: ${service.tanggalTerakhir}")
                Text("KM Berikutnya: ${service.kmBerikutnya}")
                Text(service.catatan)

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        isButtonLoading = true

                        scope.launch {
                            delay(1500)
                            isButtonLoading = false
                            onSuccess()
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
                        Text("Jadwalkan Servis")
                    }
                }
            }
        }
    }
}