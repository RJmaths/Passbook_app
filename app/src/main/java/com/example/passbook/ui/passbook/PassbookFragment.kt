package com.example.passbook.ui.passbook

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.versionedparcelable.ParcelField
import androidx.versionedparcelable.VersionedParcelize
import com.example.passbook.databinding.FragmentPassbookBinding
import com.example.passbook.ui.TransactionListClass

class PassbookFragment : Fragment() {

    private lateinit var passbookViewModel: PassbookViewModel
    private var _binding: FragmentPassbookBinding? = null


    data class TransactionInstance(val amount: Double,
                                   val depositWithdrawal: String,
                                   val dateAndTime: String)

    private val transactionList = TransactionListClass.getTransactionList()


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPassbookBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
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
    }

    //Remove this and check if it works
    companion object {
        fun newInstance(): PassbookFragment = PassbookFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}