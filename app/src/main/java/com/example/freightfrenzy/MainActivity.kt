package com.example.freightfrenzy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Change back the theme to default home theme right before load the layout, to end the splash screen right before load into the app.
        setTheme(R.style.Theme_FreightFrenzy)
        setContentView(R.layout.activity_main)
    }
}