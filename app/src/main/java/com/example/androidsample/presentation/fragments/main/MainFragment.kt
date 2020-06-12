package com.example.androidsample.presentation.fragments.main

import android.graphics.Color
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.androidsample.R
import com.example.androidsample.data.pojo.User
import com.example.androidsample.presentation.adapters.UsersAdapter
import com.google.android.material.transition.MaterialContainerTransform
import kotlinx.android.synthetic.main.item_user.*
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    lateinit var viewModel: MainViewModel

    private val usersAdapter = UsersAdapter { user, view ->
        val extras = FragmentNavigatorExtras(
            view to user.id
        )
        val action = MainFragmentDirections.actionMainFragmentToUserDetailsFragment(user)
        findNavController().navigate(action, extras)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.adapter = usersAdapter

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.users.observe(viewLifecycleOwner, Observer<MutableList<User>> { users ->
            usersAdapter.setNewItems(users)
        })
    }

}
