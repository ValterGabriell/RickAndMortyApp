package com.valtergabriel.rickandmortyapp.domain.repository


import com.valtergabriel.rickandmortyapp.data.remote.mydto.CharsDTO

interface CharacterRepository {
    suspend fun getAllCharacters(): CharsDTO
    suspend fun getSingleCharacter(id: Int): com.valtergabriel.rickandmortyapp.data.remote.mydto.Result

}