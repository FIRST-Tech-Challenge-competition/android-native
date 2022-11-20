package com.example.freightfrenzy.screens.registered_teams

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.freightfrenzy.R
import com.example.freightfrenzy.database.RegisteredTeam
//import com.example.freightfrenzy.screens.registered_teams.RegisteredTeamsFragment.RegisteredTeamViewHolder
import androidx.recyclerview.widget.ListAdapter

class RegisteredTeamsAdapter(val clickListener: RegisteredTeamListener): ListAdapter<RegisteredTeam, RegisteredTeamViewHolder>(RegisteredTeamsDiffUtil()) {
    override fun onBindViewHolder(holder: RegisteredTeamViewHolder, position: Int) {
        holder.bind(clickListener, getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegisteredTeamViewHolder {
        return RegisteredTeamViewHolder.create(parent)
    }
}