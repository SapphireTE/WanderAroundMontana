package com.te.api.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
@RequestMapping(value={"/api/sqsmessage"},produces = MediaType.APPLICATION_JSON_VALUE)
public class MessageSQSController {
    private Logger logger= LoggerFactory.getLogger(getClass());
}
