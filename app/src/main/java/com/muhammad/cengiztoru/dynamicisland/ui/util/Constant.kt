package com.muhammad.cengiztoru.dynamicisland.ui.util

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


/**
 * Created by Cengiz TORU on 09/09/2022.
 * cengiztoru@gmail.com
 */
object Constant {

    val dynamicIslandBackgroundShape = RoundedCornerShape(64.dp)
    val dynamicIslandBackgroundColor = Color.Black

    @Composable
    fun getMinIslandWidth(): Dp {
        val configuration = LocalConfiguration.current
        return (configuration.screenWidthDp / 2.5f).dp
    }

    @Composable
    fun getMinIslandHeight(): Dp {
        val configuration = LocalConfiguration.current
        return (configuration.screenHeightDp / 18f).dp
    }

    @Composable
    fun getScreenHeightDp(): Dp {
        val configuration = LocalConfiguration.current
        return configuration.screenHeightDp.dp
    }

    @Composable
    fun getScreenWidthDp(): Dp {
        val configuration = LocalConfiguration.current
        return configuration.screenWidthDp.dp
    }

}