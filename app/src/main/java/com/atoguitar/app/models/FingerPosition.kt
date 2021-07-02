package com.atoguitar.app.models

data class FingerPosition(
    val fingerNumber: Int,
    val stringFretPosition: Int,
    val stringFretFirstBarrePosition: Int? = null,
    val stringFretLastPosition: Int? = null
)
