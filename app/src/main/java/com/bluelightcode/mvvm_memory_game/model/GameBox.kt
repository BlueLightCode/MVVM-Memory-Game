package com.bluelightcode.mvvm_memory_game.model

import android.widget.TextView

data class GameBox(
    var boxHex: Int,  // Variable for holding color value
    var paired: Boolean, // Variable for tracking if a box been paired
    var pairedView: TextView? // Tracks which view is associated with this object
)