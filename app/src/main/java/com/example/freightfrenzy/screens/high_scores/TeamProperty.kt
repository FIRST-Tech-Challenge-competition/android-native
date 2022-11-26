package com.example.freightfrenzy.screens.high_scores

import com.squareup.moshi.Json

data class TeamProperty (
    @Json(name = "id") val id: String,
    @Json(name = "teamid") val teamid: String,
    @Json(name = "autonomous") val autonomous: String,
    @Json(name = "drivercontrolled") val drivercontrolled: String,
    @Json(name = "endgame") val endgame: String,
    @Json(name = "score") val score: String,
    @Json(name = "location") val location: String
)