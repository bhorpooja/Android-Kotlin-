package com.codekul.verification

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.verticalLayout

class VerifyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify)

        verticalLayout {

            background=getDrawable(R.drawable.ic_logo)
        }
    }
}
