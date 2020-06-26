package com.example.androidsample.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.androidsample.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RootActivity: AppCompatActivity() {

    var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.root_activity)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    }
}