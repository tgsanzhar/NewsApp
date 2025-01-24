package com.example.newsfinalapp.Fragments.BaseScreen

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        try {
            for (i in 1..5) {
                Thread.sleep(1000)
                println("Task running... Step $i")
            }

            return Result.success()
        } catch (e: Exception) {
            return Result.failure()
        }
    }
}