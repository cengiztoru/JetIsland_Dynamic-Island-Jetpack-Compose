package com.muhammad.cengiztoru.dynamicisland.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.muhammad.cengiztoru.dynamicisland.ui.util.Constant


/**
 * Created by Cengiz TORU on 09/09/2022.
 * cengiztoru@gmail.com
 */
@Composable
fun Notch() {
    val notchWidth = Constant.getMinIslandWidth()
    val notchHeight = Constant.getMinIslandHeight()

    Card(
        modifier = Modifier
            .width(notchWidth)
            .height(notchHeight),
        backgroundColor = Constant.dynamicIslandBackgroundColor,
        shape = Constant.dynamicIslandBackgroundShape,
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