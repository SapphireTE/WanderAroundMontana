package com.te.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="outdoor_Recreations")
public class OutdoorRecreation {

    @Column(name="category")
    public String category;

    @Column(name="hiking")
    public String hiking;

    @Column(name="fishing")
    public String fishing;

    @Column(name="skiing")
    public String skiing;

    public String getCategory(){
        return this.category;
    }
    public void setCategory(String category){
        this.category=category;
    }

    public String getHiking(){
        return this.hiking;
    }
    public void setHiking(String hiking){
        this.hiking=hiking;
    }

    public String getFishing(){
        return this.fishing;
    }
    public void setFishing(String fishing){
        this.fishing=fishing;
    }

    public String getSkiing(){
        return this.skiing;
    }
    public void setSkiing(){
        this.skiing=skiing;
    }

}
