package com.te.api.v1;

import com.te.domain.Scenery;
import com.te.domain.User;
import com.te.service.SceneryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value={"/api/scereries"})
public class SceneryController {
    private final Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private SceneryService sceneryService;

    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
    public Scenery findById(@PathVariable ("Id") Long Id){
        logger.debug("scenery path variable is:" +Id);
        Scenery result=sceneryService.findById(Id);
        return result;
    }

//    public Scenery createScenery(@RequestBody Scenery scenery){
//        Scenery result=sceneryService.createScenery(scenery);
//        return result;
//    }

    @RequestMapping(value="", method=RequestMethod.GET, params={"category"})
    public Scenery findByCategory(@RequestParam("category") String category){
        logger.debug("scenery parameter name is:" +category);
//        Scenery result =sceneryService.findByCategory(category);
        return new Scenery();
    }

//    @RequestMapping(value="",method=RequestMethod.GET,params={"nature"})
//    public Scenery findByNature(@RequestParam("nature") String Nature){
//        logger.debug("parameter name is:" +Nature);
//        Scenery result=sceneryService.findByNature(Nature);
//        return result;
//    }
//
//    @RequestMapping(value="", method = RequestMethod.GET, params={"national_park"})
//    public Scenery findByNationalParks(@RequestParam("national_park") String NationalParks){
//        logger.debug("parameter name is:" +NationalParks);
//        Scenery result=sceneryService.findByNationalParks(NationalParks);
//        return result;
//    }

}
