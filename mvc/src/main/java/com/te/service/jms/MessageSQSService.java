package com.te.service.jms;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class MessageSQSService {
    private AmazonSQS sqs;
    private String queueUrl;

    public MessageSQSService(@Autowired AmazonSQS sqs, @Value("#{applicationProperties['jms.queue.name']}")String sqsName){
        this.sqs=sqs;
        this.queueUrl=getQueueUrl(sqsName);
    }

    public void sendMessage (String messageBody,Integer delaySec) { //method needs () instance
        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(queueUrl)
                .withMessageBody(messageBody)
                .withDelaySeconds(delaySec);
        sqs.sendMessage(send_msg_request);
    }

    public String getQueueUrl(String sqsName){
        String queueUrl=sqs.getQueueUrl(sqsName).getQueueUrl();
        return queueUrl;
    }
}
