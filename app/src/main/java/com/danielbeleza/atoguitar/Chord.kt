package com.danielbeleza.atoguitar

data class Chord(val fingerPositions: List<FingerPosition>)

data class FingerPosition(
    val fingerNumber: Int,
    val stringFretPosition: Int,
    val ligaturePosition: LigaturePosition? = null
)

data class LigaturePosition(
    val ligatureFretPosition: Int,
    val ligatureLastFretPosition: Int
)

sealed class NoteIndicatorType {
    data class PrimaryFingerPosition(val fingerNumber: Int) : NoteIndicatorType()
    data class PrimaryFingerPositionWithLigature(val fingerNumber: Int) : NoteIndicatorType()
    data class LastFingerPosition(val fingerNumber: Int) : NoteIndicatorType()
    object Ligature : NoteIndicatorType()
    object None : NoteIndicatorType()
}

enum class NoteIndicatorLigatureType {
    START,
    END
}
