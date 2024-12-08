package com.example.prueba.Api

import com.example.prueba.Model.CharacterResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance{
    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    val api: CharacterApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CharacterApi::class.java)
    }
}

class CharacterRepository(private val api: CharacterApi) {
    suspend fun fetchCharacters(page: Int): CharacterResponse {
        return api.getCharacters(page)
    }
}
