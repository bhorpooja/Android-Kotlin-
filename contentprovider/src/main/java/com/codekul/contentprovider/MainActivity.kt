package com.codekul.contentprovider

import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.ArrayAdapter
import org.jetbrains.anko.alert
import org.jetbrains.anko.listView
import org.jetbrains.anko.verticalLayout


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        readContact()
        runTimePrmsn()
    }

    private fun runTimePrmsn() {
        if(ContextCompat.checkSelfPermission(this@MainActivity,
                android.Manifest.permission.READ_CONTACTS)
                !=PackageManager.PERMISSION_GRANTED){

            if(ActivityCompat.shouldShowRequestPermissionRationale(this@MainActivity,
                    android.Manifest.permission.READ_CONTACTS))
            {
                alert {
                    title="Need your pwrmission"
                    message="want to read contacts, Don't worry wont steal ur data"
                    iconResource=R.mipmap.ic_launcher
                    positiveButton("yes"){
                        ActivityCompat.requestPermissions(this@MainActivity,
                                arrayOf(android.Manifest.permission.READ_CONTACTS),
                                1234)
                    }
                }.show()
            }else {
                ActivityCompat.requestPermissions(this@MainActivity,
                        arrayOf(android.Manifest.permission.READ_CONTACTS),
                        1234)
            }
        }else readContact()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode==1234){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                readContact()
            }
        }
    }
   private fun readContact(){

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
