package com.valtergabriel.rickandmortyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.valtergabriel.rickandmortyapp.domain.model.Characters
import com.valtergabriel.rickandmortyapp.ui.character_detail.CharacterDetailScreen
import com.valtergabriel.rickandmortyapp.ui.characters_list.CharactersListScreen
import com.valtergabriel.rickandmortyapp.ui.theme.RickAndMortyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyAppTheme {
                val navHostController = rememberNavController()
                NavHost(
                    navController = navHostController,
                    startDestination = "main"
                ) {


                    composable(
                        route = "main"
                    ) {
                        CharactersListScreen(navHostController = navHostController)
                    }

                    composable(
                        "detailView/{characterId}",
                        arguments = listOf(navArgument("characterId") {
                            type = NavType.IntType
                            defaultValue = 1
                            nullable = false
                        })
                    ) { entry -> CharacterDetailScreen(characterId = entry.arguments?.getInt("characterId")!!)
                    }
                }
            }
        }
    }
}
