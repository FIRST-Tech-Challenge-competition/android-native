package com.example.freightfrenzy.screens.driver_controlled

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.freightfrenzy.R
import com.example.freightfrenzy.databinding.FragmentDriverControlledBinding

class DriverControlledFragment: Fragment() {
    private lateinit var driverControlledViewModel: DriverControlledViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentDriverControlledBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_driver_controlled, container, false)

        //Get the ViewModel for this fragment
        driverControlledViewModel = ViewModelProvider(this).get(DriverControlledViewModel::class.java)

        //Add ViewModel and LiveData to the Layout directly.
        //This is done so that we don't have to set up observers and listeners in the fragment, the Layout will do the job
        binding.driverControlledViewModel = driverControlledViewModel
        binding.setLifecycleOwner(viewLifecycleOwner)

        //Get args from Bundle
        var args = DriverControlledFragmentArgs.fromBundle(arguments!!)

        //Set up navigation for all button(s) on the screen
        binding.toEndGameButton.setOnClickListener{ view!!.findNavController().navigate(DriverControlledFragmentDirections.actionDriverControlledFragmentToEndGameFragment(args.autonomousScore, driverControlledViewModel.calculate_score())) }
        return binding.root
    }
}