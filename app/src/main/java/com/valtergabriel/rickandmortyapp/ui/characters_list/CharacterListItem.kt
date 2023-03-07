package com.valtergabriel.rickandmortyapp.ui.characters_list

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.valtergabriel.rickandmortyapp.R
import com.valtergabriel.rickandmortyapp.domain.model.Characters

@Composable
fun CharacterListItem(character: Characters, onItemClick: (Characters) -> Unit) {

    /**
     * Linha que guarda a foto do personagem e a coluna com os dados dele
     */
    val rowModifier = Modifier
        .padding(20.dp)
        .clip(RoundedCornerShape(16f))
        .background(Color.Gray)

    Row(
        modifier = rowModifier,
        horizontalArrangement = Arrangement.Center
    ) {
        val imageModifier = Modifier
            .size(100.dp)
            .padding(4.dp)
            .clip(CircleShape)

        Image(
            painter = rememberAsyncImagePainter(model = character.image),
            contentDescription = character.character_id.toString(),
            contentScale = ContentScale.Crop,
            modifier = imageModifier
        )

        /**
         * Coluna que lista os dados sobre o personagem
         */
        val columnModifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
        Column(
            modifier = columnModifier,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = character.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = if (character.status == "Alive") "Vivo - ${character.species}" else "Morto - ${character.species}",
                color = if (character.status == "Alive") Color.Green else Color.Red
            )

        }


    }

}