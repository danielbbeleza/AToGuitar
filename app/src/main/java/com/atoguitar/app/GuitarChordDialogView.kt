package com.atoguitar.app

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.AbstractComposeView

class GuitarChordDialogView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AbstractComposeView(context, attrs, defStyle) {

    var chord by mutableStateOf(ChordFactory.buildChordFromLetter())

    @Composable
    override fun Content() {
        GuitarChordDialog(chord = chord) {
        }
    }
}