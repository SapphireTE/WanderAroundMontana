package com.te.repository;

import com.te.domain.Image;
import com.te.domain.Scenery;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface ImageRepository extends CrudRepository<Image,Long> {
    Image findByImageName(String imageName);
//    Image uploadImage ()
    Image findByUploadDate(LocalDate uploadDate);
    Image findByUuid (String uuid);
    Image findByScenery (Scenery scenery);

}
