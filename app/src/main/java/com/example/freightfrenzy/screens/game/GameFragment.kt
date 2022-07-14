package com.example.freightfrenzy.screens.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.freightfrenzy.R
import com.example.freightfrenzy.databinding.FragmentGameBinding

class GameFragment: Fragment() {
    private lateinit var gameViewModel: GameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity?.setTitle("Choose a team to play")
        val binding: FragmentGameBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)

        //Get the ViewModel for this fragment
        gameViewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        //Set up navigation for all buttons on the screen
        binding.startGameButton.setOnClickListener{ view!!.findNavController().navigate(GameFragmentDirections.actionGameFragmentToAutonomousFragment()) }
        return binding.root
    }
}

//TODO: Add team selection here