package com.te.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MessageService {
    private AmazonSQS sqs;
    private String queueUrl;
//    @Value("#{applicationProperties['jms.queue.name']}")
//    private String queueName;

    public MessageService(@Autowired AmazonSQS sqs,@Value("#{applicationProperties['jms.queue.name']}") String queueName){
//        AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
        this.sqs=sqs;
        this.queueUrl = getQueueUrl(queueName);
    }

    public void sendMessage(String messageBody, Integer delaySec) {
//        String queueUrl = getQueueUrl();
        SendMessageRequest send_msg_request = new SendMessageRequest().withQueueUrl(queueUrl).withMessageBody(messageBody).withDelaySeconds(delaySec);
        sqs.sendMessage(send_msg_request);
    }

    public void sendMessage(Map<String, MessageAttributeValue> messageBody, Integer delaySec){
        SendMessageRequest send_msg_request = new SendMessageRequest().withQueueUrl(queueUrl).withMessageBody("send this message:"+messageBody).withDelaySeconds(delaySec);
        sqs.sendMessage(send_msg_request);
    }

    public String getQueueUrl(String queueName){
        String queueUrl = sqs.getQueueUrl(queueName).getQueueUrl();
        return queueUrl;
    }

}
