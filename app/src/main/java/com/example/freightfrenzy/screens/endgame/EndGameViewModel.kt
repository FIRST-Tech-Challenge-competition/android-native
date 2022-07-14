package com.example.freightfrenzy.screens.endgame

import android.widget.Switch
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class EndGameViewModel: ViewModel() {
    private var _ducks_delivered = MutableLiveData<Int>()

    val ducks_delivered = Transformations.map(_ducks_delivered, {ducks -> ducks.toString()})

    private val min_score = 0
    private val max_ducks_delivered_score = 6

    init {
        _ducks_delivered.value = 0
    }

    fun calculate_score(checks: Map<Switch, Int>): Int{
        var total_score: Int = 0
        checks.forEach{ check, score -> if(check.isChecked) total_score += score }
        total_score += _ducks_delivered.value!!
        return total_score
    }

    fun update_score(added: Boolean, max_val: Int, min_val: Int, changed_val: MutableLiveData<Int>){
        if(added && changed_val.value!! < max_val) changed_val.value = changed_val.value?.plus(1)
        if(!added && changed_val.value!! > min_val) changed_val.value = changed_val.value?.minus(1)
    }

    fun update_ducks_delivered(added: Boolean){
        update_score(added, max_ducks_delivered_score, min_score, _ducks_delivered)
    }
}