package com.muhammad.cengiztoru.dynamicisland.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


/**
 * Created by Cengiz TORU on 09/09/2022.
 * cengiztoru@gmail.com
 */
@Composable
fun Notch() {
    val configuration = LocalConfiguration.current
    val islandWidth = (configuration.screenWidthDp / 2.5f).dp
    val islandHeight = (configuration.screenHeightDp / 18f).dp

    Card(
        modifier = Modifier
            .width(islandWidth)
            .height(islandHeight),
        backgroundColor = Color.Black,
        shape = RoundedCornerShape(32.dp),
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            FakeCamera()
            NotificationLight()
            FakeCamera()
        }
    }
}

@Preview
@Composable
fun NotchPreview() {
    Notch()
}