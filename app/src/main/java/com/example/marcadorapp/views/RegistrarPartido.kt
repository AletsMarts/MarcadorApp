package com.example.marcadorapp.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.draw.clip
import androidx.navigation.NavController

@Composable
fun RegisterMatchScreen(navController: NavController) {
    // Variables para almacenar nombres de los equipos
    var team1 by remember { mutableStateOf("") }
    var team2 by remember { mutableStateOf("") }


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
            onValueChange = { team1 = it },
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
            onValueChange = { team2 = it },
            placeholder = { Text("Nombre equipo 2") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFF99E0F4))
        )

        // Botón para Registrar Partido
        Button(
            onClick = { /* Acción al presionar Registrar Partido */ },
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
