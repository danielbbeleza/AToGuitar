package com.atoguitar.demo

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.atoguitar.app.ChordFactory
import com.atoguitar.app.ChordLetter
import com.atoguitar.app.views.GuitarChordDialog

@ExperimentalFoundationApi
@Composable
fun ChordsList(chordLetters: List<ChordLetter>) {
    val (showDialog, setShowDialog) = remember { mutableStateOf(false) }
    val (chordLetterClicked, setChordLetterClicked) = remember { mutableStateOf(ChordLetter.NONE) }
    val (showChordLetterRow, setShowChordLetterRow) = remember { mutableStateOf(true) }

    LazyVerticalGrid(cells = GridCells.Fixed(count = 4)) {
        items(chordLetters) { chordLetter ->
            ChordCell(chordLetter) {
                setShowDialog(it)
                setChordLetterClicked(chordLetter)
            }
        }
    }
    if (showDialog) {
        GuitarChordDialog(
            chord = ChordFactory.buildChordFromLetter(chordLetterClicked),
            setShowDialog = setShowDialog,
            showChordLetter = showChordLetterRow,
            setShowChordLetterRow = setShowChordLetterRow
        )
    }
}

@Composable
fun ChordCell(chordLetter: ChordLetter, onClick: (Boolean) -> Unit) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .padding(horizontal = 8.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Button(modifier = Modifier
            .height(56.dp), onClick = {
            onClick(true)
        }) {
            Text(
                text = chordLetter.toKey(),
                style = TextStyle(
                    Color.White,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace
                )
            )
        }
    }
}