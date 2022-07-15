package com.example.freightfrenzy.screens.register

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.freightfrenzy.R
import com.example.freightfrenzy.databinding.FragmentRegisterBinding

class RegisterFragment: Fragment() {
    private lateinit var registerViewModel: RegisterViewModel
    private var data: Uri? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity?.setTitle("Team registration")
        //return super.onCreateView(inflater, container, savedInstanceState)
        val binding: FragmentRegisterBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)

        //Create Intent when click the button
        //This works, but there is a delay here, need to fix that
        binding.chooseImage.setOnClickListener{ imgView ->
            update_image()
            //Use Glide for faster image loading
            Glide.with(this).load(data).into(binding.chooseImage)
        }

        //Get the ViewModel for this fragment
        registerViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        return binding.root
    }

    fun update_image(){
        val getIntent = Intent(Intent.ACTION_GET_CONTENT)
        getIntent.setType("image/*")
        launcher.launch(getIntent)
    }

    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode == Activity.RESULT_OK){
            data = result.data!!.data
        }
    }
}