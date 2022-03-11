package com.example.freightfrenzy.screens.autonomous

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.freightfrenzy.R
import com.example.freightfrenzy.databinding.FragmentAutonomousBinding

class AutonomousFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentAutonomousBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_autonomous, container, false)

        binding.driverControlledButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_autonomousFragment_to_driverControlledFragment))
        return binding.root
    }
}