package com.example.freightfrenzy.screens.registered_teams

import androidx.recyclerview.widget.DiffUtil
import com.example.freightfrenzy.database.RegisteredTeam

class RegisteredTeamsDiffUtil: DiffUtil.ItemCallback<RegisteredTeam>() {
    override fun areItemsTheSame(oldItem: RegisteredTeam, newItem: RegisteredTeam): Boolean {
        //Check primary key
        return oldItem.registrationID == newItem.registrationID
    }

    override fun areContentsTheSame(oldItem: RegisteredTeam, newItem: RegisteredTeam): Boolean {
        //Check everything, not just ID. E.g.: Sometimes, same object can change it's content.
        return oldItem == newItem
    }

}