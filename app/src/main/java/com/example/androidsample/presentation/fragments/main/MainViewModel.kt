package com.example.androidsample.presentation.fragments.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidsample.R
import com.example.androidsample.data.pojo.User
import java.util.*

class MainViewModel @ViewModelInject constructor() : ViewModel() {

    val users: MutableLiveData<MutableList<User>> = MutableLiveData()

    init {
        loadUsers()
    }


    private fun loadUsers()  {
        val users = mutableListOf<User>()

        users.add(User( UUID.randomUUID().toString(),"Some Name", R.drawable.ic_launcher_foreground))
        users.add(User(UUID.randomUUID().toString(),"Some Name2", R.drawable.ic_launcher_foreground))
        users.add(User(UUID.randomUUID().toString(),"Some Name3", R.drawable.ic_launcher_foreground))
        users.add(User(UUID.randomUUID().toString(),"Some Name4", R.drawable.ic_launcher_foreground))
        users.add(User(UUID.randomUUID().toString(),"Some Name5", R.drawable.ic_launcher_foreground))
        users.add(User(UUID.randomUUID().toString(),"Some Name6", R.drawable.ic_launcher_foreground))

        this.users.postValue(users)
    }
}