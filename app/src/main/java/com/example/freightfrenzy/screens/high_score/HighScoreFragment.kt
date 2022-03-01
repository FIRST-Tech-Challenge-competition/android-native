package com.example.freightfrenzy.screens.high_score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.freightfrenzy.R
import com.example.freightfrenzy.databinding.FragmentHighScoreBinding

class HighScoreFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentHighScoreBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_high_score, container, false)
        return binding.root
    }
}