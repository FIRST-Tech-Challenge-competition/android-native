package com.example.freightfrenzy.screens.endgame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.freightfrenzy.R
import com.example.freightfrenzy.databinding.FragmentEndgameBinding

class EndGameFragment: Fragment() {
    private lateinit var endGameViewModel: EndGameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentEndgameBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_endgame, container, false)

        //Get the ViewModel for this fragment
        endGameViewModel = ViewModelProvider(this).get(EndGameViewModel::class.java)

        //Set up navigation for all button(s) on the screen
        binding.finishGameButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_endGameFragment_to_finalScoreFragment))
        return binding.root
    }
}