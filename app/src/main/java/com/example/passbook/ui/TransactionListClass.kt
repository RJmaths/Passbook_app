package com.example.passbook.ui

import android.R.string
import com.example.passbook.ui.passbook.PassbookFragment.TransactionInstance


object TransactionListClass {
    private val listTransaction = mutableListOf<TransactionInstance>(
    )
    fun addTransaction(transactInst : TransactionInstance){
        listTransaction.add(transactInst)
    }
    fun getTransactionList(): MutableList<TransactionInstance>{
        return listTransaction
    }
}