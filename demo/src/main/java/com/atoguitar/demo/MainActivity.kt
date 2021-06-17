package com.atoguitar.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import com.atoguitar.app.ChordLetter

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ChordsList(
                chordLetters = ChordLetter
                    .values()
                    .toList()
                    .filterNot { it == ChordLetter.NONE }
            )
        }
    }
}