package com.atoguitar.app.models

import com.atoguitar.app.ChordLetter

data class Chord(val chordLetter: ChordLetter, val fingerPositions: List<FingerPosition>)
