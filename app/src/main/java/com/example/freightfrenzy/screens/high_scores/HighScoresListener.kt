package com.example.freightfrenzy.screens.high_scores

import com.example.freightfrenzy.database.RegisteredTeam

class HighScoresListener (val clickListener: (team: TeamProperty) -> Unit) {
    fun onClick(team: TeamProperty) = clickListener(team)

    //TODO: Will try a better way to do this one
    fun formatContent(item: TeamProperty): String {
        return """${item.teamid}
            |${item.score}
            |${item.autonomous}
            |${item.drivercontrolled}
            |${item.endgame}
            |${item.location}""".trimMargin()
    }
}