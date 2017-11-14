package com.codekul.uithread

import android.os.*
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class MainActivity : AppCompatActivity() {


    var hand: Handler?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hand =Handler(Looper.getMainLooper())

    }

    fun onBtnOkay(vw: View?){
       // handlerWay()

        //MyTask(txtVw ).execute(0,10)

        val dialog=AlertDialog.Builder(this).setTitle("Android").create()


        doAsync {
            uiThread {
                dialog.show()
            }
            for (i in 1..10){
                uiThread {
                    txtVw.text="""$i"""
                }
                Thread.sleep(1000)
            }
            uiThread {
                dialog.dismiss()
            }
        }

    }

    fun handlerWay() {
        Thread {
            for (i in 1..10) {
                Thread.sleep(1000)
                hand?.post{txtVw.text="""$i"""}
            }
        }.start()
    }

    class MyTask(txtVw:TextView) :AsyncTask<Int/*params*/, Int/*progress*/, Boolean/*Result*/>(){

        private val txt=txtVw

        override fun onPreExecute() {
            super.onPreExecute()
            //UI Thread
        }

        override fun doInBackground(vararg progress: Int?/*param*/): Boolean/*result*/ {

            //Worker Thread
            for (i in 1..10){
                Thread.sleep(1000)
                publishProgress(i)
            }
            return true
        }

        override fun onPostExecute(result: Boolean?/*result*/) {
            super.onPostExecute(result)
            //UI Thread
        }

        override fun onProgressUpdate(vararg values: Int?/*progress*/) {
            super.onProgressUpdate(*values)
            txt.text="""${values[0]}"""

            //UI Thread
        }
    }

    }


