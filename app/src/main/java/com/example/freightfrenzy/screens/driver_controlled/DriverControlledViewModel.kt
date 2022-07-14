package com.example.freightfrenzy.screens.driver_controlled

import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class DriverControlledViewModel: ViewModel() {
    private var _freight = MutableLiveData<Int>()
    private var _freight_l1 = MutableLiveData<Int>()
    private var _freight_l2 = MutableLiveData<Int>()
    private var _freight_l3 = MutableLiveData<Int>()
    private var _shared_hub_freight = MutableLiveData<Int>()

    //Mapping to create value that can add to Layout directly, w/o having to transform in the layout.
    val freight = Transformations.map(_freight, {res -> res.toString() })
    val freight_l1 = Transformations.map(_freight_l1, {res -> res.toString() })
    val freight_l2 = Transformations.map(_freight_l2, {res -> res.toString() })
    val freight_l3 = Transformations.map(_freight_l3, {res -> res.toString() })
    val shared_hub_freight = Transformations.map(_shared_hub_freight, {res -> res.toString() })

    //Some constants (Have tried to put it into resources file, but didn't work quite well)
    private val min_score = 0
    private var max_freight_score = 1
    private var max_freight_l1_score = 2
    private var max_freight_l2_score = 4
    private var max_freight_l3_score = 6
    private var max_shared_hub_freight_score = 4

    init {
        _freight.value = 0
        _freight_l1.value = 0
        _freight_l2.value = 0
        _freight_l3.value = 0
        _shared_hub_freight.value = 0
    }

    fun calculate_score(): Int{
        return _freight.value!! + _freight_l1.value!! + _freight_l2.value!! + _freight_l3.value!! + _shared_hub_freight.value!!
    }

    fun update_score(added: Boolean, max_val: Int, min_val: Int, changed_val: MutableLiveData<Int>){
        if(added && changed_val.value!! < max_val) changed_val.value = changed_val.value?.plus(1)
        if(!added && changed_val.value!! > min_val) changed_val.value = changed_val.value?.minus(1)
    }

    fun update_freight(added: Boolean){
        update_score(added, max_freight_score, min_score, _freight)
    }

    fun update_freight_l1(added: Boolean){
        update_score(added, max_freight_l1_score, min_score, _freight_l1)
    }

    fun update_freight_l2(added: Boolean){
        update_score(added, max_freight_l2_score, min_score, _freight_l2)
    }

    fun update_freight_l3(added: Boolean){
        update_score(added, max_freight_l3_score, min_score, _freight_l3)
    }

    fun update_shared_hub_freight(added: Boolean){
        update_score(added, max_shared_hub_freight_score, min_score, _shared_hub_freight)
    }
}