package com.example.newsfinalapp.Fragments.StartScreen

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.newsfinalapp.LocalColors
import com.example.newsfinalapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    onEvent: (StartEvent) -> Unit
) {

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(
            top = 84.dp,
            bottom = 46.dp
        ).padding(
            horizontal = 16.dp,
        )
    ){
        var isSizeSmall by remember { mutableStateOf(false) }

        Image(
            modifier = modifier
                .animateContentSize()
                .size(if (isSizeSmall) 100.dp else 200.dp, 300.dp)
                .clip(shape = RoundedCornerShape(32.dp))
                ,
            painter = painterResource(R.drawable.img_news),
            contentDescription = "Main Image",
            contentScale = ContentScale.Crop,


        )

        Text (
            modifier = Modifier.padding(top = 32.dp)
                .fillMaxWidth(),
            text = "Open Your Knowledge Power",
            fontWeight = FontWeight(700),
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            color = LocalColors.current.title,

        )

        Text(
            modifier = Modifier.padding(top = 4.dp)
                .fillMaxWidth(),
            text = "Motivation can take you far, but it can take you even futher if you first find your vision",
            fontWeight = FontWeight(500),
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = LocalColors.current.subtitle,
        )

        Spacer(Modifier.weight(1f))



        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .animateContentSize()
                .width(if (isSizeSmall) 50.dp else 100.dp),
            onClick = {
                onEvent(StartEvent.onClick)
//                    isSizeSmall = !isSizeSmall
              },
            colors = ButtonColors(
                contentColor = Color(0xFFFFFFFF),
                containerColor = Color(0xFF08080A),
                disabledContentColor = Color(0xFFFFFFFF),
                disabledContainerColor = Color(0xFF08080A),
            ),
            shape = RoundedCornerShape(12.dp)
        )
        {
            Text(
                text = "Get Started",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight(700),
                fontSize = 16.sp,
            )
        }


    }
}

