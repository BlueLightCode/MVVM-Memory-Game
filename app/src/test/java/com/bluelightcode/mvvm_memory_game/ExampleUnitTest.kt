package com.bluelightcode.mvvm_memory_game

import com.bluelightcode.mvvm_memory_game.screens.model.GameBox
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
//    @Test
//    fun addition_isCorrect() {
//        assertEquals(4, 2 + 2)
//    }

    //var blankField = MutableLiveData<MutableList<GameBox>>()

    /**
     * The following lists have an extra gamebox in them both, so neither one errors
     * out when trying to add/remove something from a null List
     * **/
    var listBoxes: MutableList<GameBox> = mutableListOf(
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

    var coloredBoxes: MutableList<GameBox> =
        mutableListOf(GameBox("#FFFFFF", paired = false, visible = false))

    init {
        val colorsList: List<String> = listOf(
            "#05c9de", "#cf7ce2", "#ca1e24", "#096951",
            "#6a90ef", "#f64a1e", "#9f734c", "#4b6b91"
        )


        for (color in colorsList) {// Assigns colors to two game boxes at a time.

            var x: Int = 0

            while (x < 2) {
                listBoxes[0].boxHex = color

                coloredBoxes.add(listBoxes[0])
                listBoxes .removeAt(0)

                x++
            }

        }

        listBoxes.add(coloredBoxes[0])
        coloredBoxes.removeAt(0)
        coloredBoxes.shuffle()
    }
}