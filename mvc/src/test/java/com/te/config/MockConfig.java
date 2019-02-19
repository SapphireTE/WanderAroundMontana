package com.te.config;

import com.amazonaws.services.s3.AmazonS3;
import com.te.service.StorageService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class MockConfig { //incomplete

    public StorageService getStorageService() throws IOException {
        AmazonS3 client = Mockito.mock(AmazonS3.class);
        StorageService storageService=new StorageService(client);
        storageService.setBucket("mt.project");
        return storageService;
    }
}
