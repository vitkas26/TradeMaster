package com.crypto.trademaster.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.crypto.trademaster.repository.MainRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(
    val mainRepository: MainRepository
    ): ViewModel() {

}