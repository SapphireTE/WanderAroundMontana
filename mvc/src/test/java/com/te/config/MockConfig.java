package com.te.config;

import com.amazonaws.services.s3.AmazonS3;
import com.te.service.StorageService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import java.io.IOException;

@Configuration
public class MockConfig { //incomplete

    @Bean
    public AmazonS3 amazonS3(){
        AmazonS3 client = Mockito.mock(AmazonS3.class);
        return client;
    }

    @Bean
//    @Primary
    @Profile({"dev","test","prod","staging","unit"})
    public StorageService getStorageService(@Autowired AmazonS3 client) throws IOException {
//        AmazonS3 client = Mockito.mock(AmazonS3.class);
        StorageService storageService=new StorageService(client);
        storageService.setBucket("mt.project");
        return storageService;
    }
}
