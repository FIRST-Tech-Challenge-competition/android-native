package com.example.freightfrenzy.screens.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.freightfrenzy.R
import com.example.freightfrenzy.databinding.FragmentRegisterBinding

class RegisterFragment: Fragment() {
    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        val binding: FragmentRegisterBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)

        //Get the ViewModel for this fragment
        registerViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        return binding.root
    }
}