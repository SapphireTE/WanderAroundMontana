package com.te.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="scenery")
public class Scenery {

    @Id
    public Long id;

    @Column(name="category")
    public String category;

    @Column(name="nature")
    public String nature;

    @Column(name="national_parks")
    public String nationalParks;

    public Long getId(){
        return this.id;
    }

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

    public String getNationalParks(){
        return this.nationalParks;
    }
    public void setNationalParks(String nationParks){
        this.nationalParks=nationParks;
    }
}
