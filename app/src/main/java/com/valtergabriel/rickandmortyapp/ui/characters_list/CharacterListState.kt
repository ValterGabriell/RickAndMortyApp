package com.valtergabriel.rickandmortyapp.ui.characters_list

import com.valtergabriel.rickandmortyapp.domain.model.Characters

data class CharacterListState(
    val isLoading: Boolean = false,
    val characters: List<Characters> = emptyList(),
    val error: String = ""
)