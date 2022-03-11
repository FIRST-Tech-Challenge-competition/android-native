package com.example.freightfrenzy.screens.driver_controlled

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.freightfrenzy.R
import com.example.freightfrenzy.databinding.FragmentDriverControlledBinding

class DriverControlledFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentDriverControlledBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_driver_controlled, container, false)

        binding.toEndGameButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_driverControlledFragment_to_endGameFragment))
        return binding.root
    }
}