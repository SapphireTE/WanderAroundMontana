package com.te.api.v1;

import com.te.domain.*;
import com.te.service.ImageService;
import com.te.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/api/image") //build api
public class ImageController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private StorageService storageService;

    @Autowired
    private ImageService imageService;

    @RequestMapping(value="/imageId/{Id}", method = RequestMethod.GET)
    private Image findById(@PathVariable("Id") Long Id){
        logger.debug("Path variable is:" +Id);
        Image result=imageService.findById(Id);
        return result;
    }

    @RequestMapping(value = "",method = RequestMethod.GET,params = {"image_name"})
    private Image findByImageName(@RequestParam("image_name") String imageName){
        logger.debug("Parameter name is:"+imageName);
        Image result=imageService.findByImageName(imageName);
        return result;
    }

    @RequestMapping(value="/uploadDate",method = RequestMethod.GET, params={"upload_date"})
    private List<Image> findByUploadDate(@RequestParam("upload_date") LocalDate uploadDate){
        logger.debug("Parameter name is:"+uploadDate);
        List<Image> result=imageService.findByUploadDate(uploadDate);
        return result;
    }

    @RequestMapping(value="", method=RequestMethod.GET, params={"scenery_category"})
    public List<Image> findBySceneryCategory (@RequestParam("scenery_category") String sceneryCategory){
        logger.debug("Parameter name is:"+sceneryCategory);
        List<Image> result=imageService.findBySceneryCategory(sceneryCategory);
        return result;
    }

    @RequestMapping(value="/uuid",method = RequestMethod.GET,params = {"uuid"})
    private Image findByUuid (@RequestParam("uuid") String uuid){
        logger.debug("Parameter name is:"+uuid);
        Image result=imageService.findByUuid(uuid);
        return result;
    }

    @RequestMapping(value = "",method = RequestMethod.GET, params = {"scenery"})
    public List<Image> findByScenery(@RequestParam("scenery") Scenery scenery) {
        logger.debug("Parameter name is:"+scenery);
        List<Image> result=imageService.findByScenery(scenery);
        return result;
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET, params ={"user"})
    private Image findByUser(@RequestParam("user") User user){
        logger.debug("Parameter name is:"+user);
        Image result =imageService.findByUser(user);
        return result;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, params = {"cultural_inheritance"})
    public List<Image> findByCulturalInheritance (@RequestParam("cultural_inheritance") CulturalInheritance culturalInheritance){
        logger.debug("Parameter name is:"+culturalInheritance);
        List<Image> result=imageService.findByCulturalInheritance(culturalInheritance);
        return result;
    }

    @RequestMapping(value = "",method = RequestMethod.GET,params = {"cultural_inheritance_category"})
    public List<Image> findByCulturalInheritanceCategory (@RequestParam("cultural_inheritance_category") String culturalInheritanceCategory){
        logger.debug("Parameter name is:"+culturalInheritanceCategory);
        List<Image> result=imageService.findByCulturalInheritanceCategory(culturalInheritanceCategory);
        return result;
    }

    @RequestMapping(value="",method = RequestMethod.GET,params = {"outdoor_recreation"})
    public List<Image> findByOutdoorRecreation(@RequestParam("outdoor_recreation") OutdoorRecreation outdoorRecreation){
        logger.debug("Parameter name is:"+outdoorRecreation);
        List<Image> result=imageService.findByOutdoorRecreation(outdoorRecreation);
        return result;
    }

    @RequestMapping(value = "",method = RequestMethod.GET,params = {"outdoor_recreation_category"})
    public List<Image> findByOutdoorRecreationCategory(@RequestParam("outdoor_recreation_category") String outdoorRecreationCategory){
        logger.debug("Parameter name is:"+outdoorRecreationCategory);
        List<Image> result=imageService.findByOutdoorRecreationCategory(outdoorRecreationCategory);
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

    @ResponseBody
    @RequestMapping (value="user", method=RequestMethod.POST, consumes = {"multipart/form-data"})
    public Map<String, String> uploadImage (@RequestParam(value="pic") MultipartFile picture){
        Map<String, String> result= new HashMap<>(1);
//        try{
//            Image image=imageService.saveFakeImage(picture, isPublic);
//            result.put("s3_url", image.getUrl());
//        } catch (SerialException e) {
//            logger.error ("error on savin record", e);
//        }
        return result;
    }
}
