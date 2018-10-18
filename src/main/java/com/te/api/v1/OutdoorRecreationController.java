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
    private final Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private OutdoorRecreationService outdoorRecreationService;

    @RequestMapping(value="/{Id}", method = RequestMethod.GET)
    public OutdoorRecreation findById(@PathVariable("Id") Long Id){
        logger.debug("scenery path variable is:" +Id);
        OutdoorRecreation result=outdoorRecreationService.findById(Id);
        return result;
    }

    @RequestMapping(method = RequestMethod.POST)
    public OutdoorRecreation createOutdoorRecreation(@RequestBody OutdoorRecreation outdoorRecreation){
        OutdoorRecreation result=outdoorRecreationService.createOutdoorRecreation(outdoorRecreation);
        return result;
    }
}
