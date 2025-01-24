package com.example.newsfinalapp.Fragments.BaseScreen

import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import coil3.compose.rememberAsyncImagePainter
import com.example.newsfinalapp.LocalColors
import com.example.newsfinalapp.R
import com.example.newsfinalapp.ext.VideoPlayer


@Composable
fun BaseScreen(
    onEvent: (BaseEvent) -> Unit,
    state: BaseState,
    navigate: (Int, Bundle) -> Unit,
) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
//        var timer = remember { mutableStateOf(-1) }
        LifecycleEventEffect(Lifecycle.Event.ON_START) {
            onEvent(BaseEvent.OnGetNews)
        }
//        LaunchedEffect(state.rowData.news) {
//            if (state.rowData.news.isNotEmpty())
//            {
//                launch {
//                    timer.value = 0
//                    while (timer.value != -1)
//                    {
//                        timer.value += 1
//                        Log.d("TIMER", timer.value.toString())
//                        delay(1000)
//                    }
//                }
//            }
//        }
//
//        DisposableEffect(Unit) {
//            onDispose {
//                timer.value = -1
//            }
//        }
//
//
//        AnimatedVisibility(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(32.dp),
//            visible = (timer.value != -1),
//            enter = slideInVertically(),
//            exit = slideOutVertically(),
//        ) {
//            Box(modifier = Modifier
//                .fillMaxWidth()
//                .height(32.dp)
//                .background(Color(0xFF000aaa))
//            ) {
//                Text(
//                    modifier = Modifier.align(Alignment.Center),
//                    color = Color(0xFF000000),
//                    text = timer.value.toString(),
//                )
//            }
//
//            SideEffect {
//                Log.d("TIMER", "Show Timer")
//            }
//        }



        Column(
            modifier = Modifier
                .padding(top = 36.dp, bottom = 16.dp)
                .padding(horizontal = 24.dp)
        ) {
            LazyColumn {
                item {
                    Top()

                }
                item {
                    Search(onEvent, state)

                }
                item {
                    RowList(state, navigate)

                }
                item {
                    ColumnList(state)
                }
                item {
                    VideoPlayer()
                }
                for (item in state.columnData.news) {
                    item {

                        Row (
                            modifier = Modifier
                                .padding(bottom = 16.dp)

                        ) {

                            Image(
                                modifier = Modifier
                                    .padding(end = 21.dp)
                                    .size(86.dp)
                                    .clip(shape = RoundedCornerShape(12.dp)),
                                painter = rememberAsyncImagePainter(item.image),
                                contentDescription = "Image",
                                contentScale = ContentScale.Crop

                            )

                            Column {

                                Text(
                                    modifier = Modifier
                                        .background(
                                            color = LocalColors.current.backgroundOfRow,
                                            shape = RoundedCornerShape(12.dp)
                                        )
                                        .padding(2.dp),
                                    text = item.category,
                                    fontWeight = FontWeight(500),
                                    fontSize = 11.sp
                                )

                                Text(
                                    modifier = Modifier
                                        .padding(vertical = 8.dp),
                                    text = item.title,
                                    fontWeight = FontWeight(600),
                                    fontSize = 16.sp,
                                    maxLines = 2
                                )

                                Row {
                                    Text(
                                        text = item.author,
                                        fontWeight = FontWeight(500),
                                        fontSize = 11.sp
                                    )

                                    Text(
                                        text = ".",
                                        fontWeight = FontWeight(500),
                                        fontSize = 11.sp
                                    )

                                    Text(
                                        text = item.readTime,
                                        fontWeight = FontWeight(500),
                                        fontSize = 11.sp
                                    )
                                }

                            }

                        }

                    }
                }
                item {
                    Spacer(
                        modifier = Modifier
                            .padding(bottom = 78.dp)
                    )
                }



            }

        }



        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(78.dp)
                .align(Alignment.BottomCenter)
                .background(LocalColors.current.bottomNavBackground)
        ) {
            BottomNav(onEvent, state)
        }
    }
}


@Composable
@OptIn(ExperimentalFoundationApi::class)
fun BottomNav(onEvent: (BaseEvent) -> Unit, state: BaseState) {


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
                    onClick = { onEvent(BaseEvent.toNewest) },
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
                    onClick = { onEvent(BaseEvent.toSettings) },
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


@Composable
fun ColumnList(state: BaseState) {
    Row(
        modifier = Modifier.padding(vertical = 24.dp)

    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterVertically),
            text = "Reading List",
            fontWeight = FontWeight(600),
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            modifier = Modifier.align(Alignment.CenterVertically),
            text = "See All",
            fontWeight = FontWeight(500),
            fontSize = 12.sp
        )
    }


//    LazyColumn(
//        verticalArrangement = Arrangement.spacedBy(8.dp),
//    ) {
//
//
//    }
}

@Composable
fun RowList(state: BaseState, navigate: (Int, Bundle) -> Unit) {
    Row(
        modifier = Modifier.padding(vertical = 24.dp)
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterVertically),
            text = "Popular List",
            fontWeight = FontWeight(600),
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            modifier = Modifier.align(Alignment.CenterVertically),
            text = "See All",
            fontWeight = FontWeight(500),
            fontSize = 12.sp
        )
    }


    LazyRow(
        modifier = Modifier
            .height(256.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
    ) {

        for (item in state.rowData.news) {
            item {

                Column(
                    modifier = Modifier
                        .height(256.dp)
                        .width(130.dp)
                        .clickable {
                            val bundle = Bundle()
                            bundle.putInt("id", item.id)
                            bundle.putString("type", "column")
                            navigate(R.id.action_baseFragment_to_newsDetailedFragment, bundle)
                        },

                    ) {
                    Image(
                        painter = rememberAsyncImagePainter(item.imageSrc),
                        contentDescription = "Images",
                        modifier = Modifier
                            .size(130.dp, 164.dp)
                            .clip(shape = RoundedCornerShape(12.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        modifier = Modifier
                            .padding(top = 8.dp),
                        text = item.subTitle,
                        fontWeight = FontWeight(500),
                        fontSize = 14.sp,
                        maxLines = 1
                    )

                    Text(
                        text = item.title,
                        fontWeight = FontWeight(600),
                        fontSize = 20.sp
                    )

                }

            }
        }
    }
}

@Composable
fun Search(
    onEvent: (BaseEvent) -> Unit,
    state: BaseState
) {
    TextField(
        placeholder = {
            Text(
                color = Color(0xFF828282),
                text = "Search",
                fontSize = 14.sp,
                fontWeight = FontWeight(500)
            )
        },
        textStyle = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight(500)
        ),
        singleLine = true,

        prefix = {
            Icon(
                painter = painterResource(R.drawable.icon___search),
                contentDescription = "Icon",
                modifier = Modifier
                    .size(24.dp),
            )
        },
        suffix = {
            if (state.isFocused && state.searchText != "") {
                Icon(
                    painter = painterResource(R.drawable.ic_icon_back),
                    contentDescription = "Icon",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            onEvent(BaseEvent.onValueChanged(""))
                        },
                )
            }
        },
        modifier = Modifier
            .padding(top = 24.dp)
            .fillMaxWidth()
            .height(64.dp)
            .shadow(20.dp)
            .onFocusChanged { it -> state.isFocused = it.hasFocus },
        shape = RoundedCornerShape(12.dp),
        value = state.searchText,
        onValueChange = { it ->
            onEvent(BaseEvent.onValueChanged(it))
        },

        )
}

@Composable
fun Top() {

    Row {

        Column {

            Text(
                text = "NewsApp",
                fontWeight = FontWeight(700),
                fontSize = 28.sp
            )

            Row(
                modifier = Modifier.padding(top = 4.dp)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    text = "Today’s Reading",
                    fontWeight = FontWeight(500),
                    fontSize = 14.sp,
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(horizontal = 8.dp),
                    text = "25 min left",
                    fontWeight = FontWeight(500),
                    fontSize = 14.sp
                )
            }

        }

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            painter = painterResource(R.drawable.img_news),
            contentDescription = "News Icon",
            modifier = Modifier
                .size(48.dp)
                .clip(shape = CircleShape),

            )

    }
}
