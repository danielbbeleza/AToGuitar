package com.atoguitar.app.views

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.AbstractComposeView
import androidx.core.view.isVisible
import com.atoguitar.app.models.Chord
import com.atoguitar.app.R
import com.atoguitar.app.ChordFactory
import com.atoguitar.app.res.ColorPrimary

class GuitarChordDialogView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AbstractComposeView(context, attrs, defStyle) {

    var chord by mutableStateOf<Chord>(ChordFactory.buildChordFromLetter())
    private var fingerPositionBackgroundColor: Color

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.GuitarChordDialogView,
            0,
            0
        ).apply {
            try {
                fingerPositionBackgroundColor = Color(getColor(R.styleable.GuitarChordDialogView_fingerPositionColor, ColorPrimary.toArgb()))
            } finally {
                recycle()
            }
        }
    }


    @Composable
    override fun Content() {
        val (showChordLetterRow, setShowChordLetterRow) = remember { mutableStateOf(true) }
        GuitarChordDialog(
            chord = chord,
            showChordLetter = showChordLetterRow,
            setShowDialog = {
                isVisible = it
            },
            setShowChordLetterRow = setShowChordLetterRow,
            fingerPositionBackgroundColor = fingerPositionBackgroundColor
        )
    }
}