package com.example.myfinanceapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class WithdrawActivity : TransactionActivity() {

    private lateinit var edtAmount: EditText
    private lateinit var btnSubmitWithdraw: Button
    private lateinit var txtBalance: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_withdraw)

        edtAmount = findViewById(R.id.edtAmount)
        btnSubmitWithdraw = findViewById(R.id.btnSubmitWithdraw)
        txtBalance = findViewById(R.id.txtBalance)

        displayCurrentBalance(txtBalance)

        btnSubmitWithdraw.setOnClickListener {
             val amountString = edtAmount.text.toString()
            if(amountString.isNotEmpty()){
                try {
                    val amount = amountString.toDouble()
                    if(getCurrentBalance() >= amount){
                        updateBalance(amount,false)
                        saveTransaction("Withdraw",amount)
                        Toast.makeText(this, "Withdraw: R$amount", Toast.LENGTH_SHORT).show()
                        finish()
                    }else{
                        Toast.makeText(this, "Insufficient funds", Toast.LENGTH_SHORT).show()
                    }
                }catch(e:NumberFormatException){
                    Toast.makeText(this, "Invalid number", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Enter amount", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

        /*
        *val amountString = edtAmount.text.toString()
            if (amountString.isNotEmpty()) {
                try {
                    val amount = amountString.toDouble()
                    if (getCurrentBalance() >= amount) {
                        updateBalance(amount, false)
                        saveTransaction("Withdraw", amount)
                        Toast.makeText(this, "Withdraw: R$amount", Toast.LENGTH_SHORT).show()
                        finish()
                    } else {
                        Toast.makeText(this, "Insufficient funds", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Invalid amount", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Enter amount", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
        * */
            /*

        btnSubmitWithdraw.setOnClickListener {
            val amountString = edtAmount.text.toString()
            if (amountString.isNotEmpty()) {
                try {
                    val amount = amountString.toDouble()
                    if (getCurrentBalance() >= amount) {
                        updateBalance(amount, false)
                        saveTransaction("Withdraw", amount)
                        Toast.makeText(this, "Withdrawn: R$amount", Toast.LENGTH_SHORT).show()
                        finish()
                    } else {
                        Toast.makeText(this, "Insufficient balance", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Invalid amount", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter an amount", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
*/