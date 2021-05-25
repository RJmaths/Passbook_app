package com.example.passbook.ui.passbook

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.passbook.R

class ListAdapter(private val list: List<PassbookFragment.TransactionInstance>)
    : RecyclerView.Adapter<PassbookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PassbookViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PassbookViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: PassbookViewHolder, position: Int) {
        val transactInstance: PassbookFragment.TransactionInstance = list[position]
        val amountInstance: Double = transactInstance.amount
        val withdrawDepositInstance: String = transactInstance.depositWithdrawal
        val dateAndTimeInstance: String = transactInstance.dateAndTime
        holder.bind(amountInstance,withdrawDepositInstance, dateAndTimeInstance)
    }

    override fun getItemCount(): Int = list.size

}

class PassbookViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {
    private var amount: TextView? = null
    private var withdrawDeposit: TextView? = null
    private var dateTime: TextView? = null


    init {
        amount = itemView.findViewById(R.id.AmountDisplayID)
        withdrawDeposit = itemView.findViewById(R.id.DepositWithdrawID)
        dateTime = itemView.findViewById(R.id.TimeID)
    }

    fun bind(amount_inst : Double, withdraw_deposit_inst : String, date_time_inst : String) {
        amount?.text = "Rs $amount_inst"
        withdrawDeposit?.text = withdraw_deposit_inst
        dateTime?.text = date_time_inst

    }

}