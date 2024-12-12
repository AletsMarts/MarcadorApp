package com.example.marcadorapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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


@Preview(showBackground = true)
@Composable
fun ScoreboardApp() {
    var scoreTeam1 by remember { mutableStateOf(0) }
    var scoreTeam2 by remember { mutableStateOf(0) }


    Row(
        modifier = Modifier
            .fillMaxSize()
    ) {


        // Panel del Equipo 1
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .background(Color(0xFFFF6B6B)),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxHeight()
            ) {
                Text(
                    text = "Equipo 1",
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Marcador",
                    fontSize = 20.sp,
                    color = Color.White
                )
                Text(
                    text = scoreTeam1.toString(),
                    fontSize = 48.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Row {
                    Button(
                        onClick = { if (scoreTeam1 > 0) scoreTeam1-- },
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(text = "-")
                    }
                    Button(
                        onClick = { scoreTeam1++ },
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(text = "+")
                    }
                }
            }
        }

        // Panel del Equipo 2
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .background(Color(0xFF4D96FF)),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxHeight()
            ) {
                Text(
                    text = "Equipo 2",
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Marcador",
                    fontSize = 20.sp,
                    color = Color.White
                )
                Text(
                    text = scoreTeam2.toString(),
                    fontSize = 48.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Row {
                    Button(
                        onClick = { if (scoreTeam2 > 0) scoreTeam2-- },
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(text = "-")
                    }
                    Button(
                        onClick = { scoreTeam2++ },
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(text = "+")
                    }
                }
            }
        }
    }
}