package com.valtergabriel.rickandmortyapp.domain.model

import com.valtergabriel.rickandmortyapp.data.local.DatabaseCharacter

data class Characters(
    var created: String = "Loading",
    var gender: String = "Loading",
    var character_id: Int = 0,
    var image: String = "Loading",
    var name: String = "Loading",
    var species: String = "Loading",
    var status: String = "Loading",
    var type: String = "Loading",
    var url: String = ""
)

fun List<Characters>.asDatabaseModel() : List<DatabaseCharacter> {
    return map {
        DatabaseCharacter(
            created = it.created,
            gender = it.gender,
            character_id = it.character_id,
            image = it.image,
            name = it.name,
            species = it.species,
            status = it.status,
            type = it.type,
            url = it.url
        )
    }
}