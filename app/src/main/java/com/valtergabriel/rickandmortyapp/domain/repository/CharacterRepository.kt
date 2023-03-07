package com.valtergabriel.rickandmortyapp.domain.repository


import com.valtergabriel.rickandmortyapp.data.remote.mydto.CharsDTO
import com.valtergabriel.rickandmortyapp.domain.model.Characters
import kotlinx.coroutines.flow.MutableStateFlow

interface CharacterRepository {
    suspend fun insertCharacters()
    suspend fun getAllCharacters() : List<Characters>
    suspend fun getSingleCharacter(id: Int): com.valtergabriel.rickandmortyapp.data.remote.mydto.Result

}