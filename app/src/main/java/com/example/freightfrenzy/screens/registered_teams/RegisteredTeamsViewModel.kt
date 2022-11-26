package com.example.freightfrenzy.screens.registered_teams

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.freightfrenzy.database.RegisteredTeam
import com.example.freightfrenzy.database.RegisteredTeamDatabaseDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class RegisteredTeamsViewModel(val database: RegisteredTeamDatabaseDao): ViewModel() {
    private var _teams = MutableLiveData<List<RegisteredTeam>>()
    val teams: LiveData<List<RegisteredTeam>>
        get() = _teams

    private var viewModelJob = Job()
    private var coroutineScope = CoroutineScope(viewModelJob + Dispatchers.IO)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    init {
        coroutineScope.launch {
            //Must use postValue(), since we run it in I/O thread
            _teams.postValue(database.getAllTeams())
        }
    }
}