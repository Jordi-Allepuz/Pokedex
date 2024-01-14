//package com.example.pokedex.pokedexapp.ui.screens
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.width
//import androidx.compose.material3.Card
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.unit.dp
//import coil.compose.rememberImagePainter
//import com.example.pokedex.pokedexapp.data.dataInfo.Pokemon
//
//@Composable
//fun SelectionView(){
//    val pokemonList= listOf<String>("ditto", "gyarados", "squirtle", "charizard", "dragonite")
//
//    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
//        pokemonList.forEach{
//            CardSelection(it)
//        }
//    }
//}
//
//
//
//
//@Composable
//fun CardSelection(pokemonNombre: String) {
//    Card() {
//        Row() {
//            Image(
//                painter = rememberImagePainter(data = pokemon.sprites.other.officialArtwork.frontDefault),
//                contentDescription = "pokemonImagen",
//                alignment = Alignment.BottomCenter,
//                modifier = Modifier
//                    .width(180.dp),
//                contentScale = ContentScale.Crop
//            )
//            Text(text = pokemonNombre)
//        }
//    }
//}