package com.example.freightfrenzy.screens.registered_teams

import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RegisteredTeamViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView) {

    init {
        textView.setOnClickListener {
            val position = adapterPosition
            Toast.makeText(itemView.context, "You clicked on the item #" + position.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}