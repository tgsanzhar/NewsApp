package com.example.newsfinalapp.ext

import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun VideoPlayer() {
    AndroidView(
        factory = { ctx ->
            VideoView(ctx).apply {
                val videoPath = "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"
                setVideoPath(videoPath)

                val mediaController = MediaController(ctx)
                mediaController.setAnchorView(this)
                setMediaController(mediaController)

                start()
            }
        },
        update = { videoView ->
        }
    )
}