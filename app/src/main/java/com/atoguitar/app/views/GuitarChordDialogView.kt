package com.atoguitar.app.views

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.AbstractComposeView
import com.atoguitar.app.Chord
import com.atoguitar.app.ChordFactory

class GuitarChordDialogView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AbstractComposeView(context, attrs, defStyle) {

    var chord by mutableStateOf<Chord>(ChordFactory.buildChordFromLetter())

    @Composable
    override fun Content() {
        GuitarChordDialog(chord = chord) {
        }
    }
}