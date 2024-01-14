package com.example.pokedex.pokedexapp.data.repositories

import com.example.pokedex.pokedexapp.data.dataInfo.Pokemon
import com.example.pokedex.pokedexapp.data.sources.local.PokemonLocalDataSource
import com.example.pokedex.pokedexapp.domain.repositories.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val localDataSource: PokemonLocalDataSource) :PokemonRepository {

    override suspend fun getPokemonFromJson(jsonNombre: String): Pokemon {
        return localDataSource.getPokemonFromJson(jsonNombre)
    }
}