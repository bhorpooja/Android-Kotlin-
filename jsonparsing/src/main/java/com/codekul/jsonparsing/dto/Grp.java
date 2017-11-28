
package com.codekul.jsonparsing.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Grp {

    @SerializedName("str")
    @Expose
    private Integer str;
    @SerializedName("ttl")
    @Expose
    private String ttl;

    public Integer getStr() {
        return str;
    }

    public void setStr(Integer str) {
        this.str = str;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

}
