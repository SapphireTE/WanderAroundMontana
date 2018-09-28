package com.te.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="sceneries")
public class Scenery {

    @Column(name="category")
    public String category;

    @Column(name="nature")
    public String nature;

    @Column(name="nation_parks")
    public String nationParks;

    public String getCategory(){
        return this.category;
    }
    public void setCategory(String category){
        this.category=category;
    }

    public String getNature(){
        return this.nature;
    }
    public void setNature(String nature){
        this.nature=nature;
    }

    public String getNationParks(){
        return this.nationParks;
    }
    public void setNationParks(String nationParks){
        this.nationParks=nationParks;
    }
}
