package com.example.myfinanceapp

import android.os.Bundle
import android.widget.TextView

class TransactionHistoryActivity : TransactionActivity() {
    private lateinit var txtTransaction: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction_history)

        txtTransaction = findViewById(R.id.txtTransaction)
        displayTransactionHistory(txtTransaction)
    }
}
