package com.valtergabriel.rickandmortyapp.data.remote.mydto

import com.valtergabriel.rickandmortyapp.domain.model.Characters

data class Result(
    var created: String,
    var episode: List<String>,
    var gender: String,
    var id: Int,
    var image: String,
    var location: Location,
    var name: String,
    var species: String,
    var status: String,
    var type: String,
    var url: String
)


fun Result.toCharacters(): Characters {
    return Characters(created, gender, id, image, name, species, status, type, url)
}