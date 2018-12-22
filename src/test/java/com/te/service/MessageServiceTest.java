package com.te.service;

import com.te.config.AppConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
@TestExecutionListeners(listeners={DependencyInjectionTestExecutionListener.class})
public class MessageServiceTest {
}












//MessageServiceTest
//Mock
//SendMessageTest("Hi",5)
//Mock.sendMessage(???)
//time 1
//getQueueUrl
//Mock.getQueueUrl