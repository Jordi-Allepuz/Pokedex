package com.example.pokedex.pokedexapp.domain.usecases

import com.example.pokedex.pokedexapp.data.dataInfo.Pokemon
import com.example.pokedex.pokedexapp.domain.repositories.PokemonRepository
import javax.inject.Inject

class GetPokemoUseCase @Inject constructor(private val repository: PokemonRepository){

    suspend fun execute (jsonNombre:String): Pokemon {
        return repository.getPokemonFromJson(jsonNombre)
    }


}