
package com.codekul.jsonparsing.dto;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Demo {

    @SerializedName("nm")
    @Expose
    private String nm;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("isIndian")
    @Expose
    private Boolean isIndian;
    @SerializedName("sal")
    @Expose
    private Double sal;
    @SerializedName("mobs")
    @Expose
    private List<String> mobs = null;
    @SerializedName("grp")
    @Expose
    private Grp grp;

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getIsIndian() {
        return isIndian;
    }

    public void setIsIndian(Boolean isIndian) {
        this.isIndian = isIndian;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public List<String> getMobs() {
        return mobs;
    }

    public void setMobs(List<String> mobs) {
        this.mobs = mobs;
    }

    public Grp getGrp() {
        return grp;
    }

    public void setGrp(Grp grp) {
        this.grp = grp;
    }

}
