package com.te.repository;

import com.te.domain.*;
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
    List<Image> findByCulturalInheritance(CulturalInheritance culturalInheritance);
    List<Image> findByCulturalInheritanceCategory (String category);

//    OutdoorRecreation
    List<Image> findByOutdoorRecreation(OutdoorRecreation outdoorRecreation);
    List<Image> findByOutdoorRecreationCategory(String category);

}
