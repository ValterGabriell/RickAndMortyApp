package com.valtergabriel.rickandmortyapp.ui.character_detail

import com.valtergabriel.rickandmortyapp.domain.model.Characters

data class CharacterDetailState(
    val isLoading: Boolean = false,
    var character: Characters? = null,
    val error: String = ""
)