package com.example.freightfrenzy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Change back the theme to default home theme right before load the layout, to end the splash screen right before load into the app.
        setTheme(R.style.Theme_FreightFrenzy)
        setContentView(R.layout.activity_main)
        val navController: NavController = this.findNavController(R.id.navigation)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController: NavController = this.findNavController(R.id.navigation)
        return navController.navigateUp()
    }
}