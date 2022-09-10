package com.muhammad.cengiztoru.dynamicisland.ui.components.notification.phone_call

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhammad.cengiztoru.dynamicisland.R
import com.muhammad.cengiztoru.dynamicisland.ui.util.Constant


/**
 * Created by Cengiz TORU on 09/09/2022.
 * cengiztoru@gmail.com
 */

@Composable
fun PhoneCallCollapsed(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.width(Constant.getScreenWidthDp() / 1.75f),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val imageSize = 24.dp
        val generalImageModifier = Modifier
            .clip(CircleShape)
            .size(imageSize)

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                Icons.Default.Call, "Call Accepted",
                modifier = generalImageModifier,
                tint = Color.Green
            )

            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = "3:33",
                color = Color.Green,
                fontSize = 16.sp
            )
        }

        Icon(
            painterResource(id = R.drawable.ic_sound),
            "Call Sound",
            modifier = generalImageModifier,
            tint = Color.Green
        )
    }
}

@Preview
@Composable
private fun PhoneCallCollapsedPreview() {

}
