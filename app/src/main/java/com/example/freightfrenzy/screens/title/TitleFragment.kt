package com.example.freightfrenzy.screens.title

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
import com.example.freightfrenzy.databinding.FragmentTitleBinding

class TitleFragment: Fragment() {
    private lateinit var titleViewModel: TitleViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity?.setTitle("Freight Frenzy")
        //return super.onCreateView(inflater, container, savedInstanceState)
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)

        //Get the ViewModel for this fragment
        titleViewModel = ViewModelProvider(this).get(TitleViewModel::class.java)

        //Set up navigation for all buttons in the title screen
        binding.aboutButton.setOnClickListener{ view!!.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToAboutFragment()) }
        binding.gameButton.setOnClickListener{ view!!.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment()) }
        binding.registerButton.setOnClickListener{ view!!.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToRegisterFragment()) }
        binding.scoreButton.setOnClickListener{ view!!.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToRegisteredTeamsFragment()) }
        binding.highScoreButton.setOnClickListener{ view!!.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToHighScoresFragment()) }
        return binding.root
    }
}