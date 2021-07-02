package com.atoguitar.app

import com.atoguitar.app.models.Chord
import com.atoguitar.app.models.FingerPosition

object ChordFactory {

    fun buildChordFromLetter(chordLetter: ChordLetter = ChordLetter.NONE): Chord {
        return when (chordLetter) {
            ChordLetter.A_MAJOR -> {
                buildChord(
                    ChordLetter.A_MAJOR,
                    FingerPosition(fingerNumber = 1, stringFretPosition = 8),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 9),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 10)
                )
            }
            ChordLetter.A_MAJOR_7 -> {
                buildChord(
                    ChordLetter.A_MAJOR_7,
                    FingerPosition(fingerNumber = 1, stringFretPosition = 3),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 8),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 10)
                )
            }
            ChordLetter.A_7 -> {
                buildChord(
                    ChordLetter.A_7,
                    FingerPosition(fingerNumber = 1, stringFretPosition = 8),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 10),
                )
            }
            ChordLetter.A_MINOR -> {
                buildChord(
                    ChordLetter.A_MINOR,
                    FingerPosition(fingerNumber = 1, stringFretPosition = 4),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 8),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 9),
                )
            }
            ChordLetter.A_MINOR_7 -> {
                buildChord(
                    ChordLetter.A_MINOR_7,
                    FingerPosition(fingerNumber = 1, stringFretPosition = 4),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 8),
                )
            }
            ChordLetter.B_MAJOR -> {
                buildChord(
                    ChordLetter.B_MAJOR,
                    FingerPosition(fingerNumber = 1, stringFretPosition = 7),
                    FingerPosition(fingerNumber = 1, stringFretPosition = 11),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 20),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 21),
                    FingerPosition(fingerNumber = 4, stringFretPosition = 22)
                )
            }
            ChordLetter.B_MINOR -> {
                buildChord(
                    ChordLetter.B_MINOR,
                    FingerPosition(fingerNumber = 1, stringFretPosition = 7),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 16),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 20),
                    FingerPosition(fingerNumber = 4, stringFretPosition = 21),
                )
            }
            ChordLetter.B_FLAT -> {
                buildChord(
                    ChordLetter.B_FLAT,
                    FingerPosition(fingerNumber = 1, stringFretPosition = 1),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 14),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 15),
                    FingerPosition(fingerNumber = 4, stringFretPosition = 16),
                )
            }
            ChordLetter.B_7 -> {
                buildChord(
                    ChordLetter.B_7,
                    FingerPosition(fingerNumber = 1, stringFretPosition = 2),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 7),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 9),
                    FingerPosition(fingerNumber = 4, stringFretPosition = 11),
                )
            }
            ChordLetter.C_MAJOR -> {
                buildChord(
                    ChordLetter.C_MAJOR,
                    FingerPosition(fingerNumber = 1, stringFretPosition = 4),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 8),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 13)
                )
            }
            ChordLetter.C_MAJOR_7 -> {
                buildChord(
                    ChordLetter.C_MAJOR_7,
                    FingerPosition(fingerNumber = 2, stringFretPosition = 8),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 13)
                )
            }
            ChordLetter.C_7 -> {
                buildChord(
                    ChordLetter.C_7,
                    FingerPosition(fingerNumber = 1, stringFretPosition = 4),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 8),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 13),
                    FingerPosition(fingerNumber = 4, stringFretPosition = 15)
                )
            }
            ChordLetter.D_MAJOR -> {
                buildChord(
                    ChordLetter.D_MAJOR,
                    FingerPosition(fingerNumber = 1, stringFretPosition = 9),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 11),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 16)
                )
            }
            ChordLetter.D_MAJOR_7 -> {
                buildChord(
                    ChordLetter.D_MAJOR_7,
                    FingerPosition(fingerNumber = 1, stringFretPosition = 9),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 10),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 11)
                )
            }
            ChordLetter.D_MINOR -> {
                buildChord(
                    ChordLetter.D_MINOR,
                    FingerPosition(fingerNumber = 1, stringFretPosition = 5),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 9),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 16)
                )
            }
            ChordLetter.D_MINOR_7 -> {
                buildChord(
                    ChordLetter.D_MINOR_7,
                    FingerPosition(fingerNumber = 1, stringFretPosition = 4),
                    FingerPosition(fingerNumber = 1, stringFretPosition = 5),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 9)
                )
            }
            ChordLetter.D_7 -> {
                buildChord(
                    ChordLetter.D_7,
                    FingerPosition(fingerNumber = 1, stringFretPosition = 4),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 9),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 11)
                )
            }
            ChordLetter.E_MAJOR -> {
                buildChord(
                    ChordLetter.E_MAJOR,
                    FingerPosition(fingerNumber = 1, stringFretPosition = 3),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 7),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 8)
                )
            }
            ChordLetter.E_MINOR -> {
                buildChord(
                    ChordLetter.E_MINOR,
                    FingerPosition(fingerNumber = 2, stringFretPosition = 7),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 8)
                )
            }
            ChordLetter.E_MINOR_7 -> {
                buildChord(
                    ChordLetter.E_MINOR_7,
                    FingerPosition(fingerNumber = 2, stringFretPosition = 7)
                )
            }
            ChordLetter.E_7 -> {
                buildChord(
                    ChordLetter.E_7,
                    FingerPosition(fingerNumber = 1, stringFretPosition = 3),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 7)
                )
            }
            ChordLetter.F_MAJOR -> {
                buildChord(
                    ChordLetter.F_MAJOR,
                    FingerPosition(fingerNumber = 1, stringFretPosition = 4),
                    FingerPosition(fingerNumber = 1, stringFretPosition = 5),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 9),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 14)
                )
            }
            ChordLetter.F_MAJOR_7 -> {
                buildChord(
                    ChordLetter.F_MAJOR_7,
                    FingerPosition(fingerNumber = 1, stringFretPosition = 4),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 9),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 14)
                )
            }
            ChordLetter.G_MAJOR -> {
                buildChord(
                    ChordLetter.G_MAJOR,
                    FingerPosition(fingerNumber = 1, stringFretPosition = 7),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 12),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 17)
                )
            }
            ChordLetter.G_7 -> {
                buildChord(
                    ChordLetter.G_7,
                    FingerPosition(fingerNumber = 1, stringFretPosition = 5),
                    FingerPosition(fingerNumber = 2, stringFretPosition = 7),
                    FingerPosition(fingerNumber = 3, stringFretPosition = 12)
                )
            }
            ChordLetter.NONE -> buildChord(ChordLetter.NONE)
        }
    }

    fun buildPlayableStringsSymbols(chordLetter: ChordLetter): Map<Int, String> {
        return when (chordLetter) {
            ChordLetter.A_MAJOR -> mapOf(
                0 to NOT_PLAYABLE_STRING_SYMBOL,
                1 to PLAYABLE_STRING_SYMBOL,
                5 to PLAYABLE_STRING_SYMBOL
            )
            ChordLetter.A_MAJOR_7 -> mapOf(
                0 to NOT_PLAYABLE_STRING_SYMBOL,
                1 to PLAYABLE_STRING_SYMBOL,
                5 to PLAYABLE_STRING_SYMBOL
            )
            ChordLetter.A_7 -> mapOf(
                0 to NOT_PLAYABLE_STRING_SYMBOL,
                1 to PLAYABLE_STRING_SYMBOL,
                3 to PLAYABLE_STRING_SYMBOL,
                5 to PLAYABLE_STRING_SYMBOL
            )
            ChordLetter.A_MINOR -> mapOf(
                0 to NOT_PLAYABLE_STRING_SYMBOL,
                1 to PLAYABLE_STRING_SYMBOL,
                5 to PLAYABLE_STRING_SYMBOL
            )
            ChordLetter.A_MINOR_7 -> mapOf(
                0 to NOT_PLAYABLE_STRING_SYMBOL,
                1 to PLAYABLE_STRING_SYMBOL,
                5 to PLAYABLE_STRING_SYMBOL
            )
            ChordLetter.B_MAJOR -> mapOf(
                0 to NOT_PLAYABLE_STRING_SYMBOL
            )
            ChordLetter.B_MINOR -> mapOf(
                0 to NOT_PLAYABLE_STRING_SYMBOL,
                5 to NOT_PLAYABLE_STRING_SYMBOL
            )
            ChordLetter.B_FLAT -> mapOf(
                0 to NOT_PLAYABLE_STRING_SYMBOL,
                5 to NOT_PLAYABLE_STRING_SYMBOL
            )
            ChordLetter.B_7 -> mapOf(
                0 to NOT_PLAYABLE_STRING_SYMBOL,
                4 to PLAYABLE_STRING_SYMBOL
            )
            ChordLetter.C_MAJOR -> mapOf(
                0 to NOT_PLAYABLE_STRING_SYMBOL,
                3 to PLAYABLE_STRING_SYMBOL,
                5 to PLAYABLE_STRING_SYMBOL
            )
            ChordLetter.C_MAJOR_7 -> mapOf(
                0 to NOT_PLAYABLE_STRING_SYMBOL,
                3 to PLAYABLE_STRING_SYMBOL,
                4 to PLAYABLE_STRING_SYMBOL,
                5 to PLAYABLE_STRING_SYMBOL
            )
            ChordLetter.C_7 -> mapOf(
                0 to NOT_PLAYABLE_STRING_SYMBOL,
                5 to PLAYABLE_STRING_SYMBOL
            )
            ChordLetter.D_MAJOR,
            ChordLetter.D_MAJOR_7,
            ChordLetter.D_MINOR,
            ChordLetter.D_MINOR_7,
            ChordLetter.D_7 -> mapOf(
                0 to NOT_PLAYABLE_STRING_SYMBOL,
                1 to NOT_PLAYABLE_STRING_SYMBOL,
                2 to PLAYABLE_STRING_SYMBOL
            )
            ChordLetter.E_MAJOR -> mapOf(
                0 to PLAYABLE_STRING_SYMBOL,
                4 to PLAYABLE_STRING_SYMBOL,
                5 to PLAYABLE_STRING_SYMBOL
            )
            ChordLetter.E_MINOR -> mapOf(
                0 to PLAYABLE_STRING_SYMBOL,
                3 to PLAYABLE_STRING_SYMBOL,
                4 to PLAYABLE_STRING_SYMBOL,
                5 to PLAYABLE_STRING_SYMBOL
            )
            ChordLetter.E_MINOR_7 -> mapOf(
                0 to PLAYABLE_STRING_SYMBOL,
                2 to PLAYABLE_STRING_SYMBOL,
                3 to PLAYABLE_STRING_SYMBOL,
                4 to PLAYABLE_STRING_SYMBOL,
                5 to PLAYABLE_STRING_SYMBOL
            )
            ChordLetter.E_7 -> mapOf(
                0 to PLAYABLE_STRING_SYMBOL,
                2 to PLAYABLE_STRING_SYMBOL,
                4 to PLAYABLE_STRING_SYMBOL,
                5 to PLAYABLE_STRING_SYMBOL
            )
            ChordLetter.F_MAJOR -> mapOf(
                0 to NOT_PLAYABLE_STRING_SYMBOL,
                1 to NOT_PLAYABLE_STRING_SYMBOL,
            )
            ChordLetter.F_MAJOR_7 -> mapOf(
                5 to PLAYABLE_STRING_SYMBOL
            )
            ChordLetter.G_MAJOR -> mapOf(
                2 to PLAYABLE_STRING_SYMBOL,
                3 to PLAYABLE_STRING_SYMBOL,
                4 to PLAYABLE_STRING_SYMBOL,
            )
            ChordLetter.G_7 -> mapOf(
                2 to PLAYABLE_STRING_SYMBOL,
                3 to PLAYABLE_STRING_SYMBOL,
                4 to PLAYABLE_STRING_SYMBOL,
            )
            ChordLetter.NONE -> mapOf()
        }
    }

    private fun buildChord(chordLetter: ChordLetter, vararg fingerPosition: FingerPosition): Chord {
        return Chord(chordLetter, fingerPosition.toList())
    }

    private const val PLAYABLE_STRING_SYMBOL = "○"
    private const val NOT_PLAYABLE_STRING_SYMBOL = "×"
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
    G_7("G7"),
    NONE("");

    fun toKey(): String = chordLabel
}