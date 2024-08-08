package com.example.myfinanceapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

open class TransactionActivity : AppCompatActivity() {
    protected lateinit var sharedPreferences: SharedPreferences
    protected var accountNumber: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        accountNumber = intent.getStringExtra("ACCOUNT_NUMBER") ?: ""
    }

    protected fun saveTransaction(type: String, amount: Double) {
        val editor = sharedPreferences.edit()
        val transaction = sharedPreferences.getString("${accountNumber}-transactions", "") ?: ""
        //for.amt date pattern
        val dateFormat = SimpleDateFormat("EEE dd MMM HH:mm:ss yyyy", Locale.getDefault())
        val date = dateFormat.format(Date())
        //format amount with two decimal places
        val formattedAmount = String.format("%.2f", amount)
        val newTransaction = "$type:\n R$formattedAmount on $date \n\n"
        editor.putString("${accountNumber}-transactions", transaction + newTransaction)
        editor.apply()
    }

    // validate recipient account
    private fun isValidRecipient(accountNumber: String): Boolean {
        return sharedPreferences.contains("$accountNumber-username")
    }

    protected fun setRecipientAccount() {
        val recipientAccount = isValidRecipient(accountNumber)
    }

    protected fun updateBalance(amount: Double, isDeposit: Boolean, recipientAccount: String? = null) {
        val currentBalance = sharedPreferences.getFloat("${accountNumber}-balance", 0.0f)
        //update balance based on the condition
        val newBalance = if (isDeposit) currentBalance + amount else currentBalance - amount
        // update the balance of the current account
        with(sharedPreferences.edit()) {
            putFloat("${accountNumber}-balance", newBalance.toFloat())
            apply()// save the balance of the current account
        }
        // Update the balance and transaction history of the recipient if provided
        recipientAccount?.let {
            val recipientBalance = sharedPreferences.getFloat("${it}-balance", 0.0f)
            val recipientNewBalance = recipientBalance + amount

            // Update recipient balance
            with(sharedPreferences.edit()) {
                putFloat("${it}-balance", recipientNewBalance.toFloat())
                apply()
            }
            // Update recipient transaction history
            //retrieve the details(name and surname) of the recipient
            val recipientName = sharedPreferences.getString("$accountNumber-name", "Unknown Sender") ?: "Unknown Sender"
            val recipientSurname = sharedPreferences.getString("$accountNumber-surname", "Unknown Surname") ?: "Unknown Surname"
            val dateFormat = SimpleDateFormat("EEE dd MMM HH:mm:ss yyyy", Locale.getDefault())
            val date = dateFormat.format(Date())
            val formattedAmount = String.format("%.2f", amount)
            val newTransaction = "Payment received:\n +R$formattedAmount on $date from $recipientName $recipientSurname \n\n"

            val recipientTransaction = sharedPreferences.getString("${it}-transactions", "") ?: ""
            with(sharedPreferences.edit()) {
                putString("${it}-transactions", recipientTransaction + newTransaction)
                apply()
            }
        }
    }
    protected fun getCurrentBalance(): Double {
        return sharedPreferences.getFloat("${accountNumber}-balance", 0.0f).toDouble()
    }

    protected fun displayCurrentBalance(textView: TextView) {
                val currentBalance = getCurrentBalance()
                val formattedAmount = String.format("%.2f", currentBalance)
                textView.text = "Current Balance: R$formattedAmount"
            }

    protected fun getTransactionHistory(): String? {
                return sharedPreferences.getString("${accountNumber}-transactions", "")
            }

    protected fun displayTransactionHistory(textView: TextView) {
        val history = getTransactionHistory()
        //check if history is not empty if it's not null
        if (history != null && history.isNotEmpty()) {
            textView.text = history
        } else {
            textView.text = "No transaction history was found"
        }
    }

    protected fun getUserInfo(): String? {
        return sharedPreferences.getString("$accountNumber-name", "")?.let { name ->
            val surname = sharedPreferences.getString("$accountNumber-surname", "")
            val accountNumber = sharedPreferences.getString("$accountNumber-accountNumber", "")
            "$name $surname \nAccount Number:$accountNumber"

        }
    }


    protected fun displayUserInfo(txtUserInfo: TextView) {
        val userInfo = getUserInfo()
        txtUserInfo.text = userInfo ?: "No user information available"
    }

}



