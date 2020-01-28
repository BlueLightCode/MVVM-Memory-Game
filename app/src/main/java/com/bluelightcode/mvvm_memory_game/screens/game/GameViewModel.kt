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


    private var listBoxes: MutableList<GameBox> = mutableListOf(
        GameBox("#FFFFFF", paired = false, visible = false),
        GameBox("#FFFFFF", paired = false, visible = false),
        GameBox("#FFFFFF", paired = false, visible = false),
        GameBox("#FFFFFF", paired = false, visible = false),
        GameBox("#FFFFFF", paired = false, visible = false),
        GameBox("#FFFFFF", paired = false, visible = false),
        GameBox("#FFFFFF", paired = false, visible = false),
        GameBox("#FFFFFF", paired = false, visible = false),
        GameBox("#FFFFFF", paired = false, visible = false),
        GameBox("#FFFFFF", paired = false, visible = false),
        GameBox("#FFFFFF", paired = false, visible = false),
        GameBox("#FFFFFF", paired = false, visible = false),
        GameBox("#FFFFFF", paired = false, visible = false),
        GameBox("#FFFFFF", paired = false, visible = false),
        GameBox("#FFFFFF", paired = false, visible = false),
        GameBox("#FFFFFF", paired = false, visible = false)
    )

    private var coloredBoxes: MutableList<GameBox> =
        mutableListOf(GameBox("#FFFFFF", paired = false, visible = false))

    init {

        _score.value = 0

        _message.value = "Match squares until you reach 40 points"


        val colorsList: List<String> = listOf(
            "#05c9de", "#cf7ce2", "#ca1e24", "#096951",
            "#6a90ef", "#f64a1e", "#9f734c", "#4b6b91"
        )


        for (color in colorsList) {// Assigns colors to two game boxes at a time.

            var x: Int = 0

            while (x < 2) {
                /**
                 * Sets the current color to the first box in listBoxes for two boxes
                 * Once done, this loop moves the colored boxes to a separate list**/
                listBoxes[0].boxHex = color

                coloredBoxes.add(listBoxes[0])
                listBoxes .removeAt(0)

                x++
            }

        }

        listBoxes.add(coloredBoxes[0])
        coloredBoxes.removeAt(0)

        coloredBoxes.shuffle()

        _field.postValue(coloredBoxes)
    }
}