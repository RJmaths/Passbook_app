package com.example.passbook.ui.transaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.passbook.databinding.FragmentTransactionBinding
import com.example.passbook.ui.TransactionListClass
import com.example.passbook.ui.passbook.PassbookFragment
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*

class TransactionFragment : Fragment(){

    private var _binding: FragmentTransactionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTransactionBinding.inflate(inflater, container, false)
        val view = binding.root
        val button: Button = binding.submitTransaction

        //implements submitting functionality
        button.setOnClickListener {
            //checks if entered amount is empty
            if (binding.transactionAmount.text.isNotEmpty()){
                //Truncates input to 2 decimal places
                val amount = (binding.transactionAmount.text.toString().toDouble()*100).toInt()/100.0
                //Creates appropriate text for letter value
                val withdrawalOrDeposit: String =
                    if (binding.transactionTypeRadioGroup.checkedRadioButtonId == binding.deposit.id){
                    "Deposit"
                    } else{
                    "Withdrawal"
                    }
                //creates the time of transaction
                val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
                val currentDateAndTime = sdf.format(Date())
                //passes inputs to Transaction list
                TransactionListClass.addTransaction(
                    PassbookFragment.TransactionInstance(
                        amount,
                        withdrawalOrDeposit,
                        currentDateAndTime
                    )
                )
                binding.transactionAmount.setText("")
                val snack = Snackbar.make(it,"Transaction Added Successfully",Snackbar.LENGTH_LONG)
                snack.show()
            }
            else{
                val snack = Snackbar.make(it,"Please enter an amount for transaction",Snackbar.LENGTH_SHORT)
                snack.show()
            }
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}