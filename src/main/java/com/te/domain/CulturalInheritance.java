package com.te.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cultural_inheritance")
public class CulturalInheritance {

    @Id
    public Long id;

    @Column(name="category")
    public String category;

    @Column(name="museum")
    public String museum;

    @Column(name="historical_scene")
    public String historicalScene;

    public Long getId(){
        return this.id;
    }

    public String getCategory(){
        return this.category;
    }
    public void setCategory(String category){
        this.category=category;
    }

    public String getMuseum(){
        return this.museum;
    }
    public void setMuseum(String museum){
        this.museum=museum;
    }

    public String getHistoricalScene(){
        return this.historicalScene;
    }
    public void setHistoricalScene(String historicalScene){
        this.museum=museum;
    }
}
