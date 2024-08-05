package com.example.myfinanceapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var edtName: EditText
    private lateinit var edtSurname: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPhoneNumber: EditText
    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnRegister: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        edtName = findViewById(R.id.edtName)
        edtSurname = findViewById(R.id.edtSurname)
        edtEmail = findViewById(R.id.edtEmail)
        edtPhoneNumber = findViewById(R.id.edtPhoneNumber)
        edtUsername = findViewById(R.id.edtUsername)
        edtPassword = findViewById(R.id.edtPassword)
        btnRegister = findViewById(R.id.btnRegister)
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        btnRegister.setOnClickListener {
            val name = edtName.text.toString()
            val surname = edtSurname.text.toString()
            val email = edtEmail.text.toString()
            val phoneNumber = edtPhoneNumber.text.toString()
            val username = edtUsername.text.toString()
            val password = edtPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                val accountNumber = generateAccountNumber()
                with(sharedPreferences.edit()) {
                    putString("$accountNumber-name", name)
                    putString("$accountNumber-surname", surname)
                    putString("$accountNumber-email", email)
                    putString("$accountNumber-phoneNumber", phoneNumber)
                    putString("$accountNumber-username", username)
                    putString("$accountNumber-password", password)
                    putFloat("$accountNumber-balance", 0.0f) // Initialize balance
                    putString("$accountNumber-transactions", "") // Initialize transactions
                    apply()
                }
                Toast.makeText(this, "Registration successful. Account number: $accountNumber", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun generateAccountNumber(): String {
        val numbers = (1..9).map { it.toString() }
        return (1..10).map { numbers.random() }.joinToString("")
    }
}
