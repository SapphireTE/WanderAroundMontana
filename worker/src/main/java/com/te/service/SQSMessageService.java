//package com.te.service;
//
//import com.amazonaws.services.sqs.AmazonSQS;
//import com.amazonaws.services.sqs.model.Message;
//import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class SQSMessageService {
//    @Autowired
//    private AmazonSQS sqsClient;
//
//    @Value("${jms.queue.name}")
//    private String queueName;
//
//    public void receiveMessage(){
//        // Receive messages
//        System.out.println("Receiving messages from MyQueue.\n");
//        final ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(getQueueUrl(queueName));
//        final List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).getMessages();
//        for (final Message message : messages) {
//            System.out.println("Message");
//            System.out.println("  MessageId:     " + message.getMessageId());
//            System.out.println("  ReceiptHandle: " + message.getReceiptHandle());
//            System.out.println("  MD5OfBody:     " + message.getMD5OfBody());
//            System.out.println("  Body:          " + message.getBody());
//            for (final Map.Entry<String, String> entry : message.getAttributes().entrySet()) {
//                System.out.println("Attribute");
//                System.out.println("  Name:  " + entry.getKey());
//                System.out.println("  Value: " + entry.getValue());
//            }
//        }
//        System.out.println();
//    }
//
//    public String getQueueUrl(String queueName){
//        String queueUrl = sqsClient.getQueueUrl(queueName).getQueueUrl();
//        return queueUrl;
//    }
//}
