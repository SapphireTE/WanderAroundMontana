package com.te.service;

import com.te.domain.Image;
import com.te.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Image findById(Long id){
        Optional<Image> result=imageRepository.findById(id);
        Image image=result.get();
        return image;
    }

    public Image findByImageName(String imageName){
        Image result=imageRepository.findByImageName(imageName);
        return result;
    }

    public Image findByUploadDate (LocalDate uploadDate){
        Image result=imageRepository.findByUploadDate(uploadDate);
        return result;
    }

    public Image findByUuid (String uuid) {
        Image result=imageRepository.findByUuid(uuid);
        return result;
    }

    //todo write Image saveFakeImage
}
