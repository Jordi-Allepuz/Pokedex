package com.example.pokedex.pokedexapp.domain.models

import com.example.pokedex.pokedexapp.data.dataInfo.Stat
import com.example.pokedex.pokedexapp.data.dataInfo.Type


data class Pokemon (
    val id: Int,
    val name: String,
    val imageURL: String,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int,
    val height: Int
)
