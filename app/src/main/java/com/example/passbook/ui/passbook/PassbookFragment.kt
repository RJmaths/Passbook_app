package com.example.passbook.ui.passbook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.passbook.databinding.FragmentPassbookBinding
import com.example.passbook.ui.TransactionListClass

class PassbookFragment : Fragment() {

    private var _binding: FragmentPassbookBinding? = null

    //initialize the dataclass that represents a single transaction input
    data class TransactionInstance(val amount: Double,
                                   val depositWithdrawal: String,
                                   val dateAndTime: String)

    //retrieves list of transactions from TransactionListClass
    private val transactionList = TransactionListClass.getTransactionList()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPassbookBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // RecyclerView node initialized here
        binding.passbookID.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = ListAdapter(transactionList)
        }
        binding.totalAmountDisplayID.text = "Total balance\nRs ${TransactionListClass.getTotalBalance()}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}