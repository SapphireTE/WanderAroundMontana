package com.te.service;

import com.te.domain.*;
import com.te.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
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

    public List<Image> findByUploadDate (LocalDate uploadDate){
        List<Image> result=imageRepository.findByUploadDate(uploadDate);
        return result;
    }

    public Image findByUuid (String uuid) {
        Image result=imageRepository.findByUuid(uuid);
        return result;
    }

    public List<Image> findByScenery (Scenery scenery) {
        List<Image> result=imageRepository.findByScenery(scenery);
        return result;
    }

    public List<Image> findBySceneryCategory (String category) {
        List<Image> result=imageRepository.findBySceneryCategory(category);
        return result;
    }

    public Image findByUser (User user) {
        Image result=imageRepository.findByUser(user);
        return result;
    }

    public List<Image> findByCulturalInheritance (CulturalInheritance culturalInheritance){
        List<Image> result=imageRepository.findByCulturalInheritance(culturalInheritance);
        return result;
    }

    public List<Image> findByCulturalInheritanceCategory(String category){
        List<Image> result=imageRepository.findByCulturalInheritanceCategory(category);
        return result;
    }

    public List<Image> findByOutdoorRecreation(OutdoorRecreation outdoorRecreation){
        List<Image> result=imageRepository.findByOutdoorRecreation(outdoorRecreation);
        return result;
    }

    public List<Image> findByOutdoorRecreationCategory(String category){
        List<Image> result=imageRepository.findByOutdoorRecreationCategory(category);
        return result;
    }


    //todo write Image saveFakeImage
}
