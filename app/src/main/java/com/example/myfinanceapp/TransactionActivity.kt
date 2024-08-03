package com.example.myfinanceapp

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*


open class TransactionActivity: AppCompatActivity() {
protected  lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("transaction", MODE_PRIVATE)
    }
    protected fun saveTransaction(type:String, amount:Double) {
        val editor = sharedPreferences.edit()
        val transaction = sharedPreferences.getString("transaction", "") ?: ""
        val dateFormat = SimpleDateFormat("EEE MM HH:mm:ss z yyy", Locale.getDefault())
        val date = dateFormat.format(Date())
        val formattedAmount = String.format("%.2f", amount)  // Format amount
        val newTransaction = "$type:\n R$formattedAmount on $date \n\n"
        editor.putString("transaction", transaction + newTransaction)
        editor.apply()
    }
    protected fun updateBalance(amount:Double, isDeposit:Boolean) {
        val currentBalance = sharedPreferences.getFloat("balance", 0.0f)
        val newBalance = if (isDeposit) currentBalance + amount else currentBalance - amount
        with(sharedPreferences.edit()) {
            putFloat("balance", newBalance.toFloat())
            apply()
        }
    }
    protected fun getCurrentBalance():Double{
        return sharedPreferences.getFloat("balance",0.0f).toDouble()
    }
    /*
    protected fun getCurrentBalance():Double{
        return sharedPreferences.getFloat("balance",0.00f).toDouble()
    }
*/

    protected fun displayCurrentBalance(textView: TextView) {
        val currentBalance = getCurrentBalance()
        val formattedAmount = String.format("%.2f", currentBalance)  // Format amount
        textView.text = "Current Balance: R$formattedAmount"
    }
    protected fun getTransactionHistory(): String? {
        return sharedPreferences.getString("transaction","")
    }
    protected  fun displayTransactionHistory(txtTransaction: TextView){
        val history = getTransactionHistory()
        txtTransaction.text ="$history"
    }

}

    /*


    protected lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
    }

    protected fun saveTransaction(type: String, amount: Double) {
        val editor = sharedPreferences.edit()
        val transactions = sharedPreferences.getString("transactions", "") ?: ""
        val dateFormat = SimpleDateFormat("EEE MMM dd HH:mm:ss z yyy", Locale.getDefault())
        val date = dateFormat.format(Date())
        val newTransaction = "$type: R$amount on $date\n"
        editor.putString("transactions", transactions + newTransaction)
        editor.apply()
    }

    protected fun updateBalance(amount:Double, isDeposit:Boolean){
        val currentBalance = sharedPreferences.getFloat("balance",0.0f)
        val newBalance = if (isDeposit) currentBalance + amount else currentBalance -amount
        with(sharedPreferences.edit()){
            putFloat("balance", newBalance.toFloat())
            apply()
        }
    }

    protected fun getCurrentBalance():Double{
        return sharedPreferences.getFloat("balance",0.0f).toDouble()
    }
}*/








    /*
open class TransactionActivity: AppCompatActivity() {
    protected lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
    }

    protected fun saveTransaction(type: String, amount: Double) {
        val editor = sharedPreferences.edit()
        /*
        The Elvis operator checks if the result of the expression on its left (sharedPreferences.getString(...)) is null.
        If it is null, it returns the default value specified on its right side, which is also an empty string "".
         */
        val transactions = sharedPreferences.getString("transactions", "") ?: ""
        val dateFormat = SimpleDateFormat("EEE MMM dd HH:mm:ss z yyy", Locale.getDefault())
        val date = dateFormat.format(Date())                                  //specify the user's region
        val newTransaction = "$type: R$amount on $date\n"
        editor.putString("transactions", transactions + newTransaction)
        editor.apply()
    }

*/

 /*
    protected fun updateBalance(amount: Double, isDeposit: Boolean) {
        val currentBalance = sharedPreferences.getFloat("balance", 0.0f)
        val newBalance = if (isDeposit) currentBalance + amount else currentBalance - amount
        with(sharedPreferences.edit()) {
            putFloat("balance", newBalance.toFloat())
            apply()
        }
    }

    protected fun getCurrentBalance(): Double {
        return sharedPreferences.getFloat("balance", 0.0f).toDouble()
    }
}
*/


