package com.te.api.v1;

import com.amazonaws.protocol.json.SdkJsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.service.jms.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@ResponseBody
@RequestMapping(value={"/api/message"},produces = MediaType.APPLICATION_JSON_VALUE)
public class MessageController {
    private final Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private MessageService messageService;

    @RequestMapping(value="/{Id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Boolean postFakeMessage (@PathVariable("Id") Long messageId){
        logger.debug("Receive a message Id:" +messageId);
        ObjectMapper mapper = new ObjectMapper();
        String json = "";

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "mkyong");
        map.put("age", 29);

//        messageService.sendMessage(messageId.toString(),1);
        return Boolean.TRUE;
    }

    public static void main(String[] args) {

        try {

            ObjectMapper mapper = new ObjectMapper();
            String json = "";

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name", "mkyong");
            map.put("age", 29);

            // convert map to JSON string
            json = mapper.writeValueAsString(map);

            System.out.println(json);

            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);

            // pretty print
            System.out.println(json);

        } catch (SdkJsonGenerator.JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


