package com.example.marcadorapp.views
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.marcadorapp.R // Asegúrate de que la imagen está en res/drawable y de que el nombre del recurso es correcto.
@Composable
fun AboutScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Acerca de Volley Score",
            style = androidx.compose.material3.MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Materia: Desarrollo de Aplicaciones en Android")
        Text(text = "Docente: José Luis Mota Espeleta")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Aplicación hecha por:")
        Text(text = "Alejandro Martínez")
        Text(text = "Ronaldo Puentes")
        Text(text = "Neo Maldonado")
        Text(text = "Alfredo Reza")
        Spacer(modifier = Modifier.height(32.dp))
        Image(
            painter = painterResource(id = R.drawable.unnamed), // Reemplaza 'your_image' por el nombre de tu recurso
            contentDescription = "Imagen Acerca de",
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = { navController.navigate("home") }) {
            Text(text = "Volver al Inicio")
        }
    }
}