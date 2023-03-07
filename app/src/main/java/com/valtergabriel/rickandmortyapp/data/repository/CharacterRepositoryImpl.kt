package com.valtergabriel.rickandmortyapp.data.repository

import android.util.Log
import coil.util.Logger
import com.valtergabriel.rickandmortyapp.data.local.CharactersDatabase
import com.valtergabriel.rickandmortyapp.data.remote.RetrofitAPI
import com.valtergabriel.rickandmortyapp.data.remote.mydto.toCharacters
import com.valtergabriel.rickandmortyapp.domain.model.Characters
import com.valtergabriel.rickandmortyapp.domain.model.asDatabaseModel
import com.valtergabriel.rickandmortyapp.domain.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: RetrofitAPI,
    private val database: CharactersDatabase
) :
    CharacterRepository {


    override suspend fun insertCharacters() {
        Log.d("TAG", "inserindo personagens")
        withContext(Dispatchers.IO) {
            val chars = api.getAllCharacters().results.map {
                it.toCharacters()
            }.asDatabaseModel()
            database.charDao.insertCharacters(chars)
        }
    }

    override suspend fun getAllCharacters(): List<Characters> {
        Log.d("TAG", "recuperando personagens")
        return database.charDao.getAllCharacters()
    }

    override suspend fun getSingleCharacter(id: Int): com.valtergabriel.rickandmortyapp.data.remote.mydto.Result {
        return api.getSingleCharacter(id)
    }
}