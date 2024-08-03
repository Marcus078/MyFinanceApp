package com.example.myfinanceapp

import android.content.SharedPreferences
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
class MainActivity : AppCompatActivity() {
    private lateinit var btnDeposit: Button
    private lateinit var btnTransfer: Button
    private lateinit var btnWithdraw: Button
    private lateinit var btnViewTransactions:Button
    private lateinit var  btnViewBalance:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDeposit = findViewById(R.id.btnDeposit)
        btnTransfer = findViewById(R.id.btnTransfer)
        btnWithdraw = findViewById(R.id.btnWithdraw)
        btnViewTransactions = findViewById(R.id.btnViewTransactions)
        btnViewBalance= findViewById(R.id.btnViewBalance)

        btnDeposit.setOnClickListener {
            // create an intent object to start deposit activity
            // "this" keyword refers to current activity, refers to the current instance of the activity from which the button is being clicked
            /* An "Intent" is an object that provides runtime binding between separate components (such as two activities).
             It is used to start a new activity, send data between activities, etc.
             */
            //the "::class." java syntax is used to get a reference to the KClass of DepositActivity.
            val intent = Intent(this, DepositActivity::class.java)
            startActivity(intent)// method to open the specified activity
        }

        btnTransfer.setOnClickListener {
            val intent = Intent(this, TransferActivity::class.java)
            startActivity(intent)
        }

        btnWithdraw.setOnClickListener {
            val intent = Intent(this, WithdrawActivity::class.java)
            startActivity(intent)
        }
        btnViewTransactions.setOnClickListener {
            val intent = Intent(this, TransactionHistoryActivity::class.java)
            startActivity(intent)
        }

        btnViewBalance.setOnClickListener {
            startActivity(Intent(this, ViewBalanceActivity::class.java))
        }
    }
}


/*
class MainActivity : AppCompatActivity() {
    private lateinit var btnDeposit: Button
    private lateinit var btnTransfer: Button
    private lateinit var btnWithdraw: Button
    private lateinit var edtAmount: EditText
    private lateinit var edtRecipientAccount: EditText
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var loggedInUser: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Check if user is logged in
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)
        loggedInUser = sharedPreferences.getString("loggedInUser", "") ?: ""

        if (!isLoggedIn) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
            return
        }

        setContentView(R.layout.activity_main)

        btnDeposit = findViewById(R.id.btnDeposit)
        btnTransfer = findViewById(R.id.btnTransfer)
        btnWithdraw = findViewById(R.id.btnWithdraw)
        edtAmount = findViewById(R.id.edtAmount)
        edtRecipientAccount = findViewById(R.id.edtRecipientAccount)

        btnDeposit.setOnClickListener {
            val amount = edtAmount.text.toString().toDoubleOrNull()
            if (amount != null) {
                performDeposit(amount)
            } else {
                Toast.makeText(this, "Invalid amount", Toast.LENGTH_SHORT).show()
            }
        }

        btnTransfer.setOnClickListener {
            val amount = edtAmount.text.toString().toDoubleOrNull()
            val recipientAccount = edtRecipientAccount.text.toString()
            if (amount != null && recipientAccount.isNotBlank()) {
                performTransfer(amount, recipientAccount)
            } else {
                Toast.makeText(this, "Invalid amount or recipient account", Toast.LENGTH_SHORT).show()
            }
        }

        btnWithdraw.setOnClickListener {
            val amount = edtAmount.text.toString().toDoubleOrNull()
            if (amount != null) {
                performWithdraw(amount)
            } else {
                Toast.makeText(this, "Invalid amount", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun performDeposit(amount: Double) {
        // Assuming account number is fixed
        val accountNumber = "57832189"
        val name = sharedPreferences.getString("$loggedInUser:name", "")
        val surname = sharedPreferences.getString("$loggedInUser:surname", "")
        val deposit = Transaction(amount, "Deposit to account $accountNumber by $name $surname")
        Toast.makeText(this, deposit.displayDetails(), Toast.LENGTH_LONG).show()
    }

    private fun performTransfer(amount: Double, recipientAccount: String) {
        // Retrieve user details
        val accountNumber = "57832189"
        val name = sharedPreferences.getString("$loggedInUser:name", "")
        val surname = sharedPreferences.getString("$loggedInUser:surname", "")
        val transfer = Transfer(amount, recipientAccount, accountNumber, "2024-07-23")
        Toast.makeText(this, transfer.displayDetails(), Toast.LENGTH_LONG).show()
    }

    private fun performWithdraw(amount: Double) {
        // Retrieve user details
        val name = sharedPreferences.getString("$loggedInUser:name", "")
        val surname = sharedPreferences.getString("$loggedInUser:surname", "")
        val withdraw = Withdraw(amount, "ATM Location", "2024-07-23")
        Toast.makeText(this, withdraw.displayDetails(), Toast.LENGTH_LONG).show()
    }
}

 */