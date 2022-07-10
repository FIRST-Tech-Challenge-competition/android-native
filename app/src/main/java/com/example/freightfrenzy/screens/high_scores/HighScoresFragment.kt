package com.example.freightfrenzy.screens.high_scores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.freightfrenzy.R
import com.example.freightfrenzy.databinding.FragmentHighScoresBinding

class HighScoresFragment: Fragment() {
    private lateinit var highScoresViewModel: HighScoresViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentHighScoresBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_high_scores, container, false)

        //Get the ViewModel for this fragment
        highScoresViewModel = ViewModelProvider(this).get(HighScoresViewModel::class.java)

        //Set up navigation for all buttons in the screen
        binding.selectHighScoreTeam.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_highScoresFragment_to_highScoreFragment))
        return binding.root
    }
}