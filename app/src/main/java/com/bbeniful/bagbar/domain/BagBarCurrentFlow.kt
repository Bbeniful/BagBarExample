package com.bbeniful.bagbar.domain

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update


object BagBarCurrentFlow {

     var _status = MutableStateFlow(BagBarStatus.CHECK_OUT_NOW)
        private set


    fun setStatus(status: BagBarStatus = BagBarStatus.CHECK_OUT_NOW) {
        _status.update { status }
    }

}