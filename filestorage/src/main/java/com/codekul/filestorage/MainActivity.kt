package com.codekul.filestorage

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import org.jetbrains.anko.button
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.verticalLayout
import java.io.File
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        verticalLayout {

            button("write"){
                onClick {
//                    writeInternal()
                   writeExternal()
//                    writePubExt()
                }
            }

            button("read"){
                onClick{
//                    readInternal()
                   readExternal()
//                    readPubExt()
                }
            }


            button("more"){
                onClick {

                    val pthIn=File(filesDir,"my.txt")
                    Log.i("@codekul", """Internal Storage Path : ${pthIn.absolutePath} """)

                    val pthExt=File(getExternalFilesDir("Downloads"),"my.txt")
                    Log.i("@codekul","""External Storage Path : ${pthExt.absolutePath}""")

                }
            }
        }
    }

    private fun writeInternal() {

        val flDt="This is Kotlin File Writer"

        openFileOutput(
                "my.txt",
                Context.MODE_PRIVATE
        ).write(flDt.toByteArray())
    }

    private fun readInternal() {

        val flDt=openFileInput("my.txt")
                .bufferedReader()
                .use {
                    it.readText()
                }
        Log.i("@codekul","File Data is :"+flDt)

    }

    private  fun writeExternal(){

       File(getExternalFilesDir("Downloads"),"my.txt")
                .writeText(
                        "This is getting stored on External Storage",
                        Charset.defaultCharset()
                )
    }

    private fun readExternal(){
        val flDt=File(getExternalFilesDir("Downloads"),"my.txt")
                .readText(
                        Charset.defaultCharset()
                )
        Log.i("@codekul","""file Data is $flDt""")
    }

    private fun writePubExt(){
        if(Environment.getExternalStorageState()==Environment.MEDIA_MOUNTED)
            File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),"my.txt")
                    .writeText(
                            "This is stored on External Storage",
                            Charset.defaultCharset()
                    )
    }

    private fun readPubExt(){
        val flDt=File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),"my.txt")
                .readText(
                        Charset.defaultCharset()
                )
        Log.i("@codekul","""File Data is : $flDt""")
    }


}
