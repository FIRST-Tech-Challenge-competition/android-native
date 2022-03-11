package com.example.freightfrenzy.screens.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.freightfrenzy.R
import com.example.freightfrenzy.databinding.FragmentRegisteredTeamsBinding

class RegisteredTeamsFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentRegisteredTeamsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_registered_teams, container, false)

        binding.chooseTeamButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_registeredTeamsFragment_to_registeredTeamFragment))
        return binding.root
    }
}

//TODO: Create a RecycleView to view all registered teams and their info, and results.