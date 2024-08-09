package com.example.myfinanceapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnRegister: Button
    private lateinit var sharedPreferences: SharedPreferences

    //Textview declaration
    private lateinit var tvRegister:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtUsername = findViewById(R.id.edtUsername)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
      //  btnRegister = findViewById(R.id.btnRegister)
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        //Textview To ID
        tvRegister = findViewById(R.id.tvSignUp)

        btnLogin.setOnClickListener {
            val username = edtUsername.text.toString().trim()
            val password = edtPassword.text.toString().trim()
            if (authenticateUser(username, password)) {
                val accountNumberr = getAccountNumber(username) ?: ""
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("ACCOUNT_NUMBER", accountNumberr)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }

        tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun authenticateUser(username: String, password: String): Boolean {
        val allEntries = sharedPreferences.all
        for ((key, value) in allEntries) {
            if (key.contains("-username")) {
                val accountNumber = key.split("-")[0]
                val storedUsername = sharedPreferences.getString("$accountNumber-username", null)
                val storedPassword = sharedPreferences.getString("$accountNumber-password", null)
                if (username == storedUsername && password == storedPassword) {
                    return true
                }
            }
        }
        return false
    }

    private fun getAccountNumber(username: String): String? {
        val allEntries = sharedPreferences.all
        for ((key, value) in allEntries) {
            if (key.contains("-username")) {
                val accountNumber = key.split("-")[0]
                val storedUsername = sharedPreferences.getString("$accountNumber-username", null)
                if (username == storedUsername) {
                    return accountNumber
                }
            }
        }
        return null
    }
}
