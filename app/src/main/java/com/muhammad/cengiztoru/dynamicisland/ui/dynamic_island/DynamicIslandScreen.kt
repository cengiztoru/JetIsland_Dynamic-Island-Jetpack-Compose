package com.muhammad.cengiztoru.dynamicisland.ui.dynamic_island

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.muhammad.cengiztoru.dynamicisland.ui.components.Notch


/**
 * Created by Cengiz TORU on 08/09/2022.
 * cengiztoru@gmail.com
 */

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