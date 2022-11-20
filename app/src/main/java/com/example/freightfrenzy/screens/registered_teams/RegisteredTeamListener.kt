package com.example.freightfrenzy.screens.registered_teams

import com.example.freightfrenzy.database.RegisteredTeam

//A click listener
class RegisteredTeamListener(val clickListener: (registrationID: Long) -> Unit) {
    fun onClick(team: RegisteredTeam) = clickListener(team.registrationID)

    //TODO: Will try a better way to do this one
    fun formatContent(item: RegisteredTeam): String {
        return """${item.teamID}
            |${item.teamName}
            |${item.robotName}
            |${item.latitude}
            |${item.longtitude}""".trimMargin()
    }
}