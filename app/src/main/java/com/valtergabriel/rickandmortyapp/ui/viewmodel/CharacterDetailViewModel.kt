package com.valtergabriel.rickandmortyapp.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.valtergabriel.rickandmortyapp.data.remote.mydto.toCharacters
import com.valtergabriel.rickandmortyapp.domain.model.Characters
import com.valtergabriel.rickandmortyapp.domain.use_cases.get_detail_character_use_case.GetDetailCharacterUseCase
import com.valtergabriel.rickandmortyapp.ui.character_detail.CharacterDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getDetailCharacterUseCase: GetDetailCharacterUseCase
) :
    ViewModel() {

    val state = mutableStateOf(Characters())
    fun getCharacterDetail(id: Int) {
        viewModelScope.launch {
            val character = getDetailCharacterUseCase.getCharacterById(id)
            state.value = character.toCharacters()
        }
    }

}