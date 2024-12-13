package com.example.marcadorapp.OnBoardViews


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.marcadorapp.R
import com.example.marcadorapp.data.PageData
import com.example.marcadorapp.dataStore.StoreBoarding
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class,ExperimentalFoundationApi::class)
@Composable
fun MainOnBoarding(navController: NavController, store: StoreBoarding){
    val items = ArrayList<PageData>()

    items.add(
        PageData(
            R.raw.page1,
            titulo ="Bienvenido",
            descripcion = "Descripcion 2 - Deslizar para continuar"
        )
    )

    items.add(
        PageData(R.raw.page2,
            titulo = "Aplicacion Boarding",
            descripcion = "Descripción 2 - Deslizar para continuar")
    )

    items.add(
        PageData(R.raw.page3,
            titulo = "Su aplicación de confianza",
            descripcion = "Pulse para continuar"
        )
    )

    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0
    )

    OnBoardingPager(item=items, pagerState=pagerState, modifier = Modifier
        .fillMaxWidth()
        .background(Color.White),
        navController, store)
}
