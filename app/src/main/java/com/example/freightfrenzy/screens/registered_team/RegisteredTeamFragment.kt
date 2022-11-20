package com.example.freightfrenzy.screens.registered_team

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.freightfrenzy.R
import com.example.freightfrenzy.database.RegisteredTeam
import com.example.freightfrenzy.database.RegisteredTeamsDatabase
import com.example.freightfrenzy.databinding.FragmentRegisteredTeamBinding
import com.example.freightfrenzy.screens.driver_controlled.DriverControlledFragmentArgs
import com.example.freightfrenzy.screens.registered_teams.RegisteredTeamsViewModel
import com.example.freightfrenzy.screens.registered_teams.RegisteredTeamsViewModelFactory

class RegisteredTeamFragment: Fragment() {
    private lateinit var registeredTeamViewModel: RegisteredTeamViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentRegisteredTeamBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_registered_team, container, false)

        //Get the ViewModel for this fragment with the factory, and add in the database
        var args = RegisteredTeamFragmentArgs.fromBundle(arguments!!)
        val application = requireNotNull(this.activity).application
        val dataSource = RegisteredTeamsDatabase.getInstance(application).registeredTeamDatabaseDao
        val viewModelFactory = RegisteredTeamViewModelFactory(dataSource, args.registrationID, application)

        registeredTeamViewModel = ViewModelProvider(this, viewModelFactory).get(RegisteredTeamViewModel::class.java)
        binding.setLifecycleOwner(viewLifecycleOwner)
        binding.registeredTeamViewModel = registeredTeamViewModel
        //Assign only when the DB operation is done
        registeredTeamViewModel.teamInfo.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.teamID.text = it.teamID.toString()
                //TODO: Need to find a way to be able to access Google Drive provider to load image, or using another way to do upload image
                binding.teamImage.setImageURI(it.imageInfo)
                binding.location.text = "${it.latitude}(Lat) ${it.longtitude}(Long)"
            }
        })

        return binding.root
    }
}