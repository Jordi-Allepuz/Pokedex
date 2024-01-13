package com.example.pokedex.pokedexapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.pokedex.pokedexapp.data.dataInfo.Pokemon

@OptIn(ExperimentalCoilApi::class)
@Composable
fun Cabecera(pokemon: Pokemon) {

    val tamañoPantalla = LocalConfiguration.current.screenHeightDp.dp
    val tamañoCabecera = tamañoPantalla * 0.35f

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(tamañoCabecera),
        colors = CardDefaults.cardColors(containerColor = tipoColores(pokemon.types.get(0))),
        shape = RoundedCornerShape(bottomEnd = 45.dp, bottomStart = 45.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
                Text(
                    text = "Pokedex",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Text(
                    text = "#${pokemon.id.toString().padStart(3, '0')}",
                    textAlign = TextAlign.End,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth(), color = Color.White, fontWeight = FontWeight.Bold
                )
            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
            )
            Image(
                painter = rememberImagePainter(data = pokemon.sprites.other.officialArtwork.frontDefault),
                contentDescription = "pokemonImagen",
                alignment = Alignment.BottomCenter,
                modifier = Modifier
                    .width(180.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}