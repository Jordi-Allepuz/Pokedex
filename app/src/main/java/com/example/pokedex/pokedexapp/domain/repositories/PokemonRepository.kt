package com.example.pokedex.pokedexapp.domain.repositories

import android.content.Context
import com.example.pokedex.pokedexapp.data.dataInfo.Pokemon

interface PokemonRepository {
    suspend fun getPokemonFromJson(jsonNombre: String): Pokemon
    suspend fun readJsonFromAssets(context: Context, jsonNombre: String): String
    suspend fun parseJsonToModel(jsonNombre: String): Pokemon
}