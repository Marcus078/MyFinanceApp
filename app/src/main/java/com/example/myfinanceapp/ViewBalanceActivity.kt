package com.example.myfinanceapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ViewBalanceActivity : TransactionActivity() {
    private lateinit var txtBalance: TextView
    private lateinit var btnBack:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_balance)

        txtBalance = findViewById(R.id.txtBalance)
        displayCurrentBalance(txtBalance)

        //Connecting Id AND Variable
        btnBack = findViewById(R.id.btnBackBalance)
        //Onclick method for back button
        btnBack.setOnClickListener {
            finish()
        }
    }
}
