package com.te.api.v1;

import com.te.domain.CulturalInheritance;
import com.te.service.CulturalInheritanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/culturalInheritance")
public class CulturalInheritanceController {
    private final Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private CulturalInheritanceService culturalInheritanceService;

    @RequestMapping(value = "/{Id}",method = RequestMethod.GET)
    public CulturalInheritance findById(@PathVariable("Id") Long Id){
        logger.debug("Cultural Inheritance path variable is:" +Id);
        CulturalInheritance result=culturalInheritanceService.findById(Id);
        return result;
    }

//    @RequestMapping(method = RequestMethod.POST )
//    public CulturalInheritance createCulturalInheritance(@RequestBody CulturalInheritance culturalInheritance){
//        CulturalInheritance result=culturalInheritanceService.createCulturalInheritance(culturalInheritance);
//        return result;
//    }

//    @RequestMapping(value = "", method=RequestMethod.GET)
//    public CulturalInheritance findByMuseum(@RequestParam("Museum") String Museum){
//        logger.debug("culturalInheritance path variable is:"+Museum);
//        CulturalInheritance result=culturalInheritanceService.findByMuseum(Museum);
//        return result;
//    }
//
//    @RequestMapping(value="",method = RequestMethod.GET)
//    public CulturalInheritance findByHistoricalScene(@RequestParam("Historical_Scene") String HistoricalScene){
//        logger.debug("culturalInheritance path variable is:"+HistoricalScene);
//        CulturalInheritance result=culturalInheritanceService.findByHistoricalScene(HistoricalScene);
//        return result;
//    }

    @RequestMapping(value="",method = RequestMethod.GET)
    public CulturalInheritance findByCategory(@RequestParam("category") String category){
        logger.debug("Cultural Inheritance parameter is:"+category);
        return new CulturalInheritance();
    }
}
