package com.muhammad.cengiztoru.dynamicisland.ui.components.notification.media_player

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.muhammad.cengiztoru.dynamicisland.R
import com.muhammad.cengiztoru.dynamicisland.ui.util.Constant


/**
 * Created by Cengiz TORU on 09/09/2022.
 * cengiztoru@gmail.com
 */

@Composable
fun MediaPlayerExpanded(
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        modifier
            .padding(12.dp)
            .width(Constant.getScreenWidthDp() - 20.dp)
    ) {
        val (image, title, description, soundIcon, passedTime, progressBar, remainingTime, previous, pause, next) = createRefs()

        Image(
            painterResource(id = R.drawable.media_player_background), "Media Player",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(6.dp))
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
        )

        Text("Lorem Ipsum", fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(image.top, margin = 4.dp)
                start.linkTo(image.end, margin = 12.dp)
            })

        Text("Some desc", fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier.constrainAs(description) {
                start.linkTo(title.start)
                top.linkTo(title.bottom, margin = 4.dp)
                bottom.linkTo(image.bottom, margin = 8.dp)
            })

        Icon(
            painterResource(id = R.drawable.ic_sound),
            "Music Sound",
            modifier = Modifier
                .size(32.dp)
                .constrainAs(soundIcon) {
                    top.linkTo(image.top, margin = 4.dp)
                    end.linkTo(parent.end)
                },
            tint = Color.Magenta
        )

        Text("0:37", fontSize = 14.sp,
            color = Color.White,
            modifier = Modifier.constrainAs(passedTime) {
                top.linkTo(image.bottom, margin = 16.dp)
                start.linkTo(image.start)
            })


        LinearProgressIndicator(
            modifier = modifier
                .height(12.dp)
                .clip(CircleShape)
                .constrainAs(progressBar) {
                    top.linkTo(passedTime.top)
                    bottom.linkTo(passedTime.bottom)
                    start.linkTo(passedTime.end)
                    end.linkTo(remainingTime.start)
                },
            backgroundColor = Color.LightGray,
            color = Color.Green,
            progress = 0.25F
        )

        Text("-2:56", fontSize = 14.sp,
            color = Color.White,
            modifier = Modifier.constrainAs(remainingTime) {
                top.linkTo(passedTime.top)
                bottom.linkTo(passedTime.bottom)
                end.linkTo(parent.end)
            })

        Icon(
            painterResource(id = R.drawable.ic_pause),
            "Pause",
            modifier = Modifier
                .size(32.dp)
                .constrainAs(pause) {
                    top.linkTo(progressBar.bottom, margin = 24.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            tint = Color.White
        )

        Icon(
            painterResource(id = R.drawable.ic_previous),
            "Previous",
            modifier = Modifier
                .size(32.dp)
                .constrainAs(previous) {
                    top.linkTo(pause.top)
                    bottom.linkTo(pause.bottom)
                    end.linkTo(pause.start, margin = 20.dp)
                },
            tint = Color.White
        )

        Icon(
            painterResource(id = R.drawable.ic_next),
            "Next",
            modifier = Modifier
                .size(32.dp)
                .constrainAs(next) {
                    top.linkTo(pause.top)
                    bottom.linkTo(pause.bottom)
                    start.linkTo(pause.end, margin = 20.dp)
                },
            tint = Color.White
        )


    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFF0000)
@Composable
private fun MediaPlayerExpandedPreview() {
    MediaPlayerExpanded()
}
