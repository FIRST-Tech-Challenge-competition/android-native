package com.example.freightfrenzy.screens.register

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.io.InputStream

class RegisterViewModel: ViewModel() {

    //Create an intent, and call (caller) the activity
    fun uploadImage(imageUploaderLauncher: ActivityResultLauncher<Intent>){
        val getIntent = Intent(Intent.ACTION_GET_CONTENT)
        getIntent.setType("image/*")
        imageUploaderLauncher.launch(getIntent)
    }
}