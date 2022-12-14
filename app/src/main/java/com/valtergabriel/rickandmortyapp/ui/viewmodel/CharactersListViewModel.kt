package com.valtergabriel.rickandmortyapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.valtergabriel.rickandmortyapp.common.Resource
import com.valtergabriel.rickandmortyapp.domain.use_cases.get_all_characters_use_case.GetAllCharactersUseCase
import com.valtergabriel.rickandmortyapp.ui.characters_list.CharacterListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharactersListViewModel @Inject constructor(
    private val getAllCharactersUseCase: GetAllCharactersUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CharacterListState())
    val state = _state

    init {
        getAllCharacters()
    }

    private fun getAllCharacters() {
        getAllCharactersUseCase().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = CharacterListState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = CharacterListState(characters = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value =
                        CharacterListState(error = result.message ?: "Um erro inesperado aconteceu")
                }
            }
        }.launchIn(viewModelScope)
    }


}