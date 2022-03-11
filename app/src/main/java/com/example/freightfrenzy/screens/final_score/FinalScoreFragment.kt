package com.example.freightfrenzy.screens.final_score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.freightfrenzy.R
import com.example.freightfrenzy.databinding.FragmentFinalScoreBinding

class FinalScoreFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentFinalScoreBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_final_score, container, false)

        binding.backHomeButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_finalScoreFragment_to_titleFragment))
        return binding.root
    }
}