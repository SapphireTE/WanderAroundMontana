package com.te.api.v1;

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
