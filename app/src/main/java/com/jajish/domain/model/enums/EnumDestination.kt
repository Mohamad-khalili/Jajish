package com.jajish.domain.model.enums

import android.graphics.drawable.Icon
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import com.jajish.R

enum class EnumDestination (
    val route: String,
    val label: String,
    val icon: Int,
    val contentDescription: String
){
    MapScreen("mapScreen","Map",  R.drawable.baseline_map_24,"Map"),
    SecondScreen("mapScreen","Map",  R.drawable.outline_wc_24,"Map") //Temporary, It will change..
}
