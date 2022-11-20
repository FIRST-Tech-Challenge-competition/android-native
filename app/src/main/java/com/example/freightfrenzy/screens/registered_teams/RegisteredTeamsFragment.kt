package com.example.freightfrenzy.screens.registered_teams

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.freightfrenzy.R
import com.example.freightfrenzy.database.RegisteredTeamsDatabase
import com.example.freightfrenzy.databinding.FragmentRegisteredTeamsBinding
import com.example.freightfrenzy.screens.registered_teams.RegisteredTeamsViewModel

class RegisteredTeamsFragment: Fragment() {
    private lateinit var registeredTeamsViewModel: RegisteredTeamsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentRegisteredTeamsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_registered_teams, container, false)

        //Get the ViewModel for this fragment with the factory, and add in the database
        val application = requireNotNull(this.activity).application
        val dataSource = RegisteredTeamsDatabase.getInstance(application).registeredTeamDatabaseDao
        val viewModelFactory = RegisteredTeamsViewModelFactory(dataSource, application)

        registeredTeamsViewModel = ViewModelProvider(this, viewModelFactory).get(RegisteredTeamsViewModel::class.java)
        binding.setLifecycleOwner(viewLifecycleOwner)
        binding.registeredTeamsViewModel = registeredTeamsViewModel

        //Set up adapter for the recycler view
        val adapter = RegisteredTeamsAdapter(RegisteredTeamListener { registrationID ->
            Toast.makeText(context, "You clicked on item #${registrationID}", Toast.LENGTH_SHORT).show()
            view!!.findNavController().navigate(RegisteredTeamsFragmentDirections.actionRegisteredTeamsFragmentToRegisteredTeamFragment(registrationID))
        })
        binding.teamList.adapter = adapter

        //Allows to observer LiveData only when recycler view is on screen
        registeredTeamsViewModel.teams.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })
        return binding.root
    }
}