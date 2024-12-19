package com.example.marcadorapp.splashscreen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.*
import com.example.marcadorapp.R

@Composable
fun LogoView(navController: NavController, store: Boolean) {
    // Determinar pantalla a la que se navegará
    val screen = if (store) "home" else "onBoarding"

    // Configurar animación Lottie
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.logo))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = 1 // Reproduce la animación una vez
    )

    // Detectar finalización de la animación y navegar
    LaunchedEffect(progress) {
        if (progress == 1f) {
            navController.navigate(screen) {
                popUpTo(0) // Elimina el stack de navegación previo
            }
        }
    }

    // Contenido del Splash Screen
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            "VolleyMate",
            style = TextStyle(
                fontSize = 45.sp,
                fontWeight = FontWeight.ExtraBold,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                color = Color.Black
            ),
            modifier = Modifier
                .padding(top = 75.dp)
                .fillMaxWidth()
        )

        // Animación Lottie
        LottieAnimation(
            composition = composition,
            progress = progress,
            modifier = Modifier
                .size(200.dp) // Ajusta el tamaño según sea necesario
                .padding(vertical = 16.dp)
        )

        Text(
            "By DDA_Team",
            style = TextStyle(
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Normal,
                color = Color.Gray
            ),
            modifier = Modifier.padding(bottom = 50.dp)
        )
    }
}
