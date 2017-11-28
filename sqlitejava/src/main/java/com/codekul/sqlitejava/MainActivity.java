package com.codekul.sqlitejava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.arch.persistence.room.Room;
import android.util.Log;

import com.codekul.sqlitejava.db.AppDb;
import com.codekul.sqlitejava.model.Car;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Car car = new Car();
        car.setCost(123);
        car.setId(System.currentTimeMillis());
        car.setName("Android");

        AppDb db = Room.databaseBuilder(this, AppDb.class,"my.db").allowMainThreadQueries().build();
        db.carDao().insert(car);

        for (Car car1 : db.carDao().cars()) {
            Log.i("@codekul", "Name = "+car1.getName());
            Log.i("@codekul","cost = "+car1.getCost());
            Log.i("@codekul","Id = "+car1.getId());

        }

    }
}
