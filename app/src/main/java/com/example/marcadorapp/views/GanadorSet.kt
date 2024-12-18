package com.example.marcadorapp.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.marcadorapp.R

@Composable
fun SetWinnerScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF9CC3E5)) // Fondo azul claro
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        // Título
        Text(
            text = "¡El Equipo 1 gana este set!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Texto "Set actual"
        Text(
            text = "Set actual",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Número de set actual
        Box(
            modifier = Modifier
                .size(48.dp) // Tamaño del círculo
                .background(Color.White, shape = CircleShape), // Fondo blanco sin borde
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "1", // Texto dentro del círculo
                color = Color.Black,
                style = MaterialTheme.typography.bodyLarge
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Texto "Sets ganados"
        Box(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp) // Espaciado interno
                .background(
                    Color.White,
                    shape = RoundedCornerShape(8.dp)
                ) // Fondo blanco con bordes redondeados
        ) {
            Text(
                text = "Sets ganados",
                color = Color.Black,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(
                    horizontal = 12.dp,
                    vertical = 4.dp
                ) // Ajusta el padding interno
            )
        }
        Spacer(modifier = Modifier.height(22.dp))

        // Marcadores de sets ganados
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.White, shape = CircleShape)
            ) {
                Text(
                    text = "1",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.White, shape = CircleShape)
            ) {
                Text(
                    text = "0",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Marcador de puntos - Equipo 1
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(bottom = 16.dp)
                .background(Color(0xFF42774A), shape = RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "25",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.weight(1f)
                )

                Icon(
                    painter = painterResource(id = R.drawable.ic_volleyball), // Ícono personalizado
                    contentDescription = "Volleyball",
                    tint = Color.White,
                    modifier = Modifier.size(48.dp)
                )
            }
        }

        // Marcador de puntos - Equipo 2
        Box(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(bottom = 32.dp)
                .background(Color(0xFFDF3A32), shape = RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "22",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.weight(1f)
                )

                Icon(
                    painter = painterResource(id = R.drawable.ic_sad_face), // Ícono personalizado
                    contentDescription = "Sad face",
                    tint = Color.White,
                    modifier = Modifier.size(48.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(70.dp))
        // Botón de confirmación
        Button(
            onClick = { /* Acción de confirmación - poner la redireccion con el navManager */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),

            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF8F8F6))
        ) {
            Text(
                text = "De acuerdo",
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SetWinnerScreenPreview() {
    SetWinnerScreen(navController = NavController(LocalContext.current))

}