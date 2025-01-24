package com.example.newsfinalapp.Fragments.NewsDetailedScreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import com.example.newsfinalapp.Fragments.BaseScreen.BaseEvent
import com.example.newsfinalapp.ext.VideoPlayer

@Composable
fun NewsDetailedScreen(
    onEvent: (NewsDetailedEvent) -> Unit,
    state: NewsDetailedState
) {
    LifecycleEventEffect(Lifecycle.Event.ON_START) {
        onEvent(NewsDetailedEvent.getNews)
    }
    Text(
        text = state.title,
        fontSize = 25.sp
    )
    VideoPlayer()
}