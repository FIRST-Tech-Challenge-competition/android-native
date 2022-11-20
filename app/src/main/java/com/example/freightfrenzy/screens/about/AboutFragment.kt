package com.example.freightfrenzy.screens.about

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.freightfrenzy.R
import com.example.freightfrenzy.databinding.FragmentAboutBinding

class AboutFragment: Fragment() {
    private lateinit var viewModel: AboutViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentAboutBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_about, container, false)

        //Get ViewModel for this fragment
        viewModel = ViewModelProvider(this).get(AboutViewModel::class.java)

        return binding.root
    }
}