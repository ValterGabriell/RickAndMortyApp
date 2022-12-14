package com.valtergabriel.rickandmortyapp.di

import com.valtergabriel.rickandmortyapp.common.Constants
import com.valtergabriel.rickandmortyapp.data.remote.RetrofitAPI
import com.valtergabriel.rickandmortyapp.data.repository.CharacterRepositoryImpl
import com.valtergabriel.rickandmortyapp.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): RetrofitAPI {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(RetrofitAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(api: RetrofitAPI): CharacterRepository {
        return CharacterRepositoryImpl(api)
    }


}