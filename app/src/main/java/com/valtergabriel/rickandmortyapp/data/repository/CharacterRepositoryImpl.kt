package com.valtergabriel.rickandmortyapp.data.repository

import com.valtergabriel.rickandmortyapp.data.remote.RetrofitAPI
import com.valtergabriel.rickandmortyapp.data.remote.mydto.CharsDTO
import com.valtergabriel.rickandmortyapp.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(private val api: RetrofitAPI) :
    CharacterRepository {

    override suspend fun getAllCharacters(): CharsDTO {
        return api.getAllCharacters()
    }

    override suspend fun getSingleCharacter(id: Int): com.valtergabriel.rickandmortyapp.data.remote.mydto.Result {
        return api.getSingleCharacter(id)
    }
}