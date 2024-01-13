package com.example.pokedex.pokedexapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.pokedexapp.data.dataInfo.Pokemon


@Composable
fun Tipos(pokemon: Pokemon) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        pokemon.types.forEach { tipo ->
            Box(
                modifier = Modifier
                    .width(200.dp)
                    .padding(horizontal = 25.dp)
                    .clip(CircleShape)
                    .background(tipoColores(tipo))
                    .height(35.dp), contentAlignment = Alignment.Center
            ) {
                Text(
                    text = tipo.type.name, color = Color.White,
                    fontSize = 20.sp, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold
                )
            }
        }
    }
}