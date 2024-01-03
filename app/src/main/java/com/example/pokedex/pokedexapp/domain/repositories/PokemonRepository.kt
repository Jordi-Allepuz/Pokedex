package com.example.pokedex.pokedexapp.domain.repositories

import android.content.Context
import com.example.pokedex.pokedexapp.data.dataInfo.Pokemon
import com.example.pokedex.pokedexapp.data.sources.local.PokemonLocalDataSource
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val localDataSource: PokemonLocalDataSource) {

    suspend fun getPokemonFromJson(jsonNombre: String): Pokemon {
        return localDataSource.getPokemonFromJson(jsonNombre)
    }

    suspend fun readJsonFromAssets(context: Context, jsonNombre: String): String {
        return localDataSource.readJsonFromAssets(context, jsonNombre)
    }


    suspend fun parseJsonToModel(jsonNombre: String): Pokemon {
        return parseJsonToModel(jsonNombre)
    }


}