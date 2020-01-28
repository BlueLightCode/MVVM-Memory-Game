package com.bluelightcode.mvvm_memory_game.screens.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bluelightcode.mvvm_memory_game.screens.model.GameBox

class GameViewModel : ViewModel() {
    private var _field: MutableLiveData<MutableList<GameBox>> = MutableLiveData()
    public val field: LiveData<MutableList<GameBox>>
        get() = _field

    private lateinit var _score: MutableLiveData<Int>
    public val score: LiveData<Int>
        get() = _score

    private lateinit var _message: MutableLiveData<String>
    public val message: LiveData<String>
        get() = _message

    private lateinit var _guess: MutableLiveData<List<GameBox>>
    public val guess: LiveData<List<GameBox>>
        get() = _guess

    private lateinit var optionHex: MutableLiveData<List<String>>

    private var totalBoxes: Int = 0

    init {
        optionHex.value = listOf(
            "#05c9de", "#cf7ce2", "#ca1e24", "#096951",
            "#6a90ef", "#f64a1e", "#9f734c", "#4b6b91"
        )

        _score.value = 0

        _message.value = "Match squares until you reach 40 points"

        while (totalBoxes < 15) {
            _field.value?.add(GameBox("#FFFFFF",false,false))

            totalBoxes ++
        }

//        for (option in optionHex) {
//
//            var box1 = field.value?.random()
//            var box2 = field.value?.random()
//
//            box1?.boxHex = option
//            box2?.boxHex = option
//        }
    }
}