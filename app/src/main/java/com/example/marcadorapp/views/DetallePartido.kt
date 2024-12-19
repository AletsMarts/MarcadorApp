package com.example.marcadorapp.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MatchRecordScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(65.dp))
        Text(
            text = "Registro del partido",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Vea el registro detallado de los puntajes del partido",
            fontSize = 16.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = "Equipo 1",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(
                text = "vs",
                fontSize = 18.sp,
                color = Color.Gray
            )
            Text(
                text = "Equipo 2",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Fecha: 19/12/2024",
            fontSize = 16.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Sets jugados: 4",
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "3  :  2",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ScoreColumn("Equipo 1", listOf(25, 17, 25, 25, null))
            ScoreColumn("Equipo 2", listOf(22, 25, 15, 21, null))
        }
        Spacer(modifier = Modifier.height(120.dp))
        Button(
            onClick = { /*Aqui poner la logica para redirigir con el boton*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD9A441)), // Amarillo oscuro
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Volver al menú principal",
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun ScoreColumn(teamName: String, scores: List<Int?>) {
    Column(
        modifier = Modifier
            .background(Color(0xFFFFD68C), RoundedCornerShape(8.dp)) // Amarillo claro
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = teamName,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        scores.forEachIndexed { index, score ->
            Row {
                Text(
                    text = "Set ${index + 1}: ",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = score?.toString() ?: "",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
