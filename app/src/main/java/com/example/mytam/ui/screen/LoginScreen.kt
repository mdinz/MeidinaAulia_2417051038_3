package com.example.mytam.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.mytam.R
import com.example.mytam.data.model.UserSession
import com.example.mytam.ui.component.IconButtonMenu

@Composable
fun LoginScreen(
    onLoginSuccess: (UserSession) -> Unit
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_car),
            contentDescription = "MyTAM",
            modifier = Modifier.height(64.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "MyTAM",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Aplikasi Servis Kendaraan",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(28.dp))

        OutlinedTextField(
            value = username,
            onValueChange = {
                username = it
                errorMessage = ""
            },
            label = {
                Text("Username / Email")
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_account),
                    contentDescription = "Username"
                )
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                errorMessage = ""
            },
            label = {
                Text("Password")
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_setting),
                    contentDescription = "Password"
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        if (errorMessage.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        IconButtonMenu(
            text = "Masuk",
            iconRes = R.drawable.ic_login,
            onClick = {
                if (username.isNotBlank() && password == "123456") {
                    val user = UserSession(
                        name = formatNameFromLogin(username),
                        email = if (username.contains("@")) username else "$username@gmail.com",
                        vehicle = "Honda Beat",
                        plateNumber = "BE 1234 TAM",
                        status = "Aktif"
                    )

                    onLoginSuccess(user)
                } else {
                    errorMessage = "Username atau password salah"
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Password demo: 123456",
            style = MaterialTheme.typography.bodySmall
        )
    }
}

private fun formatNameFromLogin(input: String): String {
    val cleanName = input
        .substringBefore("@")
        .replace(".", " ")
        .replace("_", " ")
        .trim()

    return cleanName
        .split(" ")
        .filter { it.isNotBlank() }
        .joinToString(" ") { word ->
            word.lowercase().replaceFirstChar { it.uppercase() }
        }
}