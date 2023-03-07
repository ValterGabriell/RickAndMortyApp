package com.valtergabriel.rickandmortyapp.di

import android.content.Context
import androidx.room.Room
import com.valtergabriel.rickandmortyapp.common.Constants
import com.valtergabriel.rickandmortyapp.data.local.CharactersDatabase
import com.valtergabriel.rickandmortyapp.data.remote.RetrofitAPI
import com.valtergabriel.rickandmortyapp.data.repository.CharacterRepositoryImpl
import com.valtergabriel.rickandmortyapp.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideDatabaseModule(@ApplicationContext context: Context): CharactersDatabase {
        return Room.databaseBuilder(context, CharactersDatabase::class.java, "characters").build()
    }


    @Provides
    @Singleton
    fun provideCharacterRepository(
        api: RetrofitAPI,
        database: CharactersDatabase
    ): CharacterRepository {
        return CharacterRepositoryImpl(api, database)
    }


}