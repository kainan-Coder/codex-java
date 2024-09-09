package com.uaian.aws.utils;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3Utils {

    private final static AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();


    public static S3Object getS3Object(String bucketName, String objectKey){
        return s3Client.getObject(bucketName, objectKey);
    }
}
