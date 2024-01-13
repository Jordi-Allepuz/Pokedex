package com.example.pokedex.pokedexapp.domain.usecases

import com.example.pokedex.pokedexapp.data.dataInfo.Pokemon
import com.example.pokedex.pokedexapp.data.repositories.PokemonRepositoryImpl
import javax.inject.Inject

class GetPokemoUseCase @Inject constructor(private val repository: PokemonRepositoryImpl){

    suspend fun execute (jsonNombre:String): Pokemon {
        return repository.getPokemonFromJson(jsonNombre)
    }

}