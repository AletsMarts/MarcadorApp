package com.example.marcadorapp.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AboutScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Acerca de la Aplicación", style = androidx.compose.material3.MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Esta aplicación es un marcador para gestionar resultados y registrar partidos de manera sencilla y eficiente.")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Desarrollado por: Tu Nombre")
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = { navController.navigate("home") }) {
            Text(text = "Volver al Inicio")
        }
    }
}
