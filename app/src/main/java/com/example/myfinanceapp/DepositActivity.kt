package com.example.myfinanceapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
 class DepositActivity : TransactionActivity() {
     private lateinit var edtAmount: EditText
     private lateinit var btnSubmitDeposit: Button
     private lateinit var txtBalance:TextView

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_deposit)

         edtAmount = findViewById(R.id.edtAmount)
         btnSubmitDeposit = findViewById(R.id.btnSubmitDeposit)
         txtBalance = findViewById(R.id.txtBalance)
         displayCurrentBalance(txtBalance)

         btnSubmitDeposit.setOnClickListener {
             val amountString = edtAmount.text.toString()
             if (amountString.isNotEmpty()) {
                 try {
                     val amount = amountString.toDouble()
                     updateBalance(amount, true)
                     saveTransaction("Deposit", amount)
                     finish()
                 } catch (e: NumberFormatException) {
                     Toast.makeText(this, "Invalid amount", Toast.LENGTH_SHORT).show()
                 }
             } else {
                 Toast.makeText(this, "Enter amount", Toast.LENGTH_SHORT).show()
             }
         }
     }
 }
/*
class DepositActivity : AppCompatActivity() {
    private lateinit var edtAmount: EditText
    private lateinit var btnSubmitDeposit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deposit)

        edtAmount = findViewById(R.id.edtAmount)
        btnSubmitDeposit = findViewById(R.id.btnSubmitDeposit)

        btnSubmitDeposit.setOnClickListener {
            val amountString = edtAmount.text.toString()
            if (amountString.isNotEmpty()) {
                try {
                    val amount = amountString.toDouble()

                    //call the updateBalance method to update the user's balance with the deposited amount.
                    updateBalance(amount)
                    //call the saveTransaction method to save the transaction details.
                    saveTransaction("Deposit", amount)// store key-value pairs
                    Toast.makeText(this, "Deposited: $amount", Toast.LENGTH_SHORT).show()
                    finish()//This closes the DepositActivity and returns to the previous activity.
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Invalid amount", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter an amount", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateBalance(amount: Double) {
        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val currentBalance = sharedPreferences.getFloat("balance", 0.0f).toDouble()
        val newBalance = currentBalance + amount
        with(sharedPreferences.edit()) {// This creates an editor to make changes to the shared preferences
            putFloat("balance", newBalance.toFloat()) //This updates the balance in shared preferences with the new balance converted to a Float.
            apply()//  This saves the changes to shared preferences

            /*
            Shared Preferences Data Types: Shared preferences in Android can only store float values directly.
            The putFloat method is used for storing float values, while putDouble does not exist.
             Hence, you need to convert any Double values to Float before storing them.
             */
        }
    }

    private fun saveTransaction(type: String, amount: Double) {
        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val transactions = sharedPreferences.getString("transactions", "") ?: ""
        val dateFormat = SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.getDefault())
        val date = dateFormat.format(Date())
        val newTransaction = "$type: R$amount on $date\n"
        editor.putString("transactions", transactions + newTransaction)
        editor.apply()
    }
}
*/