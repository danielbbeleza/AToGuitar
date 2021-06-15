package com.danielbeleza.atoguitar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val chord = ChordFactory.buildChordFromLetter("Bb")
            GuitarStringsLayout(chord)
        }
    }
}