package com.example.myfinanceapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : TransactionActivity() {

    private lateinit var txtUserInfo: TextView

    //card view variable declaration
    private lateinit var cvDeposit:CardView
    private lateinit var cvTransfer:CardView
    private lateinit var cvWithdraw:CardView
    private lateinit var cvVieTrans:CardView
    private lateinit var cvBalance:CardView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Card view link with IDs
         cvDeposit = findViewById(R.id.cvDeposit)
        cvTransfer = findViewById(R.id.cvTrans)
         cvWithdraw = findViewById(R.id.cvwith)
        cvVieTrans = findViewById(R.id.cvHist)
        cvBalance = findViewById(R.id.cvBalance)


        txtUserInfo = findViewById(R.id.txtUserInfo)

        accountNumber = intent.getStringExtra("ACCOUNT_NUMBER") ?: ""
        displayUserInfo(txtUserInfo)  // Correct method call

        cvDeposit.setOnClickListener {
            val intent = Intent(this, DepositActivity::class.java)
            intent.putExtra("ACCOUNT_NUMBER", accountNumber)
            startActivity(intent)
        }

        cvTransfer.setOnClickListener {
            val intent = Intent(this, TransferActivity::class.java)
            intent.putExtra("ACCOUNT_NUMBER", accountNumber)
            startActivity(intent)
        }

        cvWithdraw.setOnClickListener {
            val intent = Intent(this, WithdrawActivity::class.java)
            intent.putExtra("ACCOUNT_NUMBER", accountNumber)
            startActivity(intent)
        }

        cvVieTrans.setOnClickListener {
            val intent = Intent(this, TransactionHistoryActivity::class.java)
            intent.putExtra("ACCOUNT_NUMBER", accountNumber)
            startActivity(intent)
        }

        cvBalance.setOnClickListener {
            val intent = Intent(this, ViewBalanceActivity::class.java)
            intent.putExtra("ACCOUNT_NUMBER", accountNumber)
            startActivity(intent)
        }
    }
}
