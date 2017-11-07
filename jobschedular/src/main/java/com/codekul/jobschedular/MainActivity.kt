package com.codekul.jobschedular

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        schedule()
    }

    fun schedule() {
        val cpmNm = ComponentName(this, MyJobService::class.java.name)
        val jbSchd = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val jbBldr = JobInfo.Builder(123, cpmNm).setMinimumLatency(5000)
            jbSchd.schedule(jbBldr.build())
        }
        else {
            val jbBldr = JobInfo.Builder(123, cpmNm).setPeriodic(5000)
            jbSchd.schedule(jbBldr.build())
        }
    }
}
