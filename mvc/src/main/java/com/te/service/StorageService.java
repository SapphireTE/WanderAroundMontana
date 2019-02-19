package com.te.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;



public class StorageService {

    private AmazonS3 s3;    // s3=s3Client
    private String bucket;
    @Value("#{applicationProperties['amazon.s3.url']}")
    private String cdnUrl;

    public StorageService(AmazonS3 s3){ //constructor
        this.s3=s3;
    } //constructor of s3

    public StorageService(){
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public void putObject(String S3key, File file){
//        System.out.print(S3key+file.getAbsolutePath());
        if(S3key!=null){
            s3.putObject(bucket,S3key,file); //bucket has been assigned (赋予) by "private String bucket;"
        }
    }

//    public void putObject(String S3key, File file){
//        s3.putObject(bucket, S3key, file);
//    }

//    public void putObject(String bucket, String S3key, File file){
//        s3.putObject(bucket, S3key, file);
//    }

    public void putObject(String bucket, String S3key, File file){
        s3.putObject(bucket,S3key,file); //String bucket on here because in case we want to use a global bucket
    }

    public void getObject(String S3key, File file){ //void--return nothing
        if(S3key !=null) {
            s3.getObject(bucket,S3key);
        }
    }

    public void getObject(String bucket, String S3key, File file){
        s3.putObject(bucket,S3key,file);
    }

//    public void uploadObject(String keyName, String filePath, String bucketName){
//        System.out.format("Uploading %s to S3 bucket %s...\n", filePath, bucketName);
//        final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
//        try {
//            s3.putObject(bucketName, keyName, new File(filePath));
//        } catch (AmazonServiceException e) {
//            System.err.println(e.getErrorMessage());
//            System.exit(1);
//        }
//    }
}
