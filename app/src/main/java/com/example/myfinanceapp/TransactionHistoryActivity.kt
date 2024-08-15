package com.example.myfinanceapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class TransactionHistoryActivity : TransactionActivity() {
    private lateinit var txtTransaction: TextView
    private lateinit var btnBackHistory:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction_history)

        txtTransaction = findViewById(R.id.txtTransaction)
        displayTransactionHistory(txtTransaction)

        //connecting id to variable
        btnBackHistory = findViewById(R.id.btnHistoryBack)

        //back method
        btnBackHistory.setOnClickListener {
            finish()
        }
    }
}
