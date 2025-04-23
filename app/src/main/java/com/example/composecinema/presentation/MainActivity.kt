package com.example.composecinema.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.composecinema.presentation.navigation.MovieNavHost
import com.example.composecinema.presentation.ui.theme.ComposeCinemaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeCinemaTheme {
                MovieNavHost()
            }
        }
    }
}

