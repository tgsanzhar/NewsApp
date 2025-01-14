package com.example.newsfinalapp.Fragments.Settings

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsfinalapp.Fragments.NewestScreen.NewestEvent
import com.example.newsfinalapp.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SettingsScreen(
    onEvent: (SettingsEvent) -> Unit,
    ) {
    Box {

        Column(
            modifier = Modifier.padding(
                horizontal = 24.dp,
            ).padding(
                top = 32.dp,
                bottom = 64.dp
            )
        ) {
            Box(
            ) {

                Icon(
                    painter = painterResource(R.drawable.ic_icon_back),
                    contentDescription = "Icon Back"
                )

                Text(
                    modifier = Modifier.fillMaxWidth()
                        .padding(top = 2.dp),
                    text = "Settings",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight(700),
                    fontSize = 20.sp
                )

            }

            Text(
                modifier = Modifier.padding(top = 32.dp),
                text = "Personal Info",
                textAlign = TextAlign.Right,
                fontWeight = FontWeight(600),
                fontSize = 14.sp
            )

            Row(
                modifier = Modifier.padding(top = 32.dp),
            ) {
                Icon(
                    painterResource(R.drawable.ic_icon_profile),
                    contentDescription = "Icon"
                )
                Text(
                    modifier = Modifier.padding(
                        top = 2.dp,
                        start = 24.dp
                    ),
                    text = "Your Profile",
                    textAlign = TextAlign.Right,
                    fontWeight = FontWeight(500),
                    fontSize = 16.sp,
                )
            }

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 24.dp)
            )

            Row {
                Icon(
                    painterResource(R.drawable.ic_icon_profile),
                    contentDescription = "Icon"
                )
                Text(
                    modifier = Modifier.padding(
                        top = 2.dp,
                        start = 24.dp
                    ),
                    text = "Change Password",
                    textAlign = TextAlign.Right,
                    fontWeight = FontWeight(500),
                    fontSize = 16.sp,
                )

            }



            HorizontalDivider(
                modifier = Modifier.padding(top = 24.dp)
            )



            Text(
                modifier = Modifier.padding(top = 32.dp),
                text = "Personal Info",
                textAlign = TextAlign.Right,
                fontWeight = FontWeight(600),
                fontSize = 14.sp
            )

            Row(
                modifier = Modifier.padding(top = 32.dp),
            ) {
                Icon(
                    painterResource(R.drawable.ic_icon_edit),
                    contentDescription = "Icon"
                )
                Text(
                    modifier = Modifier.padding(
                        top = 2.dp,
                        start = 24.dp
                    ),
                    text = "Adjust Font Size",
                    textAlign = TextAlign.Right,
                    fontWeight = FontWeight(500),
                    fontSize = 16.sp,
                )
            }

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 24.dp)
            )

            Row {
                Icon(
                    painterResource(R.drawable.ic_icon_game),
                    contentDescription = "Icon"
                )
                Text(
                    modifier = Modifier.padding(
                        top = 2.dp,
                        start = 24.dp
                    ),
                    text = "Daily Challanges",
                    textAlign = TextAlign.Right,
                    fontWeight = FontWeight(500),
                    fontSize = 16.sp,
                )

            }

            Spacer(modifier = Modifier.weight(1f))

            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    text = "Logout",
                    fontWeight = FontWeight(500),
                    fontSize = 16.sp,
                    color = Color(0xFFEB5757)
                )
            }


        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(78.dp)
                .align(Alignment.BottomCenter)
                .background(Color(0xFFFFFFFF))
            ,
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(horizontal = 26.dp)
                    .padding(top = 14.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {

                // ROW
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(76.dp)
                        .combinedClickable(
                            onClick = { onEvent(SettingsEvent.toHome) },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        )
                ) {
                    Icon(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        painter = painterResource(R.drawable.ic_icon_home),
                        contentDescription = "Home Icon"
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(76.dp)
                        .combinedClickable(
                            onClick = { },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        )
                ) {
                    Icon(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        painter = painterResource(R.drawable.ic_icon_heart),
                        contentDescription = "Heart Icon"
                    )

                }

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(76.dp)
                        .combinedClickable(
                            onClick = { onEvent(SettingsEvent.toNewest) },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        )
                ) {
                    Icon(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        painter = painterResource(R.drawable.ic_icon_document),
                        contentDescription = "Document Icon"
                    )

                }

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(76.dp)
                        .combinedClickable(
                            onClick = {  },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        )
                ) {
                    Icon(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        painter = painterResource(R.drawable.ic_icon_settings),
                        contentDescription = "Settings Icon"
                    )

                }
            }
        }
    }
}