package com.bbeniful.bagbar

import com.bbeniful.bagbar.domain.BagBarRepository
import com.bbeniful.bagbar.domain.BagBarRepositoryImpl

object RepoInject {
    val bagBarRepo = BagBarRepositoryImpl()
}
