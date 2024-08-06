package com.example.myfinanceapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : TransactionActivity() {
    private lateinit var btnDeposit: Button
    private lateinit var btnTransfer: Button
    private lateinit var btnWithdraw: Button
    private lateinit var btnViewTransactions: Button
    private lateinit var btnViewBalance: Button
    private lateinit var txtUserInfo: TextView
    private lateinit var cvBalance: CardView
    private lateinit var cvBalance2: CardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDeposit = findViewById(R.id.btnDeposit)
        btnTransfer = findViewById(R.id.btnTransfer)
        btnWithdraw = findViewById(R.id.btnWithdraw)
        btnViewTransactions = findViewById(R.id.btnViewTransactions)
        btnViewBalance = findViewById(R.id.btnViewBalance)
        txtUserInfo = findViewById(R.id.txtUserInfo)
        cvBalance = findViewById(R.id.cvBalance)
        cvBalance2 = findViewById(R.id.cvBalance2)



        accountNumber = intent.getStringExtra("ACCOUNT_NUMBER") ?: ""
        displayUserInfo(txtUserInfo)
        // Correct method call
        cvBalance.setOnClickListener{
            val intent = Intent(this, ViewBalanceActivity::class.java)
            intent.putExtra("ACCOUNT_NUMBER", accountNumber)
            startActivity(intent)
        }

        cvBalance2.setOnClickListener{
            val intent = Intent(this, TransferActivity::class.java)
            intent.putExtra("ACCOUNT_NUMBER", accountNumber)
            startActivity(intent)
        }


        btnDeposit.setOnClickListener {
            val intent = Intent(this, DepositActivity::class.java)
            intent.putExtra("ACCOUNT_NUMBER", accountNumber)
            startActivity(intent)
        }
/*
        btnTransfer.setOnClickListener {
            val intent = Intent(this, TransferActivity::class.java)
            intent.putExtra("ACCOUNT_NUMBER", accountNumber)
            startActivity(intent)
        }

 */

        btnWithdraw.setOnClickListener {
            val intent = Intent(this, WithdrawActivity::class.java)
            intent.putExtra("ACCOUNT_NUMBER", accountNumber)
            startActivity(intent)
        }

        btnViewTransactions.setOnClickListener {
            val intent = Intent(this, TransactionHistoryActivity::class.java)
            intent.putExtra("ACCOUNT_NUMBER", accountNumber)
            startActivity(intent)
        }
/*
        btnViewBalance.setOnClickListener {
            val intent = Intent(this, ViewBalanceActivity::class.java)
            intent.putExtra("ACCOUNT_NUMBER", accountNumber)
            startActivity(intent)
        }
        */

    }
}
