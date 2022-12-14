package com.valtergabriel.rickandmortyapp.domain.use_cases.get_all_characters_use_case

import com.valtergabriel.rickandmortyapp.common.Resource
import com.valtergabriel.rickandmortyapp.data.remote.mydto.toCharacters
import com.valtergabriel.rickandmortyapp.domain.model.Characters
import com.valtergabriel.rickandmortyapp.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor(private val repository: CharacterRepository) {
    operator fun invoke(): Flow<Resource<List<Characters>>> = flow {
        try {
            emit(Resource.Loading<List<Characters>>())
            val characters = repository.getAllCharacters().results.map { it.toCharacters() }
            emit(Resource.Success<List<Characters>>(characters))
        } catch (e: HttpException) {
            emit(
                Resource.Error<List<Characters>>(
                    e.localizedMessage ?: "Um erro inesperado ocorreu!"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<List<Characters>>("Não foi possivel conectar ao servidor, por favor verifique sua conexão com a internet!"))
        }
    }

}