package com.example.freightfrenzy.screens.final_score

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
import com.example.freightfrenzy.databinding.FragmentFinalScoreBinding
import com.example.freightfrenzy.screens.endgame.EndGameFragmentArgs

class FinalScoreFragment: Fragment() {
    private lateinit var finalScoreViewModel: FinalScoreViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //Get args from Bundle
        var args = FinalScoreFragmentArgs.fromBundle(arguments!!)

        ////Get the ViewModel and data binding for this fragment
        val binding: FragmentFinalScoreBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_final_score, container, false)
        finalScoreViewModel = ViewModelProvider(this).get(FinalScoreViewModel::class.java)

        //Update score
        binding.driverControlledScore.text = args.driverControlledScore.toString()
        binding.autonomousScore.text = args.autonomousScore.toString()
        binding.endGameScore.text = args.endGameScore.toString()
        binding.totalScore.text = (args.driverControlledScore + args.autonomousScore + args.endGameScore).toString()

        binding.backHomeButton.setOnClickListener{ view!!.findNavController().navigate(FinalScoreFragmentDirections.actionFinalScoreFragmentToTitleFragment()) }
        return binding.root
    }
}