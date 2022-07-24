package com.example.freightfrenzy.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.net.URI

@Entity(tableName = "registered_teams_table")
data class RegisteredTeam (
    @PrimaryKey(autoGenerate = true)
    var registrationID: Long = 0L,

    @ColumnInfo(name = "image_info")
    var imageInfo: URI? = null,

    @ColumnInfo(name = "latitude")
    var latitude: Double = 0.0,

    @ColumnInfo(name = "longtitude")
    var longtitude: Double = 0.0,

    @ColumnInfo(name = "team_name")
    var teamName: String = "",

    @ColumnInfo(name = "team_id")
    var teamID: Int,

    @ColumnInfo(name = "robot_name")
    var robotName: String = ""
)