package com.example.freightfrenzy.screens.registered_team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.freightfrenzy.R
import com.example.freightfrenzy.databinding.FragmentRegisteredTeamBinding

class RegisteredTeamFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentRegisteredTeamBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_registered_team, container, false)
        return binding.root
    }
}