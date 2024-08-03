package com.example.myfinanceapp

open class Transaction(val amount: Double, val date: String) {
    open fun displayDetails(): String {
        return "Amount: $amount \nDate: $date"
    }
}

class Transfer(amount: Double, var toAccountNumber: String, var fromAccount: String, date: String) : Transaction(amount, date) {
    override fun displayDetails(): String {
        return "Amount transferred: $amount\nTransfer to: $toAccountNumber\nFrom: $fromAccount\nDate: $date"
    }
}

class Withdraw(amount: Double, var atmLocation: String, date: String) : Transaction(amount, date) {
    override fun displayDetails(): String {
        return "Amount withdrawn: $amount\nAt: $atmLocation\nDate: $date"
    }
}