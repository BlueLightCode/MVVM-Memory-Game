package com.bluelightcode.mvvm_memory_game.screens.game


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bluelightcode.mvvm_memory_game.R
import com.bluelightcode.mvvm_memory_game.databinding.FragmentGameBinding

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {


    /** used to reference GameViewModel **/
    private lateinit var viewModel: GameViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentGameBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_game, container, false
            )


        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        binding.lifecycleOwner = this

        /** Adds observers for Viewmodel LiveData **/
        viewModel.score.observe(
            viewLifecycleOwner,
            Observer { newScore ->
                binding.scoreText.text = getString(R.string.score_string, newScore)
            })

        viewModel.message.observe(
            viewLifecycleOwner,
            Observer { newMessage -> binding.messageText.text = newMessage })

//        viewModel.boxGrid.observe(viewLifecycleOwner, Observer { currentBoard -> binding.})

        binding.gameViewModel = viewModel

        return binding.root
    }
}