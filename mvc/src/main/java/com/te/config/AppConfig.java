package com.te.config;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.te.service.MessageService;
import com.te.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;


@Configuration
@ComponentScan(basePackages = "com.te", excludeFilters=@ComponentScan.Filter(type= FilterType.REGEX,pattern="com.te.api.*"))
public class AppConfig { //scan all back-end project
    @Autowired
    private Environment environment;
    private final Logger logger= LoggerFactory.getLogger(getClass()); //log 4j

    @Bean(name="applicationProperties") //plugin @Bean in
    public PropertiesFactoryBean getDbProperties(){
        PropertiesFactoryBean bean=new PropertiesFactoryBean();
        String profile=environment.getActiveProfiles()[0];
        logger.debug("applicationProperties is" +profile);
        bean.setLocation(new ClassPathResource("META-INF/env/application-"+profile+".properties"));
        return bean;
    }

    @Bean(name="shareProperties")
    public PropertiesFactoryBean getShareProperties(){
        PropertiesFactoryBean shareProperties=new PropertiesFactoryBean();
        shareProperties.setLocation(new ClassPathResource("META-INF/share-runtime.properties"));
        return shareProperties;
    }

    @Bean
//    @Profile({"dev","test","prod","staging"})
    public StorageService getStorageService(@Autowired @Qualifier("applicationProperties") PropertiesFactoryBean beanFactory) {
        AmazonS3 s3Client= AmazonS3ClientBuilder.standard().withCredentials(new DefaultAWSCredentialsProviderChain()).build();
        StorageService storageService=new StorageService(s3Client);
//        storageService.setBucket(beanFactory.getObject().getProperty(propertyKey));
        storageService.setBucket("mt.project");
        return storageService;
    }

//    public StorageService getStorageService(){
//
//    }

    //todo build a amazon sqs bean
    @Bean
    public AmazonSQS getAmazonSQS(){
        AmazonSQS amazonSQS= AmazonSQSClientBuilder.standard().withCredentials(new DefaultAWSCredentialsProviderChain()).build();
        return amazonSQS;
    }
}
