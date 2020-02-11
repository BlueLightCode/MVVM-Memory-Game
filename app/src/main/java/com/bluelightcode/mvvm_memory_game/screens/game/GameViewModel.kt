package com.bluelightcode.mvvm_memory_game.screens.game

import android.graphics.Color
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bluelightcode.mvvm_memory_game.R
import com.bluelightcode.mvvm_memory_game.model.GameBox
import java.util.*
import kotlin.concurrent.timerTask

class GameViewModel : ViewModel() {

    /** Variable used for tracking the score **/
    private lateinit var _score: MutableLiveData<Int>
    public val score: LiveData<Int>
        get() = _score

    /** Variable used for changing messageText **/
    private lateinit var _message: MutableLiveData<String>
    public val message: LiveData<String>
        get() = _message

    /** Variable used for tracking what been guessed **/
    private var _guess = Array<GameBox?>(2) { null }

//    public val guess: LiveData<GameBox?>
//        get() = _guess

    /** Variable used for tracking the GameBox objects **/
    private var boxGrid: MutableList<GameBox> = mutableListOf(
        GameBox(
            boxHex = Color.parseColor("#05c9de"),
            paired = false,
            pairedView = null
        ),
        GameBox(
            boxHex = Color.parseColor("#05c9de"),
            paired = false,
            pairedView = null
        ),
        GameBox(
            boxHex = Color.parseColor("#cf7ce2"),
            paired = false,
            pairedView = null
        ),
        GameBox(
            boxHex = Color.parseColor("#cf7ce2"),
            paired = false,
            pairedView = null
        ),
        GameBox(
            boxHex = Color.parseColor("#ca1e24"),
            paired = false,
            pairedView = null
        ),
        GameBox(
            boxHex = Color.parseColor("#ca1e24"),
            paired = false,
            pairedView = null
        ),
        GameBox(
            boxHex = Color.parseColor("#096951"),
            paired = false,
            pairedView = null
        ),
        GameBox(
            boxHex = Color.parseColor("#096951"),
            paired = false,
            pairedView = null
        ),
        GameBox(
            boxHex = Color.parseColor("#6a90ef"),
            paired = false,
            pairedView = null
        ),
        GameBox(
            boxHex = Color.parseColor("#6a90ef"),
            paired = false,
            pairedView = null
        ),
        GameBox(
            boxHex = Color.parseColor("#f64a1e"),
            paired = false,
            pairedView = null
        ),
        GameBox(
            boxHex = Color.parseColor("#f64a1e"),
            paired = false,
            pairedView = null
        ),
        GameBox(
            boxHex = Color.parseColor("#9f734c"),
            paired = false,
            pairedView = null
        ),
        GameBox(
            boxHex = Color.parseColor("#9f734c"),
            paired = false,
            pairedView = null
        ),
        GameBox(
            boxHex = Color.parseColor("#4b6b91"),
            paired = false,
            pairedView = null
        ),
        GameBox(
            boxHex = Color.parseColor("#4b6b91"),
            paired = false,
            pairedView = null
        )
    )

//    /** Serves as a reference variable for the DataBinding Map **/
//    private lateinit var _gridBinding: MutableLiveData<HashMap<GameBox, TextView>>
//
//    public val gridBinding: LiveData<HashMap<GameBox, TextView>>
//        get() = _gridBinding


    init {  // Resets score, and shuffle squares

        _score.value = 0

        _message.value = "Match 2 boxes to get 5 points.  Once you get 40 points, you win!"

        boxGrid.shuffle()
    }

    private fun showColor(selectedBox: GameBox, selectedView: TextView?) {
        selectedView!!.setBackgroundResource(selectedBox.boxHex)
    }


    private fun hideColor(selectedView: TextView?) {
        selectedView!!.setBackgroundResource(R.color.white)
    }


    private fun takeAGuess(selectedBox: GameBox, selectedView: TextView) {

        if (selectedBox.pairedView == null) {
            /** Pairs the GameBox with a view, so the view can be referenced by object **/
            selectedBox.pairedView = selectedView
        }

        if (_guess.isEmpty()) {
            /** Adds the first guess to the array, and show it's color **/
            _guess[0] = selectedBox

            selectedView.isClickable = false

            showColor(selectedBox, selectedView)

        } else {
            /** Adds second guess to array, then checks if they match **/
            _guess[1] = selectedBox

            selectedView.isClickable = false

            showColor(selectedBox, selectedView)

            checkValidity()
        }
    }

    private fun checkValidity() {
        if (_guess[0]!!.boxHex != _guess[1]!!.boxHex) {
            /** Tells player their guess was incorrect, and hide colors after a few moments **/

            _message.value = "Too bad, those don't match up."

            Timer().schedule(timerTask {
                hideColor(_guess[0]!!.pairedView)
                hideColor(_guess[1]!!.pairedView)

                _guess[0]!!.pairedView!!.isClickable = true
                _guess[1]!!.pairedView!!.isClickable = true
            }, 2000)


        } else {
            /** Tells player their guess was correct, and increases score **/

            _message.value = "Good job! you got a match!"
            _guess[0]!!.paired = true
            _guess[1]!!.paired = true

            _score.value!!.plus(5)
        }

        _guess = emptyArray()  //Empties array for new guess attempt
    }
}