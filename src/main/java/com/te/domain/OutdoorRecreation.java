package com.te.domain;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="outdoor_Recreations")
public class OutdoorRecreation {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "outdoorrecreations_id_seq")
    @SequenceGenerator(name="outdoorrecreations_id_seq", sequenceName = "outdoorrecreations_id_seq", allocationSize=1)
    public Long id;

    @Column(name="category")
    public String category;

    @Column(name="hiking")
    public String hiking;

    @Column(name="fishing")
    public String fishing;

    @Column(name="skiing")
    public String skiing;

    @Column(name="distance")
    public Double distance;

    public Long getId(){
        return this.id;
    }

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
    public void setSkiing(String skiing){
        this.skiing=skiing;
    }

    public Double getDistance(){
        return this.distance;
    }
    public void setDistance(Double distance){
        this.distance=distance;
    }
}
