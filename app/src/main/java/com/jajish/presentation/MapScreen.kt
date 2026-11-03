package com.jajish.presentation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapEffect
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberUpdatedMarkerState

@Composable
fun MapScreen(modifier: Modifier = Modifier) {
    val loc = LatLng(1.35, 103.87)
    val markerState = rememberUpdatedMarkerState(position = loc)
    val cameraPositionState = rememberCameraPositionState{
        position = CameraPosition.fromLatLngZoom(loc,10f)
    }

    val uiSetting by remember { mutableStateOf(
        MapUiSettings(
            zoomControlsEnabled = true,
            compassEnabled = true
        )
    )
     }


        GoogleMap(
            modifier = modifier.size(500.dp,600.dp),
            cameraPositionState = cameraPositionState,
            uiSettings =  uiSetting) {

            Marker(
                state = markerState, title = "a"
            )


        }






}

