package com.te.api.v1;

import com.te.domain.Authority;
import com.te.domain.User;
import com.te.service.AuthorityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/authorities")
public class AuthorityController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthorityService authorityService;

    @RequestMapping(value = "/authorities", method = RequestMethod.GET)
    public Authority authority(@RequestParam("authorities") String authority) {
        logger.debug("parameter name is:" +authority);
        Authority result = authorityService.findAuthorityByUser(authority);
        return result;
    }
}
