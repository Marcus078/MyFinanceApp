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
        val dateFormat = SimpleDateFormat("EEE MM dd HH:mm:ss z yyyy", Locale.getDefault())
        val date = dateFormat.format(Date())
        val formattedAmount = String.format("%.2f", amount)
        val newTransaction = "$type:\n R$formattedAmount on $date \n\n"
        editor.putString("${accountNumber}-transactions", transaction + newTransaction)
        editor.apply()
    }

    protected fun updateBalance(amount: Double, isDeposit: Boolean) {
        val currentBalance = sharedPreferences.getFloat("${accountNumber}-balance", 0.0f)
        val newBalance = if (isDeposit) currentBalance + amount else currentBalance - amount
        with(sharedPreferences.edit()) {
            putFloat("${accountNumber}-balance", newBalance.toFloat())
            apply()
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
        return sharedPreferences.getString("${accountNumber}-transactions","")
    }

    protected fun displayTransactionHistory(textView: TextView) {
        val history = getTransactionHistory()
        //check if history is not empty if it's not null
        if(history != null && history.isNotEmpty()){
            textView.text = history
        }else {
            textView.text ="No transaction history was found"
        }

    }

    protected fun getUserInfo(): String? {
        return sharedPreferences.getString("$accountNumber-name", "")?.let { name ->
            val surname = sharedPreferences.getString("$accountNumber-surname", "")
            "$name $surname"
        }
    }

    protected fun displayUserInfo(txtUserInfo: TextView) {
        val userInfo = getUserInfo()
        txtUserInfo.text = userInfo ?: "No user information available"
    }
}
