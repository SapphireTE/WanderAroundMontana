package com.te.repository;

import com.te.domain.Image;
import com.te.domain.Scenery;
import com.te.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface ImageRepository extends CrudRepository<Image,Long> {
    Image findByImageName(String imageName);
//    Image uploadImage ()
//    General
    List<Image> findByUploadDate(LocalDate uploadDate);
    Image findByUuid (String uuid);

//    User
    Image findByUser(User user);

//    Scenery
    List<Image> findByScenery (Scenery scenery);
    List<Image> findBySceneryCategory (String category);

//todo

//    CulturalInheritance

//    OutdoorRecreation

}
