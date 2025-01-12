package com.bbeniful.bagbar.view.bagBar

import androidx.annotation.StringRes
import com.bbeniful.bagbar.R

data class BagBarViewState(
    @StringRes var text: Int = R.string.checkout
)