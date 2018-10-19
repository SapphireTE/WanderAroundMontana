package com.te.api.v1;

import com.te.domain.CulturalInheritance;
import com.te.service.CulturalInheritanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class CulturalInheritanceController {
    private final Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private CulturalInheritanceService culturalInheritanceService;

    @RequestMapping(value = "/{Id}",method = RequestMethod.GET)
    public CulturalInheritance findById(@PathVariable("Id") Long Id){
        logger.debug("culturalInheritance path variable is:" +Id);
        CulturalInheritance result=culturalInheritanceService.findById(Id);
        return result;
    }

    @RequestMapping(method = RequestMethod.POST )
    public CulturalInheritance createCulturalInheritance(@RequestBody CulturalInheritance culturalInheritance){
        CulturalInheritance result=culturalInheritanceService.createCulturalInheritance(culturalInheritance);
        return result;
    }
}
