package com.codekul.loginsystem.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.codekul.loginsystem.dao.LoginDao;
import com.codekul.loginsystem.model.Login;

/**
 * Created by pooja on 28/11/17.
 */


@Database(entities = {Login.class},version = 1)
public abstract class AppDb extends RoomDatabase {

    public abstract LoginDao loginDao();
}
