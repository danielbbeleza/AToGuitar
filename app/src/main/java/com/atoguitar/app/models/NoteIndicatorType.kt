package com.atoguitar.app.models

sealed class NoteIndicatorType {
    data class PrimaryFingerPosition(val fingerNumber: Int) : NoteIndicatorType()
    data class PrimaryFingerPositionWithLigature(val fingerNumber: Int) : NoteIndicatorType()
    data class LastFingerPosition(val fingerNumber: Int) : NoteIndicatorType()
    object Ligature : NoteIndicatorType()
    object None : NoteIndicatorType()
}