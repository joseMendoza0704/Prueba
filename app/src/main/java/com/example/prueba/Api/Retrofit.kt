package com.example.prueba.Api
import android.graphics.pdf.PdfDocument.Page
import androidx.core.app.GrammaticalInflectionManagerCompat.GrammaticalGender
import com.example.prueba.Model.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap
import java.sql.ClientInfoStatus

interface CharacterApi {
    @GET("character")
    suspend fun getCharacters(
        @Query("page") page: Int = 1,
        @Query("name") name: String? = null,
        @Query("status") status: String? = null,
        @Query("species") species: String? = null,
        @Query("gender") gender: String? = null,
        @Query("type") type: String? = null,
        @QueryMap origin: Map<String, String>? = null // Usamos Map para manejar el objeto origin
    ): CharacterResponse
}
