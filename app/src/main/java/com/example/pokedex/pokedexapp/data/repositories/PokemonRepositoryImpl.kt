package com.example.pokedex.pokedexapp.data.repositories

import android.content.Context
import com.example.pokedex.pokedexapp.data.dataInfo.Pokemon
import com.example.pokedex.pokedexapp.data.sources.local.PokemonLocalDataSource
import com.example.pokedex.pokedexapp.domain.repositories.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val localDataSource: PokemonLocalDataSource) :PokemonRepository {

    override suspend fun getPokemonFromJson(jsonNombre: String): Pokemon {
        return localDataSource.getPokemonFromJson(jsonNombre)
    }

    override suspend fun readJsonFromAssets(context: Context, jsonNombre: String): String {
        return localDataSource.readJsonFromAssets(context, jsonNombre)
    }


    override suspend fun parseJsonToModel(jsonNombre: String): Pokemon {
        return parseJsonToModel(jsonNombre)
    }


}