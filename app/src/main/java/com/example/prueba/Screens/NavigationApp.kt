package com.example.prueba.Screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation (){

    val= navController= rememberNavController()
    NavHost(navController = navController,
        startDestination = "HomeScreen"

    ){
        composable("HomeScreen"){ HomeScreen(navController) }
        composable("CharacterScreen"){ ScreenContent(navController, "CharacterScreen") }
        composable("CharactersDetailScreen"){ ScreenContent(navController, "CharactersDetailScreen") }
        composable("EpisodeScreen"){ ScreenContent(navController, "EpisodeScreen") }
        composable("LocationScreen"){ ScreenContent(navController, "LocationScreen") }
    }


}