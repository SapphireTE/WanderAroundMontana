package com.te.api.v1;

import com.te.domain.Scenery;
import com.te.service.SceneryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/scereries")
public class SceneryServiceController {
    private final Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private SceneryService sceneryService;

    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
    public Scenery findById(@PathVariable ("Id") Long Id){
        logger.debug("user path variable is:" +Id);
        Scenery result=sceneryService.findById(Id);
        return result;
    }

    public Scenery createScenery(@RequestBody Scenery scenery){
        Scenery result=sceneryService.createScenery(scenery);
        return result;
    }


}