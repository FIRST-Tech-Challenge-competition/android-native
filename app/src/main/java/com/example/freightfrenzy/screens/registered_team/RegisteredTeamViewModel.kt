package com.example.freightfrenzy.screens.registered_team

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freightfrenzy.database.RegisteredTeam
import com.example.freightfrenzy.database.RegisteredTeamDatabaseDao
import kotlinx.coroutines.*

class RegisteredTeamViewModel(
    val database: RegisteredTeamDatabaseDao,
    val registrationId: Long,
    application: Application): AndroidViewModel(application) {

    private var viewModelJob = Job()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private val uiScope = CoroutineScope(Dispatchers.IO + viewModelJob)

    //TODO: Might need to some coroutine stuff here for optimization
    val teamInfo = database.get(registrationId)

    //TODO: Complete these 2 methods
    fun getLocation(latitude: Double, longtitude: Double): String{
        return ""
    }

    fun getImage(imageUri: Uri){
        return
    }
}