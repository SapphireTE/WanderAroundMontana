package com.te.api.v1;

import com.te.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sun.plugin2.message.Message;

@RestController
@ResponseBody
@RequestMapping(value={"/api/message"},produces = MediaType.APPLICATION_JSON_VALUE)
public class MessageController {
    private final Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private MessageService messageService;

    @RequestMapping(value="/{Id}", method = RequestMethod.POST)
    public Boolean postFakeMessage (@PathVariable("Id") Long messageId){
        logger.debug("Receive a message Id::" +messageId);
        messageService.sendMessage(messageId.toString());
        return Boolean.TRUE;
    }


}
