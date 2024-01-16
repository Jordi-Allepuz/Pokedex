package com.example.pokedex.pokedexapp.ui.components

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pokedex.pokedexapp.data.dataInfo.PokemonDTO
import com.example.pokedex.pokedexapp.domain.models.Pokemon

@Composable
fun Stats(pokemon: Pokemon) {

    val maxStat = pokemon.stats.maxOf { it.baseStat }.toFloat()

    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        pokemon.stats.forEach { stat ->
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = abreviaturasEstados(stat),
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 30.dp)
                        .weight(1f)
                )
                Box(
                    modifier = Modifier.weight(3f)
                        .padding(start = 20.dp, end = 50.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .height(20.dp)
                ) {
                    val barraStat = (stat.baseStat.toFloat() / maxStat).coerceIn(0f, 1f)

                    var animacionActivada by remember {
                        mutableStateOf(false)
                    }
                    // Animación para cada barra
                    val valorbarraAnimada by animateFloatAsState(
                        targetValue =  if (animacionActivada) barraStat else 0f,
                        animationSpec = tween(durationMillis = 2000, easing = LinearOutSlowInEasing )
                    )

                    LaunchedEffect(key1 = true) {
                        animacionActivada = true
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(valorbarraAnimada)
                            .clip(CircleShape)
                            .background(estadosColores(stat))
                            .height(20.dp), horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "${(valorbarraAnimada * stat.baseStat).toInt()}/${maxStat.toInt()}",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}
