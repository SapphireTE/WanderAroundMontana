package com.te.api.v1;

import com.te.domain.OutdoorRecreation;
import com.te.service.OutdoorRecreationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/outdoorRecreations")
public class OutdoorRecreationController {
    private final Logger logger= LoggerFactory.getLogger(getClass()); //??????

    @Autowired
    private OutdoorRecreationService outdoorRecreationService;

    @RequestMapping(value="/{Id}", method = RequestMethod.GET)
    public OutdoorRecreation findById(@PathVariable("Id") Long Id){
        logger.debug("outdoor_recreation path variable is:" +Id);
        OutdoorRecreation result=outdoorRecreationService.findById(Id);
        return result;
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public OutdoorRecreation createOutdoorRecreation(@RequestBody OutdoorRecreation outdoorRecreation){
//        OutdoorRecreation result=outdoorRecreationService.createOutdoorRecreation(outdoorRecreation);
//        return result;
//    }

    @RequestMapping(value="",method = RequestMethod.GET)
    public OutdoorRecreation findByCategory (@PathVariable("Category") String Category){
        logger.debug("outdoor_recreation path variable is:" +Category);//???????
        OutdoorRecreation result=outdoorRecreationService.findByCategory(Category);
        return result;
    }

    @RequestMapping(value="",method = RequestMethod.GET)
    public OutdoorRecreation findByHiking(@RequestParam("Hiking") String Hiking){
        logger.debug("outdoor_recreation path variable is:"+Hiking);
        OutdoorRecreation result=outdoorRecreationService.findByHiking(Hiking);
        return result;
    }

    @RequestMapping(value="",method = RequestMethod.GET)
    public OutdoorRecreation findBySkiing(@RequestParam("Skiing") String Skiing){
        logger.debug("outdoor_recreation path variable is:"+Skiing);
        OutdoorRecreation result=outdoorRecreationService.findBySkiing(Skiing);
        return result;
    }

    @RequestMapping(value="",method = RequestMethod.GET)
    public OutdoorRecreation findByFishing(@RequestParam("Fishing") String Fishing){
        logger.debug("outdoor_recreation path variable is:"+Fishing);
        OutdoorRecreation result=outdoorRecreationService.findByFishing(Fishing);
        return result;
    }

    @RequestMapping(value="",method = RequestMethod.GET)
    public OutdoorRecreation findByDistance(@RequestParam("Distance") Double Distance){
        logger.debug("outdoor_recreation path variable is:"+Distance);
        OutdoorRecreation result=outdoorRecreationService.findByDistance(Distance);
        return result;
    }

}
