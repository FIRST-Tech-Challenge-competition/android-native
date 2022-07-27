package com.example.freightfrenzy.screens.register

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.freightfrenzy.database.RegisteredTeamDatabaseDao
import javax.sql.DataSource

class RegisterViewModelFactory(
    private var dataSource: RegisteredTeamDatabaseDao,
    private val application: Application): ViewModelProvider.Factory {

    //@Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RegisterViewModel::class.java)){
            return RegisterViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}