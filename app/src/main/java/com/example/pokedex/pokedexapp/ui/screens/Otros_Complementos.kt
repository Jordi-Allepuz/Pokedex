package com.example.pokedex.pokedexapp.ui.screens

import androidx.compose.ui.graphics.Color
import com.example.pokedex.pokedexapp.data.dataInfo.Stat
import com.example.pokedex.pokedexapp.data.dataInfo.Type
import com.example.pokedex.ui.theme.agua
import com.example.pokedex.ui.theme.ataque
import com.example.pokedex.ui.theme.ataqueEspecial
import com.example.pokedex.ui.theme.bixo
import com.example.pokedex.ui.theme.defensa
import com.example.pokedex.ui.theme.defensaEspecial
import com.example.pokedex.ui.theme.dragon
import com.example.pokedex.ui.theme.electrico
import com.example.pokedex.ui.theme.fantasma
import com.example.pokedex.ui.theme.fuego
import com.example.pokedex.ui.theme.hada
import com.example.pokedex.ui.theme.hielo
import com.example.pokedex.ui.theme.hierba
import com.example.pokedex.ui.theme.hp
import com.example.pokedex.ui.theme.lucha
import com.example.pokedex.ui.theme.metal
import com.example.pokedex.ui.theme.normal
import com.example.pokedex.ui.theme.oscuro
import com.example.pokedex.ui.theme.psiquico
import com.example.pokedex.ui.theme.roca
import com.example.pokedex.ui.theme.tierra
import com.example.pokedex.ui.theme.velocidad
import com.example.pokedex.ui.theme.veneno
import com.example.pokedex.ui.theme.volador
import java.util.Locale

fun abreviaturasEstados(stat: Stat): String {
    return when (stat.stat.name.lowercase()) {
        "hp" -> "HP"
        "attack" -> "Atk"
        "defense" -> "Def"
        "special-attack" -> "SpAtk"
        "special-defense" -> "SpDef"
        "speed" -> "Spd"
        else -> ""
    }
}

fun estadosColores(stat: Stat): Color {
    return when (stat.stat.name.lowercase()) {
        "hp" -> hp
        "attack" -> ataque
        "defense" -> defensa
        "special-attack" -> ataqueEspecial
        "special-defense" -> defensaEspecial
        "speed" -> velocidad
        else -> Color.White
    }
}


fun tipoColores(type: Type): Color {
    return when (type.type.name.lowercase(Locale.ROOT)) {
        "normal" -> normal
        "fire" -> fuego
        "water" -> agua
        "electric" -> electrico
        "grass" -> hierba
        "ice" -> hielo
        "fighting" -> lucha
        "poison" -> veneno
        "ground" -> tierra
        "flying" -> volador
        "psychic" -> psiquico
        "bug" -> bixo
        "rock" -> roca
        "ghost" -> fantasma
        "dragon" -> dragon
        "dark" -> oscuro
        "steel" -> metal
        "fairy" -> hada
        else -> Color.Black
    }
}