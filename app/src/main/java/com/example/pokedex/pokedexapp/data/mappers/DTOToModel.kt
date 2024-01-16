package com.example.pokedex.pokedexapp.data.mappers

import com.example.pokedex.pokedexapp.data.dataInfo.PokemonDTO
import com.example.pokedex.pokedexapp.domain.models.Pokemon

fun DTOToModel(pokemonDTO: PokemonDTO): Pokemon{

    var pokemon = Pokemon(
        id = pokemonDTO.id,
        name = pokemonDTO.name,
        imageURL = pokemonDTO.sprites.other.officialArtwork.frontDefault,
        stats = pokemonDTO.stats,
        types= pokemonDTO.types,
        weight = pokemonDTO.weight,
        height = pokemonDTO.height,
    )
    return pokemon
}