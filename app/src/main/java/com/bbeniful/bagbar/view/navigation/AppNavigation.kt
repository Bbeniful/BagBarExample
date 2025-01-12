package com.bbeniful.bagbar.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bbeniful.bagbar.view.simpleOne.SimpleViewOne
import com.bbeniful.bagbar.view.simpleTwo.SimpleViewTwo
import kotlinx.serialization.Serializable

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = SimpleOne) {
        composable<SimpleOne> {
            SimpleViewOne()
        }
        composable<SimpleTwo> {
            SimpleViewTwo()
        }
    }
}


@Serializable
data object SimpleOne

@Serializable
data object SimpleTwo