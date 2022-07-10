package com.example.freightfrenzy.screens.autonomous

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.freightfrenzy.R
import com.example.freightfrenzy.databinding.FragmentAutonomousBinding

class AutonomousFragment: Fragment() {
    private lateinit var autonomousViewModel: AutonomousViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentAutonomousBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_autonomous, container, false)

        //Get the ViewModel for this fragment
        autonomousViewModel = ViewModelProvider(this).get(AutonomousViewModel::class.java)

        //Set up navigation for all button(s) on the screen
        binding.driverControlledButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_autonomousFragment_to_driverControlledFragment))
        return binding.root
    }
}