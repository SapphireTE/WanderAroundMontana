package com.te;

import java.util.Arrays;

//import com.te.service.SQSMessageService;
//import com.te.service.SQSMessageService;
import com.te.service.SQSMessageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.swing.*;

@SpringBootApplication
public class Application {

    public static void main(String[] args) { //main method
        ApplicationContext app=SpringApplication.run(Application.class, args);
        SQSMessageService messageService=app.getBean(SQSMessageService.class);
        messageService.receiveMessage();
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//
//        };
//    }

}