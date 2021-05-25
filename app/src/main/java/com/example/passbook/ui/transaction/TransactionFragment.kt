package com.example.passbook.ui.transaction

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.passbook.databinding.FragmentTransactionBinding
import com.example.passbook.ui.TransactionListClass
import com.example.passbook.ui.passbook.PassbookFragment

class TransactionFragment : Fragment(){

    private lateinit var transactionViewModel: TransactionViewModel
    private var _binding: FragmentTransactionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTransactionBinding.inflate(inflater, container, false)
        val view = binding.root
        val button: Button = binding.submitTransaction
        button.setOnClickListener {
            TransactionListClass.addTransaction(
                PassbookFragment.TransactionInstance(binding.transactionAmount.text.toString().toDouble())
            )
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}