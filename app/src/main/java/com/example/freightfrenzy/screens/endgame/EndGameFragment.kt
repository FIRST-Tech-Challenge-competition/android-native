package com.example.freightfrenzy.screens.endgame

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.freightfrenzy.R
import com.example.freightfrenzy.databinding.FragmentEndgameBinding
import com.example.freightfrenzy.screens.driver_controlled.DriverControlledFragmentArgs

class EndGameFragment: Fragment() {
    private lateinit var endGameViewModel: EndGameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentEndgameBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_endgame, container, false)

        //Get the ViewModel for this fragment
        endGameViewModel = ViewModelProvider(this).get(EndGameViewModel::class.java)

        //Add ViewModel and LiveData to the Layout directly.
        //This is done so that we don't have to set up observers and listeners in the fragment, the Layout will do the job
        binding.endGameViewModel = endGameViewModel
        binding.setLifecycleOwner(viewLifecycleOwner)

        //Get args from Bundle
        var args = EndGameFragmentArgs.fromBundle(arguments!!)

        //Set up navigation for all button(s) on the screen
        binding.finishGameButton.setOnClickListener { view!!.findNavController().navigate(EndGameFragmentDirections.actionEndGameFragmentToFinalScoreFragment(args.autonomousScore, args.driverControlledScore, endGameViewModel.calculate_score(mapOf(
            binding.sharedHubTipped to 20,
            binding.shippingHubBalanced to 10,
            binding.shippingHubCapped to 15,
            binding.endParkingWarehouse to 3,
            binding.endCompletelyInWarehouse to 6
        ))))
        }
        return binding.root
    }
}