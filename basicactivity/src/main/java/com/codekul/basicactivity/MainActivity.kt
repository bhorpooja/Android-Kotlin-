package com.codekul.basicactivity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.text.InputFilter
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        registerForContextMenu(findViewById(R.id.txtVw))

        fab.setOnClickListener {
                    startActivity(
                            Intent(this,
                                    NextActivity::class.java)
                    )
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings ->{
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show()
               return true
        }
            R.id.action_cut ->{
                Toast.makeText(this,"Cut",Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.action_cut1 ->{
                Toast.makeText(this,"Cut1",Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.action_cut2 ->{
                Toast.makeText(this,"Cut2",Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.action_cut3 ->{
                Toast.makeText(this,"Cut3",Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.action_cut4 ->{
                Toast.makeText(this,"Cut4",Toast.LENGTH_SHORT).show()
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

        menu?.add(1,1,0,"Select")
        menu?.add(1,2,1,"Copy")
        menu?.add(2,3,0,"Paste")
        menu?.add(2,4,1,"Cut")

    }
    override fun onContextItemSelected(item: MenuItem?): Boolean {

//        return super.onContextItemSelected(item)
        Toast.makeText(
                this,
                """ Item is ${item?.itemId}""",
                Toast.LENGTH_SHORT
        ).show()
        return true


    }
}
