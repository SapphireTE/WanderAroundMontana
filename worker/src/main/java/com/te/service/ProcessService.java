package com.te.service;

import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
//@Service for invoking
public class ProcessService {
    protected  final Logger logger= LoggerFactory.getLogger(getClass());
    @JmsListener(destination = "WAMT-dev")
    public void processMessage(String msg) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();
        // convert JSON string to Map
        map=mapper.readValue(msg,new TypeReference<Map<String, String>>(){});
//        String msgType=(String)msg.get("msgType");
//        String msgText=(String)msg.get("msgText");
//        Long userID=Long.valueOf(msgText);
//        logger.info("receive msgType:"+msgType);
//        logger.info("receive msgText:"+msgText);
        logger.info("this message is:"+msg);
    }

//    @JmsListener(destination = "WAMT-dev")
//    public void processMessage(Map<String, MessageAttributeValue> msg){
////        String msgType=(String)msg.get("msgType");
////        String msgText=(String)msg.get("msgText");
////        Long userID=Long.valueOf(msgText);
////        logger.info("receive msgType:"+msgType);
////        logger.info("receive msgText:"+msgText);
//        logger.info("this message is:"+msg);
//    }
}
