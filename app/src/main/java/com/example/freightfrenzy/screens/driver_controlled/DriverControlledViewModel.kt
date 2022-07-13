package com.example.freightfrenzy.screens.driver_controlled

import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class DriverControlledViewModel: ViewModel() {
    private var _freight = MutableLiveData<Int>()
    private var freight_l1: Int = 0
    private var freight_l2: Int = 0
    private var freight_l3: Int = 0
    private var shared_hub_freight: Int = 0

    //Mapping to create value that can add to Layout directly, w/o having to transform in the layout.
    val freight = Transformations.map(_freight, {res -> res.toString() })

    init {
        _freight.value = 0
    }

    fun update_freight(added: Boolean){
        if(added) _freight.value = _freight.value?.plus(1)
        else if(_freight.value!! > 0) _freight.value = _freight.value?.minus(1)
    }

    fun update_freight_l1(added: Boolean){
        if(added) freight_l1++
        else if(freight_l1 > 0) freight_l1--
    }

    fun update_freight_l2(added: Boolean){
        if(added) freight_l2++
        else if(freight_l2 > 0) freight_l2--
    }

    fun update_freight_l3(added: Boolean){
        if(added) freight_l3++
        else if(freight_l3 > 0) freight_l3--
    }

    fun update_shared_hub_freight(added: Boolean){
        if(added) shared_hub_freight++
        else if(shared_hub_freight > 0) shared_hub_freight--
    }
}