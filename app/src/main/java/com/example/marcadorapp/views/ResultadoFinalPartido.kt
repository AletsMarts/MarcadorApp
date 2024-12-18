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
fun FinalResultsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = "Resultados finales",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "¡El partido termino! Ahora recapitulemos los resultados",
            fontSize = 16.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "¡Ha ganado el equipo 1!",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color(0xFF007AFF) // Azul
        )
        Spacer(modifier = Modifier.height(16.dp))
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
            ResultColumn("Equipo 1", listOf(25, 17, 25, 25, null))
            ResultColumn("Equipo 2", listOf(22, 25, 15, 21, null))
        }


        Spacer(modifier = Modifier.height(70.dp))

        Button(
            onClick = { /*Aqui poner la logica para redirigir con el boton*/ }, // Acción para la navegación
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF66CFFF)), // Color de fondo azul claro
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth(0.8f)
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
fun ResultColumn(teamName: String, scores: List<Int?>) {
    Column(
        modifier = Modifier
            .background(Color(0xFFD3F4FF), RoundedCornerShape(8.dp))
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
