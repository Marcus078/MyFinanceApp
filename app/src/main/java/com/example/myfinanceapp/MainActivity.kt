package com.example.myfinanceapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : TransactionActivity() {
    private lateinit var btnViewTransactions: Button
    private lateinit var btnLogout:Button
    private lateinit var txtUserInfo: TextView
    private lateinit var cvBalance: CardView
    private lateinit var cvTransfer:CardView
    private lateinit var cvWithdraw:CardView
    private lateinit var cvDeposit:CardView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* btnDeposit = findViewById(R.id.btnDeposit)
         btnTransfer = findViewById(R.id.btnTransfer)
         btnWithdraw = findViewById(R.id.btnWithdraw)*/
        btnViewTransactions = findViewById(R.id.btnViewTransactions)
        btnLogout = findViewById(R.id.btnLogout)
        /*  btnViewBalance = findViewById(R.id.btnViewBalance)*/
        txtUserInfo = findViewById(R.id.txtUserInfo)
        cvBalance = findViewById(R.id.cvBalance)
        // cvBalance2 = findViewById(R.id.cvBalance2)

        cvTransfer = findViewById(R.id.cvTrans)
        cvWithdraw = findViewById(R.id.cvwith)
        cvDeposit = findViewById(R.id.cvDeposit)



        accountNumber = intent.getStringExtra("ACCOUNT_NUMBER") ?: ""
        displayUserInfo(txtUserInfo)
        // Correct method call
        cvBalance.setOnClickListener{
            val intent = Intent(this, ViewBalanceActivity::class.java)
            intent.putExtra("ACCOUNT_NUMBER", accountNumber)
            startActivity(intent)
        }

        cvTransfer.setOnClickListener{
            val intent = Intent(this, TransferActivity::class.java)
            intent.putExtra("ACCOUNT_NUMBER", accountNumber)
            startActivity(intent)
        }


        cvDeposit.setOnClickListener {
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

        cvWithdraw.setOnClickListener {
            val intent = Intent(this, WithdrawActivity::class.java)
            intent.putExtra("ACCOUNT_NUMBER", accountNumber)
            startActivity(intent)
        }

        btnViewTransactions.setOnClickListener {
            val intent = Intent(this, TransactionHistoryActivity::class.java)
            intent.putExtra("ACCOUNT_NUMBER", accountNumber)
            startActivity(intent)
        }

        //logout
        btnLogout.setOnClickListener{
            finish()
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
