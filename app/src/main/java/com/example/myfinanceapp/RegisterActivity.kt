package com.example.myfinanceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {
    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText
    private lateinit var edtName: EditText
    private lateinit var edtSurname: EditText
    private lateinit var edtAccountNumber: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPhoneNumber: EditText
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        edtUsername = findViewById(R.id.edtUsername)
        edtPassword = findViewById(R.id.edtPassword)
        edtName = findViewById(R.id.edtName)
        edtSurname = findViewById(R.id.edtSurname)
        edtAccountNumber = findViewById(R.id.edtAccountNumber)
        edtEmail = findViewById(R.id.edtEmail)
        edtPhoneNumber = findViewById(R.id.edtPhoneNumber)
        btnRegister = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val username = edtUsername.text.toString()
            val password = edtPassword.text.toString()
            val name = edtName.text.toString()
            val surname = edtSurname.text.toString()
            val accountNumber = edtAccountNumber.text.toString()
            val email = edtEmail.text.toString()
            val phoneNumber = edtPhoneNumber.text.toString()

            if (registerUser(username, password, name, surname, accountNumber, email, phoneNumber)) {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun registerUser(username: String, password: String, name: String, surname: String, accountNumber: String, email: String, phoneNumber: String): Boolean {
        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        with(sharedPreferences.edit()) {
            putString("username", username)
            putString("password", password)
            putString("name", name)
            putString("surname", surname)
            putString("accountNumber", accountNumber)
            putString("email", email)
            putString("phoneNumber", phoneNumber)
            apply()
        }

        return true
    }
}
