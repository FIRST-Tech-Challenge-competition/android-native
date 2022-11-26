package com.example.freightfrenzy.screens.registered_teams

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.freightfrenzy.database.RegisteredTeamDatabaseDao

class RegisteredTeamsViewModelFactory(private val dataSource: RegisteredTeamDatabaseDao): ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RegisteredTeamsViewModel::class.java)){
            return RegisteredTeamsViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}