package com.example.marcadorapp.navigation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.marcadorapp.OnBoardViews.MainOnBoarding
import com.example.marcadorapp.dataStore.StoreBoarding
import com.example.marcadorapp.splashscreen.LogoView
import com.example.marcadorapp.views.ScoreboardApp

import com.example.marcadorapp.views.MainScreen
import com.example.marcadorapp.views.RegisterMatchScreen
import com.example.marcadorapp.views.SetWinnerScreen
import com.example.marcadorapp.views.FinalResultsScreen
import com.example.marcadorapp.views.FinalResultsScreen
import com.example.marcadorapp.views.MatchRecordScreen
import com.example.marcadorapp.views.MatchHistoryScreen
import com.example.marcadorapp.views.AboutScreen

@Composable
fun NavManager(){
    val context= LocalContext.current
    val dataStore= StoreBoarding(context)
    val store=dataStore.getStoreBoarding.collectAsState(initial = false)

    val navController = rememberNavController()
    NavHost(navController=navController,
        startDestination = if(store.value==true) "home" else "Splash" )
    {
        composable("onBoarding"){
            MainOnBoarding(navController,dataStore)
        }
        composable("ScoreView"){
            ScoreboardApp(navController)
        }
        composable("Splash"){
            LogoView(navController, store.value==true)
        }
        composable("home"){
            MainScreen(navController)
        }
        composable("RegistrarPartido") {
            RegisterMatchScreen(navController)
        }
        composable("GanadorSet") {
            SetWinnerScreen(navController)
        }
        composable("ResultadoFinalPartido") {
            FinalResultsScreen(navController)
        }
        composable("HistorialPartidos") {
            MatchHistoryScreen(navController)
        }
        composable("DetalleHistorialPartido") {
            MatchRecordScreen(navController)
        }
        composable("AboutScreen") {
            AboutScreen(navController) // Pantalla de "Acerca de"
        }
    }
}