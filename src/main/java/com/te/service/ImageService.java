package com.te.service;

import com.te.domain.Image;
import com.te.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Image findById(Long Id){
        Optional<Image> result=imageRepository.findById(Id);
        Image image=result.get();
        return image;
    }

    public Image findByImageName(String imageName){
        Image result=imageRepository.findByImageName(imageName);
        return result;
    }
}
