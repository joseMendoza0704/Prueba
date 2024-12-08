package com.example.prueba.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.example.prueba.CharacterViewModel
import com.example.prueba.Model.RMCharacter // Asegúrate de que esta importación esté correcta

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CharacterListScreen(viewModel: CharacterViewModel) {
    val characters by viewModel.characters.collectAsState() // Asegúrate de que este sea un List<RMCharacter>
    val isLoading by viewModel.isLoading.collectAsState()

    Scaffold {
        Box(modifier = Modifier.fillMaxSize()) {
            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            } else {
                LazyColumn(
                    modifier = Modifier.padding(16.dp) // Padding opcional para la lista
                ) {
                    items(characters) { characters ->
                        CharacterItem(characters)
                    }
                }
            }
        }
    }
}

@Composable
fun CharacterItem(character: RMCharacter) {
    Row(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = rememberAsyncImagePainter(character.image),
            contentDescription = character.name,
            modifier = Modifier.size(64.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = character.name, style = MaterialTheme.typography.bodyLarge)
            Text(text = "Status: ${character.status}", style = MaterialTheme.typography.bodySmall)
            Text(text = "Species: ${character.species}", style = MaterialTheme.typography.bodySmall)
        }
    }
}
