package com.muhammad.cengiztoru.dynamicisland.model

import androidx.compose.runtime.Composable


/**
 * Created by Cengiz TORU on 09/09/2022.
 * cengiztoru@gmail.com
 */

sealed class Notification {
    abstract val expandedContent: @Composable () -> Unit
    abstract val collapsedContent: @Composable () -> Unit

    data class PhoneCall(
        override val expandedContent: @Composable () -> Unit,
        override val collapsedContent: @Composable () -> Unit
    ) : Notification()

    data class MediaPlayer(
        override val expandedContent: @Composable () -> Unit,
        override val collapsedContent: @Composable () -> Unit
    ) : Notification()
}
