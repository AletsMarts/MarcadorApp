package com.example.marcadorapp.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun RegisterMatchScreen(navController: NavController) {
    // Variables para almacenar nombres de los equipos
    var team1 by remember { mutableStateOf("") }
    var team2 by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    // Layout principal
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        // Título
        Text(
            text = "Registrar Partido",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .padding(bottom = 8.dp)

        )

        // Subtítulo
        Text(
            text = "Primero registremos los equipos que se enfrentaran",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(bottom = 24.dp)
        )

        // Campo de texto para Equipo 1
        OutlinedTextField(
            value = team1,
            onValueChange = {
                team1 = it
                showError = false // Ocultar el mensaje de error al escribir
            },
            placeholder = { Text("Nombre equipo 1") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFF99E0F4))
        )

        // Campo de texto para Equipo 2
        OutlinedTextField(
            value = team2,
            onValueChange = {
                team2 = it
                showError = false // Ocultar el mensaje de error al escribir
            },
            placeholder = { Text("Nombre equipo 2") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFF99E0F4))
        )

        // Mostrar mensaje de error si los campos están vacíos
        if (showError) {
            Text(
                text = "Los campos están vacíos",
                color = Color.Red,
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        Button(
            onClick = {
                if (team1.isBlank() || team2.isBlank()) {
                    showError = true // Mostrar mensaje de error
                } else {
                    navController.navigate("ScoreView")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .clip(RoundedCornerShape(8.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF57B6C8))
        ) {
            Text(
                text = "Registrar Partido",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterMatchScreenPreview() {
    RegisterMatchScreen(navController = NavController(LocalContext.current))
}
