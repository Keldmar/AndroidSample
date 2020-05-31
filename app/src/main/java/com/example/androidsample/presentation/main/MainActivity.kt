package com.example.androidsample.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.TokenWatcher
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProvider
import com.example.androidsample.R
import com.example.androidsample.data.pojo.User
import com.example.androidsample.presentation.adapters.UsersAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    private val usersAdapter = UsersAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = usersAdapter

       // viewModel= ViewModelProvider(this).get(MainViewModel::class.java)

//        viewModel.users.observe(this, Observer<MutableList<User>>{ users ->
//            usersAdapter.setNewItems(users)
//        })
//
//        viewModel.someText.observe(this, Observer<String> { someText ->
//            someFieldTextView.setText(someText)
//        })


//        someFieldTextView.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable?) {
//              // viewModel.someText.postValue(s.toString())
//            }
//
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//
//            }
//        })
    }
}
