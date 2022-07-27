package com.example.freightfrenzy.screens.registered_teams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        activity?.setTitle("Registered Teams")
        val binding: FragmentRegisteredTeamsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_registered_teams, container, false)

        //Get the ViewModel for this fragment with the factory, and add in the database
        val application = requireNotNull(this.activity).application
        val dataSource = RegisteredTeamsDatabase.getInstance(application).registeredTeamDatabaseDao
        val viewModelFactory = RegisteredTeamsViewModelFactory(application = application, dataSource = dataSource)

        registeredTeamsViewModel = ViewModelProvider(this, viewModelFactory).get(RegisteredTeamsViewModel::class.java)
        binding.setLifecycleOwner(viewLifecycleOwner)
        binding.registeredTeamsViewModel = registeredTeamsViewModel

        //Set up adapter for the recycler view
        val adapter = RegisteredTeamsAdapter()
        binding.teamList.adapter = adapter
        registeredTeamsViewModel.teams.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })

        //Set up navigation for all button(s) on the screen
        //binding.teamList.setOnClickListener{ view!!.findNavController().navigate(RegisteredTeamsFragmentDirections.actionRegisteredTeamsFragmentToRegisteredTeamFragment()) }
        //TODO: Need to setup navigation from registered teams to only one registered team
        return binding.root
    }
}