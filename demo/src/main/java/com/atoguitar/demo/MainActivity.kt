package com.atoguitar.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import com.atoguitar.app.ChordFactory
import com.atoguitar.app.ChordLetter
import com.atoguitar.app.views.GuitarChordDialogView

@ExperimentalFoundationApi
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<GuitarChordDialogView>(R.id.guitar_chord_view).chord = ChordFactory.buildChordFromLetter(ChordLetter.D_MAJOR)
//        setContent {
//            ChordsList(
//                chordLetters = ChordLetter
//                    .values()
//                    .toList()
//                    .filterNot { it == ChordLetter.NONE }
//            )
//        }
    }
}