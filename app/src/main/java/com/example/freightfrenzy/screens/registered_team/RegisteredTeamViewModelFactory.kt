package com.example.freightfrenzy.screens.registered_team

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.freightfrenzy.database.RegisteredTeamDatabaseDao
import com.example.freightfrenzy.screens.registered_teams.RegisteredTeamsViewModel

class RegisteredTeamViewModelFactory(
    private val database: RegisteredTeamDatabaseDao,
    private val registrationId: Long): ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RegisteredTeamViewModel::class.java)){
            return RegisteredTeamViewModel(database, registrationId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}