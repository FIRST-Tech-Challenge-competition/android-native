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

class RegisteredTeamsAdapter: RecyclerView.Adapter<RegisteredTeamViewHolder>() {
    var data = listOf<RegisteredTeam>()
        //Update data when there's any change (So the recyclerview know to use new data to draw)
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: RegisteredTeamViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text =
            item.teamID.toString() + "\n"+
                item.teamName + "\n" +
                item.robotName + "\n" +
                item.latitude.toString() + " " + item.longtitude.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegisteredTeamViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.text_item_view, parent, false) as TextView
        return RegisteredTeamViewHolder(view)
    }
}