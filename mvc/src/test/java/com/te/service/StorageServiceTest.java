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

    String bucket="mt.project";
    File file=new File("/Users/tsai_te/Desktop/testjpg.png");
    String s3key="testThisKey";

    //todo how to create a mock bucket and file

    @InjectMocks
    @Autowired
    private StorageService storageService;

    @Mock
    private AmazonS3 client = Mockito.mock(AmazonS3.class);

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception{
        validateMockitoUsage();
    }

//    @Autowired
//    private AmazonS3 client;

    @Test
    public void putObjectTest (){
//        AmazonS3 s3=AmazonS3ClientBuilder.standard().withRegion("us-east-1").build();
//        AmazonS3 s3=AmazonS3ClientBuilder.defaultClient();
        //storageService=new StorageService(s3);
//        String s3key="hhhhh";
//        File file=new File("/Users/tsai_te/Desktop/testjpg.png");
//        String bucket="mt.project";
        storageService.putObject(s3key,file);
        assertTrue(false);

    }

    @Test
    public void putObjectMockTest(){
        String key="testKey";
        storageService.putObject(key,file);
        verify(client,times(1)).putObject(bucket,key,file); // this client invokes putObject (s3) with 1 time, file is local file, key is file name on s3
        String key2=null;
        storageService.putObject(key2,file); // 0 time
        verify(client,times(0)).putObject(bucket,key2,file);

        String key3="testKey3";
        storageService.putObject(key3,file);
        verify(client,times(1)).putObject(bucket,key3,file);
        String key4="testKey4";
        storageService.putObject(key4,file);
        verify(client,times(1)).putObject(bucket,key4,file);
    }

    @Test
    public void getObjectTest(){
        storageService.getObject(s3key,file);
        verify(client,times(1)).getObject(bucket,s3key); // see getObject source code, (String bucketName, String key)
    }

    @Test
    public void getObjectTest2(){
        storageService.getObject(bucket, s3key, file);
        verify(client,times(1)).getObject(bucket,s3key);
    }

    @Test
    public void deleteObjectTest(){
        storageService.deleteObject(bucket,s3key,file);
        verify(client,times(1)).deleteObject(bucket,s3key);
    }

}
