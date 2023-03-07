package com.valtergabriel.rickandmortyapp.domain.use_cases.get_all_characters_use_case

import com.valtergabriel.rickandmortyapp.common.Resource
import com.valtergabriel.rickandmortyapp.data.remote.mydto.toCharacters
import com.valtergabriel.rickandmortyapp.domain.model.Characters
import com.valtergabriel.rickandmortyapp.domain.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor(private val repository: CharacterRepository) {
    operator fun invoke(): Flow<Resource<List<Characters>>> = flow {
        try {
            emit(Resource.Loading())
            val listCharacters = MutableStateFlow<List<Characters>>(emptyList())
            withContext(Dispatchers.IO) {
                repository.insertCharacters()
                listCharacters.value = repository.getAllCharacters()
            }

            emit(Resource.Success(listCharacters.value))

        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    e.localizedMessage ?: "Um erro inesperado ocorreu!"
                )
            )
        }catch (e: IOException) {
            if (withContext(Dispatchers.IO) { repository.getAllCharacters().isNotEmpty() }) {
                emit(Resource.Success(withContext(Dispatchers.IO) { repository.getAllCharacters() }))
            } else {
                emit(Resource.Error("Não foi possivel conectar ao servidor, por favor verifique sua conexão com a internet!"))
            }
        }
    }.flowOn(Dispatchers.Main)

}