package com.valtergabriel.rickandmortyapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.valtergabriel.rickandmortyapp.domain.model.Characters

@Entity
data class DatabaseCharacter constructor(
    @PrimaryKey
    val character_id: Int = 0,
    val created: String = "Loading",
    val gender: String = "Loading",
    val image: String = "Loading",
    val name: String = "Loading",
    val species: String = "Loading",
    val status: String = "Loading",
    val type: String = "Loading",
    val url: String = ""
)

fun List<DatabaseCharacter>.asDomainModel() : List<Characters> {
    return map {
        Characters(
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