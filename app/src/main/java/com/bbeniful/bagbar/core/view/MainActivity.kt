package com.bbeniful.bagbar.core.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bbeniful.bagbar.RepoInject
import com.bbeniful.bagbar.ui.theme.BagBarTheme
import com.bbeniful.bagbar.view.bagBar.BagBarView
import com.bbeniful.bagbar.view.navigation.AppNavigation
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BagBarTheme {
                val repo = remember { RepoInject.bagBarRepo }
                LaunchedEffect(Unit) {
                    delay(2000)
                    repo.add()
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainView(paddingValues = innerPadding)
                }
            }
        }
    }
}

@Composable
fun MainView(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .padding(paddingValues)
            .consumeWindowInsets(paddingValues)
    ) {
        AppNavigation()
        BagBarView()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BagBarTheme {
        MainView(PaddingValues())
    }
}