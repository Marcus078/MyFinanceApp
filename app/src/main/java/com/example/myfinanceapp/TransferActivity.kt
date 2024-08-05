package com.example.myfinanceapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class TransferActivity : TransactionActivity() {
    private lateinit var edtAmount: EditText
    private lateinit var edtRecipientAccount: EditText
    private lateinit var btnSubmitTransfer: Button
    private lateinit var txtCurrentBalance: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer)

        edtAmount = findViewById(R.id.edtAmount)
        edtRecipientAccount = findViewById(R.id.edtRecipientAccount)
        btnSubmitTransfer = findViewById(R.id.btnSubmitTransfer)
        txtCurrentBalance = findViewById(R.id.txtCurrentBalance)

        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        displayCurrentBalance(txtCurrentBalance)

        btnSubmitTransfer.setOnClickListener {
            val amountString = edtAmount.text.toString()
            val recipientAccount = edtRecipientAccount.text.toString()
            if (amountString.isNotEmpty() && recipientAccount.isNotEmpty()) {
                try {
                    val amount = amountString.toDouble()
                    if (getCurrentBalance() >= amount) {
                        if (isValidRecipient(recipientAccount)) {
                            updateBalance(amount, false)
                            saveTransaction("Transfer", amount)
                            Toast.makeText(this, "Transfer of R$amount to account $recipientAccount successful", Toast.LENGTH_SHORT).show()
                            finish()
                        } else {
                            Toast.makeText(this, "Recipient account does not exist", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this, "Insufficient funds", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Invalid amount or account number", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Enter amount and recipient account", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun isValidRecipient(accountNumber: String): Boolean {
        return sharedPreferences.contains("$accountNumber-username")
    }
}
