package com.example.freightfrenzy.screens.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.freightfrenzy.R
import com.example.freightfrenzy.databinding.FragmentRegisterBinding

class RegisterFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        val binding: FragmentRegisterBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        return binding.root
    }
}