package com.danielbeleza.atoguitar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val chord = listOf(
                FingerPosition(fingerNumber = 1, stringFretPosition = 1, barreLastStringPosition = 4),
                FingerPosition(fingerNumber = 3, stringFretPosition = 15),
                FingerPosition(fingerNumber = 2, stringFretPosition = 7),
            )
            GuitarStringsLayout(chord)
        }
    }
}