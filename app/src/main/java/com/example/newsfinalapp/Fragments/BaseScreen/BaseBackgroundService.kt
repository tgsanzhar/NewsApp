package com.example.newsfinalapp.Fragments.BaseScreen

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import org.koin.android.scope.ScopeService
import org.koin.android.scope.newScope
import org.koin.android.scope.serviceScope


class BaseBackgroundService : Service() {

    private val serviceScope = CoroutineScope(Dispatchers.IO)

    override fun onCreate() {
        super.onCreate()
        // Initialize Service
    }
    override fun onDestroy() {
        super.onDestroy()
        // Cleanup Service
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        serviceScope.launch {
            var timer = 0
            while (true)
            {

                Log.d("TIMER", timer.toString())
                delay(1000)
                timer += 1
            }
        }
        // Logic of service
        return START_STICKY
    }
    override fun onBind(p0: Intent?): IBinder? {
        // Ignore for Not Bound Service
        return null
    }
}