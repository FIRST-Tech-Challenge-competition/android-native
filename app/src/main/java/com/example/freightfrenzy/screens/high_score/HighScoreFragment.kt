package com.example.freightfrenzy.screens.high_score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.freightfrenzy.R
import com.example.freightfrenzy.databinding.FragmentHighScoreBinding

class HighScoreFragment: Fragment() {
    private lateinit var highScoreViewModel: HighScoreViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentHighScoreBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_high_score, container, false)

        //Get the ViewModel for this fragment
        highScoreViewModel = ViewModelProvider(this).get(HighScoreViewModel::class.java)
        return binding.root
    }
}