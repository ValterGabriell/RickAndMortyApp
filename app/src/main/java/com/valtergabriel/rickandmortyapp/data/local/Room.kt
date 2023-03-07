package com.valtergabriel.rickandmortyapp.data.local

import androidx.room.*
import com.valtergabriel.rickandmortyapp.domain.model.Characters


@Dao
interface CharacterDao {
    @Query("select * from databasecharacter")
    fun getAllCharacters(): List<Characters>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacters(characters: List<DatabaseCharacter>)
}

@Database(entities = [DatabaseCharacter::class], version = 1)
abstract class CharactersDatabase : RoomDatabase() {
    abstract val charDao: CharacterDao
}

