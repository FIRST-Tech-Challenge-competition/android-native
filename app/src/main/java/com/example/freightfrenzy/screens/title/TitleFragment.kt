package com.example.freightfrenzy.screens.title

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.freightfrenzy.R
import com.example.freightfrenzy.databinding.FragmentTitleBinding

class TitleFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)

        //Set up navigation for all buttons in the title screen
        binding.aboutButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_aboutFragment))
        binding.gameButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment))
        binding.registerButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_registerFragment))
        binding.scoreButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_scoreFragment))
        binding.highScoreButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_highScoreFragment))
        return binding.root
    }
}