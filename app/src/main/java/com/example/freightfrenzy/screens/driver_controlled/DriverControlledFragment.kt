package com.example.freightfrenzy.screens.driver_controlled

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.freightfrenzy.R
import com.example.freightfrenzy.databinding.FragmentDriverControlledBinding

class DriverControlledFragment: Fragment() {
    private lateinit var driverControlledViewModel: DriverControlledViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentDriverControlledBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_driver_controlled, container, false)

        //Get the ViewModel for this fragment
        driverControlledViewModel = ViewModelProvider(this).get(DriverControlledViewModel::class.java)

        //Set up navigation for all button(s) on the screen
        binding.toEndGameButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_driverControlledFragment_to_endGameFragment))
        return binding.root
    }
}