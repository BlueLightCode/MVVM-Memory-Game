package com.bluelightcode.mvvm_memory_game.screens.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bluelightcode.mvvm_memory_game.screens.model.GameBox

class GameViewModel : ViewModel() {
    private lateinit var _field : MutableLiveData<List<GameBox>>
    public val field : LiveData<List<GameBox>>
        get() = _field

    private lateinit var _score : MutableLiveData<Int>
    public val score: LiveData<Int>
        get() = _score

    private lateinit var _message : MutableLiveData<String>
    public val  message: LiveData<String>
        get() = _message

    private lateinit var _guess : MutableLiveData<List<GameBox>>
    public val guess : LiveData<List<GameBox>>
        get() = _guess

    init {
        // Will put the color assignment code here
    }
}