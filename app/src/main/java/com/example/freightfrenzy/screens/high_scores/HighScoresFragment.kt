package com.example.freightfrenzy.screens.high_scores

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.freightfrenzy.R
import com.example.freightfrenzy.databinding.FragmentHighScoresBinding
import com.example.freightfrenzy.screens.registered_teams.RegisteredTeamListener
import com.example.freightfrenzy.screens.registered_teams.RegisteredTeamsAdapter
import com.example.freightfrenzy.screens.registered_teams.RegisteredTeamsFragmentDirections

class HighScoresFragment: Fragment() {
    private lateinit var highScoresViewModel: HighScoresViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentHighScoresBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_high_scores, container, false)

        //Get the ViewModel for this fragment
        highScoresViewModel = ViewModelProvider(this).get(HighScoresViewModel::class.java)
        binding.setLifecycleOwner(viewLifecycleOwner)
        binding.highScoresViewModel = highScoresViewModel

        //TODO: Need to allow navigating with an object (Can be done with Parcable type. If not possible, can use multiple params instead)
        //I may find some helps here: https://levelup.gitconnected.com/compose-your-android-navigation-with-custom-arguments-20d4467b5dfd
        val adapter = HighScoresAdapter(HighScoresListener { team ->
            Toast.makeText(context, "You clicked on item #${team.id}", Toast.LENGTH_SHORT).show()
            view!!.findNavController().navigate(HighScoresFragmentDirections.actionHighScoresFragmentToHighScoreFragment())
        })
        binding.highScoreList.adapter = adapter

        highScoresViewModel.response.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        //Set up navigation for all buttons in the screen
        //binding.selectHighScoreTeam.setOnClickListener{ view!!.findNavController().navigate(HighScoresFragmentDirections.actionHighScoresFragmentToHighScoreFragment()) }
        return binding.root
    }
}