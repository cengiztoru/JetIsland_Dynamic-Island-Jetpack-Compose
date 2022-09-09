package com.muhammad.cengiztoru.dynamicisland.ui.components.notification.phone_call

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
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
fun PhoneCallExpanded(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.width(Constant.getScreenWidthDp() - 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val imageSize = 64.dp
        val generalImageModifier = Modifier
            .clip(CircleShape)
            .size(imageSize)

        Image(
            modifier = generalImageModifier,
            painter = painterResource(id = R.drawable.cengiztoru), contentDescription = ""
        )

        Text(text = "Cengiz TORU", color = MaterialTheme.colors.onSurface, fontSize = 16.sp)


        Icon(
            Icons.Default.Call, "Reject Call",
            modifier = generalImageModifier
                .background(Color.Red)
                .padding(12.dp)
                .rotate(130f),
            tint = Color.White
        )

        Icon(
            Icons.Default.Call, "Answer Call",
            modifier = generalImageModifier
                .background(Color.Green)
                .padding(12.dp),
            tint = Color.White
        )


    }
}

@Preview
@Composable
private fun PhoneCallExpandedPreview() {
    PhoneCallExpanded()
}
