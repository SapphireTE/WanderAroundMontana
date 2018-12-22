package com.te.repository;

import com.te.domain.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image,Long> {
    Image findByImageName(String imageName);
}
