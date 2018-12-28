package com.te.domain;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="sceneries")
public class Scenery {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "sceneries_id_seq")
    @SequenceGenerator(name="sceneries_id_seq", sequenceName = "sceneries_id_seq", allocationSize = 1)
    public Long id;

    @Column(name="category")
    public String category;

    @Column(name="nature")
    public String nature;

    @Column(name="national_park")
    public String nationalParks;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "scenery",cascade = CascadeType.ALL)
    @JsonView({JsView.Admin.class})
    private List<Image> images;

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

    public List<Image> getImages(){return images==null ? new ArrayList<>():images;}
    public void setImages (List<Image> images){this.images=images;}

}
