package com.bluelightcode.mvvm_memory_game.model

data class GameBox(
    var boxHex: String,  // Variable for holding color value
    var paired: Boolean, // Variable for tracking if a box been paired
    var visible: Boolean // Shows if the gameBox's color is being seen
)