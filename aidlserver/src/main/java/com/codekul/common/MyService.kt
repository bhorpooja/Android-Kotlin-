package com.codekul.common

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyService : Service() {

    private val clc = MyCalc()

    override fun onBind(intent: Intent): IBinder? {
        return clc
    }

     class MyCalc : ICommon.Stub() {
        override fun calculate(num1: Int, num2: Int, op: Char): Int {
            return when (op) {
                '+' -> num1 + num2
                '-' -> num1 - num2
                '*' -> num1 * num2
                '/' -> num1 / num2
                else -> -9
            }
        }
    }
}
