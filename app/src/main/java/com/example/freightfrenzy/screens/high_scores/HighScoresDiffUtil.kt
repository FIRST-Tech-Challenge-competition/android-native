package com.example.freightfrenzy.screens.high_scores

import androidx.recyclerview.widget.DiffUtil

class HighScoresDiffUtil: DiffUtil.ItemCallback<TeamProperty>() {
    override fun areItemsTheSame(oldItem: TeamProperty, newItem: TeamProperty): Boolean {
        //Check the unique ID (should be different in the API)
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TeamProperty, newItem: TeamProperty): Boolean {
        //Check everything, not just ID. E.g.: Sometimes, same object can change it's content.
        return oldItem == newItem
    }
}