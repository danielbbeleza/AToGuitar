package com.atoguitar.app

object ChordFactory {

    fun buildChordFromLetter(chordLabel: String = ""): Chord {
        ChordLetter.values().find { chordLabel == it.toKey() }
        return when (chordLabel) {
            ChordLetter.A_MAJOR.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 1, stringFretPosition = 8),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 9),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 10)
                )
            }
            ChordLetter.A_MAJOR_7.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 1, stringFretPosition = 3),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 8),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 10)
                )
            }
            ChordLetter.A_7.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 1, stringFretPosition = 8),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 10),
                )
            }
            ChordLetter.A_MINOR.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 1, stringFretPosition = 4),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 8),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 9),
                )
            }
            ChordLetter.A_MINOR.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 1, stringFretPosition = 4),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 8),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 9),
                )
            }
            ChordLetter.A_MINOR_7.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 1, stringFretPosition = 4),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 8),
                )
            }
            ChordLetter.B_MAJOR.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 1, stringFretPosition = 7, stringFretFirstBarrePosition = 7, stringFretLastPosition = 11),
                    FingerPosition(fingerNumber = 1, stringFretPosition = 8, stringFretFirstBarrePosition = 7, stringFretLastPosition = 11),
                    FingerPosition(fingerNumber = 1, stringFretPosition = 9, stringFretFirstBarrePosition = 7, stringFretLastPosition = 11),
                    FingerPosition(fingerNumber = 1, stringFretPosition = 10, stringFretFirstBarrePosition = 7, stringFretLastPosition = 11),
                    FingerPosition(fingerNumber = 1, stringFretPosition = 11, stringFretFirstBarrePosition = 7, stringFretLastPosition = 11),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 20),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 21),
                    FingerPosition(fingerNumber = 4, stringFretPosition = 22)
                )
            }
            ChordLetter.B_MINOR.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 1, stringFretPosition = 7),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 16),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 20),
                    FingerPosition(fingerNumber = 4, stringFretPosition = 21),
                )
            }
            ChordLetter.B_FLAT.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 1, stringFretPosition = 1),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 14),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 15),
                    FingerPosition(fingerNumber = 4, stringFretPosition = 16),
                )
            }
            ChordLetter.B_7.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 1, stringFretPosition = 2),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 7),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 9),
                    FingerPosition(fingerNumber = 4, stringFretPosition = 11),
                )
            }
            ChordLetter.C_MAJOR.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 1, stringFretPosition = 4),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 8),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 13)
                )
            }
            ChordLetter.C_MAJOR_7.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 2, stringFretPosition = 8),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 13)
                )
            }
            ChordLetter.C_7.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 1, stringFretPosition = 4),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 8),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 13),
                    FingerPosition(fingerNumber = 4, stringFretPosition = 15)
                )
            }
            ChordLetter.D_MAJOR.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 1, stringFretPosition = 9),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 11),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 16)
                )
            }
            ChordLetter.D_MAJOR_7.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 1, stringFretPosition = 9),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 10),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 11)
                )
            }
            ChordLetter.D_MINOR.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 1, stringFretPosition = 5),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 9),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 16)
                )
            }
            ChordLetter.D_MINOR_7.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 1, stringFretPosition = 4),
                    FingerPosition(fingerNumber = 1, stringFretPosition = 5),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 9)
                )
            }
            ChordLetter.D_7.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 1, stringFretPosition = 4),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 9),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 11)
                )
            }
            ChordLetter.E_MAJOR.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 1, stringFretPosition = 3),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 7),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 8)
                )
            }
            ChordLetter.E_MINOR.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 2, stringFretPosition = 7),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 8)
                )
            }
            ChordLetter.E_MINOR_7.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 2, stringFretPosition = 7)
                )
            }
            ChordLetter.E_7.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 1, stringFretPosition = 3),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 7)
                )
            }
            ChordLetter.F_MAJOR.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 1, stringFretPosition = 4),
                    FingerPosition(fingerNumber = 1, stringFretPosition = 5),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 9),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 14)
                )
            }
            ChordLetter.F_MAJOR_7.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 1, stringFretPosition = 4),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 9),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 14)
                )
            }
            ChordLetter.G_MAJOR.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 1, stringFretPosition = 7),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 12),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 17)
                )
            }
            ChordLetter.G_7.toKey() -> {
                buildChord(
                    FingerPosition(fingerNumber = 1, stringFretPosition = 5),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 7),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 12)
                )
            }
            else -> {
                buildChord()
            }
        }
    }

    private fun buildChord(vararg fingerPosition: FingerPosition): Chord {
        return Chord(fingerPosition.toList())
    }
}

enum class ChordLetter(private val chordLabel: String) {
    A_MAJOR("A"),
    A_MAJOR_7("Amaj7"),
    A_7("A7"),
    A_MINOR("Am"),
    A_MINOR_7("Am7"),
    B_MAJOR("B"),
    B_MINOR("Bm"),
    B_FLAT("Bb"),
    B_7("B7"),
    C_MAJOR("C"),
    C_MAJOR_7("Cmaj7"),
    C_7("C7"),
    D_MAJOR("D"),
    D_MAJOR_7("Dmaj7"),
    D_MINOR("Dm"),
    D_MINOR_7("Dm7"),
    D_7("D7"),
    E_MAJOR("E"),
    E_MINOR("Em"),
    E_MINOR_7("Em7"),
    E_7("E7"),
    F_MAJOR("F"),
    F_MAJOR_7("Fmaj7"),
    G_MAJOR("G"),
    G_7("G7");

    fun toKey(): String = chordLabel
}