package com.atoguitar.app.views

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.atoguitar.app.*

@Composable
fun GuitarChordDialog(chord: Chord, setShowDialog: (Boolean) -> Unit) {
    // Layout
    NonClickableBackground {
        setShowDialog(it)
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        GuitarChordLayout(chord = chord)
    }
}

@Composable
private fun NonClickableBackground(setShowDialog: (Boolean) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable { setShowDialog(false) })
}

@Composable
private fun GuitarChordLayout(chord: Chord) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .clickable {}
    ) {
        Box(
            modifier = Modifier
                .clip(RectangleShape)
                .fillMaxWidth(0.55f)
                .clip(RoundedCornerShape(margin_x2))
                .background(ColorBackground),
        ) {
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(top = 8.dp)
            ) {
                val playableStrings = ChordFactory.buildPlayableStringsSymbols(chord.chord)
                ChordsLettersRow(playableStrings)

                Spacer(modifier = Modifier.height(margin_x2))

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
                        .height(letter_chord_divider_height)
                        .background(ColorSecondaryOnBackground)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Column(Modifier.wrapContentHeight()) {
                        for ((index, fret) in notes.withIndex()) {
                            if (index > 0) {
                                GuitarFret()
                            }
                            val height = when (index) {
                                0 -> fret_height_2
                                1 -> fret_height_2
                                2 -> fret_height_3
                                3 -> fret_height_3
                                else -> fret_height_3
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = margin_x4),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                // Loop through each fret's row
                                // each element will be a note in the guitar. Validate comparing it with the given chord, if these match then do something accordingly
                                fret.forEach { stringNote ->  // single guitar string
                                    val noteIndicatorType = getNoteIndicatorType(chord, stringNote)
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

private fun getNoteIndicatorType(chord: Chord, stringNote: Int): NoteIndicatorType {
    lateinit var noteIndicatorType: NoteIndicatorType
    fingerPositionLoop@ for (fingerPosition in chord.fingerPositions) {
        if (fingerPosition.stringFretLastPosition != null && fingerPosition.stringFretFirstBarrePosition != null) {
            Log.i("GuitarComposable", "Is barre")
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
            val fingerPositionEqualToNote: FingerPosition? =
                chord.fingerPositions.firstOrNull { it.stringFretPosition == stringNote }
            val fingerNumber: Int? = fingerPositionEqualToNote?.fingerNumber

            noteIndicatorType = if (fingerNumber != null) {
                NoteIndicatorType.PrimaryFingerPosition(fingerNumber)
            } else {
                NoteIndicatorType.None
            }
        }
    }
    return noteIndicatorType
}

@Composable
internal fun ChordsLettersRow(playableStrings: Map<Int, String>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = margin_x7),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Guitar chords: E, A, D, G, B, E
        Text(text = playableStrings[0].orEmpty())
        Text(text = playableStrings[1].orEmpty())
        Text(text = playableStrings[2].orEmpty())
        Text(text = playableStrings[3].orEmpty())
        Text(text = playableStrings[4].orEmpty())
        Text(text = playableStrings[5].orEmpty())

//        Text(text = ChordLetter.E_MAJOR.toKey())
//        Text(text = ChordLetter.A_MAJOR.toKey())
//        Text(text = ChordLetter.D_MAJOR.toKey())
//        Text(text = ChordLetter.G_MAJOR.toKey())
//        Text(text = ChordLetter.B_MAJOR.toKey())
//        Text(text = ChordLetter.E_MAJOR.toKey())
    }
}

@Composable
internal fun GuitarFretString(noteIndicatorType: NoteIndicatorType, height: Dp) {
    Box(
        modifier = Modifier
            .wrapContentHeight()
            .width(string_fret_width),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .height(height = height)
                .width(margin_x05)
                .background(ColorSecondary)
        )

        when (noteIndicatorType) {
            is NoteIndicatorType.PrimaryFingerPosition -> NoteShapeIndicator(note = noteIndicatorType.fingerNumber)
            is NoteIndicatorType.PrimaryFingerPositionWithLigature -> NoteShapeIndicator(note = noteIndicatorType.fingerNumber)
            is NoteIndicatorType.LastFingerPosition -> NoteShapeIndicator(note = noteIndicatorType.fingerNumber)
            NoteIndicatorType.Ligature -> BarreLigature()
        }
    }
}


@Composable
internal fun BarreLigature() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(ligature_barre_height)
            .background(White)
    )
}

@Composable
internal fun NoteShapeIndicator(note: Int) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .background(color = White, shape = CircleShape)
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
internal fun GuitarFrets() {
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
internal fun GuitarFret() {
    Box(
        modifier = Modifier
            .clip(RectangleShape)
            .fillMaxWidth()
            .height(fret_line_height)
            .background(Black)
    )
}