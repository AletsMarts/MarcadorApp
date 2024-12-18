package com.example.marcadorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.marcadorapp.navigation.NavManager
import com.example.marcadorapp.splashscreen.LogoView
import com.example.marcadorapp.ui.theme.MarcadorAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        MarcadorAppTheme {
            Surface (
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ){
                //LogoView() //Esto es el splash de Alejandro
                NavManager() //Esto es el navManager qu yo añadi
            }
        }

        }//Commit


    }
}