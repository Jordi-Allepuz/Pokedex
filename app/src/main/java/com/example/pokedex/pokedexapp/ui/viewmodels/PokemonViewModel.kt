package com.example.pokedex.pokedexapp.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.pokedexapp.data.dataInfo.Pokemon
import com.example.pokedex.pokedexapp.domain.usecases.GetPokemoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(private val getPokemonUseCase: GetPokemoUseCase) :
    ViewModel() {

    var pokemon = mutableStateOf<Pokemon?>(null)
        private set


    init {
        loadPokemon("charizard.json")
    }


    fun loadPokemon(jsonNombre: String) {
        viewModelScope.launch {
            pokemon.value = getPokemonUseCase.execute(jsonNombre)
        }
    }

}