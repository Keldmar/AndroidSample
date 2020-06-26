package com.example.androidsample.presentation.fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.androidsample.R
import com.example.androidsample.data.pojo.User
import com.example.androidsample.presentation.adapters.UsersAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.main_fragment.*

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

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

        viewModel.users.observe(viewLifecycleOwner, Observer<MutableList<User>> { users ->
            usersAdapter.setNewItems(users)
        })
    }

}
