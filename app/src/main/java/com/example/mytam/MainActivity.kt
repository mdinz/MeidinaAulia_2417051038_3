package com.example.mytam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mytam.model.VehicleServiceData
import com.example.mytam.ui.theme.MyTAMTheme
import androidx.compose.foundation.layout.fillMaxSize

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyTAMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val services = VehicleServiceData.dummyServices

    Column(modifier = Modifier.padding(24.dp)) {
        services.forEach { service ->
            Text(text = "Servis: ${service.namaServis}")
            Text(text = "Tanggal: ${service.tanggalTerakhir}")
            Text(text = "KM berikutnya: ${service.kmBerikutnya}")
            Text(text = "Catatan: ${service.catatan}")
            Text(text = "-------------------")
        }
    }


@Composable
@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
fun GreetingPreview() {
    MyTAMTheme {
        Greeting()
    }
}