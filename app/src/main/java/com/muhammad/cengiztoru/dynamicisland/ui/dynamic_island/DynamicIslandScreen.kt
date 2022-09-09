package com.muhammad.cengiztoru.dynamicisland.ui.dynamic_island

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhammad.cengiztoru.dynamicisland.model.Notification
import com.muhammad.cengiztoru.dynamicisland.ui.components.Notch
import com.muhammad.cengiztoru.dynamicisland.ui.util.Constant
import com.muhammad.cengiztoru.dynamicisland.ui.util.extensions.noRippleClickable
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
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var notificationId by remember { mutableStateOf(1) }
        var randomNotification by remember { mutableStateOf<Notification?>(null) }

        DynamicIsland(
            notificationId = notificationId,
            notification = randomNotification,
        )

        Button(
            shape = RoundedCornerShape(32.dp),
            modifier = Modifier.padding(30.dp, 30.dp, 30.dp, 100.dp),
            onClick = {
                notificationId++
                randomNotification = getRandomNotification()
            }
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "Send Random Notification", fontSize = 20.sp
            )
        }
    }
}

@Composable
fun DynamicIsland(
    modifier: Modifier = Modifier,
    notificationId: Int,
    notification: Notification? = null,
) {
    var showExpandedContent by remember(notificationId) { mutableStateOf(true) }

    Box(
        modifier = modifier
            .padding(8.dp)
            .clip(Constant.dynamicIslandBackgroundShape)
            .background(Constant.dynamicIslandBackgroundColor)
            .defaultMinSize(Constant.getMinIslandWidth(), Constant.getMinIslandHeight())
            .animateContentSize()
            .wrapContentSize()
    ) {
        if (notification == null) {
            Notch()
        } else {
            Box(
                modifier = Modifier
                    .noRippleClickable { showExpandedContent = true }
                    .padding(16.dp)
            ) {
                if (showExpandedContent) {
                    notification.expandedContent()

                    LaunchedEffect(true) {
                        delay(1000)
                        showExpandedContent = false
                    }

                } else {
                    notification.collapsedContent()
                }
            }
        }
    }

}


@Preview
@Composable
fun testPreview() {

}