package com.danielbeleza.atoguitar

object ChordFactory {

    fun buildChordFromLetter(chordLabel: String): Chord {
        ChordLetter.values().find { chordLabel == it.toKey() }
        return when (chordLabel) {
            ChordLetter.A_MAJOR.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 1, stringFretPosition = 8),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 9),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 10)
                )
            }
            ChordLetter.B_MAJOR.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 1, stringFretPosition = 7, barreLastStringPosition = 11),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 20),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 21),
                    FingerPosition(fingerNumber = 4, stringFretPosition = 22)
                )
            }
            else -> {
                throw IllegalStateException("Unknown")
            }
        }
    }

    private fun buildChord(vararg fingerPosition: FingerPosition): Chord {
        return Chord(fingerPosition.toList())
    }
}

enum class ChordLetter(private val chordLabel: String) {
    C_MAJOR("C"),
    D("D"),
    E_MAJOR("E"),
    E_MINOR("Em"),
    F_MAJOR("F"),
    F_SHARP("F#"),
    G_MAJOR("G"),
    A_MAJOR("A"),
    B_MAJOR("B");

    fun toKey(): String = chordLabel
}