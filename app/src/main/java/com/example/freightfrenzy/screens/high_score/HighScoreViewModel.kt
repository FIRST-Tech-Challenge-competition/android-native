package com.example.freightfrenzy.screens.high_score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.freightfrenzy.screens.high_scores.TeamProperty
import com.example.freightfrenzy.utility.FrenzyAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class HighScoreViewModel(val teamid: String): ViewModel() {

    private val _response = MutableLiveData<TeamProperty>()

    // The external immutable LiveData for the request status String
    val response: LiveData<TeamProperty>
        get() = _response

    //Create coroutine job and scope, since we work with coroutine.
    //TODO: Find out why this one can run on Main and DB operations (RegisteredTeams) can't
    private var viewModelJob = Job()
    private var coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getTeam()
    }

    //Change to coroutine exception handling stuff instead
    private fun getTeam() {
        coroutineScope.launch {
            var getPropertiesDeferred = FrenzyAPI.frenzyService.getTeam(id = teamid)
            try {
                var result = getPropertiesDeferred.await()
                _response.value = result
            } catch (e: Throwable){
                //Failed case
                Log.e("API error", "No team found")
            }
        }
    }

    //Cancel the job when API is done loading
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}