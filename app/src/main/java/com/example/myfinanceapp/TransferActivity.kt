package com.example.myfinanceapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class TransferActivity : TransactionActivity() {
    private lateinit var txtCurrentBalance: TextView
    private lateinit var edtAmount: EditText
    private lateinit var edtRecipientAccount: EditText
    private lateinit var btnSubmitTransfer: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer)

        edtAmount = findViewById(R.id.edtAmount)
        edtRecipientAccount = findViewById(R.id.edtRecipientAccount)
        btnSubmitTransfer = findViewById(R.id.btnSubmitTransfer)
        txtCurrentBalance =findViewById(R.id.txtCurrentBalance)

        displayCurrentBalance(txtCurrentBalance)


        btnSubmitTransfer.setOnClickListener {
            val amountString = edtAmount.text.toString()
            val accountString = edtRecipientAccount.text.toString()
            if (amountString.isNotEmpty() && accountString.isNotEmpty()) {
                try {
                    val amount = amountString.toDouble()
                    if (getCurrentBalance() >= amount) {
                        updateBalance(amount, false)
                        saveTransaction("Transfer", amount)
                        Toast.makeText(this, "Transfer: R$amount", Toast.LENGTH_SHORT).show()
                        finish()
                    } else {
                        Toast.makeText(this, "Insufficient funds", Toast.LENGTH_SHORT).show()
                    }

                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Invalid amount or account number", Toast.LENGTH_SHORT).show()

                }
            } else {

            }

        }

    }
}



        /*
        btnSubmitTransfer.setOnClickListener {
            val amountString = edtAmount.text.toString()
            val recipientAccount = edtRecipientAccount.text.toString()

            if (amountString.isNotEmpty() && recipientAccount.isNotEmpty()) {
                try {
                    val amount = amountString.toDouble()
                    if (updateBalance(-amount)) {
                        saveTransaction("Transfer", amount, recipientAccount)
                        Toast.makeText(this, "Transferred: $amount to $recipientAccount", Toast.LENGTH_SHORT).show()
                        finish()
                    } else {
                        Toast.makeText(this, "Insufficient balance", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Invalid amount", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateBalance(amount: Double): Boolean {
        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val currentBalance = sharedPreferences.getFloat("balance", 0.0f).toDouble()
        return if (currentBalance + amount >= 0) {
            val newBalance = currentBalance + amount
            with(sharedPreferences.edit()) {
                putFloat("balance", newBalance.toFloat())
                apply()
            }
            true
        } else {
            false
        }
    }

    private fun saveTransaction(type: String, amount: Double, recipientAccount: String) {
        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val transactions = sharedPreferences.getString("transactions", "") ?: ""
        val dateFormat = SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.getDefault())
        val date = dateFormat.format(Date())
        val newTransaction = "$type: R$amount to $recipientAccount on $date\n"
        editor.putString("transactions", transactions + newTransaction)
        editor.apply()
    }
}
*/