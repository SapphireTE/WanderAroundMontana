package com.te.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.te.config.AppConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import sun.plugin2.message.Message;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.verify;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
@TestExecutionListeners(listeners={DependencyInjectionTestExecutionListener.class})
public class MessageServiceTest {
    @InjectMocks
    @Autowired
    private MessageService messageService;

    @Mock
    private AmazonSQS client= Mockito.mock(AmazonSQS.class); //to invoke, we only test, not really send message to amazon

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception{
        validateMockitoUsage();
    }

    @Test
    public void sendMessageTest(){
        String message="hello, ryo";
        String email="haha";
        messageService.sendMessage(message);
        verify(client,times(1)).sendMessage(message,email);
    }
}












//MessageServiceTest
//Mock
//SendMessageTest("Hi",5)
//Mock.sendMessage(???)
//time 1
//getQueueUrl
//Mock.getQueueUrl