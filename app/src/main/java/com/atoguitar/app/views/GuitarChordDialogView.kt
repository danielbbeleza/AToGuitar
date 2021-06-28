package com.atoguitar.app.views

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.AbstractComposeView
import com.atoguitar.app.Chord
import com.atoguitar.app.ChordFactory
import com.atoguitar.app.ChordLetter

class GuitarChordDialogView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AbstractComposeView(context, attrs, defStyle) {

    var chord by mutableStateOf<Chord>(ChordFactory.buildChordFromLetter(ChordLetter.NONE))
    var fingerPositionBackgroundColor by mutableStateOf<Color>(ColorPrimary)

    @Composable
    override fun Content() {
        val (_, setShowDialog) = remember { mutableStateOf(false) }
        val (showChordLetterRow, setShowChordLetterRow) = remember { mutableStateOf(true) }
        GuitarChordDialog(
            chord = chord,
            showChordLetter = showChordLetterRow,
            setShowDialog = setShowDialog,
            setShowChordLetterRow = setShowChordLetterRow,
            fingerPositionBackgroundColor = fingerPositionBackgroundColor
        )
    }
}