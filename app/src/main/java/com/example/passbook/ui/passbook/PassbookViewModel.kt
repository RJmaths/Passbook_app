package com.example.passbook.ui.passbook

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PassbookViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is passbook Fragment"
    }
    val text: LiveData<String> = _text
}