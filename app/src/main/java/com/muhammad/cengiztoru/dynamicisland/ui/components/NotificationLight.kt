package com.muhammad.cengiztoru.dynamicisland.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


/**
 * Created by Cengiz TORU on 09/09/2022.
 * cengiztoru@gmail.com
 */

@Composable
fun NotificationLight() {
    val infiniteTransition = rememberInfiniteTransition()
    val infinitelyAnimatedFloat = infiniteTransition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.8f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000),
            repeatMode = RepeatMode.Reverse
        )
    )

    Canvas(
        modifier = Modifier
            .height(6.dp)
            .width(6.dp)
    ) {
        drawCircle(
            color = Color.Green,
            radius = 10f,
            alpha = infinitelyAnimatedFloat.value
        )
    }
}

@Preview
@Composable
fun NotificationLightPreview() {
    NotificationLight()
}