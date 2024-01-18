package com.example.pokedex.pokedexapp.data.repositories

import com.example.pokedex.pokedexapp.data.sources.local.PokemonLocalDataSource
import com.example.pokedex.pokedexapp.domain.models.Pokemon
import com.example.pokedex.pokedexapp.domain.repositories.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val localDataSource: PokemonLocalDataSource) :PokemonRepository {

    override suspend fun getPokemonFromJson(jsonNombre: String): Pokemon {
        return withContext(Dispatchers.IO) {
            localDataSource.getPokemonFromJson(jsonNombre)
        }
    }
}