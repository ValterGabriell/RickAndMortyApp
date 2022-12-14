package com.valtergabriel.rickandmortyapp.domain.model

import com.valtergabriel.rickandmortyapp.data.remote.mydto.Origin

data class Characters(
    var created: String = "Loading",
    var gender: String = "Loading",
    var character_id: Int = 0,
    var image: String = "Loading",
    var origin: Origin? = null,
    var name: String = "Loading",
    var species: String = "Loading",
    var status: String = "Loading",
    var type: String = "Loading",
    var url: String = ""
)