package com.bbeniful.bagbar.domain

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

interface BagBarRepository {

    val bagBarStatus: SharedFlow<BagBarStatus>

    fun add()

    fun fetch()
}

class BagBarRepositoryImpl: BagBarRepository {

    private var _bagBarStatus = MutableSharedFlow<BagBarStatus>(replay = 1).apply {
        tryEmit(BagBarStatus.CHECK_OUT_NOW)
    }

    override val bagBarStatus: SharedFlow<BagBarStatus>
        get() = _bagBarStatus.asSharedFlow()

    override fun add() {
        CoroutineScope(Dispatchers.Main).launch {
            _bagBarStatus.emit(BagBarStatus.ITEM_ADDED)
            delay(1000)
            _bagBarStatus.emit(BagBarStatus.CHECK_OUT_NOW)
        }
    }

    override fun fetch() {
        CoroutineScope(Dispatchers.Main).launch {
            _bagBarStatus.emit(BagBarStatus.CHECK_OUT_NOW)
        }
    }
}