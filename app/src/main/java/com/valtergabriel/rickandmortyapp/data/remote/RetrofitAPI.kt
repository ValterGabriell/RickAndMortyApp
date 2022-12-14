package com.valtergabriel.rickandmortyapp.data.remote

import com.valtergabriel.rickandmortyapp.data.remote.mydto.CharsDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitAPI {

    @GET("character")
    suspend fun getAllCharacters(): CharsDTO

    @GET("character/{id}")
    suspend fun getSingleCharacter(@Path("id") id: Int): com.valtergabriel.rickandmortyapp.data.remote.mydto.Result

}