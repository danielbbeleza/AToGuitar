package com.danielbeleza.atoguitar

typealias Chord = List<FingerPosition>

typealias FingerNumber = Int
typealias Note = Int

data class FingerPosition(
    val fingerNumber: Int,
    val stringFretPosition: Int,
    val barreLastStringPosition: Int? = null
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
