package com.example.marcadorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.marcadorapp.splashscreen.LogoView
import com.example.marcadorapp.ui.theme.MarcadorAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        MarcadorAppTheme {
            LogoView()
        }

        }
    }
}