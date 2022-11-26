package com.example.freightfrenzy.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface RegisteredTeamDatabaseDao {

    @Insert
    fun insert(team: RegisteredTeam)

    @Update
    fun update(team: RegisteredTeam)

    @Query("SELECT * from registered_teams_table WHERE registrationID = :key")
    fun get(key: Long): RegisteredTeam

    @Query("DELETE FROM registered_teams_table")
    fun clear()

    @Query("SELECT * FROM registered_teams_table ORDER BY registrationID DESC")
    fun getAllTeams(): List<RegisteredTeam>
}