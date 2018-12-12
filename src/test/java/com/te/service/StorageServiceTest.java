package com.te.service;

import com.amazonaws.services.cloudsearchdomain.model.Bucket;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.te.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;

import static junit.framework.TestCase.assertTrue;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class StorageServiceTest {

//    @Autowired
//    private StorageService storageService;

    @Test
    public void putObjectTest (){
//        AmazonS3 s3=AmazonS3ClientBuilder.standard().withRegion("us-east-1").build();
        AmazonS3 s3=AmazonS3ClientBuilder.defaultClient();
        StorageService storageService=new StorageService(s3);
        String s3key="tt";
        File file=new File("/Users/tsai_te/Desktop/Screen Shot 2018-10-27 at 11.48.30 AM.png");
        String bucket="mt.project";
        storageService.putObject(bucket, s3key,file);
        assertTrue(false);

    }

}
