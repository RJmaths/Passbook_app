package com.example.passbook.ui

import android.R.string
import com.example.passbook.ui.passbook.PassbookFragment.TransactionInstance


object TransactionListClass {
    private val listTransaction = mutableListOf<TransactionInstance>(
        TransactionInstance(12.5),
        TransactionInstance(22.5),
        TransactionInstance(32.5),
        TransactionInstance(45.5),
        TransactionInstance(52.5),
        TransactionInstance(62.5),
        TransactionInstance(72.5)
    )
    fun addTransaction(transactInst : TransactionInstance){
        listTransaction.add(transactInst)
    }
    fun getTransactionList(): MutableList<TransactionInstance>{
        return listTransaction
    }
}