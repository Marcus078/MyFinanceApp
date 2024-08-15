package com.example.myfinanceapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Settings : AppCompatActivity() {

    //button declaration
    private lateinit var btnExit:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        //Assign id to the button
        btnExit = findViewById(R.id.btnSettingExit)

        //Onclick method for exit button
        btnExit.setOnClickListener {
           //code to exit the activity
            finish()
        }

    }
}