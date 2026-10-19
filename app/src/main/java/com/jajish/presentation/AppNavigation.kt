package com.jajish.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jajish.domain.model.enums.EnumDestination


@Composable
fun AppNavHost(navController: NavHostController,startDestination: EnumDestination,modifier: Modifier = Modifier) {
    NavHost(
        navController,startDestination.route,modifier = modifier
    ) {
        EnumDestination.entries.forEach { destination ->
            composable(destination.route){
                when(destination){
                    EnumDestination.MapScreen-> MapScreen(modifier = Modifier)
                    EnumDestination.SecondScreen-> MapScreen(modifier = modifier)
                }
            }
        }
    }

}
@Composable
fun MyNavigationBar(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val startDestination = EnumDestination.MapScreen
    var selectedDestination by rememberSaveable { mutableIntStateOf(startDestination.ordinal) }

    Scaffold(modifier = modifier, bottomBar = {
        NavigationBar(windowInsets = NavigationBarDefaults.windowInsets) {
            EnumDestination.entries.forEachIndexed { index, destination ->
                NavigationBarItem(
                    selected = selectedDestination == index,
                    onClick = {
                        navController.navigate(route = destination.route)
                        selectedDestination = index
                    },
                    icon = { Icon(
                        painter = painterResource( destination.icon),
                        contentDescription = destination.contentDescription
                    )
                    },
                    label = { Text(destination.label) }
                )
            }
        }
    }
    ) { contentPadding ->

        AppNavHost(navController,startDestination,modifier = modifier.padding(top = contentPadding.calculateTopPadding()))

    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun NavigationBarPreview() {
    MyNavigationBar(modifier = Modifier)
}