package com.example.myfinanceapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class ViewBalanceActivity : TransactionActivity() {
    private lateinit var txtBalance: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_balance)

        txtBalance = findViewById(R.id.txtBalance)
        displayCurrentBalance(txtBalance)

        /*
        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val currentBalance = sharedPreferences.getFloat("balance", 0.0f).toDouble()
        txtBalance.text = "Current Balance: R$currentBalance"
        */

    }
}
