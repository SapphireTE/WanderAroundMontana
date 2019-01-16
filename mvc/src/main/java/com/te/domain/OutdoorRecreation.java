package com.te.domain;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="outdoor_Recreations")
public class OutdoorRecreation {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "outdoorRecreations_id_seq")
    @SequenceGenerator(name="outdoorRecreations_id_seq", sequenceName = "outdoorRecreations_id_seq", allocationSize=1)
    public Long id;

    @Column(name="category")
    public String category;

//    @Column(name="hiking")
//    public String hiking;
//
//    @Column(name="fishing")
//    public String fishing;
//
//    @Column(name="skiing")
//    public String skiing;
//
//    @Column(name="distance")
//    public Double distance;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "outdoorRecreation",cascade = CascadeType.ALL)
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

//    public String getHiking(){
//        return this.hiking;
//    }
//    public void setHiking(String hiking){
//        this.hiking=hiking;
//    }
//
//    public String getFishing(){
//        return this.fishing;
//    }
//    public void setFishing(String fishing){
//        this.fishing=fishing;
//    }
//
//    public String getSkiing(){
//        return this.skiing;
//    }
//    public void setSkiing(String skiing){
//        this.skiing=skiing;
//    }
//
//    public Double getDistant(){
//        return this.distance;
//    }
//    public void setDistant(Double distant){
//        this.distance=distant;
//    }

    public List<Image> getImages(){return images==null ? new ArrayList<>():images;}
    public void setImages (List<Image> images){this.images=images;}
}
