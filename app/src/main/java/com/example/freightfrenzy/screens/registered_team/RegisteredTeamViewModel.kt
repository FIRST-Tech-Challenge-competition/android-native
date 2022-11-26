package com.example.freightfrenzy.screens.registered_team

import android.app.Application
import android.net.Uri
import androidx.lifecycle.*
import com.example.freightfrenzy.database.RegisteredTeam
import com.example.freightfrenzy.database.RegisteredTeamDatabaseDao
import kotlinx.coroutines.*

class RegisteredTeamViewModel(
    val database: RegisteredTeamDatabaseDao,
    val registrationId: Long): ViewModel() {

    private var _teamInfo = MutableLiveData<RegisteredTeam>()
    val teamInfo: LiveData<RegisteredTeam>
        get() = _teamInfo

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.IO + viewModelJob)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    init {
        coroutineScope.launch {
            _teamInfo.postValue(database.get(registrationId))
        }
    }

    //TODO: Complete these 2 methods, if needed
    fun getLocation(latitude: Double, longtitude: Double): String{
        return ""
    }

    fun getImage(imageUri: Uri){
        return
    }
}