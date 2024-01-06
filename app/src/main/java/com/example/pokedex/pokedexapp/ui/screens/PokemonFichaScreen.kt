package com.example.pokedex.pokedexapp.ui.screens


import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.pokedex.pokedexapp.ui.viewmodels.PokemonViewModel


@Composable
fun PokemonPantallaFicha(viewModel: PokemonViewModel) {

    val pokemon = viewModel.pokemon.value!!

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF272727)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Cabecera(pokemon = pokemon)
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
        )
        Text(
            text = pokemon.name,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            modifier = Modifier.padding(10.dp)
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
        )
        Tipos(pokemon = pokemon)
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(25.dp)
        )
        PesoAltura(pokemon = pokemon)
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
        )
        Text(
            text = "Base Stats",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(4.dp)
        )
        Stats(pokemon = pokemon)
    }
}




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




@Composable
fun PesoAltura(pokemon: Pokemon) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "${pokemon.weight / 10.0} KG",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(text = "Weight", color = Color.White)
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "${pokemon.height / 10.0} M",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(text = "Height", color = Color.White)
        }
    }
}




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