package com.valtergabriel.rickandmortyapp

sealed class Screens(val route:String) {
    object CharacterListScreen:Screens("characters_list_screen")
    object CharacterDetailScreen:Screens("characters_detail_screen")
}