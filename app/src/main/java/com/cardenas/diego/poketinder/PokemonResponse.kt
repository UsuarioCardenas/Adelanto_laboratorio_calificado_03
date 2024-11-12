package com.cardenas.diego.poketinder

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

data class PokemonResponse(
    val name: String,
    val url: String
) {
    fun getPokemonId() = getIdPokemonFromUrl(url)
    fun getIdPokemonFromUrl(url: String): String =
        url.split("/").toTypedArray()[6]
    fun getPokemonImage(): String =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${getPokemonId()}.png"
}
