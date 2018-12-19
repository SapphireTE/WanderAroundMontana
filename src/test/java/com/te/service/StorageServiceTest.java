package com.te.service;

import com.amazonaws.services.cloudsearchdomain.model.Bucket;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
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

import java.io.File;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.verify;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
@TestExecutionListeners (listeners={DependencyInjectionTestExecutionListener.class})
public class StorageServiceTest {
    @InjectMocks
    @Autowired
    private StorageService storageService;

    @Mock
    private AmazonS3 client= Mockito.mock(AmazonS3.class);

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception{
        validateMockitoUsage();
    }

//    @Autowired
//    private StorageService storageService;

    @Test
    public void putObjectTest (){
//        AmazonS3 s3=AmazonS3ClientBuilder.standard().withRegion("us-east-1").build();
       // AmazonS3 s3=AmazonS3ClientBuilder.defaultClient();
        //storageService=new StorageService(s3);
        String s3key="hhhhh";
        File file=new File("/Users/tsai_te/Desktop/testjpg.png");
        String bucket="mt.project";
        storageService.putObject(s3key,file);
        assertTrue(false);

    }

    @Test
    public void putObjectMockTest(){
        String key="testKey";
        File file=new File("/Users/tsai_te/Desktop/testjpg.png");
        String bucket="mt.project";
        storageService.putObject(key,file);
        verify(client,times(1)).putObject("mt.project",key,file);
        String key2=null;
        storageService.putObject(key2,file);
        verify(client,times(1)).putObject("mt.project",key2,file);
    }

}
