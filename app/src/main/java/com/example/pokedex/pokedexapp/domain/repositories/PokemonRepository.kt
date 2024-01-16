package com.example.pokedex.pokedexapp.domain.repositories

import com.example.pokedex.pokedexapp.domain.models.Pokemon

interface PokemonRepository {
    suspend fun getPokemonFromJson(jsonNombre: String): Pokemon
}