package com.example.myfinanceapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Settings : AppCompatActivity() {

    // declaration
    private lateinit var btnExit:Button
    private lateinit var edNameUpdate:EditText
    private lateinit var edSurnameUpdate:EditText
    private lateinit var edEmailUpdate:EditText
    private lateinit var edNumberUpdate:EditText
    private lateinit var edUsernameUpdate:EditText
    private lateinit var edPasswordUpdate:EditText
    private lateinit var btnSaveSetting:Button

    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        //Assign id to the button and edittext
        btnExit = findViewById(R.id.btnSettingExit)
        edNameUpdate = findViewById(R.id.edUpdateName)
        edSurnameUpdate = findViewById(R.id.edUpdateSurname)
        edEmailUpdate = findViewById(R.id.edUpdateEmail)
        edNumberUpdate = findViewById(R.id.edUpdateNumber)
        edUsernameUpdate = findViewById(R.id.edUpdateUsername)
        edPasswordUpdate = findViewById(R.id.edUpdatePassword)
        btnSaveSetting = findViewById(R.id.btnSettingSave)

        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)



        //Onclick method for save button to make update for profile
        btnSaveSetting.setOnClickListener {

        }

        //Onclick method for exit button
        btnExit.setOnClickListener {
           //code to exit the activity
            finish()
        }

    }
}