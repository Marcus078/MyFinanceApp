package com.example.myfinanceapp

import android.os.Bundle
import android.widget.TextView

class ViewBalanceActivity : TransactionActivity() {
    private lateinit var txtBalance: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_balance)

        txtBalance = findViewById(R.id.txtBalance)
        displayCurrentBalance(txtBalance)
    }
}
