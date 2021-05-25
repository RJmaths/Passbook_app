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
        holder.bind(amountInstance)
    }

    override fun getItemCount(): Int = list.size

}

class PassbookViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {
    private var amount: TextView? = null


    init {
        amount = itemView.findViewById(R.id.AmountDisplayID)
    }

    fun bind(amount_inst : Double) {
        amount?.text = amount_inst.toString()
    }

}