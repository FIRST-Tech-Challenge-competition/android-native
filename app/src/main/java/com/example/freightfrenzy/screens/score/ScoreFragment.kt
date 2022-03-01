package com.example.freightfrenzy.screens.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.freightfrenzy.R
import com.example.freightfrenzy.databinding.FragmentScoreBinding

class ScoreFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentScoreBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_score, container, false)
        return binding.root
    }
}