package com.atoguitar.app

data class Chord(val chord: ChordLetter, val fingerPositions: List<FingerPosition>)

data class FingerPosition(
    val fingerNumber: Int,
    val stringFretPosition: Int,
    val stringFretFirstBarrePosition: Int? = null,
    val stringFretLastPosition: Int? = null
)

sealed class NoteIndicatorType {
    data class PrimaryFingerPosition(val fingerNumber: Int) : NoteIndicatorType()
    data class PrimaryFingerPositionWithLigature(val fingerNumber: Int) : NoteIndicatorType()
    data class LastFingerPosition(val fingerNumber: Int) : NoteIndicatorType()
    object Ligature : NoteIndicatorType()
    object None : NoteIndicatorType()
}
