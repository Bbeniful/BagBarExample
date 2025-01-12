package com.bbeniful.bagbar.view.bagBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bbeniful.bagbar.R
import com.bbeniful.bagbar.RepoInject
import com.bbeniful.bagbar.domain.BagBarRepositoryImpl

@Composable
fun BagBarView() {
    @Suppress("UNCHECKED_CAST")
    val viewModel = viewModel<BagBarViewModel>(
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return BagBarViewModel(RepoInject.bagBarRepo) as T
            }
        }
    )

    val uiState by viewModel.uiState.collectAsState()
    BagBarContent(mainText = uiState.text)
}

@Composable
fun BagBarContent(mainText: Int) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color.Yellow)
                .padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = stringResource(mainText))
            Text(text = "hulala")
        }
    }

}


@Preview
@Composable
fun BagBarViewPreview() {
    BagBarContent(mainText = R.string.checkout)

}