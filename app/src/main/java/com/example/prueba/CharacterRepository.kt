package com.example.prueba

import com.example.prueba.Api.CharacterApi
import com.example.prueba.Model.CharacterResponse
import retrofit2.HttpException

class CharacterRepository(private val apiService: CharacterApi) {

    suspend fun fetchCharacters(page: Int): CharacterResponse {
        try {
            // Llama al método correcto de apiService y asigna la respuesta directamente
            val response = apiService.getCharacters(page)

            // Retorna directamente el objeto CharacterResponse
            return response
        } catch (e: Exception) {
            throw e
        }
    }
}
