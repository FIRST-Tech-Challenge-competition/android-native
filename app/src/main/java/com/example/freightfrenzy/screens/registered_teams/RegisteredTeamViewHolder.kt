package com.example.freightfrenzy.screens.registered_teams

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.freightfrenzy.R
import com.example.freightfrenzy.database.RegisteredTeam
import com.example.freightfrenzy.databinding.RegisteredTeamItemViewBinding
import com.example.freightfrenzy.generated.callback.OnClickListener

class RegisteredTeamViewHolder private constructor(val binding: RegisteredTeamItemViewBinding): RecyclerView.ViewHolder(binding.root) {

    //This is used to not changed the class implementation, and make constructor private too
    companion object {
        //This method is used to create an instance of ViewHolder with a binding object
        fun create(parent: ViewGroup): RegisteredTeamViewHolder{
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = RegisteredTeamItemViewBinding.inflate(layoutInflater, parent, false)
            return RegisteredTeamViewHolder(binding)
        }
    }

    fun bind(clickListener: RegisteredTeamListener, item: RegisteredTeam) {
        binding.team = item
        binding.clickListener = clickListener
        //Update bindings
        binding.executePendingBindings()
    }
}