package com.codekul.jobschedular

import android.app.Service
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyJobService : JobService() {
    override fun onStopJob(p0: JobParameters?): Boolean {
            Log.i("@codekul","onStopJob")
            return false
    }

    override fun onStartJob(p0: JobParameters?): Boolean {

            Log.i("@codekul","onStartJob")
            return false
    }


}
