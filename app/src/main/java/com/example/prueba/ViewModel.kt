package com.example.prueba

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prueba.Api.CharacterRepository
import com.example.prueba.Model.RMCharacter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    private val _characters = MutableStateFlow<List<RMCharacter>>(emptyList())
    val characters: StateFlow<List<RMCharacter>> get() = _characters

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    fun fetchCharacters(page: Int = 1) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = repository.fetchCharacters(page)
                _characters.value = response.results // Asumiendo que "results" es una lista de RMCharacter
            } catch (e: Exception) {
                // Maneja el error si es necesario
            } finally {
                _isLoading.value = false
            }
        }
    }
}
