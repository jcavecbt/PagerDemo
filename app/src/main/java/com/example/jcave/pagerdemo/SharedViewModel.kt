package com.example.jcave.pagerdemo

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SharedViewModel : ViewModel() {

    private lateinit var myLiveData: MutableLiveData<String>


    fun getData() : LiveData<String> {
        if (!::myLiveData.isInitialized) {
            myLiveData = MutableLiveData()
            loadData()
        }
        return myLiveData
    }

    private fun loadData(){
        GlobalScope.launch {
            myLiveData.postValue("ayayyayayay")
        }

    }

}