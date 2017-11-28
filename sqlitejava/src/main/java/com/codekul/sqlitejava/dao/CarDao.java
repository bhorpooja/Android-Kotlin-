package com.codekul.sqlitejava.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.database.Cursor;

import com.codekul.sqlitejava.model.Car;

import java.util.List;

/**
 * Created by pooja on 28/11/17.
 */

@Dao
public interface CarDao {

    @Insert
    void insert(Car car);

    @Query("select * from Car")
    List<Car> cars();

    @Query("select * from Car")
    Cursor allCars();
}
