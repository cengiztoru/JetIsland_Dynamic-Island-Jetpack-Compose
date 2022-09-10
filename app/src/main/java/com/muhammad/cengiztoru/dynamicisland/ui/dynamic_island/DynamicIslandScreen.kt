package com.muhammad.cengiztoru.dynamicisland.ui.dynamic_island

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhammad.cengiztoru.dynamicisland.model.Notification
import com.muhammad.cengiztoru.dynamicisland.ui.components.Notch
import com.muhammad.cengiztoru.dynamicisland.ui.components.notification.media_player.MediaPlayerCollapsed
import com.muhammad.cengiztoru.dynamicisland.ui.components.notification.media_player.MediaPlayerExpanded
import com.muhammad.cengiztoru.dynamicisland.ui.components.notification.phone_call.PhoneCallCollapsed
import com.muhammad.cengiztoru.dynamicisland.ui.components.notification.phone_call.PhoneCallExpanded
import com.muhammad.cengiztoru.dynamicisland.ui.util.Constant
import com.muhammad.cengiztoru.dynamicisland.ui.util.extensions.noRippleClickable
import kotlinx.coroutines.delay
import kotlin.random.Random

/**
 * Created by Cengiz TORU on 08/09/2022.
 * cengiztoru@gmail.com
 */

private val notificationList = listOf(
    Notification.PhoneCall({ PhoneCallExpanded() }, { PhoneCallCollapsed() }),
    Notification.MediaPlayer({ MediaPlayerExpanded() }, { MediaPlayerCollapsed() })
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

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(30.dp, 30.dp, 30.dp, 100.dp),
        ) {

            Button(
                onClick = {
                    notificationId++
                    randomNotification = null
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                shape = RoundedCornerShape(32.dp)
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Remove notifications", fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.padding(30.dp))


            Button(
                shape = RoundedCornerShape(32.dp),
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
                        delay(3000)
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
fun DynamicIslandScreenPreview() {
    DynamicIslandScreen()
}