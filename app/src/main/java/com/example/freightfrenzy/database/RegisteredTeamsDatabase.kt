package com.example.freightfrenzy.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.freightfrenzy.utility.UriConverter

@Database(entities = [RegisteredTeam::class], version = 1, exportSchema = false)
@TypeConverters(UriConverter::class)
abstract class RegisteredTeamsDatabase: RoomDatabase(){
    abstract val registeredTeamDatabaseDao: RegisteredTeamDatabaseDao
    //We want to do singleton pattern here.
    companion object{
        @Volatile
        private var INSTANCE: RegisteredTeamsDatabase? = null
        fun getInstance(context: Context): RegisteredTeamsDatabase {
            synchronized(this){
                //Only init DB once
                var instance = INSTANCE

                if(instance == null){
                    //Reset and create new database
                    //Doesn't need to do data migration, because there's no need to keep data when change DB schema
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RegisteredTeamsDatabase::class.java,
                        "registered_teams_database")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}