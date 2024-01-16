package com.example.pokedex.pokedexapp.data.sources.local

import android.content.Context
import com.example.pokedex.pokedexapp.data.dataInfo.PokemonDTO
import com.example.pokedex.pokedexapp.data.mappers.DTOToModel
import com.example.pokedex.pokedexapp.domain.models.Pokemon
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PokemonLocalDataSource @Inject constructor(@ApplicationContext private val context: Context) {

    fun getPokemonFromJson(jsonNombre: String): Pokemon {
        val jsonString = readJsonFromAssets(context, jsonNombre)
        var pokemonDTO = parseJsonToModel(jsonString)
        return DTOToModel(pokemonDTO)
    }

    fun readJsonFromAssets(context: Context, fileName: String): String {
        return context.assets.open(fileName).bufferedReader().use { it.readText() }
    }


    fun parseJsonToModel(jsonString: String): PokemonDTO {
        val gson = Gson()
        return gson.fromJson(jsonString, object : TypeToken<PokemonDTO>() {}.type)
    }


}