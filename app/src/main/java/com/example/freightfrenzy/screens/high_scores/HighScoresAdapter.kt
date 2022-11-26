package com.example.freightfrenzy.screens.high_scores

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

class HighScoresAdapter(val clickListener: HighScoresListener): ListAdapter<TeamProperty, HighScoresViewHolder>(HighScoresDiffUtil()) {
    override fun onBindViewHolder(holder: HighScoresViewHolder, position: Int) {
        holder.bind(clickListener, getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HighScoresViewHolder {
        return HighScoresViewHolder.create(parent)
    }
}