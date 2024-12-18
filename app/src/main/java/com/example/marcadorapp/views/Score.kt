package com.example.marcadorapp.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

//PRUEBA
//@Preview(showBackground = true)
@Composable
fun ScoreboardApp(navController: NavController) {
    var scoreTeam1 by remember { mutableStateOf(0) }
    var scoreTeam2 by remember { mutableStateOf(0) }
    var setActual by remember { mutableStateOf(1) }
    var setsTeam1 by remember { mutableStateOf(0) }
    var setsTeam2 by remember { mutableStateOf(0) }
    var winner by remember { mutableStateOf<String?>(null) }

    fun checkSetWinner() {
        if (scoreTeam1 >= 25 && scoreTeam1 >= scoreTeam2 + 2) {
            setsTeam1++
            setActual++
            scoreTeam1 = 0
            scoreTeam2 = 0
        } else if (scoreTeam2 >= 25 && scoreTeam2 >= scoreTeam1 + 2) {
            setsTeam2++
            setActual++
            scoreTeam1 = 0
            scoreTeam2 = 0
        }

        if (setsTeam1 == 3) {
            winner = "¡Equipo 1 gana el partido!"
        } else if (setsTeam2 == 3) {
            winner = "¡Equipo 2 gana el partido!"
        } else if (setActual > 5) {
            winner = if (setsTeam1 > setsTeam2) "¡Equipo 1 gana el partido!" else "¡Equipo 2 gana el partido!"
        }
    }

    Row(modifier = Modifier.fillMaxSize()) {
        // Equipo 1 (verde)
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color(0xFF8BC34A)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TeamPanel(
                teamScore = scoreTeam1,
                onIncrement = {
                    if (winner == null) {
                        scoreTeam1++
                        checkSetWinner()
                    }
                },
                onDecrement = {
                    if (scoreTeam1 > 0 && winner == null) scoreTeam1--
                }
            )
        }

        // Equipo 2 (naranja)
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color(0xFFFFC107)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TeamPanel(
                teamScore = scoreTeam2,
                onIncrement = {
                    if (winner == null) {
                        scoreTeam2++
                        checkSetWinner()
                    }
                },
                onDecrement = {
                    if (scoreTeam2 > 0 && winner == null) scoreTeam2--
                }
            )
        }
    }

    // Parte central
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(top = 40.dp)) {
            Text(
                text = "Equipo 1 vs Equipo 2",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Set actual", fontSize = 16.sp)
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.White, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "$setActual", fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Sets Ganados", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(Color.White, CircleShape)
                        .size(40.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = setsTeam1.toString(), fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(Color.White, CircleShape)
                        .size(40.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = setsTeam2.toString(), fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }


            if (winner != null) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = winner!!,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red
                )
            }
        }
    }
}

@Composable
fun TeamPanel(teamScore: Int, onIncrement: () -> Unit, onDecrement: () -> Unit) {
    Text(
        text = teamScore.toString(),
        fontSize = 80.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold
    )
    Row {
        Button(
            onClick = onIncrement,
            modifier = Modifier
                .padding(8.dp)
                .size(60.dp)
        ) {
            Text(text = "+", fontSize = 24.sp)
        }
        Button(
            onClick = onDecrement,
            modifier = Modifier
                .padding(8.dp)
                .size(60.dp)
        ) {
            Text(text = "-", fontSize = 24.sp)
        }
    }
}
