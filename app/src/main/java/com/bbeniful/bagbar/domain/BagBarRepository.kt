package com.bbeniful.bagbar.domain

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

interface BagBarRepository {

    val bagBarStatus: StateFlow<BagBarStatus>
    fun add()
    fun fetch()
}

class BagBarRepositoryImpl: BagBarRepository {

    override val bagBarStatus: StateFlow<BagBarStatus>
        get() = BagBarCurrentFlow._status.asStateFlow()

    override fun add() {
        CoroutineScope(Dispatchers.Main).launch {
            BagBarCurrentFlow.setStatus(BagBarStatus.ITEM_ADDED)
            delay(1000)
            BagBarCurrentFlow.setStatus(BagBarStatus.CHECK_OUT_NOW)
        }
    }

    override fun fetch() {
        CoroutineScope(Dispatchers.Main).launch {
            BagBarCurrentFlow.setStatus(BagBarStatus.CHECK_OUT_NOW)
        }
    }
}