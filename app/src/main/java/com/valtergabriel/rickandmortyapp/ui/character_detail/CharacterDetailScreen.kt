package com.valtergabriel.rickandmortyapp.ui.character_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.valtergabriel.rickandmortyapp.ui.viewmodel.CharacterDetailViewModel

@Composable
fun CharacterDetailScreen(
    characterId: Int,
    characterDetailViewModel: CharacterDetailViewModel = hiltViewModel()
) {


    characterDetailViewModel.getCharacterDetail(characterId).also {
        val state = characterDetailViewModel.state.value
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp)
                .padding(20.dp)
                .clip(RoundedCornerShape(16f))
                .background(Color.Gray)
        ) {
            Column(verticalArrangement = Arrangement.Center) {
                val imageModifier = Modifier
                    .fillMaxWidth()
                    .size(250.dp)
                    .padding(16.dp, 54.dp, 16.dp, 4.dp)
                    .clip(CircleShape)


                Image(
                    painter = rememberAsyncImagePainter(model = state.image),
                    contentDescription = state.character_id.toString(),
                    contentScale = ContentScale.Crop,
                    modifier = imageModifier
                )

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = CenterHorizontally
                ) {
                    Text(
                        text = state.name,
                        fontSize = 42.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Text(
                        text = if (state.status == "Alive") "Vivo - ${state.species}" else "Morto - ${state.species}",
                        color = if (state.status == "Alive") Color.Green else Color.Red
                    )

                    Text(
                        text = "Origem: ${state.origin?.name}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Text(
                        text = "Gênero: ${state.gender}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                }


            }


        }
    }


}