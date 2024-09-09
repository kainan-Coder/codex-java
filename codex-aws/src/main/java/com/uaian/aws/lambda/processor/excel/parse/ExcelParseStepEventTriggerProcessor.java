package com.uaian.aws.lambda.processor.excel.parse;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.uaian.aws.lambda.processor.excel.parse.module.ConversionRequest;
import com.uaian.aws.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;


@Slf4j
public class ExcelParseStepEventTriggerProcessor  implements RequestHandler<ConversionRequest, String> {


    @Override
    public String handleRequest(ConversionRequest request, Context context) {
        request.getDataSources();



//        S3Object s3Object = s3Client.getObject(bucketName, objectKey);
//        InputStream inputStream = s3Object.getObjectContent();
//        // 获取文件扩展名
//        String extension = FileUtils.getFileExtension(objectKey);
//
//        log.info("文件扩展名: {}", extension);
//
//        FileReaderStrategy fileReaderStrategy = FileReaderFactory.getFileReaderStrategy(extension);
//        try {
//            fileReaderStrategy.read(inputStream);
//        } catch (IOException e) {
//            log.info("读取Excel报错: {}", e.getMessage());
//            e.printStackTrace();
//        }
//
//        return "Successfully processed " + objectKey + " from bucket " + bucketName;
        return "";
    }


}
