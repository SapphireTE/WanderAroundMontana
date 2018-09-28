package com.te.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="recreations")
public class OutdoorRecreation {

    @Column(name="hiking")
    public String hiking;

    @Column(name="fishing")
    public String fishing;

    @Column(name="skiing")
    public String skiing;

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
