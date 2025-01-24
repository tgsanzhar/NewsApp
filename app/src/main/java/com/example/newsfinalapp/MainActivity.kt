package com.example.newsfinalapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.newsfinalapp.Fragments.BaseScreen.BaseBackgroundService
import com.example.newsfinalapp.Fragments.BaseScreen.MyWorker
import java.util.concurrent.TimeUnit

class MainActivity : FragmentActivity(R.layout.main_activity) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        startService(Intent(this, BaseBackgroundService::class.java))

        val workRequest = OneTimeWorkRequestBuilder<MyWorker>().build()
        val per = PeriodicWorkRequestBuilder<MyWorker>(15, TimeUnit.MINUTES).build()


        WorkManager.getInstance(applicationContext).enqueue(workRequest)
        WorkManager.getInstance(applicationContext).enqueue(per)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        navController.setGraph(R.navigation.navigation)
    }
}
