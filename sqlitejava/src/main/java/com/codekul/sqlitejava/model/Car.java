package com.codekul.sqlitejava.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by pooja on 28/11/17.
 */

@Entity
public class Car {

    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String name;
    private Integer cost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
