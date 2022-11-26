package com.example.freightfrenzy.screens.high_scores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.freightfrenzy.databinding.HighScoreItemViewBinding

class HighScoresViewHolder private constructor(val binding: HighScoreItemViewBinding): RecyclerView.ViewHolder(binding.root) {

    //This is used to not changed the class implementation, and make constructor private too
    companion object {
        //This method is used to create an instance of ViewHolder with a binding object
        fun create(parent: ViewGroup): HighScoresViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = HighScoreItemViewBinding.inflate(layoutInflater, parent, false)
            return HighScoresViewHolder(binding)
        }
    }

    fun bind(clickListener: HighScoresListener, item: TeamProperty) {
        binding.team = item
        binding.clickListener = clickListener
        //Update bindings
        binding.executePendingBindings()
    }
}