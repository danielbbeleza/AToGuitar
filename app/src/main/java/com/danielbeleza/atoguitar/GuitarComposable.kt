package com.danielbeleza.atoguitar

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun GuitarStringsLayout(chord: Chord) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .clip(RectangleShape)
                .fillMaxWidth(0.55f)
                .wrapContentHeight()
                .clip(RoundedCornerShape(8.dp))
                .background(Color.LightGray),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(top = 8.dp)
            ) {
                ChordsLettersRow()

                Spacer(modifier = Modifier.height(8.dp))

                val notes = arrayOf(
                    intArrayOf(0, 1, 2, 3, 4, 5),
                    intArrayOf(6, 7, 8, 9, 10, 11),
                    intArrayOf(12, 13, 14, 15, 16, 17),
                    intArrayOf(18, 19, 20, 21, 22, 23),
                    intArrayOf(24, 25, 26, 27, 28, 29)
                ).toList()

                // Initial line after the chords letters
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(Color.Gray)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Column(Modifier.wrapContentHeight()) {
                        notes.forEachIndexed { index, fret -> // fret of strings
                            val height = when (index) {
                                0 -> 80.dp
                                1 -> 80.dp
                                2 -> 80.dp
                                3 -> 64.dp
                                else -> 48.dp
                            }
                            if (index > 0) {
                                GuitarFret()
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                // Loop through each fret's row
                                // each element will be a note in the guitar. Validate comparing it with the given chord, if these match then do something accordingly

                                fret.forEachIndexed { fretStringIndex, stringNote ->  // single guitar string
                                    lateinit var noteIndicatorType: NoteIndicatorType
                                    fingerPositionLoop@ for (fingerPosition in chord.fingerPositions) {
//                                        chord.fingerPositions.forEachIndexed fingerPositions@{ index, fingerPosition ->
                                        if (fingerPosition.stringFretLastPosition != null && fingerPosition.stringFretFirstBarrePosition != null) {
                                            Log.i("GuitarComposable", "Is barre")
//                                            if (fingerPosition.stringFretPosition == fretStringIndex) {
                                            if (fingerPosition.stringFretFirstBarrePosition == stringNote && fingerPosition.stringFretPosition == fingerPosition.stringFretFirstBarrePosition) {
                                                Log.i("GuitarComposable", "Init ligature")
                                                // Init ligature
                                                noteIndicatorType = NoteIndicatorType.PrimaryFingerPositionWithLigature(fingerPosition.fingerNumber)
                                                break@fingerPositionLoop
                                            } else if (fingerPosition.stringFretFirstBarrePosition != fingerPosition.stringFretPosition
                                                && fingerPosition.stringFretPosition == stringNote
                                                && fingerPosition.stringFretLastPosition != fingerPosition.stringFretPosition
                                            ) {
                                                Log.i("GuitarComposable", "Mid ligature")
                                                // Is mid ligature
                                                noteIndicatorType = NoteIndicatorType.Ligature
                                                break@fingerPositionLoop
                                            } else if (fingerPosition.stringFretPosition == stringNote
                                                && fingerPosition.stringFretPosition == fingerPosition.stringFretLastPosition
                                            ) {
                                                // Is last ligature
                                                Log.i("GuitarComposable", "Last ligature")
                                                noteIndicatorType = NoteIndicatorType.LastFingerPosition(fingerPosition.fingerNumber)
                                                break@fingerPositionLoop
                                            } else {
                                                Log.i("GuitarComposable", "Unknown ligature")
                                                noteIndicatorType = NoteIndicatorType.None
                                            }
                                        } else {
                                            Log.i("GuitarComposable", "Is not barre")
                                            val fingerPositionEqualToNote: FingerPosition? = chord.fingerPositions.firstOrNull { it.stringFretPosition == stringNote }
                                            val fingerNumber: Int? = fingerPositionEqualToNote?.fingerNumber

                                            noteIndicatorType = if (fingerNumber != null) {
                                                NoteIndicatorType.PrimaryFingerPosition(fingerNumber)
                                            } else {
                                                NoteIndicatorType.None
                                            }
                                        }
                                    }
                                    Log.i("GuitarComposable", "Guitar Composable: $noteIndicatorType")
                                    GuitarFretString(noteIndicatorType = noteIndicatorType, height)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun ChordsLettersRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Guitar chords: E, A, D, G, B, E
        Text(text = "E")
        Text(text = "A")
        Text(text = "D")
        Text(text = "G")
        Text(text = "B")
        Text(text = "E")
    }
}

@Composable
fun GuitarFretString(noteIndicatorType: NoteIndicatorType, height: Dp) {
    Box(
        modifier = Modifier
            .wrapContentHeight()
            .width(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .height(height = height)
                .width(2.dp)
                .background(Color.Red)
        )

        when (noteIndicatorType) {
            is NoteIndicatorType.PrimaryFingerPosition -> NoteShapeIndicator(note = noteIndicatorType.fingerNumber)
            is NoteIndicatorType.PrimaryFingerPositionWithLigature -> NoteShapeIndicator(note = noteIndicatorType.fingerNumber, noteIndicatureLigatureType = NoteIndicatorLigatureType.START)
            is NoteIndicatorType.LastFingerPosition -> NoteShapeIndicator(note = noteIndicatorType.fingerNumber, noteIndicatureLigatureType = NoteIndicatorLigatureType.END)
            NoteIndicatorType.Ligature -> BarreLigature()
        }
    }
}

@Composable
fun NoteShapeIndicatorLigature() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(4.dp)
            .background(Color.White)
    )
}

@Composable
fun BarreLigature() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(6.dp)
            .background(Color.White)
    )
}

@Composable
fun NoteShapeIndicator(note: Int, noteIndicatureLigatureType: NoteIndicatorLigatureType? = null) {
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .background(color = Color.White, shape = CircleShape)
            .wrapContentHeight()
            .layout { measurable, constraints ->
                // Measure the composable
                val placeable = measurable.measure(constraints)

                // get the current max dimension to assign width=height
                val currentHeight = placeable.height
                var heightCircle = currentHeight
                if (placeable.width > heightCircle)
                    heightCircle = placeable.width

                // assign the dimension and the center position
                layout(heightCircle, heightCircle) {
                    // Where the composable gets placed
                    placeable.placeRelative(placeable.width / 2, (heightCircle - currentHeight) / 2)
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = note.toString(),
            modifier = Modifier
                .padding(1.dp)
        )
    }
}

@Composable
@Preview
fun GuitarFrets() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        GuitarFret()
        GuitarFret()
        GuitarFret()
        GuitarFret()
    }
}

@Composable
@Preview
fun GuitarFret() {
    Box(
        modifier = Modifier
            .clip(RectangleShape)
            .fillMaxWidth()
            .height(2.dp)
            .background(Color.Black)
    )
}