package com.example.freightfrenzy.screens.autonomous

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.freightfrenzy.MainActivity
import com.example.freightfrenzy.R
import com.example.freightfrenzy.databinding.FragmentAutonomousBinding

class AutonomousFragment: Fragment() {
    private lateinit var autonomousViewModel: AutonomousViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity?.setTitle("Stage 1: Autonomous")
        val binding: FragmentAutonomousBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_autonomous, container, false)

        //Get the ViewModel for this fragment
        autonomousViewModel = ViewModelProvider(this).get(AutonomousViewModel::class.java)

        //Add ViewModel and LiveData to the Layout directly.
        //This is done so that we don't have to set up observers and listeners in the fragment, the Layout will do the job
        binding.autonomousViewModel = autonomousViewModel
        binding.setLifecycleOwner(viewLifecycleOwner)

        //Set up navigation for all button(s) on the screen
        binding.driverControlledButton.setOnClickListener{
            view!!.findNavController().navigate(AutonomousFragmentDirections.actionAutonomousFragmentToDriverControlledFragment(
                autonomousViewModel.calculate_score(mapOf(
                    binding.duckDelivered to 10,
                    binding.parkingAllianceStorageUnit to 3,
                    binding.parkingStorageUnit to 6,
                    binding.parkingWarehouse to 5,
                    binding.parkingCompletelyWarehouse to 10,
                    binding.freightStorageUnit to 2,
                    binding.freightShippingHub to 6,
                    binding.bonusDuckUsed to 10,
                    binding.bonusTeamScoreElemUsed to 20
                ))))
        }
        return binding.root
    }
}