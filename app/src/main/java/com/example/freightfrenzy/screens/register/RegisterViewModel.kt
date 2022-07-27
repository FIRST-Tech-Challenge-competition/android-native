package com.example.freightfrenzy.screens.register

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.freightfrenzy.database.RegisteredTeam
import com.example.freightfrenzy.database.RegisteredTeamDatabaseDao
import com.example.freightfrenzy.database.RegisteredTeamsDatabase
import kotlinx.coroutines.*
import java.io.InputStream
import java.net.URI

class RegisterViewModel(
    val database: RegisteredTeamDatabaseDao,
    application: Application): AndroidViewModel(application) {

    //Create an intent, and call (caller) the activity
    fun uploadImage(imageUploaderLauncher: ActivityResultLauncher<Intent>){
        val getIntent = Intent(Intent.ACTION_GET_CONTENT)
        getIntent.setType("image/*")
        imageUploaderLauncher.launch(getIntent)
    }

    //Coroutine stuff here.
    private var viewModelJob = Job()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun addingTeam(url: Uri?, latitude: Double, longtitude: Double, teamName: String, teamID: Int, robotName: String){
        uiScope.launch {
            val newTeam = RegisteredTeam(imageInfo = url, latitude = latitude, longtitude = longtitude, teamName = teamName, teamID = teamID, robotName = robotName)
            insert(newTeam)
        }
    }

    private suspend fun insert(team: RegisteredTeam){
        withContext(Dispatchers.IO){
            database.insert(team)
        }
    }
}