package com.muhammad.cengiztoru.dynamicisland.ui.dynamic_island

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.muhammad.cengiztoru.dynamicisland.model.Notification
import com.muhammad.cengiztoru.dynamicisland.ui.components.Notch
import com.muhammad.cengiztoru.dynamicisland.ui.util.Constant
import kotlinx.coroutines.delay
import kotlin.random.Random

/**
 * Created by Cengiz TORU on 08/09/2022.
 * cengiztoru@gmail.com
 */

//todo
private val notificationList = listOf(
    Notification.PhoneCall(
        {
            Text(
                color = MaterialTheme.colors.onSurface,
                text = "Phone Call Expanded Phone Call Expanded Phone Call Expanded Phone Call Expanded Phone Call Expanded Phone Call Expanded "
            )
        },
        { Text(color = MaterialTheme.colors.onSurface, text = "Phone Call Collapsed") }),
    Notification.MediaPlayer(
        {
            Text(
                color = MaterialTheme.colors.onSurface,
                text = "MediaPlayer Expanded MediaPlayer Expanded MediaPlayer Expanded MediaPlayer Expanded MediaPlayer Expanded MediaPlayer Expanded MediaPlayer Expanded MediaPlayer Expanded MediaPlayer Expanded MediaPlayer Expanded "
            )
        },
        { Text(color = MaterialTheme.colors.onSurface, text = "MediaPlayer Collapsed") }),
)

fun getRandomNotification(): Notification {
    val randomValue = Random.nextInt(0, notificationList.size)
    return notificationList[randomValue]
}

@Composable
fun DynamicIslandScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        DynamicIsland {
            Text(text = "Text")
        }
    }
}

@Composable
fun DynamicIsland(
    modifier: Modifier = Modifier,
    isExpanded: Boolean = false,
    isSecondAreaExist: Boolean = false,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .wrapContentSize()
    ) {
        Notch()
    }

}


@Preview
@Composable
fun testPreview() {

}