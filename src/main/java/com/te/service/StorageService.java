package com.te.service;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;



public class StorageService {

    private AmazonS3 s3;    // s3=s3Client
    private String bucket;
    @Value("#{applicationProperties['amazon.s3.url']}")
    private String cdnUrl;

    public StorageService(AmazonS3 s3){
        this.s3=s3;
    }

    public StorageService(){
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public void putObject(String S3key, File file){
        s3.putObject(bucket,S3key,file);
    }

    public void putObject(String bucket, String S3key, File file){
        s3.putObject(bucket, S3key, file);
    }
}
