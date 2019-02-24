package com.te.domain;



import javax.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

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

    @Column (name="title")
    private String title;

    @Column (name="upload_date")
    private LocalDate uploadDate;

    @Column (name="url")
    private String url;
    @Column
    private String extension;
    @Column
    public String uuid= UUID.randomUUID().toString();

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="scenery_id")
    private Scenery scenery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="outdoorRecreation_id")
    private OutdoorRecreation outdoorRecreation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="culturalInheritance_id")
    private CulturalInheritance culturalInheritance;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    public Long getId(){return this.Id;}

    public User getUser(){return this.user;}

    public Scenery getScenery(){return this.scenery;}

    public OutdoorRecreation getOutdoorRecreation(){return this.outdoorRecreation;}

    public CulturalInheritance getCulturalInheritance() {return this.culturalInheritance;}

    public String getUuid(){return this.uuid;}

    public String getImageName(){return this.imageName;}
    public void setImageName(String imageName){this.imageName=imageName;}

    public String getTitle(){return this.title;}
    public void setTitle(String title){this.title=title;}

    public LocalDate getUploadDate(){return this.uploadDate;}
    public void setUploadDate (LocalDate uploadDate){this.uploadDate=uploadDate;}

    public String getUrl(){return this.url;}
    public void setUrl(String url){this.url=url;}

    public String getExtension(){return this.extension;}
    public void setExtension(String extension){this.extension=extension;}


}
