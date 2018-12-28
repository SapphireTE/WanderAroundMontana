package com.te.domain;



import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity
@Table(name="images")
public class Image {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "images_id_seq")
    @SequenceGenerator(name = "images_id_seq",sequenceName = "images_id_seq",allocationSize = 1)
    private Long Id;

    @Column(name="image_name", unique=true)
    private String imageName;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="sceneryImage_id")
    private Scenery scenery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="outdoorRecreationImage_id")
    private OutdoorRecreation outdoorRecreation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="culturalInheritanceImage_id")
    private CulturalInheritance culturalInheritance;

    public Long getId(){return this.Id;}

    public String getImageName(){return this.imageName;}
    public void setImageName(String imageName){this.imageName=imageName;}

}
