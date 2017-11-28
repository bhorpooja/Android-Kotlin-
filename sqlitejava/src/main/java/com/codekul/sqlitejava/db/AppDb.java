package com.codekul.sqlitejava.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.codekul.sqlitejava.dao.CarDao;
import com.codekul.sqlitejava.model.Car;
/**
 * Created by pooja on 28/11/17.
 */

@Database(entities = {Car.class}, version = 1)
public abstract class AppDb extends RoomDatabase{
    public abstract CarDao carDao();
}
