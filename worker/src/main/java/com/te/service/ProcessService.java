package com.te.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Component
//@Service for invoking
public class ProcessService {
    protected  final Logger logger= LoggerFactory.getLogger(getClass());
    @JmsListener(destination = "WAMT-dev")
    public void processMessage(String msg){
//        String msgType=(String)msg.get("msgType");
//        String msgText=(String)msg.get("msgText");
//        Long userID=Long.valueOf(msgText);
//        logger.info("receive msgType:"+msgType);
//        logger.info("receive msgText:"+msgText);
        logger.info("this message is:"+msg);
    }
}
