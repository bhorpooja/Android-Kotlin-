package com.codekul.loginsystem.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.database.Cursor;

import com.codekul.loginsystem.model.Login;

import java.util.List;

/**
 * Created by pooja on 28/11/17.
 */

@Dao
public interface LoginDao {

    @Insert
    void insert(Login login);

    @Query("select * from Login")
    List<Login> users();

    @Query("select * from Login")
    Cursor allUsers();
}
