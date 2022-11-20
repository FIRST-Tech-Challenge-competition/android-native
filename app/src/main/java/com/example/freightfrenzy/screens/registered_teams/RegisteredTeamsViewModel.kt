package com.example.freightfrenzy.screens.registered_teams

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.freightfrenzy.database.RegisteredTeamDatabaseDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class RegisteredTeamsViewModel(
    val database: RegisteredTeamDatabaseDao,
    application: Application): AndroidViewModel(application) {

    private var viewModelJob = Job()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private val uiScope = CoroutineScope(Dispatchers.IO + viewModelJob)

    //TODO: Might need to some coroutine stuff here for optimization
    val teams = database.getAllTeams()
}