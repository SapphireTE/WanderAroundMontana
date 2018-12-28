package com.te.api.v1;

import com.te.domain.Image;
import com.te.service.ImageService;
import com.te.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping(value="/api/image") //build api
public class ImageController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private StorageService storageService;

    @Autowired
    private ImageService imageService;

    @RequestMapping(value="/{Id}", method = RequestMethod.GET)
    public Image findById(@PathVariable("Id") Long Id){
        logger.debug("Path variable is:" +Id);
        Image result=imageService.findById(Id);
        return result;
    }

    @RequestMapping(value = "",method = RequestMethod.GET,params = {"image_name"})
    public Image findByImageName(@RequestParam("image_name") String imageName){
        logger.debug("Patameter name is:"+imageName);
        Image result=imageService.findByImageName(imageName);
        return result;
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public String uploadFile (@RequestParam("file") MultipartFile uploadFile){
        File file=new File("/Users/tsai_te/Desktop/testjpg.png");
        logger.info("Image:"+uploadFile.getOriginalFilename());
        try {
            uploadFile.transferTo(file);
        } catch (IOException e) {
            logger.error("cannot save the file",e);
            return "false";
        }
        storageService.putObject(uploadFile.getOriginalFilename(),file);
        return "d";
    }
}
