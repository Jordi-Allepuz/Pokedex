package com.example.pokedex.pokedexapp.data.sources.local

import android.content.Context
import com.example.pokedex.pokedexapp.data.dataInfo.Pokemon
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PokemonLocalDataSource @Inject constructor(@ApplicationContext private val context: Context) {

    fun getPokemonFromJson(jsonNombre: String): Pokemon {
        val jsonString = readJsonFromAssets(context, jsonNombre)
        return parseJsonToModel(jsonString)
    }

    fun readJsonFromAssets(context: Context, fileName: String): String {
        return context.assets.open(fileName).bufferedReader().use { it.readText() }
    }


    fun parseJsonToModel(jsonString: String): Pokemon {
        val gson = Gson()
        return gson.fromJson(jsonString, object : TypeToken<Pokemon>() {}.type)
    }


}