package com.example.freightfrenzy.screens.autonomous

import android.util.Log
import android.widget.Switch
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AutonomousViewModel: ViewModel() {
    fun calculate_score(checks: Map<Switch, Int>): Int {
        var total_score: Int = 0
        checks.forEach { check, score -> if(check.isChecked) total_score += score }
        return total_score
    }
}