package com.example.newsfinalapp.Fragments.NewestScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsfinalapp.Fragments.BaseScreen.BaseEvent
import com.example.newsfinalapp.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NewestScreen(
    onEvent: (NewestEvent) -> Unit,
    state: NewestState,
) {
    Box {

        Column(
            modifier = Modifier
                .padding(top = 36.dp, bottom = 16.dp)
                .padding(horizontal = 24.dp)
        ) {

            Row(modifier = Modifier.padding(bottom = 32.dp)) {

                Text(
                    modifier = Modifier.align(Alignment.CenterVertically)
                        .padding(top = 4.dp),
                    text = "Newest",
                    fontWeight = FontWeight(700),
                    fontSize = 28.sp
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    painter = painterResource(R.drawable.img_news),
                    contentDescription = "News Icon",
                    modifier = Modifier
                        .size(48.dp)
                        .clip(shape = CircleShape),

                    )

            }

            Row(
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
                    .height(42.dp),
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) {
                Button(
                    onClick = { },
                    modifier = Modifier
                        .wrapContentWidth(),
                    colors = ButtonColors(
                        contentColor = Color(0xFFFFFFFF),
                        containerColor = Color(0xFF08080A),
                        disabledContentColor = Color(0xFFFFFFFF),
                        disabledContainerColor = Color(0xFF08080A),
                    ),


                    ) {

                    Text(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        text = "All",
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp
                    )

                }

                Button(
                    onClick = { },
                    modifier = Modifier
                        .wrapContentWidth()
                        .shadow(16.dp, shape = ButtonDefaults.shape),
                    colors = ButtonColors(
                        contentColor = Color(0xFF9F9FA0),
                        containerColor = Color(0xFFFFFFFF),
                        disabledContentColor = Color(0xFF9F9FA0),
                        disabledContainerColor = Color(0xFFFFFFFF),
                    )
                ) {

                    Text(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        text = "Design",
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp
                    )

                }

                Button(
                    onClick = { },
                    modifier = Modifier
                        .wrapContentWidth()
                        .shadow(16.dp, shape = ButtonDefaults.shape),
                    colors = ButtonColors(
                        contentColor = Color(0xFF9F9FA0),
                        containerColor = Color(0xFFFFFFFF),
                        disabledContentColor = Color(0xFF9F9FA0),
                        disabledContainerColor = Color(0xFFFFFFFF),
                    )
                ) {

                    Text(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        text = "History",
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp
                    )

                }

            }

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(24.dp),
                contentPadding = PaddingValues(8.dp)
            ) {
                repeat(10) {
                    item {

                        Row {

                            Image(
                                modifier = Modifier
                                    .padding(end = 21.dp)
                                    .size(86.dp)
                                    .clip(shape = RoundedCornerShape(12.dp)),
                                painter = painterResource(R.drawable.img_news),
                                contentDescription = "Image"
                            )

                            Column {

                                Text(
                                    modifier = Modifier
                                        .background(
                                            color = Color(0xFFF1F2F3),
                                            shape = RoundedCornerShape(12.dp)
                                        ).padding(2.dp),
                                    text = "Entrepeneur",
                                    fontWeight = FontWeight(500),
                                    fontSize = 11.sp
                                )

                                Text(
                                    modifier = Modifier
                                        .padding(vertical = 8.dp),
                                    text = "How to promote business right away in instagram",
                                    fontWeight = FontWeight(600),
                                    fontSize = 16.sp
                                )

                                Row {
                                    Text(
                                        text = "Bella Gonza",
                                        fontWeight = FontWeight(500),
                                        fontSize = 11.sp
                                    )

                                    Text(
                                        text = ".",
                                        fontWeight = FontWeight(500),
                                        fontSize = 11.sp
                                    )

                                    Text(
                                        text = "12 min",
                                        fontWeight = FontWeight(500),
                                        fontSize = 11.sp
                                    )
                                }

                            }

                        }

                        HorizontalDivider(
                            modifier = Modifier.padding(top = 24.dp)
                        )

                    }
                }
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
                            onClick = { onEvent(NewestEvent.toHome) },
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
                            onClick = { },
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
                            onClick = { onEvent(NewestEvent.toSettings) },
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
