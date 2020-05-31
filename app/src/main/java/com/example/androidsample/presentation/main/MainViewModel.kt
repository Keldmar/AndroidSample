package com.example.androidsample.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidsample.data.pojo.User

class MainViewModel: ViewModel() {

    var someText = MutableLiveData<String>()

//    val users: MutableLiveData<MutableList<User>> by lazy {
//        MutableLiveData().also {
//            loadUsers()
//        }
//    }


    private fun loadUsers(): MutableList<User> {
        return mutableListOf()
    }
}