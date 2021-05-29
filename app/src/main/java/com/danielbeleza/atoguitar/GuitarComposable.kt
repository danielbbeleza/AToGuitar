package com.danielbeleza.atoguitar

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
import androidx.compose.ui.graphics.graphicsLayer
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

//                val notes = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30)
                val notes = arrayOf(
                    intArrayOf(1, 2, 3, 4, 5, 6),
                    intArrayOf(7, 8, 9, 10, 11, 12),
                    intArrayOf(13, 14, 15, 16, 17, 18),
                    intArrayOf(19, 20, 21, 22, 23, 24),
                    intArrayOf(25, 26, 27, 28, 29, 30)
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
                                fret.forEach { stringNote -> // single string
                                    val chordNote: Int? = chord.firstOrNull { it.second == stringNote }?.first
                                    GuitarFretString(chordNote, height)
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
fun GuitarFretString(fingerNumber: Int?, height: Dp) {
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

        fingerNumber?.let {
            NoteShapeIndicator(note = it)

        }
    }
}

@Composable
fun NoteShapeIndicator(note: Int) {

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