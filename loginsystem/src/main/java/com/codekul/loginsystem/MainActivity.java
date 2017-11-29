package com.codekul.loginsystem;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.codekul.loginsystem.db.AppDb;
import com.codekul.loginsystem.model.Login;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLogin(View view){

        AppDb db = Room.databaseBuilder(this,AppDb.class,"my.db").allowMainThreadQueries().build();
        for (Login login : db.loginDao().users()) {
            String name=login.getName();
            String pwd= login.getPwd();
            ((EditText)findViewById(R.id.edtUsername)).setText(name);
            ((EditText)findViewById(R.id.edtPwd)).setText(pwd);
            Toast.makeText(this,"Login successfully",Toast.LENGTH_SHORT).show();


        }

    }

    public void onSave(View view){
        String name=((EditText)findViewById(R.id.edtUsername)).getText().toString();
        String pwd=((EditText)findViewById(R.id.edtPwd)).getText().toString();
        Login login = new Login();
        login.setId(System.currentTimeMillis());
        login.setName(name);
        login.setPwd(pwd);
        AppDb db = Room.databaseBuilder(this,AppDb.class,"my.db").allowMainThreadQueries().build();
        db.loginDao().insert(login);
        Toast.makeText(this,"Data save successfully",Toast.LENGTH_SHORT).show();
    }
}
