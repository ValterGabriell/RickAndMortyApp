package com.valtergabriel.rickandmortyapp.domain.use_cases.get_detail_character_use_case

import com.valtergabriel.rickandmortyapp.common.Resource
import com.valtergabriel.rickandmortyapp.data.remote.mydto.Result
import com.valtergabriel.rickandmortyapp.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDetailCharacterUseCase @Inject constructor(private val repository: CharacterRepository) {
    suspend fun getCharacterById(id: Int): Result {
        return repository.getSingleCharacter(id)
    }

}