package com.example.pokedex.pokedexapp.domain.usecases

import com.example.pokedex.pokedexapp.data.repositories.PokemonRepositoryImpl
import com.example.pokedex.pokedexapp.domain.models.Pokemon
import javax.inject.Inject

class GetPokemoUseCase @Inject constructor(private val repository: PokemonRepositoryImpl){

    suspend fun execute (jsonNombre:String): Pokemon {
        return repository.getPokemonFromJson(jsonNombre)
    }

}