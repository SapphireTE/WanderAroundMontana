package com.te.domain;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="cultural_inheritances")
public class CulturalInheritance {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "culturalInheritances_id_seq")
    @SequenceGenerator(name="culturalInheritances_id_seq", sequenceName = "culturalInheritances_id_seq", allocationSize = 1)
    public Long id;

    @Column(name="category")
    public String category;

    @Column(name="museum")
    public String museum;

    @Column(name="historical_scene")
    public String historicalScene;

    @ManyToOne(fetch=FetchType.EAGER)
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
        this.historicalScene=historicalScene;
    }

    public List<Image> images(){return images==null ? new ArrayList<>():images;}
    public void setImages (List<Image> images) {this.images=images;}

}
