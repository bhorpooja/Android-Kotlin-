package com.codekul.basicactivity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_next.*

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
        setSupportActionBar(toolbar)


        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        toolbar.setNavigationOnClickListener { onBackPressed() }


        fab.setOnClickListener {
            Snackbar.make(
                    it,
                    "Replace with your own action",
                    Snackbar.LENGTH_LONG
            ).setAction("Action", {
                Toast.makeText(
                        this,
                        "Action Taken",
                        Toast.LENGTH_SHORT
                ).show()}
            ).show()
        }
    }

}
