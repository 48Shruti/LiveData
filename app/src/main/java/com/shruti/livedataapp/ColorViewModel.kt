package com.shruti.livedataapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ColorViewModel :ViewModel() {
    var number : MutableLiveData<Int> = MutableLiveData(1)
    var color : MutableLiveData<Int> = MutableLiveData(1)
    var reset : MutableLiveData<Int> = MutableLiveData(1)
}