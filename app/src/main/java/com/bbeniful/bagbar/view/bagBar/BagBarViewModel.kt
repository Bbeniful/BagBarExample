package com.bbeniful.bagbar.view.bagBar

import android.util.Log
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bbeniful.bagbar.R
import com.bbeniful.bagbar.domain.BagBarRepository
import com.bbeniful.bagbar.domain.BagBarStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BagBarViewModel(
    private val bagBarRepository: BagBarRepository
): ViewModel() {

    private var _uiState = MutableStateFlow(BagBarViewState())
    val uiState: StateFlow<BagBarViewState>
        get() = _uiState.asStateFlow()

    init {
        listenBagBarStateChange()
    }

    private fun listenBagBarStateChange() {
        viewModelScope.launch {
            bagBarRepository.bagBarStatus.collect { state ->
                when(state) {
                    BagBarStatus.ITEM_ADDED -> {
                        updateText(R.string.added)
                    }
                    BagBarStatus.CHECK_OUT_NOW -> {
                        updateText(R.string.checkout)
                    }
                }
            }
        }
    }

    private fun updateText(@StringRes textRes: Int) {
        _uiState.update {
            it.copy(
                text = textRes
            )
        }
    }

}