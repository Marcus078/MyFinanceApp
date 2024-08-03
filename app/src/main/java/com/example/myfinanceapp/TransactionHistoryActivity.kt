package com.example.myfinanceapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class TransactionHistoryActivity : TransactionActivity() {
    private lateinit var txtTransactions: TextView
    private lateinit var txtTransaction:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction_history)

        txtTransaction = findViewById(R.id.txtTransaction)
        displayTransactionHistory(txtTransaction)
/*
        txtTransactions = findViewById(R.id.txtTransactions)
        // Retrieve and display transactions
        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val transactions = sharedPreferences.getString("transactions", "No transactions found")
        txtTransactions.text = transactions

 */
    }
}
