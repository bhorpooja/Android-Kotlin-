package com.codekul.intentandintentfilter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_b.*

class BActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        edtTxt.setText(""" Data - ${intent.data} Action - ${intent.action} """)
    }

}
