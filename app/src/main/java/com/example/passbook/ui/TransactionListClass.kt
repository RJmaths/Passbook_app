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
    fun getTotalBalance(): Double{
        if (listTransaction.isNullOrEmpty()){
            return 0.00
        }
        val withdrawList = listTransaction.filter { it.depositWithdrawal == "Withdrawal"}
        val depositList = listTransaction.filter { it.depositWithdrawal == "Deposit"}
        val withdrawAmountList = withdrawList.map { it.amount }
        val depositAmountList = depositList.map { it.amount }
        return ((depositAmountList.sum() - withdrawAmountList.sum())*100).toInt()/100.0
    }
}