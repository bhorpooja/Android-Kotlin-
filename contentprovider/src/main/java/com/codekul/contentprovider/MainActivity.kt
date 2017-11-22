package com.codekul.contentprovider

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ArrayAdapter
import android.widget.ListView
import org.jetbrains.anko.listView
import org.jetbrains.anko.verticalLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        readContact()
    }

     fun readContact(){

         val dtSt=ArrayList<String>()
         val crsr=contentResolver.query(
                 ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                 arrayOf(
                         ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                         ContactsContract.CommonDataKinds.Phone.NUMBER
                 ),
         null,
         null,
         null)

         while (crsr.moveToNext()){
             val name=crsr.getString(
                     crsr.getColumnIndex(
                             ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                     )
             )

             val num=crsr.getString(
                     crsr.getColumnIndex(
                             ContactsContract.CommonDataKinds.Phone.NUMBER
                     )
             )
             dtSt.add("""$name \n $num""")
         }

         crsr.close()

         verticalLayout {
             val lst = listView {
                 adapter = ArrayAdapter<String>(
                         this@MainActivity,
                         android.R.layout.simple_list_item_1,
                         dtSt
                 )
             }
         }

     }
}
